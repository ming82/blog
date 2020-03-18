<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue; ">
      <el-main>
        <div class="shadow" style="background-color: #fdfdfd;width: 75%;margin-left: 13%;">
          <el-row>
            <el-col :span="3">
              <img :src="userInfo.userPicture"
                   style="width: 60px;height: 60px;border-radius: 50px;margin: 30px 20px 20px">
              <span class="time" style="float: left;margin-left: 30px;margin-bottom: 10px">{{userInfo.userRegistetime | formatDate}}</span>

            </el-col>
            <el-col :span="18">
              <el-row>
                <h2 style="float: left;margin-top: 30px">{{userInfo.userNickname}}</h2>
              </el-row>
              <el-row>
              </el-row>
              <el-row>
                <span v-if="userInfo.userSignature"
                      style="margin-left:15px;float: left;margin-top: 10px;text-align: left">{{userInfo.userSignature}}</span>
                <span v-else class="time" style="margin-left:15px;float: left;margin-top: 10px;text-align: left">这个人很懒什么也没有留下...</span>
              </el-row>
              <br/>
            </el-col>
            <el-col :span="3">
              <el-tag style="height: 100px;width: 100px;margin-top: 20px" plain>
                <el-row>
                  <h3>获赞&nbsp;&nbsp;&nbsp;<i class="el-icon-s-opportunity"></i></h3>
                </el-row>
                <el-row>
                  <span style="font-size: 15px">{{userInfo.likes}}</span>
                </el-row>
              </el-tag>
            </el-col>
          </el-row>
        </div>
        <br/>
        <div class="shadow" style="background-color: #fdfdfd;width: 75%;margin-left: 13%;
            min-height:500px;*+height:100%;_height:400px;">
          <el-tabs style="margin-left: 30px;">
            <el-tab-pane label="TA的文章">
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
            <el-tab-pane label="TA的提问">
              <IssueSummary :edit-flag="false" :issue="issue" v-for="(issue,index) in issues"
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
            <el-tab-pane label="TA的收藏">
              <ArticleSummary :article="article" :edit-flag="false" v-for="(article,index) in favorites"
                              :key="index"></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop.vue";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary.vue";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import {reqArticleList} from "../../api/article";
  import {reqUserInfo} from "../../api/user";
  import {reqFavoriteArticle} from "../../api/favorite";
  import {formatTimeToStr} from "../../utils/date";
  import {reqIssueList,reqIssueByUserId} from "../../api/issue";

  export default {
    name: "UserPage",
    data() {
      return {
        articles: [],
        issues: [],
        favorites: [],
        userInfo: [],
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
    filters: {
      formatDate: function (time) {
        if (time != null && time != "") {
          var date = new Date(time);
          return formatTimeToStr(date, "yyyy-MM-dd");
        } else {
          return "";
        }
      }
    },
    mounted() {
      this.getArticleList()
      this.getIssueList()
      reqUserInfo(this.$route.params.userId).then(result => {
        if (result.status === "success") {
          this.userInfo = result.data
        }
      })
      reqIssueByUserId(this.$route.params.userId).then(result => {
        if (result.status === "success") {
          this.issues = result.data
        }
      })
      reqFavoriteArticle(this.$route.params.userId).then(result => {
        if (result.status === "success") {
          this.favorites = result.data
        }
      })
    },
    methods: {
      getArticleList() {
        reqArticleList(this.articleQuery.pageNum, this.articleQuery.pageSize
          , this.articleQuery.categoryId, this.$route.params.userId,this.articleQuery.userNickname,this.articleQuery.keyword).then(result => {
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
          , this.issueQuery.categoryId, this.$route.params.userId,this.issueQuery.userNickname, this.issueQuery.keyword).then(result => {
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
    components: {HeaderTop, ArticleSummary, IssueSummary}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>

  .shadow
    background-color #fdfdfd
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

  .time
    color #909399
    font-size 16px
    text-align left

</style>
