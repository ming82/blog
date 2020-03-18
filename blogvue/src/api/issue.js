import ajax from './ajax'
const BASE_URL = '/api'

export const reqIssue = (issueId) => ajax(BASE_URL+'/issue/'+issueId)

export const reqHotIssues = () => ajax(BASE_URL+'/issue/getHotIssues')

export const reqNoAnswerIssues = () => ajax(BASE_URL+'/issue/getNoAnswers')

export const reqIssueList = (pageNum,pageSize,categoryId,userId,userNickname,keyword) => ajax(BASE_URL+'/issue/getList',{pageNum,pageSize,categoryId,userId,userNickname,keyword})

export const postIssue = (userId,issueTitle,mdcontent,htmlcontent,categoryId) => ajax(BASE_URL+'/issue/',{userId,issueTitle,mdcontent,htmlcontent,categoryId},'POST')

export const editIssue = (issueId,userId,issueTitle,mdcontent,htmlcontent,categoryId) => ajax(BASE_URL+'/issue/',{issueId,userId,issueTitle,mdcontent,htmlcontent,categoryId},'PUT')

export const deleteIssue = (id) => ajax(BASE_URL+'/issue/'+id,'','DELETE')

export const reqIssueByUserId = (userId) => ajax(BASE_URL+'/issue/getByUserId',{userId})
