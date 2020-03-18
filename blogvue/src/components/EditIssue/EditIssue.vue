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
    <el-input v-model.trim="issueTitle" placeholder="请输入标题..." style="width: 400px;margin-left: 10px"></el-input>
    <mavon-editor autofocus='false' v-model="mdContent" ref=md
                  style="min-height:500px;*+height:100%;_height:400px;"/>
    <el-button type="primary" @click="commit()">提交</el-button>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import {editIssue} from "../../api/issue";

  export default {
    name: "EditIssue",
    props: {
      issue: Object
    },
    mounted() {
      this.issueId = this.issue.issueId
      this.issueTitle = this.issue.issueTitle
      this.mdContent = this.issue.mdcontent
      this.htmlContent = this.issue.htmlcontent
      this.categoryId = this.issue.categoryId
      this.issueStatus = this.issue.issueStatus
      this.userId = this.issue.userId
    },
    computed: {
      ...mapState(['user', 'category']),
      id() {
        return this.$store.state.user.userId
      },
    },
    data() {
      return {
        issueId: '',
        issueTitle: '',
        mdContent: '',
        htmlContent: '',
        categoryId: '',
        issueStatus: '',
        userId: '',
      }
    },
    inject: ["reload"],
    methods: {
      commit() {
        if (this.issueTitle === '') {
          this.$message.warning("请输入提问标题")
          return
        } else if (this.mdContent === '') {
          this.$message.warning("提问内容不可为空")
          return
        } else {
          this.htmlContent = this.$refs.md.d_render
          editIssue(this.issueId, this.userId, this.issueTitle, this.mdContent, this.htmlContent, this.categoryId).then(result => {
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
