import ajax from './ajax'
const BASE_URL = '/api'

export const postArticle = (userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags) => ajax(BASE_URL+'/article/',{userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags},'POST')

export const editArticle = (articleId,userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags) => ajax(BASE_URL+'/article/',{articleId,userId,articleTitle,mdcontent,htmlcontent,categoryId,articleStatus,tags},'PUT')

export const deleteArticle = (id) => ajax(BASE_URL+'/article/'+id,'','DELETE')

export const reqHotArticles = () => ajax(BASE_URL+'/article/getHots')

export const reqNewArticles = () => ajax(BASE_URL+'/article/getNews')

export const reqArticle = (articleId) => ajax(BASE_URL+'/article/'+articleId)

export const reqArticleList = (pageNum,pageSize,categoryId,userId,userNickname,keyword) => ajax(BASE_URL+'/article/getList',{pageNum,pageSize,categoryId,userId,userNickname,keyword})

export const like=(articleId,userId) => ajax(BASE_URL+'/article/like',{articleId,userId})

export const reqDraftByUserId = (userId) => ajax(BASE_URL+'/article/getDrafts',{userId})
