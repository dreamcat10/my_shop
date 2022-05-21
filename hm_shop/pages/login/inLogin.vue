<template>
	<view>
		<form @submit="submit">
			<!-- 用户名输入框 -->
		<view class="longin-boder">
			<view class="image"><image src="../../static/img/login/yonghu.png"></view>
			<input class="input" type="text" placeholder="输入账号" v-model=user.id />
		</view> 
			<!-- 密码输入框 -->
		<view class="longin-boder">
			<view class="image"><image src="../../static/img/login/mima.png"></view>
			<input class="input" type="password" placeholder="输入密码" v-model=user.password />
		</view>	
		<!-- 呢称输入框 -->
		<view class="longin-boder">
			<view class="image"><image src="../../static/img/login/rename.svg"></view>
			<input class="input" type="text" placeholder="输入昵称" v-model=user.name />
		</view>	
		<!-- 年龄输入框 -->
		<view class="longin-boder">
			<view class="image"><image src="../../static/img/login/nianling.svg"></view>
			<input class="input" type="text" placeholder="输入年龄" v-model=user.age />
		</view>	
		<!-- 性别选择框 -->	
		<view class="longin-boder">
			<label class="check">
				<p>选择性别</p>
				<radio-group @change="check" class="radio-group">
					<radio value="男" :checked="isShow" class="radio">
						<view class="image"><image src="../../static/img/login/sexMale.svg"></view>
					</radio>			
					<radio value="女" :checked="!isShow">
						<view class="image"><image src="../../static/img/login/sexFemale.svg"></view>			
					</radio>
				</radio-group>
			</label>
		</view>
		<view class="longin-boder">
			<label class="check">
				<p>选择权限</p>
				<picker @change="PickerChange" :value="index" :range="role" class="picker">
					<view>{{role[index]}}</view>
				</picker>
			</label>
		</view>
		<button class="button" form-type="submit">注册</button>
		</form>
	</view>

</template>

<script>
	
	export default {
		data(){
			return {
				user: {
					password: '',														
					id: '',
					age: '',
					money: 0,
					sex: '',
					role: '',
					name: '',
					},
				isShow: true,
				role:['root', 'use'],
				index: 0
			}
	},
	methods:{
		check(e){
			this.isShow = !this.isShow
			this.user.sex = e.detail.value
		},
		PickerChange(e){
			 this.index = e.detail.value
			 this.user.role = this.role[this.index]	
		},
		submit(){
			this.$userRequest({
				url: 'user/inLogin',
				data: {											
					userId: this.user.id,
					password: this.user.password,
					age: this.user.age,
					sex: this.user.sex,
					name: this.user.name,
					money: this.user.money,
					role: this.user.role
				},	
				method: 'POST'
			}).then(resolve =>{
				console.log(resolve)
				if(resolve.code == 200){
					setTimeout(()=>{
						uni.navigateTo({
							url:'./login'
					})
					},2000)
				}
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
	.check{
		display: flex;
	}
	.check p{
		font-size: 16px;
		color: rgba(0,0,0,.5);
		font-family:"微软雅黑";
		flex: 1;
	}
	.radio-group{
		flex: 1;
		display: flex;
	}
	.radio{
		flex: 1;
	}
	.picker{
		flex: 1;
	}
</style>
