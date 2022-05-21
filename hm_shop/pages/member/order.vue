<template>
	<view class="goods">
		<view class="empty" v-if="!show">

		<view class="empty-text">暂无订单</view>
		</view>
		<view v-if="show">
			<view class="goods-detail" v-for="(item,index) in orders" :key="index">
				<view class="detail-left">
					<view class="goods-left">
						  <image :src="item.img" style="width: 150rpx;height: 140rpx;"></image>
					</view>
					<view>
						<view class="title">
						{{item.name}}
						</view>
						<view class="size">
							<text style="font-size: 25rpx;">尺码:{{item.size}}</text>
							<text space="emsp">{{'  '}}</text>
							<text class="goods-price">价格:￥{{item.total}}</text>
						</view>
					</view>
				</view>
				<view class="detail-right">
					<text class="num">{{item.count}}</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data(){
			return{
				show: true,
				orders: []
			}
		},
		onLoad(){
			if(uni.getStorageSync("user").role != 0){
				let id = uni.getStorageSync("user").userId
				console.log(id)
				let token = uni.getStorageSync("token")	 
				this.$goodsRequest({
					url: 'indent/getIndent',
					header:{
						'token': token
					},
					data: { 
						uId: 'loin1'	
					}
				}).then(res => {			
					this.orders = res.data.data
				})
			}else{
				uni.showToast({
					icon:'error',
					title:'请先登录'
				})
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

</style>
