<template>
  <div class="shadow">
    <el-row>
      <el-divider content-position="center"></el-divider>
      <el-col :span="24" align="left" class="time">
        <el-tag></el-tag>
        <img src="../AuthorInfo/image/picture.png" style="width: 40px;height: 40px"></img>
        <a class="href" href="">司命</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>2018-8-8</span>
      </el-col>
      <el-col>
        <br/>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div>回答正文</div>
      </el-col>
      <el-col><el-divider></el-divider>
        <div align="left" style="margin-left: 10px;"><i class="el-icon-chat-dot-round"></i>评论</div>
        <br/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "Answers"
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
