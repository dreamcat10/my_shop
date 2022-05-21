<template>
	<view class="setting"> 
	    <setting-header :user="user" :isShow="isShow"></setting-header>
		<view class="body"><image src="@/static/img/setting/setting.jpg"></image></view>
		<button @click="logout" class="button">退出账号</button>
		<button @click="remove">注销账号</button>
	</view>
</template>

<script>
	import SettingHeader from '@/components/content/setting/SettingHeader.vue'
	export default {
		data(){
			return{
				user: {},
				isShow: true
			}
		},
		components:{
			SettingHeader
		},
		onShow() {
			this.user = uni.getStorageSync("user")
			this.isShow = this.user.role != 0
		},
		methods:{
			logout(){
				let token = uni.getStorageSync("token")
				this.$userRequest({
					url:'user/logout',
					method: 'DELETE',
					header:	{
						'token': token
					}
				}).then(resolve => {
					if(resolve.code == 200){
						uni.removeStorageSync("token")
						uni.setStorageSync("user", resolve.data)
						setTimeout(()=>{
							uni.switchTab({
								url:'../member/member'
						})
						},2000)
					}
				})
			},
			remove(){
				let token = uni.getStorageSync("token")
				this.$userRequest({
					url:'user/remove',
					method: 'DELETE',
					header:	{
						'token': token
					}
				}).then(resolve => {
					
					if(resolve.code == 200){
						uni.removeStorageSync("token")
						uni.setStorageSync("user", resolve.data)
						setTimeout(()=>{
							uni.switchTab({
								url:'../member/member'
						})
						},2000)
					}
				})
			}
		}
	}
</script>

<style>
	.setting{
		background-color:#E1E1E1;
		height: 90vh;
	}
	.body{
		height: 60vh;
	}
	.body image{
		height: 100%;
		width: 100%;
	}
	.button{
		margin-top: 20rpx;
		margin-bottom: 20rpx;
	}
</style>
