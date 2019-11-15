<template>
  <div class="shadow textleft">
    <div>
      <a class="articlehref"  @click="toArticle()">
        <div>
          <h4 class="title">
            <span>{{article.articleTitle}}</span>
            <el-tag v-for="(tag,index) in article.tags" :key="index">{{tag}}</el-tag>
          </h4>
        </div>
        <div>
          <p class="summary">{{article.articleSummary}}</p>
        </div>
      </a>
      <div align="left">
        <v-icon name="thumbs-up"></v-icon><span class="summary">×{{article.articleLikes}}</span>
        &nbsp;&nbsp;
        <i class="el-icon-chat-dot-round"></i><span class="summary">×{{article.articleComments}}</span>
        &nbsp;&nbsp;
        <i class="el-icon-view"></i><span class="summary">&nbsp;{{article.articlePageviews}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="summary">{{article.userNickname}}</span>
        <span class="summary time">{{article.publishdate}}</span>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    props: {
      article: Object
    },
    name: "ArticleSummary",
    methods:{
      toArticle(){
        this.$router.push({
          path: `/article/${this.article.articleId}`,
        })
      }
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .time
    margin-left  500px
  .articlehref
    cursor pointer
    text-decoration none
  .summary
    color #909399
    font-size 14px
    text-align left
    text-decoration none
  .title
    color #303133
    text-align left
    text-decoration none
</style>
