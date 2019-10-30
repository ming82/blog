<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header>
      <HeaderTop>
        <div class="login" slot="isLogin" v-if="isLogin">
          <el-button>个人空间
            <el-badge class="mark" :value="12"/>
          </el-button>
        </div>
        <div class="unlogin" slot="isLogin" v-else>
          <el-button>登录</el-button>
          <span>|</span>
          <el-button>免费注册</el-button>
        </div>
      </HeaderTop>
    </el-header>
    <el-container style="background-color: aliceblue;">
      <el-aside width="200px" style="overflow-y: hidden">
        <div class="shadow">
          <br/>
          <el-divider content-position="left"><h3>个人空间</h3></el-divider>
          <el-menu
            default-active="1"
            background-color="#fdfdfd"
            text-color="#909399"
            active-text-color="#000000"
            class="el-menu-vertical-demo"
            @select="selecthandle">
            <el-menu-item index="1">
              <i class="el-icon-menu"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-document"></i>
              <span slot="title">发表文章</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-document"></i>
              <span slot="title">发表提问</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-document"></i>
              <span slot="title">我的文章</span>
            </el-menu-item>
            <el-menu-item index="5">
              <i class="el-icon-document"></i>
              <span slot="title">我的提问</span>
            </el-menu-item>
            <el-menu-item index="6">
              <i class="el-icon-document"></i>
              <span slot="title">我的回答</span>
            </el-menu-item>
            <el-menu-item index="7">
              <i class="el-icon-setting"></i>
              <span slot="title">草稿箱(1)</span>
            </el-menu-item>
            <el-menu-item index="8">
              <i class="el-icon-setting"></i>
              <span slot="title">回收站(1)</span>
            </el-menu-item>
            <el-menu-item index="9">
              <i class="el-icon-setting"></i>
              <span slot="title">消息通知<el-badge value="12"></el-badge></span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main class="mainwidth">
        <div v-if="tag==='1'" >
          <el-tabs type="border-card" style="min-height:570px;*+height:100%;_height:400px;">
            <el-tab-pane label="个人信息">
              <img src="src/components/HeaderTop/image/icon.png" height="80px" width="80px"/>
              <p>注册时间</p>
              <p>姓名</p>
              <p>昵称</p>
              <p>邮箱</p>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='2'">
          <el-tabs type="border-card">
            <el-tab-pane label="发表文章">
              <div class="shadow" align="left">
                <mavon-editor autofocus='false' v-model="value" style="min-height:500px;*+height:100%;_height:400px;"/>
              </div>
            </el-tab-pane>
          </el-tabs>

        </div>
        <div v-if="tag==='3'">
          <div class="shadow" align="left">
            <el-tabs type="border-card">
              <el-tab-pane label="发表提问">
                <mavon-editor autofocus='false' v-model="value"/>
              </el-tab-pane>
            </el-tabs>

          </div>
        </div>
        <div v-if="tag==='4'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的文章">
              <ArticleSummary></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='5'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的提问">
              <IssueSummary></IssueSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='6'">
          <el-tabs type="border-card">
            <el-tab-pane label="我的回答">
              <IssueSummary></IssueSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='7'">
          <el-tabs type="border-card">
            <el-tab-pane label="草稿箱">
              <ArticleSummary></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='8'">
          <el-tabs type="border-card">
            <el-tab-pane label="回收站">
              <ArticleSummary></ArticleSummary>
            </el-tab-pane>
          </el-tabs>
        </div>
        <div v-if="tag==='9'">
          <el-tabs type="border-card">
            <el-tab-pane label="消息通知">
              <Message></Message>
              <Message></Message>
              <Message></Message>
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-main>
    </el-container>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop.vue";
  import Footer from "../../components/Footer/Footer";
  import ArticleSummary from "../../components/ArticleSummary/ArticleSummary";
  import IssueSummary from "../../components/IssueSummary/IssueSummary";
  import Message from "../../components/Message/Message";

  export default {
    data() {
      return {
        isLogin: true,
        tag: '1',
        factiveIndex: '1'
      }
    },
    methods: {
      selecthandle(index) {
        this.tag = index
      }
    },
    name: "MSite",
    components: {Message, IssueSummary, ArticleSummary, Footer, HeaderTop}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .mainwidth
    margin-right 130px

  .shadow
    background-color #fdfdfd
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

  .el-footer
    margin-top 10px
    margin-bottom 20px


  .el-aside
    margin-left 150px
    margin-top 40px
    margin-bottom 5px

  .el-main
    margin-top 20px
    margin-bottom 5px

  .el-button
    border 0px

  .login
    margin-top 10px
    margin-left 400px

  .unlogin
    margin-top 10px
    margin-left 350px
</style>
