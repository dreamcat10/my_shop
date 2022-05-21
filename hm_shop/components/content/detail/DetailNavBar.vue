<template>
  <nav-bar class="nav-bar">
    <template v-slot:left class="left">
      <image src="@/static/img/common/back.svg" @click="backTo" >
    </template>
    <template v-slot:center class="center">
      <view  v-for="(item , index) in titles"
            :class="{active: index === currentIndex}"
            @click="title(index)"
            class="titleItem">
        {{item}}
      </view>
    </template>
  </nav-bar>
</template>

<script>
import NavBar from "@/components/common/navbar/NavBar.vue";

export default {
  data() {
    return {
      titles: ['商品','参数','评论','推荐'],
      currentIndex: 0
    }
  },
  components: {
    NavBar
  },
  methods: {
    title(index){
      this.currentIndex = index
      this.$emit('titleClick', index)
    },
    backTo(){
		this.$router.back(-1)
    }
  }
}
</script>

<style scoped>
.nav-bar{
  height: 44px;
}
.active{
  color:#ff5777;
}
.center{
  display: flex;
  height: 44px;
}
.titleItem{
	display: flex;
	float: left;
	width: 25%;
	font-size: 13px;
	justify-content: space-around;
	flex-direction: row;
}
.left image{
	margin-top:10px;
	height: 25px;
	width: 35px;
	
}
</style>
