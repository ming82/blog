<template>
  <div class="shadow">
    <br/>
    <el-divider content-position="left"><h3>{{tag}}</h3></el-divider>
    <el-menu mode="vertical" @select="handleSelect" active-text-color="#2b2b2b">
      <el-menu-item :class="{on:flag===1}" :index="1" v-if="tag==='文章分类'">全部文章</el-menu-item>
      <el-menu-item :class="{on:flag===1}" :index="1" v-if="tag==='问题分类'">全部问题</el-menu-item>
      <el-menu-item :class="{on:flag===category.categoryId}" v-for="(category,index) in categorys" :key="index" :index="category.categoryId">{{category.categoryName}}</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
      data() {
        return {
          flag: 1
        };
      },
      methods: {
        handleSelect(key) {
          this.flag = key
          if(this.tag === '文章分类'){
            //文章
            if(key === 1)
              this.$store.dispatch("getAllArticles")
            else
              this.$store.dispatch('getArticlesByCategoryId',key)
          }else {
            //问题
            if(key === 1)
              this.$store.dispatch("getAllIssues")
            else
              this.$store.dispatch('getIssuesByCategoryId',key)
          }
        }
      },
      name: "SideGuide",
      props:{
        categorys:Object,
        tag: String
      }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .on
    background-color #c1c9d0
</style>
