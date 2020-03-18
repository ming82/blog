<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue; ">
      <el-aside width="200px">
        <div class="shadow">
          <br/>
          <el-divider content-position="left"><h3>文章分类</h3></el-divider>
          <el-menu mode="vertical" @select="handleSelect" active-text-color="#2b2b2b">
            <el-menu-item :class="{on:flag===1}" :index="1">全部文章</el-menu-item>
            <el-menu-item :class="{on:flag===categorys.categoryId}" v-for="(categorys,index) in category" :key="index"
                          :index="categorys.categoryId">{{categorys.categoryName}}
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main class="mainwidth">
        <el-tabs type="border-card">
          <el-tab-pane label="ARTICLE">
            <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in articles"
                            :key="index"></ArticleSummary>
            <br>
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page.sync="this.articleQuery.pageNum"
              :page-sizes="[5, 8, 10, 15]"
              :page-size="this.articleQuery.pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </el-tab-pane>
          <el-tab-pane label="近期热门">
            <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in hotArticles"
                            :key="index"></ArticleSummary>
          </el-tab-pane>
          <el-tab-pane label="最新发布">
            <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in newArticles"
                            :key="index"></ArticleSummary>
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
  import Footer from "../../components/Footer/Footer";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import {mapState} from 'vuex'
  import {reqArticleList} from "../../api/article";

  export default {
    data() {
      return {
        flag: 1,
        articles:[],
        total: 0,
        articleQuery:{
          pageSize: 8,
          pageNum: 1,
          categoryId: '',
          userId: '',
          keyword:'',
          userNickname:''
        }
      }
    },
    name: "Articles",
    components: {ArticleSummary, Footer, HeaderTop},
    mounted() {
      this.$store.dispatch('getHotArticles')
      this.$store.dispatch('getNewArticles')
      this.getList()
    },
    methods: {
      handleSelect(key) {
        this.articleQuery.pageSize = 8
        this.articleQuery.pageNum = 1
        this.flag = key
        if (key === 1){
          this.articleQuery.categoryId = ''
        } else{
          this.articleQuery.categoryId = key
        }

        this.getList()
      },
      getList() {
        reqArticleList(this.articleQuery.pageNum, this.articleQuery.pageSize
          , this.articleQuery.categoryId, this.articleQuery.userId,this.articleQuery.userNickname,this.articleQuery.keyword).then(result => {
          this.articles = result.data.list
          this.total = result.data.total
        })
      },
      handleSizeChange(val) {
        this.articleQuery.pageSize = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.articleQuery.pageNum = val
        this.getList()
      },
    },
    computed: {
      ...mapState(['hotArticles', 'newArticles', 'category']),
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
  .on
    background-color #c1c9d0
</style>
