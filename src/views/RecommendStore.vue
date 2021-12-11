<template>
  <div>
    <br />
    <br />
    <div class="container is-max-desktop">
      <div class="is-multiline columns is-variable is-2">
        <br />

        <!-- Start Recommend -->
        <div
          class="column is-one-quarter"
          v-for="value in store"
          :key="value.storeId"
          v-show="value.subscription_type != 'free'"
        >
          <router-link :to="`/store_seller/${value.storeId}`">
            <div class="card">
              <div class="message-header">
                <p>{{ value.storename }}</p>
              </div>
              <div class="card-image">
                <figure class="image is-4by3">
                  <img
                    :src="'http://localhost:3001/' + value.picture"
                    alt="Placeholder image"
                  />
                </figure>
              </div>
              <div class="card-content">
                <div class="content">{{ value.description }}</div>
              </div>
            </div>
          </router-link>
        </div>

        <!-- End Recommend -->
      </div>
    </div>

    <br />
  </div>
</template>



<script>
import axios from "axios";

export default {
  data() {
    return {
      store: null,
    };
  },
  created() {
    axios
     .get("http://localhost:3001/store")
      .then((res) => {
        this.store = res.data;
        console.log(res.data)      
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>






