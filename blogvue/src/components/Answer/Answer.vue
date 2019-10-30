<template>
  <div class="shadow" align="left">
    <h3><span style="margin-left: 10px;margin-top: 10px;">发表回答</span></h3>
    <mavon-editor autofocus='false' v-model="value"/>
  </div>
</template>

<script>
  export default {
    name: "Answer",
    data() {
      return { value: '' }
    },
    mounted() {
      this.$nextTick(()=> {
        document.getElementsByClassName('auto-textarea-input')[0].blur(); // 获取textarea 不一定是auto-textarea-input
        window.scrollTo(0, 0)
      })
    }
  }
</script>

<style scoped>

</style>
