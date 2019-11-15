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
        <el-button type="primary" @click="post()" plain>发表评论</el-button>
      </div>
    </div>
</template>

<script>
    import {postComment} from "../../api";
    import {mapState} from "vuex";

    export default {
      data() {
        return {
          comment: ''
        }
      },
      props:{
        id:Object,
      },
      name: "Comment",
      inject:["reload"],
      methods:{
        post(){
          postComment(this.comment,this.id,null,null,this.user.userId).then(result=>{
            if(result.status === "success"){
              this.$message.success(result.resMsg)
              this.comment = ''
              this.reload()
            }else {
              this.$message.error(result.resMsg)
            }
          })
        }
      },
      computed: {
        ...mapState(['user']),
      },
    }
</script>

<style scoped>

</style>
