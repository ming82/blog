<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-main>
        <div class="shadow" style="background-color: #fdfdfd;width: 80%;margin-left: 10%;">
          <el-carousel height="280px">
            <el-carousel-item v-for="item in 4" :key="item">
              <img src="http://localhost:8080/image/page.jpg">
            </el-carousel-item>
          </el-carousel>
        </div>
        <br>
        <el-row style="width: 80%;margin-left: 10%;">
          <el-col :span="18" class="shadow" style="background-color: #fdfdfd;">
            <el-tabs type="border-card">
              <el-tab-pane label="BLOG">
                <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in newArticles"
                                :key="index"></ArticleSummary>
              </el-tab-pane>
            </el-tabs>
          </el-col>
          <el-col :span="1">
            &nbsp;
          </el-col>
          <el-col :span="5" class="shadow" style="background-color: #fdfdfd;">
            <el-tabs type="border-card">
              <el-tab-pane label="为你推荐">
                <div v-for="(article,index) in hotArticles" :key="index" style="cursor: pointer" @click="toArticle(article.articleId)">
                  <el-divider></el-divider>
                  <h4 class="title">
                    <span>{{article.articleTitle}}</span>
                    <el-tag v-for="(tag,index) in article.tags" :key="index">{{tag}}</el-tag>
                  </h4>
                  <span class="summary">{{article.articleSummary | summaryFilter}}</span>
                  <br>
                </div>
              </el-tab-pane>
            </el-tabs>
          </el-col>
        </el-row>
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
  import {mapState} from 'vuex'

  export default {
    filters: {
      summaryFilter(value) {
        if (value && value.length > 10) {
          value = value.substring(0, 10) + '...';
        }
        return value;
      }
    },
    name: "MSite",
    components: {ArticleSummary, Footer, HeaderTop},
    mounted() {
      this.$store.dispatch('getHotArticles')
      this.$store.dispatch('getNewArticles')
    },
    methods: {
      toArticle(articleId){
        this.$router.push({
          path: `/article/${articleId}`,
        })
      }
    },
    computed: {
      ...mapState(['hotArticles', 'newArticles']),
    },
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
    margin-bottom 5px

  .el-button
    border 0px

  .on
    background-color #c1c9d0

  .title
    color #303133
    text-align left
    text-decoration none

  .summary
    float left
    color #909399
    font-size 14px
    text-align left
    text-decoration none
</style>
