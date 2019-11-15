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
        class="input"
        size="medium"
        placeholder="请输入搜索内容"
        v-model="search">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </div>
    <div class="login" v-if="user.userId">
      <el-button @click="logoutClick()">注销</el-button>
      <el-button @click="selfClick()">个人空间
        <el-badge v-if="noRead!=0" class="mark" :value="noRead"/>
      </el-button>
    </div>
    <div class="unlogin" v-else>
      <el-button @click="loginFormVisible = true">登录</el-button>
      <span>|</span>
      <el-button @click="registerFormVisible = true">免费注册</el-button>
    </div>
    <!-- LoginForm -->
    <el-dialog @closed="loginFormClose(id)" modal="false" close-on-click-modal="false" center="true" width="30%"
               title="登录"
               :visible.sync="loginFormVisible">
      <div slot="title" style="background-color: #f5f7fa">
        <h2>登录</h2>
      </div>
      <el-form :model="loginForm">
        <el-form-item label="用户名" label-width="100px">
          <el-input v-model="loginForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="100px">
          <el-input v-model="loginForm.password" type="password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="loginFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="login()">登 录</el-button>
      </div>
    </el-dialog>
    <!-- RegisterForm -->
    <el-dialog modal="false" close-on-click-modal="false" center="true" width="30%" title="登录"
               :visible.sync="registerFormVisible">
      <div slot="title" style="background-color: #f5f7fa">
        <h2>注册</h2>
      </div>
      <el-form :model="registerForm">
        <el-form-item label="用户名" label-width="100px">
          <el-input v-model="registerForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" label-width="100px">
          <el-input v-model="registerForm.userNickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="100px">
          <el-input v-model="registerForm.userPassword" type="password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" label-width="100px">
          <el-input v-model="registerForm.rePassword" type="password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" label-width="100px">
          <el-input v-model="registerForm.userEmail" type="email" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="registerFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="registerClick()">注 册</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
  import {mapState} from 'vuex'
  import {nameCheck, register} from "../../api";

  export default {
    name: "HeaderTop",
    data() {
      return {
        activeIndex: 'msite',
        search: '',
        loginFormVisible: false,
        registerFormVisible: false,
        loginForm: {
          username: '',
          password: '',
        },
        registerForm: {
          userName: '',
          userNickname: '',
          userPassword: '',
          rePassword: '',
          userEmail: '',
        },
      };
    },
    methods: {
      handleSelect(key) {
        this.activeIndex = key
      },
      login() {
        this.$store.dispatch('getLoginUser', this.loginForm)
        this.loginFormVisible = false
      },
      loginFormClose(id) {
        this.$store.dispatch('getNoreadNum', id)
      },
      registerClick() {
        let nameFlag = false
        let passwordFlag = false
        //用户名重复检查
        nameCheck(this.registerForm.userName).then(result =>{
          if(result.status === "success"){
            nameFlag = true
          }else {
            this.$message.error(result.resMsg)
          }
          //密码验证
          if(this.registerForm.userPassword === this.registerForm.rePassword){
            passwordFlag = true
          }else{
            this.$message.error("两次密码输入不一致")
          }
          //注册
          if (passwordFlag && nameFlag) {
            register(this.registerForm.userName,this.registerForm.userNickname,this.registerForm.userPassword,this.registerForm.userEmail).then(result => {
              if (result.status === "success") {
                this.$message.success(result.resMsg)
                this.registerFormVisible = false
                this.loginFormVisible = true
              } else {
                this.$message.error(result.msg)
              }
            })
          }
        })
      },
      logoutClick() {
        this.$confirm('是否注销？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$store.dispatch('toLogout')
          this.$message({
            type: 'success',
            message: '注销成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
        });
      },
      selfClick() {
        this.$router.push('/personalspace')
      }
    },
    computed: {
      ...mapState(['user', 'noRead']),
      id() {
        return this.$store.state.user.userId
      },
      no() {
        return this.$store.state.noRead
      }
    },
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .login
    margin-top 10px
    margin-left 330px

  .unlogin
    margin-top 10px
    margin-left 350px

  .el-button
    border 0px

  .img
    margin-left 150px

  .el-container
    background-color #fdfdfd

  .input
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    margin-top 10px
    margin-left 50px

  .el-menu
    margin-left 50px
</style>
