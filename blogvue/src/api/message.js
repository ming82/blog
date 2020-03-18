import ajax from './ajax'
const BASE_URL = '/api'

export const reqNoReadNum = (userId) => ajax(BASE_URL+'/message/countNoRead',{userId})

export const reqReadMessage = (userId) => ajax(BASE_URL+'/message/getRead',{userId})

export const reqNoreadMessage = (userId) => ajax(BASE_URL+'/message/getNoread',{userId})

export const markRead=(list) => ajax(BASE_URL+'/message/markRead',{list},"POST")
