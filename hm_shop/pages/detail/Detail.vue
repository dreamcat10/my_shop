<template>
	  <view id="detail">
		<view class="nav-bar">
			  <detail-nav-bar @titleClick="titleClick" ref="nav"/>
		</view> 
		   <scroll-view class="scroll-Y" scroll-y="true" > 
			<p></p>
			<detail-swiper :swipers="topImages"/>
			<detail-base-info :goods="goods" :details="details"/>
			<detail-shop-info :shop="shop"/>
			<detail-parma-info  ref="param"/>
			<detail-goods-info />
			<view class="plun">评论:<image src="@/static/img/detail/plun.png"></image></view>
			<goods-list :goods="detailRecommend" ref="recommend"/>
			<p>---到底了---</p>
		</scroll-view>
		<detail-bottom-bar @addCart="addCart" class="bot-bar"/>
		<add-cart ref="addcart" :goods="goods" :topImages="topImages"></button></add-cart>
	  </view>
	  
</template>

<script>
	import DetailNavBar from "@/components/content/detail/DetailNavBar.vue";
	import DetailSwiper from '@/components/content/detail/DetailSwiper.vue'
    import DetailBaseInfo from "@/components/content/detail/DetailBaseInfo";
	import DetailShopInfo from "@/components/content/detail/DetailShopInfo";
	import DetailGoodsInfo from "@/components/content/detail/DetailGoodsInfo";
	import DetailParmaInfo from "@/components/content/detail/DetailParmaInfo";
	
	import DetailBottomBar from "@/components/content/detail/DetailBottomBar";
	import AddCart from "@/components/content/detail/addCart/AddCart.vue"

	import GoodsList from "@/components/content/goods/GoodsList.vue";
	import {Goods,GoodsParam,Shop} from "@/network/detail.js"
	export default {
		data(){
			return{
				iid: null,
				topImages: [],
				goods: {},
				shop: {},
				details: {},
				detailRecommend:[],
				
			}
		},
		components:{
			
			 DetailBottomBar,
			 GoodsList,
			 
			 DetailParmaInfo,
			 DetailGoodsInfo,
			 DetailShopInfo,
		     DetailBaseInfo,
			 DetailSwiper,
			 DetailNavBar,
			 AddCart
		
		},
		onLoad(options) {
			this.cId = options.id;
			//获取详情页数据
			this.getDetailGoods(this.cId);
					
		
		},
		methods: {
			getDetailGoods(cId){
				this.$goodsRequest({
					url:'goods/detail',
					data: {
						cId: cId				
					}
				}).then( res =>{	
						const data = res.data.data
					  //获取轮播图数据
					  this.topImages = data.imgs
					  //获取商品信息
					  this.details = data.detail
					  this.goods = data.cargo
					  //获取店铺信息
					  this.shop = data.store
					  //获取推荐信息
					 this.detailRecommend = data.recoms	
							
				})
				},

		
		    titleClick(index){
				
			},
			//添加购物车
			addCart(){
				if( uni.getStorageSync("user") == null || uni.getStorageSync("user").role == 0){
					uni.showToast({
						icon:'error',
						title:'请先登录'
					})
				}else{
					this.$refs.addcart.open('center')
				}
			},
	
		  }
	 }

</script>

<style>
 #detail{
	height: calc(100vh);
	background-color: #fff;
  }
  .nav-bar{
		position: fixed;
		top: 0;
		left: 0;
	    z-index: 9;
	    background-color: #f4f4f4;    
	    display: flex;
		width: 100%;
  }
  .scroll-Y{
	height: calc(100% - 49px);
	overflow: hidden;
  }
  p{
	  height: 44px;
  }
  .bot-bar{
	  position: fixed;
	  bottom: 0;
	  left: 0;
	  z-index: 9;  
	  display: flex;
	  width: 100%;
	border: #18BC37 solid 1px;
  }
  .plun{
	  border: #E1E1E1 solid 2rpx;
  }
  .plun image{
	  width: 130%;
  }

</style>
