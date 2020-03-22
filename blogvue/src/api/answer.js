import ajax from './ajax'
const BASE_URL = '/api'

export const reqAnswerById = (answerId) => ajax(BASE_URL+'/answer/'+answerId)

export const reqAnswerByIssueId = (issueId) =>ajax(BASE_URL+'/answer/common/getAnswersByIssueId',{issueId})

export const postAnswer=(userId,issueId,mdcontent,htmlcontent) => ajax(BASE_URL+'/answer/',{userId,issueId,mdcontent,htmlcontent},'POST')
