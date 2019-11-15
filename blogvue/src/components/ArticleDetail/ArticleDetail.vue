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
      <div @click="likeClick()" v-if="user.userId">
        <v-icon name="thumbs-up" style="cursor: pointer"></v-icon>
        <span class="summary">×{{article.articleLikes}}</span>
      </div>
      <div @click="noLogin()" v-else>
        <v-icon name="thumbs-up" style="cursor: pointer"></v-icon>
        <span class="summary">×{{article.articleLikes}}</span>
      </div>

      <span>{{article.edittime}}</span>
    </div>
  </div>
</template>

<script>
  import {like} from "../../api";
  import {mapState} from "vuex";

  export default {
    name: "ArticleDetail",
    props:{
      article: Object,
    },
    inject:["reload"],
    methods:{
      likeClick(){
        like(this.article.articleId,this.user.userId).then(result=>{
          if(result.status === "success"){
            this.$message.success(result.resMsg)
            this.reload()
          }
          else
            this.$message.error(result.resMsg)
        })
      },
      noLogin(){
        this.$message.warning("登录后可点赞")
      }
    },
    computed:{
      ...mapState(['user'])
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
