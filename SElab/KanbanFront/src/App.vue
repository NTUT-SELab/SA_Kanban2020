<template>
  <div id="app">
    <navBar/>
    <div v-vk-margin>
      <vk-button>Button</vk-button>
      <vk-button disabled>Disabled</vk-button>
      <vk-button-link href="#">Link</vk-button-link>
    </div>
    <div uk-lightbox>
    <a class="uk-button uk-button-default" href="images/photo.jpg">Open Lightbox</a>
    </div>
  </div>
</template>

<script>
import navBar from './components/navBar.vue'

export default {
  name: 'App',
  components: {
    navBar
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
