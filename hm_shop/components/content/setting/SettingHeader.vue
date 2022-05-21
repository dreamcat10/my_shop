<template>
	<view class="user-header">
		<view class="header-left">
			<image src="@/static/img/me/headimg/woman.png"></image>
			<p v-if="isShow">用户账号:{{user.userId}} 呢称:{{user.name}}</p>
			<p v-else><navigator  url="../login/login">去登录</navigator></p>	
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
		background-color: #FFFFFF;
		margin-bottom: 20rpx ;
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
		line-height: 49px;
		margin-top: 40rpx;
		margin-left: 20rpx;
	}

</style>

