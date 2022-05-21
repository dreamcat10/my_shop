import App from './App'
import { goodsRequst, userRequest} from './network/api.js'
import store from './store'
// #ifndef VUE3
import Vue from 'vue' 
import Router from 'js_sdk/hunter-vue-router-uni/index.js'

Vue.prototype.$store = store
Vue.prototype.$goodsRequest = goodsRequst
Vue.prototype.$userRequest = userRequest
Vue.config.productionTip = false
Vue.use(Router, {
    mode: 'strict', // strict or loose 可配置项，不配置的话默认为strict
    tabBars: [ // 必须配置项
        '/pages/hello',
        '/pages/my/index'
    ]
})
App.mpType = 'app'
const app = new Vue({
    ...App,
	store
})
app.$mount()
// #endif

// #ifdef VUE3
import App from './App'
import { createSSRApp } from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif