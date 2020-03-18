<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px">
        <AuthorInfo :userInfo="this.userInfo"></AuthorInfo>
      </el-aside>
      <el-main class="mainwidth">
        <ArticleDetail :article="this.article"></ArticleDetail>
        <br/>
        <Comments :comment="comment" v-for="(comment,index) in this.comments" :key="index"></Comments>
        <br/>
        <div class="shadow" v-if="user.userId">
          <div style="margin-left: 10px;margin-right: 10px;">
            <el-input
              style="margin-top: 10px;"
              type="textarea"
              :rows="2"
              placeholder="说些什么..."
              v-model="comment">
            </el-input>
          </div>
          <div align="right" style="margin-right: 10px;">
            <el-button type="primary" @click="postComment()" plain>发表评论</el-button>
          </div>
        </div>
        <span v-else>请先登录，参与评论</span>
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
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import ArticleDetail from "../../components/ArticleDetail/ArticleDetail";
  import Comments from "../../components/Comments/Comments";
  import {reqArticle} from "../../api/article"
  import {reqUserInfo} from "../../api/user"
  import {postComment,reqArticleComments} from "../../api/comment";
  import {mapState} from "vuex";

  export default {
    data() {
      return {
        isLogin: false,
        article: null,
        userInfo:null,
        comments:[],
        comment:'',
      }
    },
    computed: {
      ...mapState(['user']),
    },
    inject:["reload"],
    methods:{
      postComment(){
        if(this.comment === ''){
          this.$message.warning("评论内容不可为空")
          return
        }else {
          postComment(this.comment,this.article.articleId,null,null,this.user.userId,null).then(result=>{
            if(result.status === "success"){
              this.$message.success(result.resMsg)
              this.comment = ''
              this.reload()
            }else {
              this.$message.error(result.resMsg)
            }
          })
        }
      }
    },
    mounted() {
      reqArticle(this.$route.params.id).then(result=>{
        if(result.status === "success"){
          this.article = result.data
          reqUserInfo(result.data.userId).then(result1 => {
            if(result1.status === "success"){
              this.userInfo = result1.data
            }
          })
        }
      }),
      reqArticleComments(this.$route.params.id).then(result => {
        if (result.status === "success") {
          this.comments = result.data
        }
      })
    },
    name: "Article",
    components: {Comments, ArticleDetail, ArticleSummary, Footer, HeaderTop, AuthorInfo}
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
