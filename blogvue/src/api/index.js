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

export const reqArticleComments = (articleId) => ajax(BASE_URL+'/comment/getByArticleId',{articleId})

export const reqAnswerComments = (answerId) => ajax(BASE_URL+'/comment/getByAnswerId',{answerId})

export const reqCategory = () => ajax(BASE_URL+'/category/getAll')

export const reqTag = () => ajax(BASE_URL+'/tag/getAll')

export const reqAnswerByIssueId = (issueId) =>ajax(BASE_URL+'/answer/getAnswersByIssueId',{issueId})

export const login = (username,password) => ajax(BASE_URL+'/login',{username,password},'POST')

export const logout = () => ajax(BASE_URL+'/logout')

export const register = (userName,userNickname,userPassword,userEmail) => ajax(BASE_URL+'/user/',{userName,userNickname,userPassword,userEmail},'POST')

export const nameCheck = (userName) => ajax(BASE_URL+'/user/nameCheck/',{userName})

// export const reqAllMessages = (userId) => ajax(BASE_URL+'/message/getNoRead',{userId},'POST')

export const reqNoReadNum = (userId) => ajax(BASE_URL+'/message/countNoRead',{userId})

export const deleteArticle = (id) => ajax(BASE_URL+'/article/'+id,'','DELETE')

export const postArticle = (userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags) => ajax(BASE_URL+'/article/',{userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags},'POST')

export const postIssue = (userId,issueTitle,mdcontent,htmlcontent,categoryId) => ajax(BASE_URL+'/issue/',{userId,issueTitle,mdcontent,htmlcontent,categoryId},'POST')

export const reqArticleByUserId = (userId) => ajax(BASE_URL+'/article/getByUserId',{userId})

export const reqIssueByUserId = (userId) => ajax(BASE_URL+'/issue/getByUserId',{userId})

export const reqDraftByUserId = (userId) => ajax(BASE_URL+'/article/getDrafts',{userId})

export const reqReadMessage = (userId) => ajax(BASE_URL+'/message/getRead',{userId})

export const reqNoreadMessage = (userId) => ajax(BASE_URL+'/message/getNoread',{userId})

export const markRead=(list) => ajax(BASE_URL+'/message/markRead',{list},"POST")

export const postComment=(commentBody,articleId,answerId,commentParentid,userId) => ajax(BASE_URL+'/comment/post',{commentBody,articleId,answerId,commentParentid,userId},"POST")

export const like=(articleId,userId) => ajax(BASE_URL+'/article/like',{articleId,userId})

export const postAnswer=(userId,issueId,mdcontent,htmlcontent) => ajax(BASE_URL+'/answer/',{userId,issueId,mdcontent,htmlcontent},'POST')

