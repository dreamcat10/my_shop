<template>
  <view class="goods-list">
    <GoodsListItem v-for="item in goods" :goods-item="item"/>
  </view>

</template>

<script>
import GoodsListItem from "./GoodsListItem.vue";
export default {
  name: "GoodsList",
  components: {
    GoodsListItem
  },
  props: {
    goods: {
      type: Array,
      default(){
        return []
      }
    }
  }
}
</script>

<style scoped>
.goods-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  background-color: #FFFFFF;

  padding: 2px;
}

</style>

