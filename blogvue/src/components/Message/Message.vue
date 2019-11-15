<template>
  <div class="shadow" style="text-align: left;">
    <div style="margin-left: 10px;margin-bottom: 5px">
      <span>{{message.publishdate}}</span>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <img src="../HeaderTop/image/icon.png" height="40px" width="40px">
      <a style="text-decoration: none;" href="">{{message.commentuserNickName}}</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span>评论了你的文章</span>
      <a href="" style="text-decoration: none;" title="查看详情">查看详情<i class="el-icon-d-arrow-right"></i></a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Message",
    props:{
      message:Object
    }
  }
</script>

<style scoped>

</style>
