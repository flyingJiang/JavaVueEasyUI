<template>
  <div id="app">
    <router-view/>
  </div>

<!--  <div class="main">-->
<!--    <div @click="openMask">打开弹窗</div>-->
<!--    <dialog-bar v-model="sendVal" type="danger" title="我是标题" content="我是内容" v-on:cancel="clickCancel()" @danger="clickDanger()" @confirm="clickConfirm()" dangerText="Delete"></dialog-bar>-->
<!--  </div>-->
</template>

<script>
  import dialogBar from './dialog.vue'
  export default {
    name: 'App',
    components:{
      'dialog-bar': dialogBar,
    },
    data(){
      return{
        sendVal: false,
      }
    },
    methods:{
      openMask(index){
        this.sendVal = true;
      },
      clickCancel(){
        console.log('点击了取消');
      },
      clickDanger(){
        console.log('这里是danger回调')
      },
      clickConfirm(){
        console.log('点击了confirm');
      }
    }
  }
  // export default {
  //   name: 'App'
  // }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
