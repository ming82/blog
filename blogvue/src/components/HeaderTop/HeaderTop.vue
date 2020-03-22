<template>
  <el-container>
    <div style="width: 100%;">
      <el-row>
        <el-col :span="4" class="img">
          <img style="float:right;" src="./image/icon.png"/>
        </el-col>
        <el-col :span="8">
          <el-menu style="height: 40px" :default-active="$route.path" mode="horizontal" @select="handleSelect"
                   active-text-color="#2b2b2b" router="true">
            <el-menu-item index="/msite">&nbsp;&nbsp;首页&nbsp;&nbsp;</el-menu-item>
            <el-menu-item index="/articles">&nbsp;&nbsp;文章专栏&nbsp;&nbsp;</el-menu-item>
            <el-menu-item index="/issues">&nbsp;&nbsp;问答专栏&nbsp;&nbsp;</el-menu-item>
            <el-menu-item index="/about">&nbsp;&nbsp;关于&nbsp;&nbsp;</el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="4">
          <el-input
            class="input"
            size="medium"
            placeholder="请输入搜索内容"
            v-model="keyword"
            @keyup.enter.native="toSearch">
            <i slot="prefix" class="el-input__icon el-icon-search" @click="toSearch"></i>
          </el-input>
        </el-col>
        <el-col :span="8" align="right" class="login" v-if="user.userId">
          <el-dropdown  style="cursor: pointer" trigger="click">
            <span>
            <img :src="imageUrl" style="height: 30px;width: 30px;border-radius: 50px">
              {{this.user.userNickname}}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item @click.native="logoutClick()">注销</el-dropdown-item>
              <el-dropdown-item @click.native="selfClick()">个人空间
                <el-badge v-if="noRead!=0" class="mark" :value="noRead"/>
              </el-dropdown-item>
              <el-dropdown-item v-if="isManager" @click.native="toManage" plain>管理空间</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <!--          <el-button @click="logoutClick()">注销</el-button>-->
          <!--          <el-button @click="selfClick()">个人空间-->
          <!--            <el-badge v-if="noRead!=0" class="mark" :value="noRead"/>-->
          <!--          </el-button>-->
          <!--          <el-button v-if="isManager" type="danger" @click="toManage" plain>管理空间</el-button>-->
        </el-col>
        <el-col :span="8" align="right" class="unlogin" v-else>
          <el-button @click="loginFormVisible = true">登录</el-button>
          <span>|</span>
          <el-button @click="registerFormVisible = true">免费注册</el-button>
        </el-col>
      </el-row>
    </div>
    <!-- LoginForm -->
    <el-dialog @closed="loginFormClose()" modal="false" close-on-click-modal="false" center="true" width="30%"
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
               :visible.sync="registerFormVisible" @close="cancel('registerForm')">
      <div slot="title" style="background-color: #f5f7fa">
        <h2>注册</h2>
      </div>
      <el-form :model="registerForm" :rules="rules" ref="registerForm">
        <el-form-item label="用户名" label-width="100px" prop="userName">
          <el-input v-model="registerForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" label-width="100px" prop="userNickname">
          <el-input v-model="registerForm.userNickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" label-width="100px" prop="userPassword">
          <el-input v-model="registerForm.userPassword" type="password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" label-width="100px" prop="rePassword">
          <el-input v-model="registerForm.rePassword" type="password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" label-width="100px" prop="userEmail">
          <el-input v-model="registerForm.userEmail" type="email" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel('registerForm')">取 消</el-button>
        <el-button type="primary" @click="registerClick('registerForm')">注 册</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
  import {mapState} from 'vuex'
  import {nameCheck, register} from "../../api/user";

  export default {
    name: "HeaderTop",
    data() {
      return {
        imageUrl:'',
        isManager: false,
        activeIndex: 'msite',
        keyword: '',
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
        rules: {
          userName: [
            {
              required: true,
              message: '请输入用户名',
              trigger: 'blur'
            }
          ],
          userNickname: [
            {
              required: true,
              message: '请输入用户昵称',
              trigger: 'blur'
            }
          ],
          userPassword: [
            {
              required: true,
              message: '请输入用户密码',
              trigger: 'blur'
            }
          ],
          rePassword: [
            {
              required: true,
              message: '请确认密码',
              trigger: 'blur'
            }
          ],
          userEmail: [
            {
              required: true,
              message: '请输入用户邮箱',
              trigger: 'blur'
            }
          ]
        },
        noReads: 0
      };
    },
    mounted() {
      this.$store.dispatch('getNoreadNum', this.user.userId)
      this.imageUrl = this.IMAGE_URL+this.user.userPicture
      for (let i = 0; i < this.user.roles.length; i++) {
        if (this.user.roles[i].roleName === 'ROLE_ADMIN') {
          this.isManager = true
        }
      }
    },
    inject: ["reload"],
    methods: {
      toSearch() {
        this.$router.push({
          path: `/search/${this.keyword}`,
        })
        if(this.$route.path.indexOf("/search") >= 0){
          this.reload()
        }
      },
      toManage() {
        this.$router.push({
          path: `/manage`,
        })
      },
      handleSelect(key) {
        this.activeIndex = key
      },
      login() {
        if (this.loginForm.username === '') {
          this.$message.warning("请输入用户名")
          return
        }
        if (this.loginForm.password === '') {
          this.$message.warning("请输入密码")
          return
        }
        this.$store.dispatch('getLoginUser', this.loginForm)
        this.loginFormVisible = false
      },
      loginFormClose() {
        this.$store.dispatch('getNoreadNum', this.user.userId)
        this.imageUrl = this.IMAGE_URL+this.user.userPicture
        for (let i = 0; i < this.user.roles.length; i++) {
          if (this.user.roles[i].roleName === 'ROLE_ADMIN') {
            this.isManager = true
          }
        }
      },
      cancel(formName) {
        this.registerFormVisible = false
        this.$refs[formName].resetFields()
      },
      registerClick(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            let nameFlag = false
            let passwordFlag = false
            //用户名重复检查
            nameCheck(this.registerForm.userName, this.registerForm.userNickname).then(result => {
              if (result.status === "success") {
                nameFlag = true
              } else {
                this.$message.error(result.resMsg)
              }
              //密码验证
              if (this.registerForm.userPassword === this.registerForm.rePassword) {
                passwordFlag = true
              } else {
                this.$message.error("两次密码输入不一致")
              }
              //注册
              if (passwordFlag && nameFlag) {
                register(this.registerForm.userName, this.registerForm.userNickname, this.registerForm.userPassword, this.registerForm.userEmail).then(result => {
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
          this.$router.push('/msite')
        }).catch(() => {
        });
      },
      selfClick() {
        this.$router.push('/personalspace')
      }
    },
    computed: {
      ...mapState(['user', 'noRead','IMAGE_URL']),
      no() {
        return this.$store.state.noRead
      }
    },
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .el-menu-item
    height 40px
    line-height 40px

  .el-button
    line-height 0
    margin-top 5px
    border 0px

  .el-container
    background-color #fdfdfd

  .input
    height 34px
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
</style>
