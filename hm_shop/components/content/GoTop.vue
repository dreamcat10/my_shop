<template>
	<view @click="goTop" class="goTop">
		<image src="../../static/img/login/dingbu.png"></image>
	</view>
</template>

<script>
	export default{
		methods:{
			goTop(){
				return uni.$emit('goTop')
			}
		}
	}
</script>

<style>
	.goTop{
		height: 40px;
		width: 40px;
		background-color: #E1E1E1;
		border-radius: 50%;
	}
	.goTop image{
		
		height:45px;
		width: 45px;
		
	}
</style>
