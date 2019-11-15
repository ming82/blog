<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header>
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue; ">
      <el-aside width="200px">
        <SideGuide tag="文章分类" :categorys="category"></SideGuide>
      </el-aside>
      <el-main class="mainwidth">
        <el-tabs type="border-card" v-if="is_search">
          <el-tab-pane label="搜索结果如下:">
            <ArticleSummary :article="article" v-for="(article,index) in articles" :key="index"></ArticleSummary>
          </el-tab-pane>
        </el-tabs>
        <el-tabs type="border-card" v-else>
          <el-tab-pane label="为你推荐">
            <ArticleSummary :article="article" v-for="(article,index) in articles" :key="index"></ArticleSummary>
          </el-tab-pane>
          <el-tab-pane label="近期热门">
            <ArticleSummary :article="article" v-for="(article,index) in hotArticles" :key="index"></ArticleSummary>
          </el-tab-pane>
          <el-tab-pane label="最新发布">
            <ArticleSummary :article="article" v-for="(article,index) in newArticles" :key="index"></ArticleSummary>
          </el-tab-pane>
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
  import {mapState} from 'vuex'

  export default {
    data(){
      return {
        is_search: false
      }
    },
    name: "MSite",
    components: {ArticleSummary, Footer, AuthorInfo, SideGuide, HeaderTop},
    mounted() {
      this.$store.dispatch('getAllArticles')
      this.$store.dispatch('getHotArticles')
      this.$store.dispatch('getNewArticles')
    },
    computed: {
      ...mapState(['articles','hotArticles','newArticles','category']),
    },
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
</style>
