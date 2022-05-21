<template>
  <div class="base-info" v-if="Object.keys(goods).length !== 0">
    <div class="info-title">{{goods.cname}}</div>
    <div class="info-price">
      <span class="n-price">{{goods.value}}</span>
    </div>
    <div class="info-other">
      <span>销量: {{details.xiaoliang}}</span>
      <span>收藏: {{details.shoucang}}</span>
      <span>72小时发货</span>
    </div>
    <div class="info-service">
		<image src="@/static/img/detail/cargoService.png"></image>
    </div>

  </div>

</template>

<script>
export default {
  name: "DetailBaseInfo",
  props: {
    goods: {
      type: Object,
      default(){
        return {}

      }
    },
	details: {
	  type: Object,
	  default(){
	    return {}
	
	  }
	}
  },
}
</script>

<style scoped>
.base-info{
  margin-top: 15px;
  padding: 0 8px;
  color: #999;
  border-bottom: 5px solid #f2f5f8;
}
.info-title{
  color: #222;
}
.info-price{
  margin-top: 10px;
}
.info-price .n-price{
  font-size: 24px;
  color: var(--color-high-text);
}
.info-price .o-price{
  font-size: 13px;
  margin-left: 5px;
  text-decoration: line-through;

}
.info-price .discount{
  font-size: 12px;
  padding: 2px 5px;
  color: #fff;
  background-color: var(--color-high-text);
  border-radius: 8px;
  margin-left: 5px;

  position: relative;
  top: -8px;
}
.info-other{
  margin-top: 15px;
  line-height: 30px;
  display: flex;

  font-size: 13px;
  border-bottom: 1px solid rgba(100,100,100,.1);
  justify-content: space-between;

}
.info-service{
  justify-content: space-between;
  height: 150rpx;
}
.info-service image{
	width: 100%;
	height: 100%;
}

</style>
