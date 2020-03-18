<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-main>
        <el-tabs type="border-card" class="shadow" style="background-color: #fdfdfd;width: 70%;margin-left: 15%;">
          <el-tab-pane label="搜索文章：">
            <span v-if="this.articleTotal === 0">抱歉，暂无结果</span>
            <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in articles"
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
          <el-tab-pane label="搜索提问：">
            <span v-if="this.issueTotal === 0">抱歉，暂无结果</span>
            <IssueSummary :issue="issue" :edit-flag="false" v-for="(issue,index) in issues"
                          :key="index"></IssueSummary>
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
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import {reqArticleList} from "../../api/article";
  import {reqIssueList} from "../../api/issue";

  export default {
    name: "Search",
    data() {
      return {
        articles: [],
        issues: [],
        articleTotal: 0,
        articleQuery: {
          pageSize: 5,
          pageNum: 1,
          categoryId: '',
          keyword: '',
          userNickname:''
        },
        issueTotal: 0,
        issueQuery: {
          pageSize: 5,
          pageNum: 1,
          categoryId: '',
          keyword: '',
          userNickname:''
        }
      }
    },
    methods: {
      getArticleList() {
        reqArticleList(this.articleQuery.pageNum, this.articleQuery.pageSize
          , this.articleQuery.categoryId, '', this.articleQuery.userNickname,this.articleQuery.keyword).then(result => {
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
          , this.issueQuery.categoryId, '',this.issueQuery.userNickname, this.issueQuery.keyword).then(result => {
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
    mounted() {
      this.articleQuery.keyword = this.$route.params.keyword
      this.issueQuery.keyword = this.$route.params.keyword
      this.getArticleList()
      this.getIssueList()
    },
    components: {HeaderTop, ArticleSummary, IssueSummary}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .shadow
    background-color #fdfdfd
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
</style>
