<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px" style="overflow-y: hidden">
        <div class="shadow">
          <br/>
          <el-divider content-position="left"><h3>个人空间</h3></el-divider>
          <el-menu
            default-active="1"
            background-color="#fdfdfd"
            text-color="#909399"
            active-text-color="#000000"
            class="el-menu-vertical-demo"
            @select="selectHandle">
            <el-menu-item index="1">
              <i class="el-icon-user"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-edit-outline"></i>
              <span slot="title">发表文章</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-edit-outline"></i>
              <span slot="title">发表提问</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-document"></i>
              <span slot="title">我的文章{{articles.length === 0?'':'('+articles.length+')'}}</span>
            </el-menu-item>
            <el-menu-item index="5">
              <i class="el-icon-document"></i>
              <span slot="title">我的提问{{issues.length === 0?'':'('+issues.length+')'}}</span>
            </el-menu-item>
            <el-menu-item index="6">
              <i class="el-icon-document"></i>
              <span slot="title">草稿箱{{drafts.length === 0?'':'('+drafts.length+')'}}</span>
            </el-menu-item>
            <el-menu-item index="8">
              <i class="el-icon-star-off"></i>
              <span slot="title">我的收藏{{favorites.length === 0?'':'('+favorites.length+')'}}</span>
            </el-menu-item>
            <el-menu-item index="7">
              <i class="el-icon-message"></i>
              <span slot="title">消息通知<el-badge v-if="no!=0" :value="noRead"></el-badge></span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main class="mainwidth">
        <div v-if="tag==='1'">
          <el-tabs type="border-card" style="min-height:570px;*+height:100%;_height:400px;">
            <el-tab-pane label="个人信息">
              <img :src="imageUrl" height="80px" width="80px" style="border-radius:50px"/>
              <el-upload class="img-btn"
                         action="#"
                         :show-file-list="false" :before-upload="beforeAvatarUpload"
                         :http-request="uploadImg">
                <el-button type="success" plain round size="mini">更改头像</el-button>
              </el-upload>
              <el-form label-position="left" label-width="80px">
                <el-form-item label="注册时间">
                  <span>{{user.userRegistetime | formatDate}}</span>
                </el-form-item>
                <el-form-item label="用户名">
                  <span>{{user.username}}</span>
                </el-form-item>
                <el-form-item label="昵称">
                  <el-input v-model="userInfo.userNickname" v-if="isEdit"></el-input>
                  <span v-else>{{user.userNickname}}</span>
                </el-form-item>
                <el-form-item label="邮箱">
                  <el-input type="email" v-model="userInfo.userEmail" v-if="isEdit"></el-input>
                  <span v-else>{{user.userEmail}}</span>
                </el-form-item>
                <el-form-item label="个性签名">
                  <el-input type="textarea" v-model="userInfo.userSignature" v-if="isEdit"></el-input>
                  <span v-else>{{user.userSignature}}</span>
                </el-form-item>
                <el-button v-if="!isEdit" @click="toEdit()"type="success" plain>修改信息</el-button>
                <el-button v-if="isEdit" @click="cancel()"type="info" plain>取消</el-button>
                <el-button v-if="isEdit" @click="toUpdate()"type="primary" plain>提交</el-button>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='2'">
          <el-tabs type="border-card">
            <el-tab-pane label="发表文章">
              <PostArticle></PostArticle>
            </el-tab-pane>
          </el-tabs>

        </div>
        <div v-if="tag==='3'">
          <div class="shadow" align="left">
            <el-tabs type="border-card">
              <el-tab-pane label="发表提问">
                <PostIssue></PostIssue>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
        <div v-if="tag==='4'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的文章">
              <ArticleSummary :article="article" :edit-flag="true" v-for="(article,index) in articles"
                              :key="index"></ArticleSummary>
              <br>
              <el-pagination
                v-if="this.articleTotal != 0"
                @size-change="handleArtSizeChange"
                @current-change="handleArtCurrentChange"
                :current-page.sync="this.articleQuery.pageNum"
                :page-sizes="[5, 8, 10, 15]"
                :page-size="this.articleQuery.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="articleTotal">
              </el-pagination>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='8'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的收藏">
              <ArticleSummary :article="favorite" :edit-flag="false" v-for="(favorite,index) in favorites"
                              :key="index"></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='5'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的提问">
              <IssueSummary :edit-flag="true" :issue="issue" v-for="(issue,index) in issues" :key="index"></IssueSummary>
              <br>
              <el-pagination
                v-if="this.issueTotal != 0"
                @size-change="handleIssSizeChange"
                @current-change="handleIssCurrentChange"
                :current-page.sync="this.issueQuery.pageNum"
                :page-sizes="[5, 8, 10, 15]"
                :page-size="this.issueQuery.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="issueTotal">
              </el-pagination>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='6'">
          <el-tabs type="border-card">
            <el-tab-pane label="草稿箱">
              <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in drafts"
                              :key="index"></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='7'">
          <el-tabs type="border-card">
            <el-tab-pane label="未读消息">
              <message :message="message" v-for="(message,index) in noreadMessage" :key="index"></message>
            </el-tab-pane>
            <el-tab-pane label="已读消息">
              <message :message="message" v-for="(message,index) in readMessage" :key="index"></message>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
  import axios from 'axios'
  import HeaderTop from "../../components/HeaderTop/HeaderTop.vue";
  import Footer from "../../components/Footer/Footer";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import Message from "../../components/Message/Message";
  import PostArticle from "../../components/PostArticle/PostArticle";
  import PostIssue from "../../components/PostIssue/PostIssue";
  import {reqDraftByUserId} from "../../api/article"
  import {reqIssueByUserId} from "../../api/issue"
  import {markRead, reqNoreadMessage, reqReadMessage} from "../../api/message";
  import {reqFavoriteArticle} from "../../api/favorite"
  import {formatTimeToStr} from "../../utils/date";
  import {reqArticleList} from "../../api/article";
  import {nickNameCheck, updateUser} from "../../api/user";
  import {reqIssueList} from "../../api/issue";
  import {mapState} from 'vuex'

  export default {
    data() {
      return {
        imageUrl:'',
        isLogin: true,
        tag: '1',
        factiveIndex: '1',
        articles: [],
        issues: [],
        drafts: [],
        favorites: [],
        readMessage: [],
        noreadMessage: [],
        isEdit: false,
        articleTotal: 0,
        issueTotal: 0,
        userInfo:{
          userNickname: '',
          userSignature:'',
          userEmail:'',
          userPicture:'',
        },
        articleQuery: {
          pageSize: 5,
          pageNum: 1,
          categoryId: '',
          keyword:'',
          userNickname:''
        },
        issueQuery: {
          pageSize: 5,
          pageNum: 1,
          categoryId: '',
          keyword:'',
          userNickname:''
        }
      }
    },
    watch: {
      items: {
        handler: function () {
          alert(this.$refs.type.value + this.$refs.content.value);
        },
        deep: true
      }
    },
    filters: {
      formatDate: function (time) {
        if (time != null && time != "") {
          var date = new Date(time);
          return formatTimeToStr(date, "yyyy-MM-dd");
        } else {
          return "";
        }
      }
    },
    inject: ["reload"],
    methods: {
      toEdit(){
        this.userInfo.userNickname = this.user.userNickname
        this.userInfo.userEmail = this.user.userEmail
        this.userInfo.userSignature= this.user.userSignature
        this.isEdit = true
      },
      cancel(){
        this.isEdit = false
      },
      update(){
        updateUser(this.user.userId,this.userInfo.userNickname,this.userInfo.userSignature,this.userInfo.userEmail,null).then(result=>{
          if(result.status === "success"){
            this.$message.success(result.resMsg)
            this.user.userNickname = this.userInfo.userNickname
            this.user.userEmail = this.userInfo.userEmail
            this.user.userSignature = this.userInfo.userSignature
            this.reload()
          } else {
            this.$message.error(result.resMsg)
          }
        })
      },
      toUpdate(){
        if(this.userInfo.userNickname === ''){
          this.$message.warning("请输入用户昵称")
          return
        }
        if(this.userInfo.userEmail === ''){
          this.$message.warning("请输入用户邮箱")
          return
        }
        if(this.userInfo.userNickname == this.user.userNickname){
          this.update()
        }else {
          nickNameCheck(this.userInfo.userNickname).then(result=>{
            if(result.status === "success"){
              this.update()
            }else {
              this.$message.error(result.resMsg)
            }
          })
        }
      },
      uploadImg (f) {
        console.log(f)
        let formdata = new FormData()
        formdata.append('file', f.file)
        axios({
          url: 'http://localhost:8080/uploadImage',
          method: 'post',
          data: formdata,
          headers: {'Content-Type': 'multipart/form-data'},
        }).then(res => {
          updateUser(this.user.userId,null,null,null,res.data.data).then(result=>{
            if(result.status === "success"){
              this.$message.success(result.resMsg)
              this.user.userPicture = res.data.data
              this.reload()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).then(error => {
          console.log(error)
        })
      },
      beforeAvatarUpload (file) {
        const isJPG = file.type === 'image/jpeg'
        const isLt2M = (file.size / 1024 / 1024) < 2

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!')
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!')
        }
        return isJPG && isLt2M
      },
      selectHandle(index) {
        this.tag = index
        if (index === '7') {

          let arr = []
          this.noreadMessage.forEach(c => {
            arr.push(c.messageId)
          })
          markRead(arr)
          this.$store.dispatch('readMessage')
        }
      },
      getArticleList() {
        reqArticleList(this.articleQuery.pageNum, this.articleQuery.pageSize
          , this.articleQuery.categoryId, this.user.userId,this.articleQuery.userNickname,this.articleQuery.keyword).then(result => {
          this.articles = result.data.list
          this.articleTotal = result.data.total
        })
      },
      handleArtSizeChange(val) {
        this.articleQuery.pageSize = val
        this.getArticleList()
      },
      handleArtCurrentChange(val) {
        this.articleQuery.pageNum = val
        this.getArticleList()
      },
      getIssueList() {
        reqIssueList(this.issueQuery.pageNum, this.issueQuery.pageSize
          , this.issueQuery.categoryId, this.user.userId,this.issueQuery.userNickname,this.issueQuery.keyword).then(result => {
          this.issues = result.data.list
          this.issueTotal = result.data.total
        })
      },
      handleIssSizeChange(val) {
        this.issueQuery.pageSize = val
        this.getIssueList()
      },
      handleIssCurrentChange(val) {
        this.issueQuery.pageNum = val
        this.getIssueList()
      },
    },
    computed: {
      ...mapState(['user', 'noRead','IMAGE_URL']),
      no() {
        return this.$store.state.noRead
      }
    },
    mounted() {
      this.imageUrl = this.IMAGE_URL+this.user.userPicture
      this.getArticleList()
      this.getIssueList()
      reqIssueByUserId(this.user.userId).then(result => {
        if (result.status === "success") {
          this.issues = result.data
        }
      })

      reqDraftByUserId(this.user.userId).then(result => {
        if (result.status === "success") {
          this.drafts = result.data
        }
      })
      reqReadMessage(this.user.userId).then(result => {
        if (result.status === "success") {
          this.readMessage = result.data
        }
      })

      reqNoreadMessage(this.user.userId).then(result => {
        if (result.status === "success") {
          this.noreadMessage = result.data
        }
      })

      reqFavoriteArticle(this.user.userId).then(result => {
        if (result.status === "success") {
          this.favorites = result.data
        }
      })

    },
    name: "PersonalSpace",
    components: {PostIssue, PostArticle, Message, IssueSummary, ArticleSummary, Footer, HeaderTop}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .mainwidth
    margin-right 130px

  .shadow
    background-color #fdfdfd
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

  .el-footer
    margin-top 10px
    margin-bottom 20px


  .el-aside
    margin-left 150px
    margin-top 40px
    margin-bottom 5px

  .el-main
    margin-top 20px
    margin-bottom 5px

  .el-button
    border 0px

  .login
    margin-top 10px
    margin-left 400px

  .unlogin
    margin-top 10px
    margin-left 350px
</style>
