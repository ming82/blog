import ajax from './ajax'
const BASE_URL = '/api'

export const reqCategory = () => ajax(BASE_URL+'/category/common/getAll')

export const postCategory = (categoryName) => ajax(BASE_URL+'/category/admin/',{categoryName},'POST')

export const editCategory = (categoryId,categoryName) => ajax(BASE_URL+'/category/admin/',{categoryId,categoryName},'PUT')

export const deleteCategory = (categoryId) => ajax(BASE_URL+'/category/admin/'+categoryId,{},'DELETE')
