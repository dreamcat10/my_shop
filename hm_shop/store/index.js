import Vuex from "vuex" // 引入vuex
import Vue from "vue" //引入vue
Vue.use(Vuex)
const store = new Vuex.Store({
	state: {
		user: {}
	},
	getters: {
		
	},
	mutations: {
		addUser(state, payload){
			state.user = payload
		}
	},
	actions: { 
		
	},
	moduels: {
		
	}
	})
export default store