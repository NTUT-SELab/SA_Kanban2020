<template>
  <div id="app">
    <navBar/>
    <BoardNav/>
  </div>
</template>

<script>
import navBar from './components/navBar.vue'
import BoardNav from './components/BoardNav.vue'

export default {
  name: 'App',
  components: {
    navBar,
    BoardNav
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

</style>
