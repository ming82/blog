<template>
  <div class="shadow" align="left" style="margin-left: 15px;">
    <div style="margin-left: 10px;">
      <img src="../AuthorInfo/image/picture.png" style="width: 30px;height: 30px">
      <a style="text-decoration: none;" href="">{{comment.userNickname}}</a>
      <span style="color:#909399;font-size:14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{comment.publishdate}}</span>
    </div>
    <div>
      <span style="cursor: pointer" v-if="user.userId" @click="answer(comment.commentId)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{comment.commentBody}}</span>
      <span style="cursor: pointer" v-else @click="noLogin()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{comment.commentBody}}</span>
    </div>
    <div class="comment" style="margin-left: 40px;background-color: #f2f2f2">
      <div v-for="(commentAnswer,index) in comment.commentAnswers" :key="index">
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">{{commentAnswer.userNickname}}</a>
        回复
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">{{commentAnswer.commentParentUserNickname}}</a>:
        <span>{{commentAnswer.commentBody}}</span>
        <!--<p><span style="text-align: right;margin-right: 2px;">{{commentAnswer.publishdate}}</span></p>-->
      </div>
    </div>
    <br/>
  </div>
</template>

<script>
  import {mapState} from "vuex";
  import {postComment} from "../../api";

  export default {
    name: "Comments",
    props: {
      comment: [],
    },
    inject:["reload"],
    methods:{
      answer(parentId){
        this.$prompt('回复', {
          confirmButtonText: '发表',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          postComment(value,null,null,parentId,this.user.userId).then(result=>{
            if(result.status === "success"){
              this.$message.success(result.resMsg)
              this.reload()
            }else {
              this.$message.error(result.resMsg)
            }
          })
        })

      },
      noLogin(){
        this.$message.warning("登录后可回复")
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
