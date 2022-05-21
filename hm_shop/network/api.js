const BASE_URL= 'http://localhost:8081/'
export function goodsRequst(options){
	return new Promise ((resolve, reject) => {
		uni.request({
			url: BASE_URL + options.url,
			method:options.method || 'GET',
			data: options.data || {},
			header: options.header || {},
			success: res => {
				if(!res){
					return uni.showToast({
						icon:'error',
						title:"获取数据失败"							
					})		
				}
				resolve(res)
			},
			fail: (err) =>{
				return uni.showToast({
					icon:'error',
					title:"网络错误"							
				})
				reject(err)
		
			}
		})
	})
}

export function userRequest(options){
	return new Promise ((resolve, reject) => {
		uni.request({
			url: BASE_URL + options.url,
			method:options.method || 'GET',
			data: options.data || {},
			header: options.header || {},
			success: (res) =>{			
					if(res.statusCode == 200){
						let data = res.data
						if(data.code == 200){
													
							uni.showToast({
							title:data.msg,
							icon:'success' })		
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
					resolve(res.data)
				},
				fail:(err)=> {
					uni.showToast({
					icon:'error',
					title:"网络错误"})
					reject(err)
				}
			})
		})
	
}
