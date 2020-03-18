<template>
  <div class="shadow">
    <br/>
    <div>
      <img :src="userInfo.userPicture" style="width: 50px;height: 50px;border-radius:50px">
      <div>
        <span>{{userInfo.userNickname}}</span>
        <br>
        <el-link @click="toUser" type="info">TA的个人主页<i class="el-icon-d-arrow-right"></i></el-link>
      </div>
    </div>
    <br/>
    <table style="border-collapse:separate; border-spacing:0px 10px;">
      <tr>
        <td>注册时间</td>
        <td>{{userInfo.userRegistetime | formatDate}}</td>
        <td></td>
      </tr>
      <tr>
        <td>邮箱</td>
        <td>{{userInfo.userEmail}}</td>
      </tr>
      <tr>
        <td>文章</td>
        <td>{{userInfo.articleNum}}</td>
        <td>篇</td>
      </tr>
      <tr>
        <td>回答</td>
        <td>{{userInfo.answerNum}}</td>
        <td>篇</td>
      </tr>
      <tr>
        <td>提问</td>
        <td>{{userInfo.issuesNum}}</td>
        <td>篇</td>
      </tr>
      <tr>
        <td>获赞</td>
        <td>{{userInfo.likes}}</td>
        <td>个</td>
      </tr>
    </table>
    <br>
  </div>
</template>

<script>

  import {formatTimeToStr} from "../../utils/date";

  export default {
    name: "AuthorInfo",
    props:{
      userInfo: Object,
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
    methods:{
      toUser(){
        this.$router.push({
          path: `/userpage/${this.userInfo.userId}`,
        })
      },
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>

</style>
