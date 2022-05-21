<template>
  <view class="nav-bar">
    <view class="left"><slot name="left"></slot> </view>
    <view class="center"><slot name="center"></slot> </view>
    <view class="right"><slot name="right"></slot> </view>
  </view>
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style scoped>
.nav-bar{
  display: flex;
  height: 44px;
  line-height: 44px;
  text-align: center;
  box-shadow: 0 1px 1px rgba(100,100,100,.2);
}
.right, .left{
  width: 60px;

}
.center{
  flex: 1;

}

</style>
