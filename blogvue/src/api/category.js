import ajax from './ajax'
const BASE_URL = '/api'

export const reqCategory = () => ajax(BASE_URL+'/category/getAll')

export const postCategory = (categoryName) => ajax(BASE_URL+'/category/',{categoryName},'POST')

export const editCategory = (categoryId,categoryName) => ajax(BASE_URL+'/category/',{categoryId,categoryName},'PUT')

export const deleteCategory = (categoryId) => ajax(BASE_URL+'/category/'+categoryId,{},'DELETE')
