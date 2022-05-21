<template>
	<view class="member">
		<user-header :user="user" :isShow="isShow"></user-header>
		<view class="order"><view class="order-p" @click="toOrder">我的订单</view>
			<view class="order-icons">
				<view class="order-icon">
					<image src="@/static/img/me/order/dingdanwancheng.svg"/>
					完成订单
				</view>
				<view class="order-icon">
					<image src="@/static/img/me/order/order-incomplete_fill.svg"/>
					未完成订单
				</view>
				<view class="order-icon">
					<image src="@/static/img/me/order/31daipingjia.svg"/>
					待评价
				</view>
				<view class="order-icon">
					<image src="@/static/img/me/order/tuikuan.svg"/>
					退款
				</view>
			</view>	
		</view>
		<view class="other">
			<image src="@/static/img/me/wd.jpg"></image>
		</view>
		
	
	</view>
</template>

<script>
	import UserHeader from '@/components/content/member/UserHeader.vue'
	export default {
		data() {
			return {
				power: '',
				user: {},
				isShow: true
				
			}
		},
		components:{
			UserHeader
		},
		onShow() {
			if(uni.getStorageSync("expireTime") < new Date().getTime()){
				uni.removeStorageSync("user")
				uni.setStorageSync("user", {"role": "0"})
				uni.removeStorageSync("token")
				uni.showToast({
				  icon:'error',
				  title:"用户登录过期，请重新登录！"
				})
			}else{
				let token = uni.getStorageSync('token')
				let user = uni.getStorageSync('user')
				this.$goodsRequest({
					url: 'user/login',
					data: {											
						userId: user.userId,
						userPassword: user.password							
					},	
					method: 'GET',
				}).then(resolve =>{
					 const res = resolve.data
					if(res.code == 200){
						if(res.data.token != null){uni.setStorageSync("token", res.data.token)
						uni.setStorageSync("expireTime",res.data.expireTime)}
						if(res.data.user != null){uni.setStorageSync("user", res.data.user)}
						}		
				})	
			
			}	setTimeout(()=>{
				this.user = uni.getStorageSync("user")	
				this.isShow = this.user.role != 0
			},100) 
				
		},
		methods: {
			toOrder(){
				uni.navigateTo({
					url:'./order'
				})	
			}
		}
	
	}
</script>

<style>
	.member{
		background-color: #f3f5f6;
	}
	.order{
		height: 14vh;
		background-color: #FFFFFF;
		border: #f3f5f6 solid 15rpx;
		border-radius: 25rpx;
		font-size: 35rpx;
		font-family: "黑体";
	}
	.order image{
		margin-left: 50rpx;
		margin-right: 50rpx;
		width: 50rpx;
		height: 50rpx;
	
	}
	.order p{
		margin-top: 40rpx;		
	}
	.order-icons{
		height: 80%;
		display: flex;
	}
	.order-icon{
		
		text-align: center;
		flex: 1;
		height: 100%;
	}
	.order-p{
		border:20rpx solid #FFFFFF;
	}
	.other{
		width: 100%;
		height: 65vh;
	}
	.other image{
		width: 100%;
		height: 100%;
	}
</style>
