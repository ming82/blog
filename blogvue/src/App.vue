<template>
  <div id="app" style="background-color: rgba(235, 235, 235, 0.08)">
  <router-view v-if="isRouterAlive"/>
</div>
</template>

<script>
  import {mapActions} from 'vuex'
export default {
  name: 'App',
  mounted () {
    this.getCategory()
    this.getAllTags()
  },
  provide(){
    return {
      reload:this.reload
    }
  },
  data(){
    return{
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(() => (this.isRouterAlive = true))
    },
    ...mapActions(['getCategory','getAllTags'])
  },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 5px;
}
</style>
