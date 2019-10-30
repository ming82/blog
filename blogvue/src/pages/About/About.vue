<template>
  <el-container>
    <el-header>
      <HeaderTop>
        <div class="login" slot="isLogin" v-if="isLogin">
          <el-dropdown>
          <span class="el-dropdown-link">
            个人信息<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人空间</el-dropdown-item>
              <el-dropdown-item>消息通知</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
        <div class="unlogin" slot="isLogin" v-else>
          <el-button>登录</el-button>
          <span>|</span>
          <el-button>免费注册</el-button>
        </div>
      </HeaderTop>
    </el-header>
    <el-main>
      <!--<div align="center">前端菜鸟，半道出家，界面简陋，敬请见谅</div>-->
    </el-main>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop";

  export default {
    name: "About",
    data() {
      return {
        isLogin: false,
      }
    },
    components: {HeaderTop}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .el-button
    border 0px

  .login
    margin-top 15px
    margin-left 430px

  .unlogin
    margin-top 10px
    margin-left 350px
</style>
