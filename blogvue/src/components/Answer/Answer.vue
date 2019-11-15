<template>
  <div class="shadow" align="left">
    <h3><span style="margin-left: 10px;margin-top: 10px;">发表回答</span></h3>
    <mavon-editor autofocus='false' v-model="mdContent" ref=md />
    <div align="right" style="margin-right: 10px;">
      <el-button type="primary" @click="postAns()" plain>发表回答</el-button>
    </div>
  </div>
</template>

<script>
  import {mapState} from "vuex";
  import {postAnswer} from "../../api";

  export default {
    name: "Answer",
    props:{
      issueId:''
    },
    data() {
      return {
        mdContent: '',
        htmlContent:''
      }
    },
    mounted() {
      this.$nextTick(()=> {
        document.getElementsByClassName('auto-textarea-input')[0].blur(); // 获取textarea 不一定是auto-textarea-input
        window.scrollTo(0, 0)
      })
    },
    methods:{
      postAns(){
        this.htmlContent = this.$refs.md.d_render
        postAnswer(this.user.userId,this.issueId,this.mdContent, this.htmlContent).then(result => {
          if (result.status === "success") {
            this.$message.success(result.resMsg)
          } else {
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
