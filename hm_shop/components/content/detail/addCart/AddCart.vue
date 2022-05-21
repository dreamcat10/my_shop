<template>
	<view>
		
		<uni-popup ref="popup" :isMaskClick="false">	
			<view  class="popup">
			   <form @submit="submit">		
				<view class="check_size">
					<p>选择尺码</p>
					<view class="size">
						<view v-for="(item, index) in sizes" 
						class="size-item" @click="check(index)" 
						:class="{active: index === currentIndex}">
							{{item}}
						</view>
					</view>					
				</view>
				<view class="check_count">
					<p>选择数量</p>
					<view class="count">
					<button class="button" @click="reduce" :disabled="isAble">-</button>
					<p>{{cart.count}}</p>
					<button class="button" @click="add">+</button>
					</view>					
				</view>
				<view class="check_price">
					<p>总价</p>
					{{total}}									
				</view>
				<button class="button1" form-type="submit">加入购物车</button>	
				</form>
				<button class="button2" @click="close">取消</button>
			  </view>
			
		</uni-popup>
	</view>
</template>
<script>
export default {
	data(){
		return{
			sizes:['M', 'L', 'XL'],
			currentIndex: 0,
			cart: {
				size: 'M',			
				count: 1,
				price: 0,
				uId:0,
				total: 0,
				img:'',
				name: '',
				cId: 0
			},
			
			
		}
	},
	props:{
		goods:{
			type:Object,
			default(){
				return {}
			}
		},
		topImages:{
			type:Array,
			default(){
				return []
			}
		}
	},
	computed:{
		isAble(){
			return this.cart.count <= 0
		},
		total(){
			return this.goods.value * this.cart.count
		}
		
	},
   methods:{
		open() {
     		this.$refs.popup.open('center')
     	},
		close(){
			this.$refs.popup.close()
		},
		check(index){
			this.currentIndex = index
			this.cart.size = this.sizes[index]
			
		},
		reduce(){	
			this.cart.count --
		},
		add(){		
			this.cart.count ++
		},
		submit(){
			this.cart.uId = uni.getStorageSync("user").userId
			this.cart.price = this.goods.value
			this.cart.img = this.goods.img
			this.cart.total = this.cart.price * this.cart.count
			this.cart.name = this.goods.cname
			this.cart.cId = this.goods.cid
			let token = uni.getStorageSync("token")
			uni.request({
				url: 'http://localhost:8081/cart/addCart',
				method: 'POST',
				data: {
					count: this.cart.count,
					img: this.cart.img,
					price : this.cart.price,
					size: this.cart.size,
					userId : this.cart.uId,
					name: this.cart.name,
					total: this.cart.total,
					cargoid: this.cart.cId
				},
				header: {
					'token': token
				},
			success: (res) =>{
					if(res.statusCode == 200){
						let data = res.data
						if(data.code == 200){							
							uni.showToast({
							title:data.msg,
							icon:'success' })
							setTimeout( ()=> {
								this.$refs.popup.close()
							},1500)
							
						}else{
							uni.showToast({
							icon:'error',
							title:data.msg})	
						}
						
					}else{
						uni.showToast({
						icon:'error',
						title:"网络错误"})
					}
				
				}
			})
		}
		
   }
}
</script>

<style>
	.popup{
		height:60vh;
		width: 50vh;
		background-color: #FFFFFF;
		
	}
	.popup button{
		border-radius: 30rpx;
		background-color: #FF5000;
		color: #FFFFFF;
		font-family: "粗体";
	}
	
	.check_size{
		
		text-align: center;
		height: 300rpx;
		border: #FFFFFF solid 1px;
	}
	.check_size p{
		height: 50rpx;
		color: #000000;
	}
	.size{
		height: 100rpx;
		display: flex;
		width: 100%;
		margin-top: 80rpx;
	}
	.size-item{
		flex: 1;	
		background-color: #E1E1E1;
		border: #FFFFFF solid 10rpx;
		line-height: 80rpx;
	}
	.active{
		border: #1AAD19 solid 1rpx;
	}
	.check_count{
		text-align: center;
		height: 150rpx;
		border: #ffffff solid 1px;
	}
	.count{
		display: flex;
		height: 100rpx;
		
	}
	.button{
		
		text-align: center;
		width: 100rpx;
	}
	.button2{
		border-top: #FFFFFF solid 20rpx;
		
	}
	.count p{
		line-height: 80rpx;
	}
	.check_price{
		text-align: center;
		height: 110rpx;
		border: #ffffff solid 1px;
	}
</style>
