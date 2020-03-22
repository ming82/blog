import ajax from './ajax'
const BASE_URL = '/api'

export const favorite = (articleId,userId) => ajax(BASE_URL+'/favorite/',{articleId,userId},'POST')

export const checkFavorited = (articleId,userId) => ajax(BASE_URL+'/favorite/favorited',{articleId,userId},'POST')

export const cancelFavorite = (articleId,userId) => ajax(BASE_URL+'/favorite/cancel',{articleId,userId},'POST')

export const reqFavoriteArticle = (userId) => ajax(BASE_URL+'/favorite/common/getFavorite',{userId})
