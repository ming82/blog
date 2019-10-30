<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header>
      <HeaderTop>
        <div class="login" slot="isLogin" v-if="isLogin">
          <el-button>个人空间 <el-badge class="mark" :value="12" /></el-button>
        </div>
        <div class="unlogin" slot="isLogin" v-else>
          <el-button>登录</el-button>
          <span>|</span>
          <el-button>免费注册</el-button>
        </div>
      </HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px">
        <SideGuide tag="文章分类"></SideGuide>
      </el-aside>
      <el-main class="mainwidth">
        <el-tabs type="border-card">
          <el-tab-pane label="为你推荐">
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
            <ArticleSummary></ArticleSummary>
          </el-tab-pane>
          <el-tab-pane label="近期热门">近期热门</el-tab-pane>
          <el-tab-pane label="最新发布">最新发布</el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop.vue";
  import SideGuide from "../../components/SideGuide/SideGuide";
  import AuthorInfo from "../../components/AuthorInfo/AuthorInfo";
  import Footer from "../../components/Footer/Footer";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";

  export default {
    data() {
      return {
        isLogin: true,
      }
    },
    name: "MSite",
    components: {ArticleSummary, Footer, AuthorInfo, SideGuide, HeaderTop}
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
