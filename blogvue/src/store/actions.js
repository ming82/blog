/*
通过mutation间接更新state的多个方法的对象
 */
import {
  RECEIVE_USER,
  RECEIVE_CATEGORY,
  RECEIVE_HOTARTICLES,
  RECEIVE_NEWARTICLES,
  RECEIVE_NOANSWERISSUES,
  RECEIVE_HOTISSUES, RECEIVE_NOREAD, RESET_USER, RECEIVE_TAGS, MESSAGE_READ,
} from './mutation-types'
import {reqHotArticles, reqNewArticles,} from '../api/article'
import {reqHotIssues, reqNoAnswerIssues,} from '../api/issue'
import {login, logout} from "../api/user";
import {reqCategory} from "../api/category";
import {reqNoReadNum} from "../api/message";
import {reqTag} from "../api/tag";

import {
  Message
} from 'element-ui'

export default {
  async getHotArticles({commit}) {
    const result = await reqHotArticles()
    if (result.status === "success") {
      const hotArticles = result.data
      commit(RECEIVE_HOTARTICLES, {hotArticles})
    }
  },
  async getNewArticles({commit}) {
    const result = await reqNewArticles()
    if (result.status === "success") {
      const newArticles = result.data
      commit(RECEIVE_NEWARTICLES, {newArticles})
    }
  },
  async getHotIssues({commit}) {
    const result = await reqHotIssues()
    if (result.status === "success") {
      const hotIssues = result.data
      commit(RECEIVE_HOTISSUES, {hotIssues})
    }
  },
  async getNoAnswerIssues({commit}) {
    const result = await reqNoAnswerIssues()
    if (result.status === "success") {
      const noAnswerIssues = result.data
      commit(RECEIVE_NOANSWERISSUES, {noAnswerIssues})
    }
  },
  async getLoginUser({commit}, {username, password}) {
    const result = await login(username, password)
    if (result.status === "success") {
      const user = result.data
      commit(RECEIVE_USER, {user})
      Message({
        message: '登录成功',
        type: 'success'
      })
    } else {
      Message({
        message: result.msg,
        type: 'error'
      })
    }
  },

  async toLogout({commit}) {
    commit(RESET_USER)
    const result = await logout()
  },
  async readMessage({commit}) {
    commit(MESSAGE_READ)
  },
  async getCategory({commit}) {
    const result = await reqCategory()
    if (result.status === "success") {
      const category = result.data
      commit(RECEIVE_CATEGORY, {category})
    }
  },
  async getNoreadNum({commit}, userId) {
    const result = await reqNoReadNum(userId)
    if (result.status === "success") {
      const noRead = result.data
      commit(RECEIVE_NOREAD, {noRead})
    }
  },
  async getAllTags({commit}) {
    const result = await reqTag()
    if (result.status === "success") {
      const tags = result.data
      commit(RECEIVE_TAGS, {tags})
    }
  }
}
