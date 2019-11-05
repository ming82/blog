<template>
  <div class="shadow">
    <el-row style="min-height:800px;*+height:100%;_height:400px;">
      <el-col :span="24" align="left" class="marginleft">
        <h2><span>{{article.articleTitle}}</span>
          <el-tag v-for="(tag,index) in article.tags" :key="index">{{tag}}</el-tag>
        </h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">
        <span>{{article.publishdate}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="href" href="">{{article.userNickname}}</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>阅读数：{{article.articlePageviews}}</span>
      </el-col>
      <el-col>
        <div style="margin-right: 10px;margin-left: 10px;">
          <el-divider></el-divider>
        </div>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div v-html="article.htmlcontent"></div>
      </el-col>
    </el-row>
    <div class="edittime">
      <v-icon name="thumbs-up"></v-icon>
      <span class="summary">×{{article.articleLikes}}</span>
      <span>{{article.edittime}}</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ArticleDetail",
    props:{
      article: Object,
    }
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
