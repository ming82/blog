<template>
  <div class="shadow textleft">
    <div>
      <a class="articlehref" style="cursor: pointer;" @click="toIssue()">
        <div>
          <h3 class="title">
            <span>{{issue.issueTitle}}</span>
          </h3>
        </div>
      </a>
      <div align="left">
        <i class="el-icon-chat-dot-round"></i><span class="summary">×{{issue.issueAnswers}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="summary">{{issue.userNickname}}</span>
        <span class="summary time">{{issue.publishdate}}</span>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "IssueSummary",
    props:{
      issue:Object,
    },
    methods:{
      toIssue(){
        this.$router.push({
          path: `/issue/${this.issue.issueId}`,
        })
      }
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .time
    margin-left  650px
  .articlehref
    text-decoration none
  .summary
    color #909399
    font-size 14px
    text-align left
    text-decoration none
  .title
    color #303133
    text-align left
    text-decoration none
</style>
