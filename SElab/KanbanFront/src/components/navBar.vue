<template>
<div>
  <vk-navbar id="boardNav">
    <vk-navbar-nav slot="left">
      <vk-iconnav-item href="#" icon="home"></vk-iconnav-item>
    </vk-navbar-nav>

    <vk-navbar-logo id="nvaLogo" slot="center">Kanban</vk-navbar-logo>

    <vk-navbar-nav slot="right">
      <vk-iconnav-item id="navbarPlusIcon" icon="plus" @click="show = true"></vk-iconnav-item>
      <vk-button id="navbarCreate" @click="show = true">New</vk-button>
    </vk-navbar-nav>

  </vk-navbar>

  <vk-modal center :show.sync="show">
    <div class="container">
        <form>
            <fieldset class="uk-fieldset">
                <vk-modal-close @click="show = false"></vk-modal-close>
                <legend id="modalLegend" class="uk-legend">Create Board</legend>

                <div class="uk-margin">
                    <input class="uk-input" type="text" placeholder="Board Title">
                </div>

                <div class="uk-margin">
                    <textarea class="uk-textarea" rows="5" placeholder="Board Description"></textarea>
                </div>
                <p v-vk-margin>
                    <vk-button type="primary" id="modalCreateButton" @click.prevent="show = false">Create</vk-button>
                </p>
            </fieldset>
        </form>
    </div>
  </vk-modal>

</div>

</template>

<script>
export default {
  data(){
    return{
      show: false,
    }
  },
  methods:{
    openBoardModal: function () {
      this.boardModalOpen = !this.boardModalOpen;
    }
  }
}
</script>>

<style scoped>
  #boardNav{
    background-color: #23a8fa !important;
  }

  #navbarCreate{
    background-color: transparent;
    color: white;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  #modalCreateButton{
    color: white;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  #nvaLogo{
    color: white;
    font-size: 40px;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  #navbarPlusIcon{
    color: white;
  }

  #modalLegend{
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, bold;
  }

</style>