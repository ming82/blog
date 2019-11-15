<template>
  <div class="shadow" align="left">
    <el-select v-model="categoryId" placeholder="请选择文章栏目" style="width: 150px;">
      <el-option
        v-for="item in category"
        :key="item.categoryId"
        :label="item.categoryName"
        :value="item.categoryId">
      </el-option>
    </el-select>
    <el-input v-model="articleTitle" placeholder="请输入标题..." style="width: 400px;margin-left: 10px"></el-input>
    <p style="font-size: 15px">请选择文章标签(多选)</p>
    <el-checkbox-group v-model="tags" size="mini">
      <el-checkbox v-for="(item,index) in tag" :key="index" :label="item.tagName" border>{{item.tagName}}</el-checkbox>
    </el-checkbox-group>
    <mavon-editor autofocus='false' v-model="mdContent" ref=md
                  style="min-height:500px;*+height:100%;_height:400px;"/>
    <el-button @click="saveArticle(2,id)">保存到草稿箱</el-button>
    <el-button type="primary" @click="saveArticle(1,id)">发表文章</el-button>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import {postArticle} from "../../api";

  export default {
    name: "PostArticle",

    computed: {
      ...mapState(['user', 'category', 'tag']),
      id() {
        return this.$store.state.user.userId
      },
    },
    data() {
      return {
        articleTitle: '',
        mdContent: '',
        htmlContent: '',
        categoryId: '',
        articleStatus: 0,
        userId: '',
        tags: [],
      }
    },
    inject:["reload"],
    methods: {
      saveArticle(status, id) {
        this.articleStatus = status
        this.htmlContent = this.$refs.md.d_render
        this.userId = id
        postArticle(this.userId, this.articleTitle, this.mdContent, this.htmlContent, this.categoryId, this.articleStatus, this.tags).then(result => {
          if (result.status === "success") {
            this.$message.success(result.resMsg)
            this.reload()
          } else {
            this.$message.error(result.resMsg)
          }
          this.$router.push('/personalspace')
        })
      }
    },
  }

</script>

<style scoped>

</style>
