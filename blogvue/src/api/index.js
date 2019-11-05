/*
包含n个接口请求函数的模块
函数的返回值: promise对象
 */
import ajax from './ajax'
const BASE_URL = '/api'

// 2、获取食品分类列表
export const reqAllArticles = () => ajax(BASE_URL+'/article/getAll')

export const reqArticlesByCategoryId = (categoryId) => ajax(BASE_URL+'/article/getByCategoryId',{categoryId})

export const reqHotArticles = () => ajax(BASE_URL+'/article/getHots')

export const reqNewArticles = () => ajax(BASE_URL+'/article/getNews')

export const reqArticle = (articleId) => ajax(BASE_URL+'/article/'+articleId)

export const reqAllIssues = () => ajax(BASE_URL+'/issue/getAll')

export const reqIssue = (issueId) => ajax(BASE_URL+'/issue/'+issueId)

export const reqHotIssues = () => ajax(BASE_URL+'/issue/getHotIssues')

export const reqNoAnswerIssues = () => ajax(BASE_URL+'/issue/getNoAnswers')

export const reqIssuesByCategoryId = (categoryId) => ajax(BASE_URL+'/issue/getByCategoryId',{categoryId})

export const reqUser = (userId) => ajax(BASE_URL+'/user/'+userId)

export const reqArticleComments = (articleId) => ajax(BASE_URL+'/comment/getByArticleId',{articleId})

export const reqAnswerComments = (answerId) => ajax(BASE_URL+'/comment/getByAnswerId',{answerId})

export const reqCategory = () => ajax(BASE_URL+'/category/getAll')

export const reqAnswerByIssueId = (issueId) =>ajax(BASE_URL+'/answer/getAnswersByIssueId',{issueId})

export const deleteArticle = (id) => ajax(BASE_URL+'/article/'+id,'','DELETE')



