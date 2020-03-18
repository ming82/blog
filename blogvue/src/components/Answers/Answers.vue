<template>
  <div style="background-color: #fdfdfd;">
    <el-row>
      <!--<el-divider content-position="center"></el-divider>-->
      <el-col :span="24" align="left" class="time">
        <el-tag type="primary" size="medium " style="margin-left: 5px;font-size: 13px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{this.count+1}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</el-tag>
      </el-col>
      <el-col :span="24" align="left" class="time">
        &nbsp;&nbsp;
        <img @click="toUser" :src="answer.userPicture"
             style="cursor:pointer;width: 40px;height: 40px;border-radius: 50px"/>
        <a @click="toUser" class="href" style="cursor: pointer">{{answer.userNickname}}</a>
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
      <el-col>
        <a v-if="comments.length > 0"
           style="float: right;font-size: 12px;cursor: pointer;color: dodgerblue;margin-right: 20px"
           @click="showComment()">展开评论({{comments.length}})</a>
        <a style="float: right;font-size: 12px;cursor: pointer;color: dodgerblue;margin-right: 20px"
           @click="commentAnswer(answer.answerId)">评论</a>
        <el-divider></el-divider>
        <!--        <el-divider content-position="left">-->
        <!--          <div align="left" style="color:#909399;font-size:14px;"><i class="el-icon-chat-dot-round"></i>评论</div>-->
        <!--        </el-divider>-->
      </el-col>
      <el-col v-if="isShowComments">
        <Comments style="margin-left: 50px" :comment="comment" v-for="(comment,index) in comments"
                  :key="index"></Comments>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import Comments from "../Comments/Comments";
  import {postComment, reqAnswerComments} from "../../api/comment";
  import {mapState} from "vuex";

  export default {
    name: "Answers",
    components: {Comments},
    data() {
      return {
        comments: [],
        isShowComments: false,
      }
    },
    props: {
      answer: Object,
      count: ''
    },
    inject: ["reload"],
    methods: {
      toUser() {
        this.$router.push({
          path: `/userpage/${this.answer.userId}`,
        })
      },
      showComment() {
        this.isShowComments = !this.isShowComments
      },
      commentAnswer(answerId) {
        if (!this.user.userId) {
          this.$message.warning("登录后可评论")
          return
        }
        this.$prompt('评论', {
          confirmButtonText: '发表',
          cancelButtonText: '取消',
          inputPattern: /^[\s\S]*.*[^\s][\s\S]*$/,
          inputErrorMessage: '不可为空'
        }).then(({value}) => {
          postComment(value, null, answerId, null, this.user.userId, '').then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.reload()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        })
      }
    },
    mounted() {
      reqAnswerComments(this.answer.answerId).then(result => {
        if (result.status === "success") {
          this.comments = result.data
        }
      })
    },
    computed: {
      ...mapState(['user'])
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
