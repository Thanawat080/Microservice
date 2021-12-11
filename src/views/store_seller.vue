<template>
         <div class="container is-max-desktop">
             <br>
             <br>
            <div class="columns">
                <div class="column is-one-quarter">
                    <div class="card">
                        <header class="card-header">
                            <p class="card-header-title">
                                {{store_name}}
                            </p>
                        </header>
                        <div class="card-image">
                            <figure class="image is-2by2">
                                <img :src="'http://localhost:3001/' + picture"
                                    alt="Placeholder image">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                              <p><font size="2">ประเภทร้านค้า : {{this.store_type}}</font></p>
                              <p><font size="2">สถานะร้าน : เปิด</font></p>
                              <p><font size="2">จำนวนสินค้า : {{count_product}}</font></p>
                              <span v-show="this.status" style="color:green;"><i class="fas fa-check" style="color:green;"></i> ยืนยันตัวตนแล้ว</span>
                            </div>
                            <button class="button is-small is-danger" @click="reports">Report Store</button>
                          </div>
                    </div>
                </div>
                <div class="column is-three-quarters">
                    <div class="is-multiline columns is-variable is-2">

                        <!-- Start สินค้า -->
                        <div class="column is-one-third" v-for='store_product in seller_store_product' :key='store_product.id'>
                            <router-link :to="`/order/${store_product.id}`"><a href="order.html">
                                <div class="card">
                                    <div class="card-image">
                                        <figure class="image is-1by1"><img :src="'http://localhost:3002/' + store_product.pic[0]"/></figure>
                                    </div>
                                    <div class="card-content">
                                        <div class="media">
                                            <div class="media-content">
                                                <p id="title" class="title is-4">{{store_product.product_name}}</p>
                                                <p class="subtitle is-6 has-text-danger">{{store_product.price}} บาท</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a></router-link> 
                        </div>
                    </div>
                </div>
            </div>
            <br>
        </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      seller_store_product:null,
      store_name:'',
      count_product:0,
      store_type:'',
      id:'',
      status:null,
      picture:'',
      storeId:'',
      report:0
    };
  },
  created() {
    this.getseller_store_product(this.$route.params.sellerId); 
  },
  methods: {
    getseller_store_product(id) {
      axios
        .get(`http://localhost:3001/store/${id}`)
        .then((res) => {
          
     
          this.report = res.data.reportnumber
         
          this.store_name =  res.data.storename
          this.store_type = res.data.rent_type
          this.picture = res.data.picture
        axios
        .get("http://localhost:3002/product/"+res.data.storeId)
        .then((res) => {
          this.seller_store_product = res.data;  
          console.log(res.data)
        })
        .catch((err) => {
          console.log(err);
        });
        })
        .catch((eer) => {
          console.log(eer);
        });
    },reports(){
      axios.put(`http://localhost:3001/store/report/`+this.storeId+'/'+1)
        .then(() => {
      
          alert("Report Success")

        })
        .catch((eer) => {
          console.log(eer);
        });
    },
  },
};
</script>
