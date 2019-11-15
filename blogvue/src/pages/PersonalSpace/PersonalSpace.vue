<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header>
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
            @select="selecthandle">
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
            <el-menu-item index="7">
              <i class="el-icon-message"></i>
              <span slot="title">消息通知<el-badge v-if="no!=0" :value="noRead"></el-badge></span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main class="mainwidth">
        <div v-if="tag==='1'" >
          <el-tabs type="border-card" style="min-height:570px;*+height:100%;_height:400px;">
            <el-tab-pane label="个人信息">
              <img src="./image/icon.png" height="80px" width="80px"/>
              <el-form label-position="left" label-width="80px">
                <el-form-item label="注册时间">
                  <span>{{user.userRegistetime | formatDate}}</span>
                </el-form-item>
                <el-form-item label="用户名">
                  <span>{{user.username}}</span>
                </el-form-item>
                <el-form-item label="昵称">
                  <el-input :value="user.userNickname"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                  <el-input type="email" :value="user.userEmail"></el-input>
                </el-form-item>
                <el-button>{{tip}}</el-button>
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
              <ArticleSummary :article="article" v-for="(article,index) in articles" :key="index"></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='5'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的提问">
              <IssueSummary :issue="issue" v-for="(issue,index) in issues" :key="index"></IssueSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='6'">
          <el-tabs type="border-card">
            <el-tab-pane label="草稿箱">
              <ArticleSummary :article="article" v-for="(article,index) in drafts" :key="index"></ArticleSummary>
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
  import HeaderTop from "../../components/HeaderTop/HeaderTop.vue";
  import Footer from "../../components/Footer/Footer";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import Message from "../../components/Message/Message";
  import PostArticle from "../../components/PostArticle/PostArticle";
  import PostIssue from "../../components/PostIssue/PostIssue";
  import {
    markRead,
    reqArticleByUserId,
    reqDraftByUserId,
    reqIssueByUserId,
    reqNoreadMessage,
    reqReadMessage
  } from "../../api";
  import {mapState} from 'vuex'
  import {formatTimeToStr} from "../../utils/data";

  export default {
    data() {
      return {
        isLogin: true,
        tag: '1',
        factiveIndex: '1',
        articles:[],
        issues:[],
        drafts:[],
        readMessage:[],
        noreadMessage:[],
        tip:'',
      }
    },
    watch: {
      items: {
        handler: function() {
          alert(this.$refs.type.value + this.$refs.content.value);
        },
        deep: true
      }
    },
    filters:{
      formatDate: function(time) {
        if(time!=null&&time!="")
        {
          var date = new Date(time);
          return formatTimeToStr(date, "yyyy-MM-dd");
        }else{
          return "";
        }
      }
    },
    methods: {
      selecthandle(index) {
        this.tag = index
        if(index === '7'){

          let arr = []
          this.noreadMessage.forEach(c => {
            arr.push(c.messageId)
          })
          markRead(arr)
          this.$store.dispatch('readMessage')
        }
      }
    },
    computed: {
      ...mapState(['user','noRead']),
      no() {
        return this.$store.state.noRead
      }
    },
    mounted() {
      reqArticleByUserId(this.user.userId).then(result=>{
        if(result.status === "success"){
          this.articles = result.data
        }
      })

      reqIssueByUserId(this.user.userId).then(result=>{
        if(result.status === "success"){
          this.issues = result.data
        }
      })

      reqDraftByUserId(this.user.userId).then(result=>{
        if(result.status === "success"){
          this.drafts = result.data
        }
      })
      reqReadMessage(this.user.userId).then(result=>{
        if(result.status === "success"){
          this.readMessage = result.data
        }
      })

      reqNoreadMessage(this.user.userId).then(result=>{
        if(result.status === "success"){
          this.noreadMessage = result.data
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
