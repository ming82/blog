<template>
  <div class="shadow" align="left" >
    <div style="margin-left: 10px;">
      <img @click="toUser(comment.userId)" :src="comment.userPicture" style="cursor:pointer;width: 30px;height: 30px;border-radius: 50px">
      <a @click="toUser(comment.userId)" style="text-decoration: none;cursor: pointer">{{comment.userNickname}}</a>
      <span style="color:#909399;font-size:14px;margin-left: 40px">{{comment.publishdate}}</span>
    </div>
    <br>
    <div>
      <span style="margin-left: 40px">{{comment.commentBody}}</span>
      <a style="float: right;font-size: 12px;cursor: pointer;color: dodgerblue;margin-right: 10px" @click="showAnswer"
         v-if="comment.commentAnswers.length != 0">展开回复({{comment.commentAnswers.length}})</a>
      <a style="float: right;font-size: 12px;cursor: pointer;color: dodgerblue;margin-right: 20px" @click="answer(comment.commentId,comment.userNickname)">回复</a>
    </div>
    <br>
    <div class="comment" style="margin-left: 40px;background-color: #f2f2f2" v-if="isShowAnswer">
      <div v-for="(commentAnswer,index) in comment.commentAnswers" :key="index">
        <img @click="toUser(commentAnswer.userId)" :src="commentAnswer.userPicture" class="image" style="cursor:pointer;width: 30px;height: 30px;border-radius: 50px">
        <a @click="toUser(commentAnswer.userId)" style="cursor: pointer" class="namehref">{{commentAnswer.userNickname}}</a>
        &nbsp;&nbsp;&nbsp;&nbsp;回复&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="namehref" style="cursor: pointer" @click="toUser(commentAnswer.commentToUserId)">{{commentAnswer.commentTo}}</a>&nbsp;&nbsp;:
        <span>{{commentAnswer.commentBody}}</span>
        <a style="float: right;font-size: 12px;cursor: pointer;color: #909399;margin-right: 20px" @click="answer(comment.commentId,commentAnswer.userNickname)">回复</a>
<!--        <span style="text-align: right;margin-right: 2px;float: right">{{commentAnswer.publishdate}}</span>-->
      </div>
    </div>
    <br/>
  </div>
</template>

<script>
  import {mapState} from "vuex";
  import {postComment} from "../../api/comment";

  export default {
    name: "Comments",
    props: {
      comment: Object,
    },
    data(){
      return{
        isShowAnswer: false
      }
    },
    inject:["reload"],
    methods:{
      toUser(userId){
        this.$router.push({
          path: `/userpage/${userId}`,
        })
      },
      answer(parentId,commentTo){
        if(!this.user.userId){
          this.$message.warning("登录后可回复")
          return
        }
        this.$prompt('回复', {
          confirmButtonText: '发表',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          postComment(value,null,null,parentId,this.user.userId,commentTo).then(result=>{
            if(result.status === "success"){
              this.$message.success(result.resMsg)
              this.reload()
            }else {
              this.$message.error(result.resMsg)
            }
          })
        })
      },
      showAnswer(){
        this.isShowAnswer = !this.isShowAnswer
      }
    },
    computed:{
      ...mapState(['user'])
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .image
    width: 20px
    height: 20px
    margin-top 5px
    margin-left 5px

  .namehref
    text-decoration none
    margin-top 5px
    margin-left 5px

  .comment
    color dimgrey
    font-size 14px
</style>
