<template>
  <el-container class="shadow" style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px">
        <div class="shadow">
          <br/>
          <el-divider content-position="left"><h3>问题分类</h3></el-divider>
          <el-menu mode="vertical" @select="handleSelect" active-text-color="#2b2b2b">
            <el-menu-item :class="{on:flag===1}" :index="1">全部问题</el-menu-item>
            <el-menu-item :class="{on:flag===categorys.categoryId}" v-for="(categorys,index) in category" :key="index"
                          :index="categorys.categoryId">{{categorys.categoryName}}
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main class="mainwidth">
        <el-tabs type="border-card">
          <el-tab-pane label="ISSUE">
            <IssueSummary :edit-flag="false" :issue="issue" v-for="(issue,index) in issues" :key="index"></IssueSummary>
            <br>
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page.sync="this.issueQuery.pageNum"
              :page-sizes="[5, 8, 10, 15]"
              :page-size="this.issueQuery.pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </el-tab-pane>
          <el-tab-pane label="等待回答">
            <IssueSummary :edit-flag="false" :issue="issue" v-for="(issue,index) in noAnswerIssues" :key="index"></IssueSummary>
          </el-tab-pane>
          <el-tab-pane label="热门问题">
            <IssueSummary :edit-flag="false" :issue="issue" v-for="(issue,index) in hotIssues" :key="index"></IssueSummary>
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
  import AuthorInfo from "../../components/AuthorInfo/AuthorInfo";
  import Footer from "../../components/Footer/Footer";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import {mapState} from 'vuex'
  import {reqIssueList} from "../../api/issue";

  export default {
    name: "Issues",
    data() {
      return {
        flag: 1,
        total: 0,
        issueQuery:{
          pageSize: 8,
          pageNum: 1,
          categoryId: '',
          userId: '',
          userNickname:'',
          keyword:''
        },
        issues: []
      }
    },
    mounted(){
      this.getList()
      this.$store.dispatch('getHotIssues')
      this.$store.dispatch('getNoAnswerIssues')
    },
    methods:{
      getList(){
        reqIssueList(this.issueQuery.pageNum, this.issueQuery.pageSize, this.issueQuery.categoryId,
          this.issueQuery.userId,this.issueQuery.userNickname,this.issueQuery.keyword).then(result =>{
          this.issues = result.data.list
          this.total = result.data.total
        })
      },
      handleSelect(key) {
        this.issueQuery.pageSize = 8
        this.issueQuery.pageNum = 1
        this.flag = key
        if (key === 1){
          this.issueQuery.categoryId = ''
        } else{
          this.issueQuery.categoryId = key
        }

        this.getList()
      },
      handleSizeChange(val) {
        this.issueQuery.pageSize = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.issueQuery.pageNum = val
        this.getList()
      },
    },
    computed: {
      ...mapState(['category','hotIssues','noAnswerIssues']),
    },
    components: {IssueSummary, Footer, AuthorInfo, HeaderTop}
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
    margin-top 15px
    margin-left 430px

  .unlogin
    margin-top 10px
    margin-left 350px
  .on
    background-color #c1c9d0
</style>
