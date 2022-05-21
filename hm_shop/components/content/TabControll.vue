<template>
  <div class="tab-control">
    <div class="tab-control-item"
         v-for="(item, index) in titles"
         :class="{active: index ===currentIndex}"
          @click="itemClick(index)">
      <span>{{item}}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabControl",
  props: {
    titles: {
      type: Array,
      default(){
        return []
      }
    }
  },
  data(){
    return {
      currentIndex: 0
    }
  },
  methods:{
    itemClick(index){
      this.currentIndex = index;
      this.$emit('tabClick', index)
    }
  }
}
</script>


<style scoped>
.tab-control{
  display: flex;
  text-align: center;
  height: 40px;
  line-height: 40px;
  font-size: 15px;
  background-color: #fff5f5;
  z-index:8;
}
.tab-control-item{
  flex: 1;
}
.tab-control-item span{
  padding:5px;
}
.active{
  color:#ff5777;
}
.active span{
  border-bottom: 3px solid  #ff8198;

}
</style>
