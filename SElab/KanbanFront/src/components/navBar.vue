<template>
<div>
  <vk-navbar>
    <vk-navbar-nav slot="left">
      <vk-iconnav-item href="#" icon="home"></vk-iconnav-item>
    </vk-navbar-nav>

    <vk-navbar-logo slot="center">Kanban</vk-navbar-logo>

    <vk-navbar-nav slot="right">
      <vk-iconnav-item icon="plus" v-on:click="openBoardModal"></vk-iconnav-item>
      <vk-button @click="show = true">New</vk-button>
    </vk-navbar-nav>

  </vk-navbar>

  <div >
      <modal-board v-model="boardModalOpen"></modal-board>
  </div>

  <vk-modal size="container" :show.sync="show">
    <div class="container">
        <form>
            <fieldset class="uk-fieldset">

                <legend class="uk-legend">Create Board</legend>

                <div class="uk-margin">
                    <input class="uk-input" type="text" placeholder="Board Title">
                </div>

                <div class="uk-margin">
                    <textarea class="uk-textarea" rows="5" placeholder="Board Description"></textarea>
                </div>
                <p v-vk-margin>
                    <vk-button @click.prevent="show = false">close</vk-button>
                </p>
            </fieldset>
        </form>
    </div>
  </vk-modal>

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
      show: false,
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