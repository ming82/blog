import ajax from './ajax'
const BASE_URL = '/api'

export const postTag = (tagName) => ajax(BASE_URL+'/tag/admin/',{tagName},'POST')

export const editTag = (tagId,tagName) => ajax(BASE_URL+'/tag/admin/',{tagId,tagName},'PUT')

export const deleteTag = (tagId) => ajax(BASE_URL+'/tag/admin/'+tagId,{},'DELETE')

export const reqTag = () => ajax(BASE_URL+'/tag/common/getAll')
