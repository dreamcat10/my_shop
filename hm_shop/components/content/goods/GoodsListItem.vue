<template>
  <view class="goods-item" @click="toDetail">
    <image :src="showImage" >
    <view class="goods-info">
      <p>{{title}}</p>
      <span class="price">{{goodsItem.value}}</span>		
    </view>
  </view>
</template>

<script>
export default {
  name: "GoodsListItem",
  props: {
    goodsItem: {
      type: Object,
      default(){
        return {}
      }
}
  },
  methods: {
   toDetail(){   
	this.$Router.push({
		query:{id: this.goodsItem.cid ||this.goodsItem.rid  },
		path:"/pages/detail/Detail"
	})
   }
  },
  computed: {
    showImage(){
      return this.goodsItem.img || this.goodsItem.show.img
    },
	title(){
	  return this.goodsItem.cname || this.goodsItem.rname
	}
  }
}
</script>

<style scoped>
.goods-item {
  padding-bottom: 40px;
  position: relative;

  width: 48%;
}

.goods-item image {
  width: 100%;
  border-radius: 5px;
  border:3px solid #FF8198;
}

.goods-info {
  font-size: 12px;
  position: absolute;
  bottom: 5px;
  left: 0;
  right: 0;
  overflow: hidden;
  text-align: center;
}

.goods-info p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 3px;
}

.goods-info .price {
  color: #FF5777;
  margin-right: 20px;
}

.goods-info .collect {
  position: relative;
}



</style>
