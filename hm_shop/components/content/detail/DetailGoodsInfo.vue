<template>
  <div v-if="Object.keys(detailInfo).length !==0" class="detail-goods-info">
    <div class="info-desc clear-fix">
      <div class="start"></div>
      <div class="desc">{{detailInfo.desc}}</div>
      <div class="end"></div>
    </div>
    <div class="info-key">{{detailInfo.detailImage[0].key}}</div>
    <div class="info-list">
      <img v-for="(item, index) in detailInfo.detailImage[0].list" :key="index"
           :src="item" @load="imageLoad">
    </div>
  </div>
</template>

<script>


export default {
  name: "DetailGoodsInfo",
  props: {
    detailInfo: {
      type: Object,
      default(){
        return {}
     }
   }
 },
  data(){
    return {
      count:0,
      imageLength:0
    }
  },
  methods: {
    imageLoad(){
      if (++this.count === this.imageLength)
        this.$emit('imageLoad')
    }
  },
  watch: {
    detailInfo(){
      this.imageLength = this.detailInfo.detailImage[0].list.length
    }
  }
}
</script>

<style scoped>
.detail-goods-info{

}
.info-list img{
  height: 100%;
  width: 100%;
}
</style>
