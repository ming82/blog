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
  RECEIVE_HOTISSUES,
} from './mutation-types'
import {
  reqAllArticles,
  reqHotArticles,
  reqNewArticles,
  reqAllIssues,
  reqHotIssues,
  reqNoAnswerIssues,
  reqIssuesByCategoryId,
  reqUser,
  reqCategory,
  reqArticlesByCategoryId,
} from '../api'

export default {

  async getAllArticles({commit}) {
    const result = await reqAllArticles()
    if (result.status === "success") {
      const articles = result.data
      commit(RECEIVE_ARTICLES, {articles})
    }
  },
  async getArticlesByCategoryId({commit},categoryId) {
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
  async getIssuesByCategoryId({commit},categoryId) {
    const result = await reqIssuesByCategoryId(categoryId)
    if (result.status === "success") {
      const issues = result.data
      commit(RECEIVE_ISSUES, {issues})
    }
  },
  async getUser({commit},userId) {
    const result = await reqUser(userId)
    if (result.status === "success") {
      const user = result.data
      commit(RECEIVE_USER, {user})
    }
  },
  async getCategory({commit}) {
    const result = await reqCategory()
    if (result.status === "success") {
      const category = result.data
      commit(RECEIVE_CATEGORY, {category})
    }
  },
}
