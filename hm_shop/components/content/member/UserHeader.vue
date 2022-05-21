<template>
	<view class="user-header">
		<view class="header-left">
			<image src="@/static/img/me/headimg/woman.png"></image>
			<view v-if="isShow" >
				<p>用户账号:{{user.userId}} 呢称:{{user.name}} </p>
				<text>余额:{{user.money}}</text>
			</view>
			<p v-else><navigator  url="../login/login">去登录</navigator></p>	
		</view>
		<view class="header-right">
			<navigator  url='../setting/setting'><image src="@/static/img/me/setUp.png" /></navigator> 
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		props:{
			user:{
				type:Object,
				default(){
					return {}
				}
			},
			isShow:{
				type:Boolean,
				default(){
					return true
				}
			}
		},

		
		
	}
</script>

<style>
	.user-header{
		color: #000000;
		font-family: "宋体";
		height: 13vh;
		display: flex;
		background-color: #F1F1F1;
	}
	.header-left{
		display: flex;
		flex: 1;
	}
	.header-left image{
		margin-top: 20rpx;
		margin-left: 20rpx;
		height: 130rpx;
		width: 130rpx;
		border-radius: 50%;
		
	}
	.header-left p{
		line-height: 49rpx;
		margin-top: 40rpx;
		margin-left: 20rpx;
	}
	.header-left text{
		margin-top: 40rpx;
		margin-left: 20rpx;
	}
	.header-right{
		
	}
	.header-right image{
		
		width: 50rpx;
		height: 50rpx;
	}
</style>
