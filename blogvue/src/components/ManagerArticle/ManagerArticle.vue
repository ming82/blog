<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="6">
        <el-input v-model="listQuery.userNickname" placeholder="请输入用户名" clearable></el-input>
      </el-col>
      <el-col :span="6">
        <el-input v-model="listQuery.keyword" placeholder="请输入关键字" clearable></el-input>
      </el-col>
      <el-col :span="4">
        <el-select v-model="listQuery.categoryId" placeholder="请选择文章栏目" clearable>
          <el-option
            v-for="item in category"
            :key="item.categoryId"
            :label="item.categoryName"
            :value="item.categoryId">
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
      <el-table style="margin-top: 20px" :data="articles" v-loading="listLoading" border fit highlight-current-row>
        <el-table-column width="50px" align="center" prop="articleId" label="ID">
        </el-table-column>
        <el-table-column width="300px" align="center" label="标题">
          <template slot-scope="scope">
            <a style="cursor: pointer;text-decoration: underline" @click="toArticle(scope.row.articleId)">{{scope.row.articleTitle}}</a>
          </template>
        </el-table-column>
        <el-table-column align="center" prop="userNickname" label="作者">
        </el-table-column>
        <el-table-column align="center" prop="categoryName" label="栏目">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="articlePageviews" label="浏览量">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="articleComments" label="评论">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="articleLikes" label="点赞">
        </el-table-column>
        <el-table-column width="80px" align="center" prop="articleFavorites" label="收藏">
        </el-table-column>
        <el-table-column width="160px" align="center" prop="publishdate" label="发布日期">
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button type="danger" @click="deleteArticle(scope.row.articleId)">删除</el-button>
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
  </div>
</template>

<script>
  import {mapState} from "vuex";
  import {deleteArticle, reqArticleList} from "../../api/article";

  export default {
    name: "ManagerArticle",
    data() {
      return {
        listLoading: false,
        articles:[],
        total:0,
        listQuery: {
          pageSize: 8,
          pageNum: 1,
          userNickname: '',
          categoryId: '',
          keyword: '',
        }
      }
    },
    mounted() {
      this.getList()
    },
    methods: {
      getList(){
        this.listLoading = true
        reqArticleList(this.listQuery.pageNum, this.listQuery.pageSize
          , this.listQuery.categoryId, '',this.listQuery.userNickname,this.listQuery.keyword).then(result => {
          this.articles = result.data.list
          for(let i =0;i < this.articles.length;i++){
            for(let j = 0;j < this.category.length;j++){
              if(this.articles[i].categoryId == this.category[j].categoryId){
                this.articles[i].categoryName = this.category[j].categoryName
                break;
              }
            }
          }
          this.total = result.data.total
          this.listLoading = false
        })
      },
      handleSizeChange(val) {
        this.listQuery.pageSize = val
        this.getList()
      },
      handleCurrentChange(val) {
        this.listQuery.pageNum = val
        this.getList()
      },
      toArticle(articleId){
        this.$router.push({
          path: `/article/${articleId}`,
        })
      },
      deleteArticle(articleId) {
        this.$confirm('是否删除此文章？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteArticle(articleId).then(result => {
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
        this.listQuery.keyword = ''
        this.listQuery.categoryId = ''
        this.getList()
      }
    },
    computed: {
      ...mapState(['category']),
    },
  }
</script>

<style scoped>

</style>
