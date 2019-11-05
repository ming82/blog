import Vue from 'vue'
import VueRouter from 'vue-router'

import MSite from "../pages/MSite/MSite"
import Article from "../pages/Article/Article"
import Issues from "../pages/Issues/Issues"
import Issue from "../pages/Issue/Issue"
import About from "../pages/About/About"
import PersonalSpace from "../pages/PersonalSpace/PersonalSpace"

// 声明使用插件
Vue.use(VueRouter)

export default new VueRouter({
  // 所有路由
  routes: [
    {
      path:'/msite',
      component: MSite,
    },
    {
      path:'/articles',
      component: MSite,
    },
    {
      path:'/article/:id',
      component: Article,
    },
    {
      path:'/issues',
      component: Issues,
    },
    {
      path:'/about',
      component: About,
    },
    {
      path:'/issue/:id',
      component: Issue,
    },
    {
      path:'/personalspace',
      component: PersonalSpace,
    },
    {
      path: '/',
      redirect: '/msite',
    },
  ]
})
