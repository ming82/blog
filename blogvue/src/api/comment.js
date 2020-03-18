import ajax from './ajax'
const BASE_URL = '/api'


export const postComment=(commentBody,articleId,answerId,commentParentid,userId,commentTo) =>
  ajax(BASE_URL+'/comment/',{commentBody,articleId,answerId,commentParentid,userId,commentTo},"POST")

export const reqArticleComments = (articleId) => ajax(BASE_URL+'/comment/getByArticleId',{articleId})

export const reqAnswerComments = (answerId) => ajax(BASE_URL+'/comment/getByAnswerId',{answerId})
