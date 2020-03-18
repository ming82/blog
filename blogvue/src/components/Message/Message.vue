<template>
  <div class="shadow" style="text-align: left;">
    <div style="margin-left: 10px;margin-bottom: 5px">
      <span>{{message.publishdate}}</span>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <img @click="toUser(message.commentuserid)" :src="message.userPicture" height="40px" width="40px" style="cursor:pointer;border-radius: 50px">
      <a @click="toUser(message.commentuserid)" style="text-decoration: none;cursor: pointer">{{message.commentuserNickName}}</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span v-if="message.messageType == 0">评论了你：{{message.commentBody}}</span>
      <span v-if="message.messageType == 1">赞了你</span>
      <span v-if="message.messageType == 2">回复了你：{{message.commentBody}}</span>
      <a v-if="message.articleId!=null" style="text-decoration: none;cursor: pointer;color: darkmagenta" @click="toArticle(message.articleId)">查看详情<i class="el-icon-d-arrow-right"></i></a>
      <a v-if="message.answerId!=null" style="text-decoration: none;cursor: pointer;color: darkmagenta" @click="toAnswer(message.answerId)">查看详情<i class="el-icon-d-arrow-right"></i></a>
    </div>
  </div>
</template>

<script>

  import {reqAnswerById} from "../../api/answer";

  export default {
    name: "Message",
    props:{
      message:Object
    },
    methods:{
      toUser(userId){
        this.$router.push({
          path: `/userpage/${userId}`,
        })
      },
      toArticle(id){
        this.$router.push({
          path: `/article/`+id,
        })
      },
      toAnswer(id){
        reqAnswerById(id).then(result =>{
          if(result.status === "success"){
            this.$router.push({
              path: `/issue/`+result.data.issueId,
            })
          }
        })
      },
    },
  }
</script>

<style scoped>

</style>
