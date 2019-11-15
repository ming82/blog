/*
直接更新state的多个方法的对象
 */
import {
  RECEIVE_ARTICLES,
  RECEIVE_USER,
  RECEIVE_CATEGORY,
  RECEIVE_HOTARTICLES,
  RECEIVE_NEWARTICLES,
  RECEIVE_ISSUES,
  RECEIVE_HOTISSUES,
  RECEIVE_NOANSWERISSUES, RECEIVE_NOREAD, RESET_USER, RECEIVE_TAGS, MESSAGE_READ,
} from './mutation-types'

export default {
  [RECEIVE_ARTICLES](state, {articles}) {
    state.articles = articles
  },
  [RECEIVE_HOTARTICLES](state, {hotArticles}) {
    state.hotArticles = hotArticles
  },
  [RECEIVE_NEWARTICLES](state, {newArticles}) {
    state.newArticles = newArticles
  },
  [RECEIVE_ISSUES](state, {issues}) {
    state.issues = issues
  },
  [RECEIVE_HOTISSUES](state, {hotIssues}) {
    state.hotIssues = hotIssues
  },
  [RECEIVE_NOANSWERISSUES](state, {noAnswerIssues}) {
    state.noAnswerIssues = noAnswerIssues
  },
  [RECEIVE_USER](state, {user}) {
    state.user = user
  },
  [RESET_USER](state) {
    state.user={}
  },
  [RECEIVE_CATEGORY](state, {category}) {
    state.category = category
  },
  [RECEIVE_NOREAD](state, {noRead}) {
    state.noRead = noRead
  },
  [RECEIVE_TAGS](state,{tags}){
    state.tag = tags
  },
  [MESSAGE_READ](state){
    state.noRead = 0
  }
}
