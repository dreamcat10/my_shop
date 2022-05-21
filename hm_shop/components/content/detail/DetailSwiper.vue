<template>
	<view>
		<swiper class="swiper"
				:indicator-dots="true"
				:indicator-active-color="'#ffff'"
				:autoplay="true"
				:circular="true"
				:interval="2000">
			<swiper-item class="swiper-item" 
			             v-for="item of this.swipers"> 	
				<image :src="item.img"></image>
			</swiper-item>
		</swiper>	
	</view>
</template>

<script>
	export default {
		props:{
			swipers: {
				type:Array,
				default:[]
			}
		},
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.swiper{
		overflow:hidden;
		height: 700rpx;
		border: #ff5777 solid 4rpx;
	}
	.swiper-item image{
		width: 100%;
		height: 100%;
	}
</style>
