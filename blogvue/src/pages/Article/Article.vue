<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header>
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px">
        <AuthorInfo></AuthorInfo>
      </el-aside>
      <el-main class="mainwidth">
        <ArticleDetail :article="this.article"></ArticleDetail>
        <br/>
        <Comments :comment="comment" v-for="(comment,index) in this.comments" :key="index"></Comments>
        <br/>
        <Comment :id="this.article.articleId" v-if="user.userId"></Comment>
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
  import SideGuide from "../../components/SideGuide/SideGuide";
  import Comment from "../../components/Comment/Comment";
  import Comments from "../../components/Comments/Comments";
  import {reqArticle, reqArticleComments} from "../../api";
  import {mapState} from "vuex";

  export default {
    data() {
      return {
        isLogin: false,
        article: null,
        comments:[]
      }
    },
    computed: {
      ...mapState(['user']),
    },
    mounted() {
      reqArticle(this.$route.params.id).then(result=>{
        if(result.status === "success"){
          this.article = result.data
        }
      })

      reqArticleComments(this.$route.params.id).then(result => {
        if (result.status === "success") {
          this.comments = result.data
        }
      })
    },
    name: "Article",
    components: {Comments, ArticleDetail, ArticleSummary, Footer, HeaderTop, AuthorInfo, SideGuide, Comment}
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
