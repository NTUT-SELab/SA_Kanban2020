<template>
<div>
  <vk-navbar id="boardNav">
    <vk-navbar-nav slot="left">
      <vk-button type="primary" id="navHomeButton"><img src="https://i.imgur.com/lohmYuW.png"></vk-button>
    </vk-navbar-nav>

    <vk-navbar-logo id="nvaLogo" slot="center">Kanban</vk-navbar-logo>

    <vk-navbar-nav slot="right">
      <vk-button type="primary" id="navImageButton" @click="show = true"><img src="https://i.imgur.com/T50ORBG.png"></vk-button>
      <vk-button type="primary" id="navAvatarButton"><img src="https://i.imgur.com/lojmoSO.png"></vk-button>
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
                    <vk-button type="primary" id="modalCreateButton" @click="createBoard">Create</vk-button>
                </p>
            </fieldset>
        </form>
    </div>
  </vk-modal>

  <vk-notification status="primary" :messages.sync="messages"></vk-notification>

</div>

</template>

<script>

export default {
  data(){
    return{
      show: false,
      messages: []
    }
  },
  methods:{
    createBoard: function(){
      this.show = false;
      this.messages.push({ message: 'Success', status: 'success' });
      this.messages.push({ message: 'Fail', status: 'danger' });
    }
  }
}
</script>>

<style scoped>

  #navInput{
    background-color: transparent;
  }

  #navHomeButton{
    background-color: transparent;
  }

  #navAvatarButton{
    background-color: transparent;
  }

  #navImageButton{
    background-color: transparent;
  }

  #boardNav{
    background-color: #23a8fa !important;
    height: 80px;
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

  #modalLegend{
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, bold;
  }

</style>