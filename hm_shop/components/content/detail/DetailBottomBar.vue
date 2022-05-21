<template>
  <view class="bottom-bar">
    <view class="bar-item bar-left">
      <view>
        <i class="icon service"></i>
        <span class="text">客服</span>
      </view>
      <view>
        <i class="icon shop"></i>
        <span class="text">店铺</span>
      </view>
      <view>
        <i class="icon select"></i>
        <span class="text">收藏</span>
      </view>
    </view>
    <view class="bar-item bar-right">
      <view class="cart" @click="addCart">加入购物车</view>
      <view class="buy">购买</view>
    </view>
  </view>
</template>

<script>
export default {
  name: "DetailBottomBar",
  methods: {
    addCart(){
      this.$emit('addCart')
    }
  }
}
</script>

<style scoped>
.bottom-bar{

  background-color: #fff;
  height: 49px;
  display: flex;
  text-align: center;
}
.bar-item{
  flex: 1;
  display: flex;
}
.bar-item>view{
  flex: 1;
}
.bar-left .text{
  font-size: 13px;
}
.bar-left .icon{
  display: block;
  width: 22px;
  height: 22px;
  margin: 5px auto 3px;
  background: url("@/static/img/detail/detail_bottom.png") 0 0/100%;
}
.bar-left .service{
  background-position: 0 -54px;
}
.bar-left .shop{
  background-position: 0 -98px;
}
.bar-right{
	display: flex;
	flex-direction: row;   
  font-size: 15px;
  color: #ffffff;
  line-height: 58px;
}
.bar-right .cart{
  background-color: #ffe817;
  color: #333333;
}
.bar-right .buy{
  background-color: #f69;
}
.sport-ball{
  position: absolute;
  left: 225px;
  bottom: 20px;
}
</style>
