<template>
  <view class="recommend">
    <view v-for="item in recommends" class="recommend-item">
      <a :href="item.link">
        <image :src="item.image">
        <view>{{item.title}}</view>
      </a>
    </view>
  </view>
</template>

<script>
export default {
  props: {
    recommends: {
      type: Array,
      default(){
        return []
      }
    }
  }
}
</script>

<style scoped>
.recommend{
  display: flex;
  width: 100%;
  text-align: center;
  padding: 15px 0 30px;
  border-bottom: 10px solid #eeeeee;
}
.recommend-item{
  flex: 1;
  }
  .recommend-item a{
	  text-decoration: none;
	  color: black;
  }
.recommend-item image{
  width: 50%;
  height: 100%;
  font-size: 15px;
}
</style>
