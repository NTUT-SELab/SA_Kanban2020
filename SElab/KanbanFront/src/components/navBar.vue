<template>
<div>
  <vk-navbar>
    <vk-navbar-nav slot="left">
      <vk-iconnav-item href="#" icon="home"></vk-iconnav-item>
    </vk-navbar-nav>

    <vk-navbar-logo slot="center">Kanban</vk-navbar-logo>

    <vk-navbar-nav slot="right">
      <vk-iconnav-item icon="plus" v-on:click="openBoardModal"></vk-iconnav-item>
    </vk-navbar-nav>

  </vk-navbar>

  <div>
      <modal-board v-model="boardModalOpen"></modal-board>
  </div>

</div>

</template>

<script>
import ModalBoard from "./ModalBoard.vue";
export default {
  components: {
    ModalBoard
  },
  data(){
    return{
      boardModalOpen: false
    }
  },
  methods:{
    openBoardModal: function () {
      this.boardModalOpen = !this.boardModalOpen;
    }
  }
}
</script>>