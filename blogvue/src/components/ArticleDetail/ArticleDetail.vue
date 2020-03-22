<template>
  <div class="shadow">
    <el-row style="min-height:800px;*+height:100%;_height:400px;">
      <el-col :span="24" class="marginleft">
        <h2 align="left">
          <span>{{article.articleTitle}}</span>
          <el-tag v-for="(tag,index) in article.tags" :key="index">{{tag}}</el-tag>
          <el-button style="float: right;margin-right: 50px" type="primary" @click="favoriteClick" plain>
            <i v-if="isFavorited" class="el-icon-star-on"></i>
            <i v-else class="el-icon-star-off"></i>
            收藏
          </el-button>
        </h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">

        <img @click="toUser" :src="article.userPicture"
             style="width: 40px;height: 40px;border-radius: 50px;cursor: pointer"/>
        <span @click="toUser" style="cursor: pointer">{{article.userNickname}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>{{article.publishdate}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span>阅读：{{article.articlePageviews}}</span>
        &nbsp;
        <span>收藏：{{article.articleFavorites}}</span>
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

      <span>文章最后编辑于&nbsp;{{article.edittime}}</span>
    </div>
  </div>
</template>

<script>
  import {like} from "../../api/article";
  import {mapState} from "vuex";
  import {favorite, checkFavorited, cancelFavorite} from "../../api/favorite";

  export default {
    data() {
      return {
        isFavorited: false,
      }
    },
    name: "ArticleDetail",
    props: {
      article: Object,
    },
    mounted() {
      checkFavorited(this.article.articleId, this.user.userId).then(result => {
        if (result.status === "success") {
          this.isFavorited = true
        }
      })
    },
    methods: {
      toUser() {
        this.$router.push({
          path: `/userpage/${this.article.userId}`,
        })
      },
      favoriteClick() {
        if (this.user.userId) {
          if (this.isFavorited == true) {
            this.$confirm('是否取消收藏？', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              cancelFavorite(this.article.articleId, this.user.userId).then(result => {
                if (result.status === "success") {
                  this.$message.success(result.resMsg)
                  this.isFavorited = false
                } else
                  this.$message.error(result.resMsg)
              })
            });
          } else {
            if (this.article.userId == this.user.userId) {
              this.$message.warning("抱歉，无法收藏自己文章")
              return
            }
            favorite(this.article.articleId, this.user.userId).then(result => {
              if (result.status === "success") {
                this.$message.success(result.resMsg)
                this.isFavorited = true
              } else
                this.$message.error(result.resMsg)
            })
          }
        }else {
          this.$message.warning("登录后可收藏")
        }
      },
      likeClick() {
        if (this.article.userId == this.user.userId) {
          this.$message.warning("抱歉，无法给自己文章点赞")
          return
        }
        like(this.article.articleId, this.user.userId).then(result => {
          if (result.status === "success") {
            this.$message.success(result.resMsg)
          } else
            this.$message.error(result.resMsg)
        })
      },
      noLogin() {
        this.$message.warning("登录后可点赞")
      }
    },
    computed: {
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

  .marginright
    margin-right 20px
</style>
