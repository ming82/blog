<template>
  <div class="shadow">
    <br/>
    <el-divider content-position="left"><h3>{{tag}}</h3></el-divider>
    <el-menu :default-active="factiveIndex" mode="vertical" @select="handleSelect" active-text-color="#2b2b2b">
      <el-menu-item index="1">Java</el-menu-item>
      <el-menu-item index="2">Linux</el-menu-item>
      <el-menu-item index="3">Python</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
      data() {
        return {
          factiveIndex: '1',
        };
      },
      methods: {
        handleSelect(key, keyPath) {
          // console.log(key, keyPath);
        }
      },
      name: "SideGuide",
      props:{
        tag: String
      }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>

</style>
