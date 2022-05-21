<template>
	<view class="goods">
		<view class="empty" v-if="!show">
			<image src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F01%2F82%2F40%2F596fa6dc00bb4_610.jpg&refer=http%3A%2F%2Fpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633499781&t=d37222e32213957ddbdd01d62e071309" mode="widthFix" style="width: 400rpx;"></image>
		<view class="empty-text">空空如也的购物</view>
		<view class="empty-button" @click="goshopping">去选购</view>
		</view>
		<view v-if="show">
			<view class="goods-detail" v-for="(item,index) in goods" :key="index" @longpress="long">
				<view class="detail-left">
					<view class="goods-left">
						<checkbox-group @change="selected(item)">
							<label>
								<checkbox  class="selected" color="#555555" :checked="item.flag"/><text></text>
							</label>
						</checkbox-group>
						  <image :src="item.img" style="width: 150rpx;height: 140rpx;"></image>
					</view>
					<view>
						<view class="title">
						{{item.name}}
						</view>
						<view class="size">
							<text style="font-size: 25rpx;">尺码:{{item.size}}</text>
							<text space="emsp">{{'  '}}</text>
							<text class="goods-price">价格:￥{{item.price * item.count}}</text>
						</view>
					</view>
				</view>
				<view class="detail-right">
					<text class="subtract" @click="reduce(item)">-</text>
					<text class="num">{{item.count}}</text>
					<text @click="add(item)" class="add">+</text>
				</view>
			</view>
		</view>
		<view class="end">
			<view class="end-left">
				<checkbox-group @change="selectgoods()">
					<label>
						<checkbox  :checked="allchecked" />全选
					</label>
				</checkbox-group>
				<view>
					总计：<text style="color: #f00;font-weight: bold;">￥ {{totalPrice}}</text>
				</view>
				</view>
				<view class="end-right" @click="buy">
				    结算({{totalNum}})
				</view>
			
			
		</view>
	</view>
</template>

<script>
	
	export default{
		data(){
			return{	
				allchecked: true,
				goods:[],
			}
		},
		onShow() {	
			this.allchecked = true
			if(uni.getStorageSync("user").role != 0){
				let id = uni.getStorageSync("user").userId
				let token = uni.getStorageSync("token")	 
				this.$goodsRequest({
					url: 'cart/getCarts',
					header:{
						'token': token
					},
					data : { 
						userId: id	
					}
				}).then(res => {
					this.goods = res.data.data
				})
			}else{
				uni.showToast({
					icon:'error',
					title:'请先登录'
				})
			}
		
		},
		methods:{
			long(){
				console.log(1)
			},
			goshopping(){
				uni.switchTab({
					url:'../index/index'
				})
			},
			reduce(item){
				let num=item.count
				if(num>1){
					num-=1
				}else if(num=1){
					uni.showToast({
					   title:"该宝贝不能减少了哟~" 
					})
				}			
				item.count=num
			},
			add(item){
				let num =item.count
				item.count=num+1
			},
		
			selected(item){
				item.flag=!item.flag
				if(!item.flag){
					this.allchecked=false		
				}else{
					let a = this.goods.filter((item)=>{
						return item.flag == false
					})
					
					if(a.length > 0){
						this.allchecked=false
					}else{
						this.allchecked=true
					}
				}
			},
			selectgoods(){
				this.allchecked=!this.allchecked
				if(this.allchecked){
					this.goods.map(item=>{	
						item.flag=true
					})
				}else{
					this.goods.map(item=>{
						item.flag=false
					})
				}
			},
		
			buy(){	
				const user = uni.getStorageSync("user")
				let buyGoods = []
				buyGoods = this.goods.filter(item =>{ 
					 return item.flag == true
				})
				let idLIst = buyGoods.map(item => {
					return item.id
				})
				let token = uni.getStorageSync("token")
				if(buyGoods.length > 0){
					uni.showModal({
						title: '确认订单',
						content: '是否购买商品？',
						success: res=> {
							if (res.confirm) {
								if(user.money >= this.totalPrice){
									this.$userRequest({
									url: 'cart/finishCart',
									header:{
										'token':token
									},
									method: 'POST',
									data:{
										idList: idLIst,
										Indents: buyGoods,
										money: this.totalPrice,
										uId: user.userId
									}
								}).then(res => {
									if(res.code == 200){
										uni.setStorageSync("user",res.data)
										setTimeout(()=>{
											this.$router.go(0)
										}, 400)
									}
								})
							}else{
								uni.showToast({
									icon:'error',
									title:'余额不足'
								})
							}
								
							} else if (res.cancel) {
								
							}
						}
					})
				}else{
					uni.showToast({
						icon:'error',
						title:'请先选中商品'
					})
				}
				
			}
		},
		computed:{
			totalNum(){
				let totalNum = 0
				this.goods.map(item => {
					item.flag ? totalNum += item.count : totalNum += 0
				})
				return totalNum
			},
			
			totalPrice() {
				let totalPrice = 0;
				this.goods.map(item => {
					item.flag ? totalPrice += item.count * item.price : totalPrice += 0
				})
				return totalPrice
			},
			show(){
				return this.goods.length > 0
			}
		}
	}
	
