<template>
  <div class="shop-info">
    <div class="shop-top">
      <image :src="shop.img">
      <span class="title">{{shop.sname}}</span>
    </div>
    <div class="shop-middle">
      <div class="shop-middle-item shop-middle-left">
        <div class="info-sells">
          <div class="sells-count">
            {{shop.grss | sellCountFilter}}
          </div>
          <div class="sells-text">总销量</div>
        </div>
        <div class="info-goods">
          <div class="goods-count">{{shop.count}}</div>
          <div class="goods-text">全部宝贝</div>
        </div>
      </div>
      <div class="shop-middle-item shop-middle-right">
        <table>
          <tr>
            <td>{{shopComment[0]}}</td>
            <td class="score" :class="{'score-better': shop.acc > 4.7}">{{shop.acc}}</td>
            <td class="better" :class="{'better-more': shop.acc > 4.7}"><span>{{shop.acc > 4.7? '高' : '低'}}</span></td>
          </tr>
		  <tr>
		    <td>{{shopComment[1]}}</td>
		    <td class="score" :class="{'score-better': shop.jiage > 4.7}">{{shop.jiage}}</td>
		    <td class="better" :class="{'better-more': shop.jiage > 4.7}"><span>{{shop.jiage > 4.7? '高' : '低'}}</span></td>
		  </tr>
		  <tr>
		    <td>{{shopComment[2]}}</td>
		    <td class="score" :class="{'score-better': shop.zhiliang > 4.7}">{{shop.zhiliang}}</td>
		    <td class="better" :class="{'better-more': shop.zhiliang > 4.7}"><span>{{shop.zhiliang > 4.7? '高' : '低'}}</span></td>
		  </tr>
        </table>
      </div>
    </div>
    <div class="shop-bottom">
      <div class="enter-shop">进店逛逛</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "DetailShopInfo",
  props: {
    shop: {
      type: Object,
      default(){
        return {}
      }
    }
  },
  data(){
	  return{
		  shopComment:['描述相符', '价格合理', '质量满意']
	  }
  },
  filters: {
    sellCountFilter: function (value){
      if (value < 10000) return value
      return (value/10000).toFixed(1) + '万'
    }
  }
}
</script>

<style scoped>
.shop-info{
  padding:25px 8px;
  border-bottom: 5px solid #f2f5f8;
}
.shop-top{
  line-height: 45px;
  display: flex;
  align-items: center;
}
.shop-top image{
  height: 60px;
  width: 60px;
  border-radius: 50%;
  border: 1px solid rgba(0,0,0,.1);
}
.shop-top .title{
  margin-left: 10px;
  vertical-align: center;
}
.shop-middle{
  display: flex;
  align-items: center;
  margin-top: 15px;
}
.shop-middle-item{
  flex: 1;
}
.shop-middle-left{
  display: flex;
  justify-content: space-evenly;
  color: #333333;
  text-align: center;
  border-right: 1px solid rgba(0,0,0,.1);
}
.sells-count, .goods-count{
  font-size: 18px;
}
.sells-text, .goods-text{
  margin-top: 10px;
  font-size: 12px;
}
.shop-middle-right{
  font-size: 13px;
  color: #333;
}
.shop-middle-right table{
  width: 120px;
  margin-left: 30px;
}
.shop-middle-right table td{
  padding: 5px 0;
}
.shop-middle-right .score{
  color: #5ea732;
}
.shop-middle-right .score-better{
  color: #f13e3a;
}
.shop-middle-right .better span{
  background-color: #5ea732;
  color: #fff;
  text-align: center;
}
.shop-middle-right .better-more span{
  background-color: #f13e3a;

}
.shop-bottom{
  text-align: center;
}
.enter-shop{

}
</style>
