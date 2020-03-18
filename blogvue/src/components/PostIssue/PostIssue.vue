<template>
  <div class="shadow" align="left">
    <el-select v-model="categoryId" placeholder="请选择提问栏目" style="width: 150px;">
      <el-option
        v-for="item in category"
        :key="item.categoryId"
        :label="item.categoryName"
        :value="item.categoryId">
      </el-option>
    </el-select>
    <el-input v-model="issueTitle" placeholder="请输入标题..." style="width: 400px;margin-left: 10px"></el-input>
    <mavon-editor autofocus='false' v-model="mdContent" ref=md
                  style="min-height:500px;*+height:100%;_height:400px;"/>
    <el-button type="primary" @click="saveIssue(1,id)">发表提问</el-button>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import {postIssue} from "../../api/issue";

  export default {
    name: "PostIssue",
    computed: {
      ...mapState(['user', 'category']),
      id() {
        return this.$store.state.user.userId
      },
    },
    data() {
      return {
        issueTitle: '',
        mdContent: '',
        htmlContent: '',
        categoryId: '',
        userId: '',
      }
    },
    inject: ["reload"],
    methods: {
      saveIssue(status, id) {
        if (this.issueTitle === '') {
          this.$message.warning("请输入提问标题")
          return
        } else if (this.categoryId === '') {
          this.$message.warning("请选择提问分类")
          return
        } else if (this.mdContent === '') {
          this.$message.warning("提问内容不可为空")
          return
        } else {
          this.articleStatus = status
          this.htmlContent = this.$refs.md.d_render
          this.userId = id
          postIssue(this.userId, this.issueTitle, this.mdContent, this.htmlContent, this.categoryId,).then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.reload()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }
      }
    },
  }
</script>

<style scoped>

</style>
