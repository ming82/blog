<template>
  <el-container>
    <div class="img">
      <img src="./image/icon.png"/>
    </div>
    <el-menu :default-active="$route.path" mode="horizontal" @select="handleSelect"
             active-text-color="#2b2b2b" router="true">
      <el-menu-item index="/msite">&nbsp;&nbsp;首页&nbsp;&nbsp;</el-menu-item>
      <el-menu-item index="/articles">&nbsp;&nbsp;文章专栏&nbsp;&nbsp;</el-menu-item>
      <el-menu-item index="/issues">&nbsp;&nbsp;问答专栏&nbsp;&nbsp;</el-menu-item>
      <el-menu-item index="/about">&nbsp;&nbsp;关于&nbsp;&nbsp;</el-menu-item>
    </el-menu>
    <div>
      <el-input
        size="medium"
        placeholder="请输入搜索内容"
        v-model="search">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </div>
    <slot name="isLogin"></slot>
  </el-container>
</template>

<script>
  export default {
    name: "HeaderTop",
    data() {
      return {
        activeIndex: 'msite',
        search: '',
      };
    },
    methods: {
      goTo(path) {
        this.$router.replace(path)
      },

      handleSelect(key, keyPath) {
        this.activeIndex = key
      }
    },

  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .img
    margin-left 150px

  .el-container
    background-color #fdfdfd

  .el-input
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    margin-top 10px
    margin-left 50px

  .el-menu
    margin-left 50px
</style>
