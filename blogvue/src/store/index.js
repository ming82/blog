/*
vuex最核心的管理对象store
 */
import Vue from 'vue'
import Vuex from 'vuex'
import state from './state'
import mutations from './mutations'
import actions from './actions'
import getters from './getters'
import persistedState from "vuex-persistedstate"

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  mutations,
  actions,
  getters,
  // 使用localstorage
  // plugins: [persistedState()]
  // 使用sessionStorage
  plugins: [
    persistedState({ storage: window.sessionStorage })
  ]
})
