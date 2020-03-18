<template>
  <div class="shadow textleft" >
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

        <i class="el-icon-star-on"></i><span class="summary">×{{article.articleComments}}</span>
        &nbsp;&nbsp;
        <i class="el-icon-view"></i><span class="summary">&nbsp;{{article.articlePageviews}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="summary">{{article.userNickname}}</span>
        <span class="summary time">{{article.publishdate}}</span>
      </div>
    </div>
    <div v-if="this.editFlag" style="display: inline-block">
      <el-button type="primary" @click="editClick"><i class="el-icon-edit"></i></el-button>
      &nbsp;&nbsp;
      <el-button type="danger" @click="deleteClick(article.articleId)"><i class="el-icon-delete"></i></el-button>
    </div>
    <el-dialog title="编辑文章" :visible.sync="editDialog" width="80%">
      <EditArticle :article="article" ></EditArticle>
    </el-dialog>
  </div>
</template>

<script>
  import {deleteArticle} from "../../api/article";
  import EditArticle from "../EditArticle/EditArticle";

  export default {
    components: {EditArticle},
    data() {
      return{
        editDialog: false
      }
    },
    props: {
      article: Object,
      editFlag: Boolean
    },
    name: "ArticleSummary",
    inject:["reload"],
    methods:{
      toArticle(){
        this.$router.push({
          path: `/article/${this.article.articleId}`,
        })
      },
      editClick(){
        this.editDialog = true
      },
      deleteClick(articleId){
        this.$confirm('是否删除此文章？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteArticle(articleId).then(result =>{
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.reload()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).catch(() => {
        });
      }
    }
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .time
    float right
    margin-right  10px
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
