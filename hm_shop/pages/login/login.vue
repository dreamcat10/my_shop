<template>

<view class="content">
	<form @submit="submit">
	<view class="longin-boder">
		<view class="image"><image src="../../static/img/login/yonghu.png"></view>
		<input class="input" type="text" placeholder="输入账号" v-model=user.id />
	</view> 
	<!-- 用户名输入框 -->
	<view class="longin-boder">
		<view class="image"><image src="../../static/img/login/mima.png"></view>
		<input class="input" type="password" placeholder="输入密码" v-model=user.password />
	</view>
	<!--密码输入框-->
	<button class="button" form-type="submit">登录</button>
	</form>
	<button class="button" @click="toInLogin">注册</button>
</view>
</template>

<script>

	export default{
		data(){
			return {
				user: {
					password: '',														
					id: ''},
				
			}
		},
		components:{
			
		},
		computed:{

		},
		methods:{
			submit(){
				this.$userRequest({
					url: 'user/login',
					data: {											
						userId: this.user.id,
						userPassword: this.user.password							
					},	
					method: 'GET',
				}).then(resolve =>{
					if(resolve.code == 200){
						setTimeout(()=>{
						uni.switchTab({
							url:'../member/member'
					})
					},2000)
					if(resolve.data.token != null){uni.setStorageSync("token", resolve.data.token)
					uni.setStorageSync("expireTime",resolve.data.expireTime)}
					if(resolve.data.user != null){uni.setStorageSync("user", resolve.data.user)}
					}				
				})				
		},
			toInLogin(){
				uni.navigateTo({
					url: "./inLogin"
				})
			}	
	}
}
	
</script>

<style>
	.content{
		width: 100%;
		margin-top: 40%;
		text-align: center;
	}
	.longin-boder{
		width: 80%;
		height: 40px;
		margin-top: 10px;
		margin-left: 10%;
		line-height: 40px;
		text-align: center;
		border: 1px solid #dddddd;
		border-radius: 5px;  
		background-color: #efefef;
	}
	.image image{
		width: 25px;
		height: 25px;
		margin-top: 8px;
		float: left;
		text-align: right;
	}
	.input{
		width: 80%;
		float: left;
		margin-left: 5%;
		height: 37px;
		line-height: 37px;
		border:0px;
		color: #333333;
		font-size: 16px;
		background-color: #efefef;
		
	}
	 
	.button{
		height: 40px;
		width: 80%;
		margin-top: 20px;
		margin-left: 10%;
		font-size: 16px;
		font-family: "微软雅黑";
		font-weight: bold;
		line-height: 38px;
		border-radius: 5px;
		color: #ffffff;
		background-color: #37B4CA;
		
	}
	 
	.button:active {  
		background-color:#37a3b9;
	}
</style>
