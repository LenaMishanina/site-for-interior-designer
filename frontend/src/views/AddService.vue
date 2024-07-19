<template>
  <main>
      <Navbar />
      <div class="add_service">
          <div class="add_service_main">
            <h2 class="text_center">Новая услуга</h2>
            <form @submit.prevent="addService">
               <!--name-->
                <div class="name">
                  <label for="name" class="form_label">Название:</label>
                  <input id="name"  type="text" name="name" class="form-control" required v-model="service.name">
                </div>

              
              <!--short_description-->
                  <div class="short_description">
                    <label for="short_description" class="form_label">Видимое описание:</label>
                    <input id="short_description" type="text"  name="short_description" class="form-control" required v-model="service.short_description" >
                  </div>

              <!--long_description-->
                  <div class="long_description">
                    <label for="long_description" class="form_label">Скрытое описание:</label>
                    <input id="long_description" type="text"  name="long_description" class="form-control" required v-model="service.long_description" >
                  </div>
    
              <!--price-->
                  <div class="price">
                    <label for="price" class="form_label">Стоимость:</label>
                    <input id="price" type="number"  name="price" class="form-control" required v-model="service.price" >
                  </div>

              <!--value_measure-->
                  <div class="value_measure">
                    <label for="value_measure" class="form_label">Ед. измерения стоимости:</label>
                    <input id="value_measure" type="text"  name="value_measure" class="form-control" required v-model="service.value_measure" >
                  </div>

                <div>
                  <input class="create_btn" type="submit" value="Создать">
                </div>
    
              <div>
                
              </div>
            </form>
      
          </div>
        </div>
  </main>
</template>


<script>
import '../assets/js/bootstrap.min.js';
import Navbar from '../components/Navbar.vue';

  export default {
      name: 'AddService',
      components: {
          Navbar
      },

      data() {
          return {
              service : {
                  name: '',
                  short_description: '',
                  long_description: '',
                  price: '',
                  value_measure: ''
              }
          }
      },

      methods: {
          addService(){
              fetch('http://localhost:8080/service/add', {
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(this.service)
              })
              .then(data => {
                  console.log(data)
                  this.$router.push("/admin/service");
              })

          }
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

.add_service {
width: 100%;
height: 100%;
min-height: 100vh;
background-color: #DDD;
display: flex;
align-items: center;
justify-content: center;
font-family: 'Bitter-Light'
}

.add_service_main {
width: 40%;
max-width: 700px;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
}

.text_center {
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

.form_label {
font-size: 18px;
font-weight: 600;
margin-bottom: 5px;
}

.form-control {
height: 30px;
border-radius: 10px;
padding: 10px 10px;
}

.create_btn {
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

.create_btn:hover {
background-color: #222;
border: 2px solid #222;
color: #DDD;
}

.create_btn:active {
transition: background-color 0.03s;
background-color: transparent;
border: 2px solid #777;
color: #777;
}
</style>