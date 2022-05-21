<template>
	<view>
		<swiper class="swiper"
				:indicator-dots="true"
				:indicator-active-color="'#ffff'"
				:autoplay="true"
				:circular="true"
				:interval="2000">
			<swiper-item class="swiper-item" > 			
				<image src="@/static/img/home/lunbo/1.webp"></image>
			</swiper-item>
			<swiper-item class="swiper-item" >
				<image src="@/static/img/home/lunbo/2.webp"></image>
			</swiper-item>
			<swiper-item class="swiper-item" >
				<image src="@/static/img/home/lunbo/3.webp"></image>
			</swiper-item>
			<swiper-item class="swiper-item" >
				<image src="@/static/img/home/lunbo/4.webp"></image>
			</swiper-item>
		</swiper>	
	</view>
</template>

<script>
	export default {
		
		data() {
			return {
				
			}
		},
		
	}
</script>

<style>
	.swiper-item image{
		width: 100%;
		height: 100%;
	}
</style>
