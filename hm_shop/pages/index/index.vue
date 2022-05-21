<template>
	<view class="home">
		
		<scroll-view scroll-y="true" class="scroll"  @scrolltolower="scrolltolower" 
		:scroll-top="scrollTop" @scroll="scroll">
			<home-swiper class="swiper"></home-swiper>			
			<feature-view class="feature"></feature-view>
			<tab-controll :titles="['流行','新款','精选']"
							@tabClick="tabClick"></tab-controll>
			<GoodsList :goods="showGoods" ></GoodsList>					
		</scroll-view>
			<go-top class="back" :style="{'display':(isShow==true? 'block':'none')}"></go-top>
	</view>
</template>

<script>
import HomeSwiper from "../../components/content/home/homeSwiper.vue"
import FeatureView from "../../components/content/home/FeatureView.vue"
import HomeRecommendView from "../../components/content/home/HomeRecommendView.vue"
import TabControll from "../../components/content/TabControll.vue"
import GoodsList from "../../components/content/goods/GoodsList.vue"
import GoTop from "../../components/content/GoTop.vue"
	export default {
		data() {
			return {
				recommends: [],
				goods:{
					'pop': {
						page: 0,
						list: []
					},
					'new':{
						page: 0,
						list: []
					},
					'sell':{
						page: 0,
						list: []
					}
				},
				currentType:['pop','new','sell'],
				index: 0,
				scrollTop: 0,
				old: {
					scrollTop: 0
				},
				isShow: false
			}
		},
		components:{
			HomeSwiper,
			FeatureView,
			HomeRecommendView,
			TabControll,
			GoodsList,
			GoTop
		},
		computed:{
			showGoods(){
				let type = this.currentType[this.index]
				return this.goods[type].list
			}
		},
		onLoad() {
			
			//获取商品数据
			this.getHomeGoods('pop')
			this.getHomeGoods('new')
			this.getHomeGoods('sell')
			
			uni.$on('goTop',()=>{
				this.scrollTop = this.old.scrollTop
				//在数据变化后要执行的某个操作，而这个操作需要使用随数据改变而改变的DOM结构的时候，这个操作都应该放进Vue.nextTick()的回调函数中。
				this.$nextTick(function() {
					this.scrollTop = 0
				})
			})	
		},
		methods: {
		
		//获取首页列表商品数据
		getHomeGoods(type){
			let page = this.goods[type].page += 1
			this.$goodsRequest({
				url: 'goods/cargos',
				data: {
					type :type,
					page : page
				}
			}).then(resolve => {
			 this.goods[type].list.push(...resolve.data.data)
			 this.goods[type].page ++
			})
		},
		tabClick(index){
			
			this.index = index			
		},
		scrolltolower(){
			let type = this.currentType[this.index]
			this.getHomeGoods(type)
		},
		scroll(e){
			this.old.scrollTop = e.detail.scrollTop
			if(e.detail.scrollTop > 1500){
				this.isShow = true
			}else this.isShow = false
		},
		

			
	}
	
}

</script>

<style>
	.home{
		height:100vh;
	}
	.scroll{
		height: calc(100%);
		overflow: hidden;
		
	}
	.swiper{
		border-bottom: #E1E1E1 solid 20rpx;
	}
	.feature{
	width: 100%;
}
	.back{
		display: block;
		position: absolute;
		bottom: 60px;
		right: 20px;
		height: 50px;
		width: 50px;
		z-index: 999;
	}
</style>
