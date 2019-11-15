/*
通过mutation间接更新state的多个方法的对象
 */
import {
  RECEIVE_ARTICLES,
  RECEIVE_USER,
  RECEIVE_CATEGORY,
  RECEIVE_HOTARTICLES,
  RECEIVE_NEWARTICLES,
  RECEIVE_ISSUES,
  RECEIVE_NOANSWERISSUES,
  RECEIVE_HOTISSUES, RECEIVE_NOREAD, RESET_USER, RECEIVE_TAGS, MESSAGE_READ,
} from './mutation-types'
import {
  reqAllArticles,
  reqHotArticles,
  reqNewArticles,
  reqAllIssues,
  reqHotIssues,
  reqNoAnswerIssues,
  reqIssuesByCategoryId,
  login,
  reqCategory,
  reqArticlesByCategoryId, reqNoReadNum, logout, reqTag,
} from '../api'

export default {

  async getAllArticles({commit}) {
    const result = await reqAllArticles()
    if (result.status === "success") {
      const articles = result.data
      commit(RECEIVE_ARTICLES, {articles})
    }
  },
  async getArticlesByCategoryId({commit}, categoryId) {
    const result = await reqArticlesByCategoryId(categoryId)
    if (result.status === "success") {
      const articles = result.data
      commit(RECEIVE_ARTICLES, {articles})
    }
  },
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
  async getAllIssues({commit}) {
    const result = await reqAllIssues()
    if (result.status === "success") {
      const issues = result.data
      commit(RECEIVE_ISSUES, {issues})
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
  async getIssuesByCategoryId({commit}, categoryId) {
    const result = await reqIssuesByCategoryId(categoryId)
    if (result.status === "success") {
      const issues = result.data
      commit(RECEIVE_ISSUES, {issues})
    }
  },
  async getLoginUser({commit}, {username, password}) {
    const result = await login(username, password)
    if (result.status === "success") {
      const user = result.data
      commit(RECEIVE_USER, {user})
    } else {
      alert("登录失败！")
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
