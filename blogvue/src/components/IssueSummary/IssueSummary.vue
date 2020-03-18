<template>
  <div class="shadow textleft">
    <div>
      <a class="articlehref" style="cursor: pointer;" @click="toIssue()">
        <div>
          <h3 class="title">
            <span>{{issue.issueTitle}}</span>
          </h3>
        </div>
      </a>
      <div align="left">
        <i class="el-icon-document"></i><span class="summary">×{{issue.issueAnswers}}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="summary">{{issue.userNickname}}</span>
        <span class="summary time">{{issue.publishdate}}</span>
      </div>
    </div>
    <br/>
    <div v-if="this.editFlag" style="display: inline-block">
      <el-button type="primary" @click="editClick"><i class="el-icon-edit"></i></el-button>
      &nbsp;&nbsp;
      <el-button type="danger" @click="deleteClick(issue.issueId)"><i class="el-icon-delete"></i></el-button>
    </div>
    <el-dialog title="编辑提问" :visible.sync="editDialog" width="80%">
      <EditIssue :issue="issue"></EditIssue>
    </el-dialog>
  </div>
</template>

<script>
  import EditIssue from "../EditIssue/EditIssue";
  import {deleteIssue} from "../../api/issue";

  export default {
    name: "IssueSummary",
    data() {
      return{
        editDialog: false
      }
    },
    inject:["reload"],
    props: {
      issue: Object,
      editFlag: Boolean
    },
    methods: {
      toIssue() {
        this.$router.push({
          path: `/issue/${this.issue.issueId}`,
        })
      },
      editClick() {
        this.editDialog = true
      },
      deleteClick(issueId) {
        this.$confirm('是否删除此提问？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteIssue(issueId).then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.reload()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消',
            duration: 1000
          });
        });
      },
    },
    components: {EditIssue}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .time
    float right
    margin-right 10px

  .articlehref
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
