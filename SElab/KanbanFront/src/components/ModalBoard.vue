<template>
<div class="modal" v-show="value">
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
                    <vk-button @click.prevent="close">close</vk-button>
                </p>
            </fieldset>
        
        </form>
    </div>
</div>

</template>

<script>
export default {
    name: "Modal",
    props: {
        value: {
            required: true
        }
    },
    methods: {
        close() {
          this.$emit("input", !this.value);
        }
    }
}
</script>

<style lang="css" scoped>
  .modal {
    background-color: rgba(0, 0, 0, 0.3);
}
    .container{
        width: 60%;
        padding-left: 20%;
        padding-right: 20%;
        padding-bottom: 0%;
    }
</style>