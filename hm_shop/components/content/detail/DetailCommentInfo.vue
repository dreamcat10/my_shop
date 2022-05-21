<template>
  <div class="comment-info" v-if="Object.keys(commentInfo).length !== 0">
    <div class="info-header">
      <div class="header-title">用户评价</div>
      <div class="header-more">
        更多
        <i class="arrow-right"></i>
      </div>
    </div>

    <div class="info-user">
      <image :src="commentInfo.user.avatar">
      <span>{{commentInfo.user.uname}}</span>
    </div>
    <div class="info-detail">
      <p>{{commentInfo.content}}</p>
      <div class="info-other">
        <span class="date">{{commentInfo.created | showDate}}</span>
        <span>{{commentInfo.style}}</span>
      </div>
      <div class="info-imgs">
        <img :src="item" v-for="(item, index) in commentInfo.images" :key="index">
      </div>
    </div>
  </div>
</template>

<script>


export default {
  name: "DetailCommentInfo",
  filters:{
    showDate(value){
      const date = new Date(value * 1000)
      return date
    }
  },
  props: {
    commentInfo: {
      type:Object,
      default(){
        return {}
      }
    },
	

  },
  data(){
	  
  },
 
}
</script>

<style scoped>
.comment-info{
 padding: 20px 10px;
  border-bottom: 5px solid#f2f5f8;
}
.info-header{
  display: flex;
  line-height: 30px;
  border-bottom: 2px solid #f2f5f8;

}
.header-title{
    margin-bottom: 10px;
}
.header-more{
 margin-left: 250px;
  font-size: 18px;
  color: #333333;
}
.info-user{
  display: flex;
  margin-top: 10px;

}
.info-user image{
  width: 50px;
  height: 50px;
  border-radius: 50%;
}
.info-user span{
  margin-left: 10px;
  margin-top: 15px;
  font-size: 18px;
}
.info-detail {
  margin-top: 10px;
}
.info-other{
  margin-top: 5px;
  font-size: 10px;
}
.info-other span{
  padding: 0px 5px;
}
.info-imgs{
  display: flex;
  margin-top: 10px;
  height: 100px;
  width: 100px;
}
.info-imgs image{
 width: 100%;

}
</style>
