<template>
  <div>
    <el-row :gutter="50">
      <el-col :span="11">
        <span style="float: left">栏目管理：</span>
        <br/>
        <br/>
        <el-button style="float: left" type="primary" @click="addCategory">新增</el-button>
        <el-button plain @click="doCateRefresh">刷新</el-button>
        <el-table style="margin-top: 20px" :data="category" v-loading="cateListLoading" border fit
                  highlight-current-row>
          <el-table-column width="50px" align="center" prop="categoryId" label="ID">
          </el-table-column>
          <el-table-column align="center" prop="categoryName" label="栏目名">
          </el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button type="primary" @click="editCategory(scope.row)">编辑</el-button>
              <el-button type="danger" @click="deleteCategory(scope.row.categoryId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
      <el-col :span="11">
        <span style="float: left">文章标签管理：</span>
        <br/>
        <br/>
        <el-button style="float: left" type="primary" @click="addTag">新增</el-button>
        <el-button plain @click="doTagRefresh">刷新</el-button>
        <el-table style="margin-top: 20px" :data="tags" v-loading="tagListLoading" border fit highlight-current-row>
          <el-table-column width="50px" align="center" prop="tagId" label="ID">
          </el-table-column>
          <el-table-column align="center" prop="tagName" label="标签名">
          </el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button type="primary" @click="editTag(scope.row)">编辑</el-button>
              <el-button type="danger" @click="deleteTag(scope.row.tagId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <!-- cateEditForm -->
    <el-dialog title="栏目编辑" :visible.sync="cateEditFormVisible" width="40%"
               :close-on-click-modal="false" @close="cancel('cateForm')">
      <el-form :model="cate" :rules="cateRules" ref="cateForm" label-width="100px">
        <el-form-item label="栏目名称" prop="categoryName">
          <el-input v-model="cate.categoryName" placeholder=""></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel('cateForm')">取 消</el-button>
        <el-button type="primary" @click="categoryEditClick('cateForm')">提交</el-button>
      </div>
    </el-dialog>
    <!-- tagEditForm -->
    <el-dialog title="标签编辑" :visible.sync="tagEditFormVisible" width="40%"
               :close-on-click-modal="false" @close="cancel('tagForm')">
      <el-form :model="tag" :rules="tagRules" ref="tagForm" label-width="100px">
        <el-form-item label="标签名称" prop="tagName">
          <el-input v-model="tag.tagName" placeholder=""></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel('tagForm')">取 消</el-button>
        <el-button type="primary" @click="tagEditClick('tagForm')">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {deleteTag, editTag, postTag, reqTag} from "../../api/tag";
  import {deleteCategory, editCategory, postCategory, reqCategory} from "../../api/category";

  export default {
    name: "ManageCategory",
    data() {
      return {
        cateEditFormVisible: false,
        tagEditFormVisible: false,
        category: [],
        tags: [],
        cateListLoading: false,
        tagListLoading: false,
        tag: {
          tagId: '',
          tagName: ''
        },
        cate: {
          categoryId: '',
          categoryName: ''
        },
        cateRules: {
          categoryName: [
            {
              required: true,
              message: '栏目名称不可为空',
              trigger: 'blur'
            }
          ],
        },
        tagRules: {
          tagName: [
            {
              required: true,
              message: '标签名称不可为空',
              trigger: 'blur'
            }
          ],
        },
      }
    },

    mounted() {
      this.getCategoryList()
      this.getTagList()
    },
    methods: {
      getCategoryList() {
        this.cateListLoading = true
        reqCategory().then(result => {
          if (result.status === 'success') {
            this.category = result.data
            this.cateListLoading = false
          }
        })
      },
      getTagList() {
        this.tagListLoading = true
        reqTag().then(result => {
          if (result.status === 'success') {
            this.tags = result.data
            this.tagListLoading = false
          }
        })
      },
      addCategory() {
        this.$prompt('栏目名', {
          confirmButtonText: '新增',
          cancelButtonText: '取消',
        }).then(({value}) => {
          postCategory(value).then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.getCategoryList()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        })
      },
      addTag() {
        this.$prompt('标签名', {
          confirmButtonText: '新增',
          cancelButtonText: '取消',
        }).then(({value}) => {
          postTag(value).then(result => {
            if (result.status === "success") {
              this.$message.success(result.resMsg)
              this.getTagList()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        })
      },
      editCategory(val) {
        this.cate.categoryId = val.categoryId
        this.cate.categoryName = val.categoryName
        this.cateEditFormVisible = true
      },
      categoryEditClick(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            editCategory(this.cate.categoryId, this.cate.categoryName).then(result => {
              if (result.status === 'success') {
                this.$message.success(result.resMsg)
                this.cateEditFormVisible = false
                this.getCategoryList()
              } else {
                this.$message.error(result.resMsg)
                this.cateEditFormVisible = false
              }
            })
          }
        })
      },
      editTag(val) {
        this.tag.tagId = val.tagId
        this.tag.tagName = val.tagName
        this.tagEditFormVisible = true
      },
      tagEditClick(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            editTag(this.tag.tagId, this.tag.tagName).then(result => {
              if (result.status === 'success') {
                this.$message.success(result.resMsg)
                this.tagEditFormVisible = false
                this.getTagList()
              } else {
                this.$message.error(result.resMsg)
                this.tagEditFormVisible = false
              }
            })
          }
        })
      },
      cancel(form) {
        this.cateEditFormVisible = false
        this.tagEditFormVisible = false
        this.cate.categoryName = ''
        this.tag.tagName = ''
        this.$refs[form].resetFields()
      },
      deleteTag(tagId) {
        this.$confirm('是否删除此标签？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteTag(tagId).then(result => {
            if (result.status === 'success') {
              this.$message.success(result.resMsg)
              this.getTagList()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).catch(() => {
        });
      },
      deleteCategory(categoryId) {
        this.$confirm('是否删除此栏目？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteCategory(categoryId).then(result => {
            if (result.status === 'success') {
              this.$message.success(result.resMsg)
              this.getCategoryList()
            } else {
              this.$message.error(result.resMsg)
            }
          })
        }).catch(() => {
        });
      },
      doCateRefresh() {
        this.getCategoryList()
      },
      doTagRefresh() {
        this.getTagList()
      },
    },
  }
</script>

<style scoped>

</style>
