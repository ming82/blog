import ajax from './ajax'
const BASE_URL = '/api'

export const postTag = (tagName) => ajax(BASE_URL+'/tag/',{tagName},'POST')

export const editTag = (tagId,tagName) => ajax(BASE_URL+'/tag/',{tagId,tagName},'PUT')

export const deleteTag = (tagId) => ajax(BASE_URL+'/tag/'+tagId,{},'DELETE')

export const reqTag = () => ajax(BASE_URL+'/tag/getAll')
