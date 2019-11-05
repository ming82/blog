<template>
  <div style="background-color: #fdfdfd;">
    <el-row>
      <el-col :span="24" align="left" class="marginleft">
        <h2>{{issue.issueTitle}}</h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">
        <span>{{issue.publishdate}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="href" href="">{{issue.userNickname}}</a>
      </el-col>
      <el-col>
        <div style="margin-right: 10px;margin-left: 10px;">
          <el-divider></el-divider>
        </div>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div v-html="issue.htmlcontent"></div>
      </el-col>
      <el-col>
        <br/>
        <br/>
        <el-divider content-position="left"><span style="font-size: 25px"> {{issue.issueAnswers}}个回答</span></el-divider>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "IssueDeatil",
    props: {
      issue: Object
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .href
    text-decoration none

  .time
    color #909399
    font-size 16px
    text-align left

  .height
    height 200px

  .marginleft
    margin-left 20px
</style>
