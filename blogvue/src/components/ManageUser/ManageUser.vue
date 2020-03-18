<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6">
        <el-input v-model="listQuery.userName" placeholder="请输入用户名" clearable></el-input>
      </el-col>
      <el-col :span="6">
        <el-input v-model="listQuery.userNickname" placeholder="请输入用户昵称" clearable></el-input>
      </el-col>
      <el-col :span="4">
        <el-select v-model="listQuery.userStatus" placeholder="请选择用户状态" clearable>
          <el-option label="正常" value="1">
          </el-option>
          <el-option label="禁用" value="0">
          </el-option>
        </el-select>
      </el-col>
      <el-col :span="2">
        <el-button type="success" @click="getList">查询</el-button>
      </el-col>
      <el-col :span="1">
        <el-button @click="doRefresh" plain>刷新</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-table style="margin-top: 20px" :data="users" v-loading="listLoading" border fit highlight-current-row>
        <el-table-column width="50px" align="center" prop="userId" label="ID">
        </el-table-column>
        <el-table-column align="center" label="头像">
          <template slot-scope="scope">
            <img :src="scope.row.userPicture" style="width: 50px;height: 50px;border-radius: 50px;">
          </template>
        </el-table-column>
        <el-table-column align="center" label="用户名">
          <template slot-scope="scope">
            <a style="cursor: pointer;text-decoration: underline" @click="toUser(scope.row.userId)">{{scope.row.userName}}</a>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="userNickname" label="用户昵称">
        </el-table-column>
        <el-table-column align="center" prop="userEmail" label="邮箱">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="articleNum" label="文章">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="issuesNum" label="提问">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="answerNum" label="回答">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="likes" label="点赞">
        </el-table-column>
        <el-table-column width="160px" align="center" prop="userRegistetime" label="发布日期">
        </el-table-column>
        <el-table-column align="center" label="状态">
          <template slot-scope="scope">
            <span>{{scope.row.userStatus | statusFilter}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="role" label="用户权限">
        </el-table-column>
        <el-table-column width="250px" align="center" label="操作">
          <template slot-scope="scope">
            <el-button v-if="scope.row.userStatus === 1" type="danger" @click="freeze(scope.row)">禁用</el-button>
            <el-button v-else type="success" @click="freeze(scope.row)">解禁</el-button>
            <el-button type="primary" @click="toUpdate(scope.row)">修改权限</el-button>
          </template>
        </el-table-column>
      </el-table>
      <br>
      <el-pagination
        v-if="this.total != 0"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync="this.listQuery.pageNum"
        :page-sizes="[5, 8, 10, 15]"
        :page-size="this.listQuery.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </el-row>

    <el-dialog title="权限修改" :visible.sync="formVisible" width="20%"
               :close-on-click-modal="false">
      <el-select v-model="edit.permit" placeholder="用户权限">
        <el-option label="普通用户" value="普通用户">
        </el-option>
        <el-option label="管理员" value="管理员">
        </el-option>
        <el-option label="超级管理员" value="超级管理员">
        </el-option>
      </el-select>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel()">取 消</el-button>
        <el-button type="primary" @click="updatePermit()">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

  import {editPermit, manageUser, reqUserList} from "../../api/user";
  import {mapState} from "vuex";

  export default {
    name: "ManageUser",
    data() {
      return {
        listLoading: false,
        users: [],
        total: 0,
        listQuery: {
          pageSize: 8,
          pageNum: 1,
          userName:'',
          userNickname: '',
          userStatus: '',
        },
        edit:{
          userId:'',
          permit:'',
        },
        formVisible : false
      }
    },
    mounted() {
      this.getList()
    },
    filters:{
      statusFilter(status){
        const statusMap = {
          0: '禁用',
          1: '正常'
        }
        return statusMap[status]
      }
    },
    methods: {
      getList(){
        this.listLoading = true
        reqUserList(this.listQuery.pageNum, this.listQuery.pageSize
          , this.listQuery.userName, '',this.listQuery.userNickname,this.listQuery.userStatus).then(result => {
          this.users = result.data.list
          for(let i = 0;i < this.users.length;i++){
            if(this.users[i].roles.length == 3){
              this.users[i].role = '超级管理员'
            } else if(this.users[i].roles.length == 2){
              this.users[i].role = '管理员'
            } else{
              this.users[i].role = '普通用户'
            }
          }
          this.total = result.data.total
          this.listLoading = false
        })
      },
      toUpdate(val){
        if(this.user.userId == val.userId){
          this.$message.warning('无法修改自己的权限')
          return
        }
        this.edit.userId = val.userId
        if(val.roles.length == 3){
          this.edit.permit = '超级管理员'
        } else if(val.roles.length == 2){
          this.edit.permit = '管理员'
        } else{
          this.edit.permit = '普通用户'
        }
        this.formVisible = true
      },
      updatePermit(){
        editPermit(this.edit.userId,this.edit.permit).then(result =>{
          if (result.status === "success") {
            this.$message.success(result.resMsg)
            this.formVisible = false
            this.doRefresh()
          } else {
            this.$message.error(result.resMsg)
          }
        })
      },
      cancel(){
        this.formVisible = false
      },

      handleSizeChange(val) {
        this.listQuery.pageSize = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val
        this.getList()
      },
      toUser(userId){
        this.$router.push({
          path: `/userpage/${userId}`,
        })
      },
      freeze(val) {
        this.$confirm('是否禁用此用户？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let statusToUpdate = 0
          if(val.userStatus == 0){
            statusToUpdate = 1
          }
          manageUser(val.userId,statusToUpdate).then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.doRefresh()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).catch(() => {
        });
      },
      doRefresh(){
        this.listQuery.userNickname = ''
        this.listQuery.userName = ''
        this.listQuery.userStatus = ''
        this.getList()
      }
    },
    computed: {
      ...mapState(['user']),
    },
  }
</script>

<style scoped>

</style>
