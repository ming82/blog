<template>
  <el-container style="min-height:710px;*+height:100%;_height:400px;">
    <el-header style="max-height: 40px">
      <HeaderTop></HeaderTop>
    </el-header>
    <el-container style="background-color: #e6ebf2">
      <el-aside width="200px" style="overflow-y: hidden;margin-top: 80px">
        <div class="shadow">
          <br/>
          <el-menu
            default-active="1"
            background-color="#fdfdfd"
            text-color="#909399"
            active-text-color="#000000"
            class="el-menu-vertical-demo"
            @select="selectHandle">
            <el-menu-item index="1">
              <i class="el-icon-s-tools"></i>
              <span slot="title">文章管理</span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-s-tools"></i>
              <span slot="title">提问管理</span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-s-tools"></i>
              <span slot="title">标签栏目管理</span>
            </el-menu-item>
            <el-menu-item index="4" v-if="isSuperManager">
              <i class="el-icon-s-tools"></i>
              <span slot="title">用户管理</span>
            </el-menu-item>
          </el-menu>
        </div>
      </el-aside>
      <el-main v-if="manageFlag == 1">
        <ManagerArticle></ManagerArticle>
      </el-main>
      <el-main v-if="manageFlag == 2">
        <ManagerIssue></ManagerIssue>
      </el-main>
      <el-main v-if="manageFlag == 3" >
        <ManageCategory></ManageCategory>
      </el-main>
      <el-main v-if="manageFlag == 4">
        <ManageUser></ManageUser>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import HeaderTop from "../../components/HeaderTop/HeaderTop";
  import {mapState} from "vuex";
  import ManagerArticle from "../../components/ManagerArticle/ManagerArticle";
  import ManagerIssue from "../../components/ManageIssue/ManagerIssue";
  import ManageCategory from "../../components/ManageCategory/ManageCategory";
  import ManageUser from "../../components/ManageUser/ManageUser";

  export default {
    name: "Manage",
    data() {
      return {
        manageFlag: 1,
        isSuperManager: false,
      }
    },
    mounted() {
      for (let i = 0; i < this.user.roles.length; i++) {
        if (this.user.roles[i].roleName === 'ROLE_SUPERADMIN') {
          this.isSuperManager = true
        }
      }
    },
    methods: {
      selectHandle(index) {
        this.manageFlag = index
      }
    },
    computed: {
      ...mapState(['user','category','hotArticles']),
    },
    components: {ManageUser, ManageCategory, ManagerIssue, ManagerArticle, HeaderTop,}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .shadow
    background-color #fdfdfd
    box-shadow 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)

</style>