</script>

<style lang="scss">
	.goods{
		line-height: 80rpx;
		background-color: #FFFFFF;
		&-detail{
		    display: flex;
		    padding: 30rpx 15rpx 30rpx 30rpx;
		    background-color: #fff;
		    justify-content: space-between;
		    border-bottom: 5rpx solid #F1F1F1;
		    align-items: center;
		    .detail-left{
		        display: flex;
		        .goods-left{
		            display: flex;
		            align-items: center;
		        }
		    }
			.title{
				justify-content: space-around;
				flex-direction: column;
				margin-left: 30rpx;
				font-family: '宋体';
				font-size: 1rpx;
				line-height: 25rpx;
				color: #FF6200;
				width: 250 rpx;
			}
		    .size{   
		        justify-content: space-around;
		        flex-direction: column;
		        margin-left: 30rpx;
				height: 60rpx;
		        .goods-price{
		            font-size: 25rpx;     
		        }
		    }
		    .detail-right{
		        text{
		            width: 50rpx;
		            line-height: 50rpx;
		            text-align: center;
		            display: inline-block;
		            background-color: #F7F7F7;
		            margin-right: 10rpx;
		        }
		        .add {
		            color: #FA4305;
		            border-radius: 10rpx 30rpx 30rpx 10rpx;
		            margin-right: 20rpx;
		        }
		        .subtract{
		            border-radius: 30rpx 10rpx 10rpx 30rpx;
		        }
		    }
		}
	}
	.empty{
		
		    position: relative;
		    top: 220rpx;
		    text-align: center;
		    display: flex;
		    align-items: center;
		    flex-direction: column;
		    &-text{
		        color: #808080;
		        margin-bottom: 50rpx;
		    }
		    &-button{
		        width: 300rpx;
		        height: 90rpx;
		        color:orange;
		        border: 1rpx solid orange;
		        text-align: center;
		        line-height: 90rpx;
		        border-radius: 48rpx;
		    }		
	}
	.end{
	    width: 100%;
	    height: 90rpx;
	    background-color:#fff;
	    position: fixed;
	    bottom: 100rpx;
	    left: 0;
	    display: flex;
	    align-items: center;
	    &-left{
	        width: 70%;
	        display: flex;
	        justify-content: space-between;
	        padding: 0 30rpx;
	        .end-flex{
	            display: flex;
	            align-items: center;
	        }
	    }
	    &-right{
	        width: 30%;
	        line-height: 90rpx;
	        background-color: #F44545;
	        text-align: center;
	        color: #fff;
	    }
	}
</style>
