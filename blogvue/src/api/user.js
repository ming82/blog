import ajax from './ajax'
const BASE_URL = '/api'


export const login = (username,password) => ajax(BASE_URL+'/login',{username,password},'POST')

export const logout = () => ajax(BASE_URL+'/logout')

export const register = (userName,userNickname,userPassword,userEmail) => ajax(BASE_URL+'/user/common/',{userName,userNickname,userPassword,userEmail},'POST')

export const updateUser = (userId,userNickname,userSignature,userEmail,userPicture) => ajax(BASE_URL+'/user/',{userId,userNickname,userSignature,userEmail,userPicture},'PUT')

export const checkUserPassword = (userId,userPassword) => ajax(BASE_URL+'/user/checkPassword',{userId,userPassword},'PUT')

export const updateUserPassword = (userId,userPassword) => ajax(BASE_URL+'/user/editPassword',{userId,userPassword},'PUT')

export const manageUser = (userId,userStatus) => ajax(BASE_URL+'/user/',{userId,userStatus},'PUT')

export const nameCheck = (userName,userNickname) => ajax(BASE_URL+'/user/common/nameCheck/',{userName,userNickname})

export const nickNameCheck = (userNickname) => ajax(BASE_URL+'/user/common/nickNameCheck/',{userNickname})

export const reqUserInfo = (userId) => ajax(BASE_URL+'/user/common/userInfo/'+userId)

export const reqUserList = (pageNum,pageSize,userName,userNickname,userStatus) => ajax(BASE_URL+'/user/superadmin/getList',{pageNum,pageSize,userName,userNickname,userStatus})

export const editPermit = (userId,permit) => ajax(BASE_URL+'/user/superadmin/editPermit',{userId,permit},'PUT')
