<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue">
<!--      <el-aside width="200px">-->
<!--        <AuthorInfo :userInfo="this.userInfo"></AuthorInfo>-->
<!--      </el-aside>-->
      <el-main>
        <IssueDetail style="width: 75%;margin-left: 13%" :issue="this.issue"></IssueDetail>
        <div style="width: 75%;margin-left: 13%" v-for="(answer,index) in answers" :key="index">
          <Answers :count="index" :answer="answer"></Answers>
        </div>
        <div style="width: 75%;margin-left: 13%" v-if="user.userId" class="shadow" align="left">
          <h3><span style="margin-left: 10px;margin-top: 10px;">发表回答</span></h3>
          <mavon-editor autofocus='false' v-model="mdContent" ref=md />
          <div align="right" style="margin-right: 10px;">
            <el-button type="primary" @click="postAns()" plain>发表回答</el-button>
          </div>
        </div>
        <div v-else>
          <br/>
          <span >请先登录后发表回答</span>
          <br/>
        </div>
      </el-main>
    </el-container>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
  import AuthorInfo from "../../components/AuthorInfo/AuthorInfo";
  import HeaderTop from "../../components/HeaderTop/HeaderTop";
  import Footer from "../../components/Footer/Footer";
  import Comments from "../../components/Comments/Comments";
  import IssueDetail from "../../components/IssueDetail/IssueDetail";
  import Answers from "../../components/Answers/Answers";
  import Message from "../../components/Message/Message";
  import {reqIssue} from "../../api/issue";
  import {reqAnswerByIssueId,postAnswer} from "../../api/answer";
  import {reqUserInfo} from "../../api/user";
  import {mapState} from "vuex";

  export default {
    data() {
      return {
        isLogin: true,
        issue: null,
        userInfo:null,
        answers:[],
        mdContent: '',
        htmlContent:''
      }
    },
    name: "Issue",
    inject:["reload"],
    methods:{
      postAns(){
        if(this.mdContent === ''){
          this.$message.warning("回答不可为空")
          return
        }
        this.htmlContent = this.$refs.md.d_render
        postAnswer(this.user.userId,this.issue.issueId,this.mdContent, this.htmlContent).then(result => {
          if (result.status === "success") {
            this.$message.success(result.resMsg)
            this.reload()
          } else {
            this.$message.error(result.resMsg)
          }
        })
      }
    },
    mounted() {
      // this.$nextTick(()=> {
      //   document.getElementsByClassName('auto-textarea-input')[0].blur(); // 获取textarea 不一定是auto-textarea-input
      //   window.scrollTo(0, 0)
      // })
      reqIssue(this.$route.params.id).then(result => {
        if (result.status === "success") {
          this.issue = result.data
          reqUserInfo(result.data.userId).then(result1 => {
            if(result1.status === "success"){
              this.userInfo = result1.data
            }
          })
        }
      })
      reqAnswerByIssueId(this.$route.params.id).then(result => {
        if (result.status === "success") {
          this.answers = result.data
        }
      })
    },
    computed: {
      ...mapState(['user']),
    },
    components: {Message, Answers, IssueDetail, Comments, Footer, HeaderTop, AuthorInfo}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>

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
