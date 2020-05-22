<template>
  <div style="background-color: #fdfdfd;">
    <el-row>
      <el-col :span="24" align="left" class="marginleft">
        <h2>{{issue.issueTitle}}</h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">
        <img @click="toUser" :src="issue.userPicture" style="cursor:pointer;width: 40px;height: 40px;border-radius: 50px"/>
        <span @click="toUser" style="cursor: pointer">{{issue.userNickname}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>{{issue.publishdate}}</span>
      </el-col>
      <el-col>
<!--        <div style="margin-right: 10px;margin-left: 10px;">-->
<!--          <el-divider></el-divider>-->
<!--        </div>-->
        <br>
        <br>
      </el-col>
      <el-col :span="24" align="left" style="padding: 0px 20px 0px 20px">
        <div v-html="issue.htmlcontent"></div>
      </el-col>
      <el-col align="left">
        <el-divider></el-divider>
        <span style="font-size: 20px;margin-left: 20px" v-if="issue.issueAnswers == 0"> 暂无回答</span>
        <span style="font-size: 20px;margin-left: 20px" v-else> {{issue.issueAnswers}}个回答</span>
        <el-divider></el-divider>
      </el-col>
    </el-row>
  </div>
</template>

<script>

  export default {
    name: "IssueDeatil",
    props: {
      issue: Object
    },
    methods:{
      toUser(){
        this.$router.push({
          path: `/userpage/${this.issue.userId}`,
        })
      },
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
