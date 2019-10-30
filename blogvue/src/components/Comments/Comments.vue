<template>
  <div class="shadow" align="left">
    <div style="margin-left: 10px;">
      <img src="../AuthorInfo/image/picture.png" style="width: 30px;height: 30px">
      <a style="text-decoration: none;" href="">司命</a>:
      <span>第一个回复</span>
    </div>
    <div class="comment" style="margin-left: 30px;background-color: #f2f2f2">
      <div>
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">司命</a>
        回复
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">名思</a>:
        <span>回复第一个回复</span>
      </div>
      <div>
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">司命</a>
        回复
        <img src="../AuthorInfo/image/picture.png" class="image"><a class="namehref" href="">名思</a>:
        <span>回复第一个回复</span>
      </div>
    </div>
    <br/>
  </div>
</template>

<script>
  export default {
    name: "Comments"
  }
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .image
    width: 20px
    height: 20px
    margin-top 5px
    margin-left 5px

  .namehref
    text-decoration none
    margin-top 5px
    margin-left 5px

  .comment
    color dimgrey
    font-size 14px
</style>
