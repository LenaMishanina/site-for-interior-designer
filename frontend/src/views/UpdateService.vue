<template>
  <main>
      <Navbar/>
      <div class="update_service">
          <div class="update_service_main" style="max-width:100%;">
            <h2 class="text-center">Изменить услугу</h2>
            <form @submit.prevent="updateService">
                 <!--name-->
                <div class="name">
                  <label for="name" class="form-label">Название</label>
                  <input id="name"  type="text" name="name" class="form-control" v-model="service.name">
                </div>
              
              <!--short_description-->
                  <div class="short_description">
                    <label for="short_description" class="form-label">Видимое описание</label>
                    <input id="short_description" type="text"  name="short_description" class="form-control" v-model="service.short_description" >
                  </div>

              <!--long_description-->
                  <div class="long_description">
                    <label for="long_description" class="form-label">Скрытое описание</label>
                    <input id="long_description" type="text"  name="long_description" class="form-control" v-model="service.long_description" >
                  </div>
    
              <!--price-->
                  <div class="price">
                    <label for="price" class="form-label">Стоимость</label>
                    <input id="price" type="number"  name="price" class="form-control" v-model="service.price" >
                  </div>

              <!--value_measure-->
                  <div class="value_measure">
                    <label for="value_measure" class="form-label">Ед. измерения стоимости</label>
                    <input id="value_measure" type="text"  name="value_measure" class="form-control" v-model="service.value_measure" >
                  </div>
          
                <div class="col-md-12 form-group">
                  <input class="change_btn" type="submit" value="Внести изменения">
                </div>      
            </form>
          </div>
        </div>

  </main>
</template>


<script>
import Navbar from '../components/Navbar.vue';
// import '../assets/js/bootstrap.min.js';

export default {
  name: 'UpdateService',
  components: {
      Navbar
  },

  data(){
      return {
          service: {
              id: '',
              name: '',
              short_description: '',
              long_description: '',
              price: '',
              value_measure: ''
          }
      }
  },

  
  methods: {
      getService(){
          fetch(`${import.meta.env.VITE_APP_API_URL_SERVICE}/${this.$route.params.id}`)
          .then(res => res.json())
          .then(data => {
              this.service = data;
          })

      },
      updateService(){
          fetch(import.meta.env.VITE_APP_API_URL_SERVICE, {
              method: 'PUT',
              headers: {
                  'Content-Type': 'application/json'
              },
              body: JSON.stringify(this.service)
          })
          .then(data => {
              this.$router.push('/admin/service');
          })
      }
  },
  beforeMount(){
      this.getService();
  }
}

</script>
<style scoped>
/* @import '../assets/css/bootstrap.min.css'; */
* {
margin: 0;
padding: 0;
box-sizing: border-box;
font: inherit;
vertical-align: baseline;
border: unset;
}

.update_service {
width: 100%;
height: 100%;
min-height: 100vh;
background-color: #DDD;
display: flex;
align-items: center;
justify-content: center;
font-family: 'Bitter-Light'
}

.update_service_main {
width: 40%;
max-width: 700px;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
}

.text-center {
text-align: center;
font-size: 40px;
font-weight: 600;
color: #222;
margin-bottom: 20px;
}

form {
width: 60%;
display: flex;
flex-direction: column;
align-items: center;
}

.name, .short_description, .long_description, .price, .value_measure {
width: 100%;
display: flex;
flex-direction: column;
margin-bottom: 20px;
}

.form-label {
font-size: 18px;
font-weight: 600;
margin-bottom: 5px;
}

.form-control {
height: 30px;
border-radius: 10px;
padding: 10px 10px;
}

.change_btn {
width: 200px;
height: 35px;
margin-top: 20px;
background-color: transparent;
border: 2px solid #222;
border-radius: 10px;
font-family: 'Bitter-Light';
font-weight: 600;
font-size: 20px;
color: #222;
cursor: pointer;
transition: background-color 0.3s;
}

.change_btn:hover {
background-color: #222;
border: 2px solid #222;
color: #DDD;
}

.change_btn:active {
transition: background-color 0.03s;
background-color: transparent;
border: 2px solid #777;
color: #777;
}
</style>