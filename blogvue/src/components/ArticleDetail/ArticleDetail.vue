<template>
  <div class="shadow">
    <el-row style="min-height:800px;*+height:100%;_height:400px;">
      <el-col :span="24" align="left" class="marginleft">
        <h2><span>这是一个标题</span>
          <el-tag>sdfd</el-tag>
        </h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">
        <span>2018-8-8</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="href" href="">司命</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>阅读数：6</span>
      </el-col>
      <el-col>
        <div style="margin-right: 10px;margin-left: 10px;">
          <el-divider></el-divider>
        </div>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div>文章正文</div>
      </el-col>
    </el-row>
    <div class="edittime">
      <v-icon name="thumbs-up"></v-icon>
      <span class="summary">×6</span>
      <span>文章最后编辑与2018-8-9</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ArticleDetail"
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .edittime
    color #909399
    font-size 14px
    text-align right
    margin-right 10px

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
