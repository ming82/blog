<template>
  <div style="background-color: #fdfdfd;">
    <el-row>
      <!--<el-divider content-position="center"></el-divider>-->
      <el-col :span="24" align="left" class="time">
        <el-tag type="info" style="margin-left: 5px">{{this.count+1}}</el-tag>
      </el-col>
      <el-col :span="24" align="left" class="time">
        &nbsp;&nbsp;
        <img src="../AuthorInfo/image/picture.png" style="width: 40px;height: 40px"/>
        <a class="href" href="">{{answer.userNickname}}</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>{{answer.publishdate}}</span>
      </el-col>
      <el-col>
        <br/>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div v-html="answer.htmlcontent"></div>
        <br/>
      </el-col>
      <!--<el-col>-->
        <!--<el-divider content-position="left">-->
          <!--<div align="left" style="color:#909399;font-size:14px;"><i class="el-icon-chat-dot-round"></i>评论</div>-->
        <!--</el-divider>-->
      <!--</el-col>-->
    </el-row>
    <!--<Comments :comment="comment" v-for="(comment,index) in comments" :key="index"></Comments>-->
  </div>
</template>

<script>
  import Comments from "../Comments/Comments";
  import {reqAnswerComments} from "../../api";
  export default {
    name: "Answers",
    components: {Comments},
    data() {
      return {
        comments:[],
      }
    },
    props: {
      answer: Object,
      count:''
    },
    mounted() {
      reqAnswerComments(this.answer.answerId).then(result => {
        if (result.status === "200") {
          this.comments = result.data
        }
      })
    },
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
