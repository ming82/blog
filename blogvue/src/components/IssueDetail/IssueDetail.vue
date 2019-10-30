<template>
  <div class="shadow">
    <el-row>
      <el-col :span="24" align="left" class="marginleft">
        <h2>这是一个问题</h2>
      </el-col>
      <el-col :span="24" align="left" class="marginleft time">
        <span>2018-8-8</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="href" href="">司命</a>
      </el-col>
      <el-col>
        <div style="margin-right: 10px;margin-left: 10px;">
          <el-divider></el-divider>
        </div>
      </el-col>
      <el-col :span="24" align="left" class="marginleft">
        <div>文章正文</div>
      </el-col>
      <el-col>
        <br/>
        <br/>
        <el-divider content-position="left"><span style="font-size: 25px"> 6个回答</span></el-divider>
        <br/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "IssueDeatil"
    }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
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
