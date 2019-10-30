<template>
    <div class="shadow">
      <div style="margin-left: 10px;margin-right: 10px;">
        <el-input
          style="margin-top: 10px;"
          type="textarea"
          :rows="2"
          placeholder="说些什么..."
          v-model="comment">
        </el-input>
      </div>
      <div align="right" style="margin-right: 10px;">
        <el-button type="primary" plain>发表评论</el-button>
      </div>
    </div>
</template>

<script>
    export default {
      data() {
        return {
          comment: ''
        }
      },
      name: "Comment"
    }
</script>

<style scoped>

</style>
