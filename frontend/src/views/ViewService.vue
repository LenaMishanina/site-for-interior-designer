<template>
  <main>
        <Navbar />

      <!-- Table-->
      <div class="container">
          <div class="row">
                  <h1 class="text_center">Услуги</h1>
                  <table class="table">
                      <thead>
                        <tr>
                          <!-- <th scope="col">Id</th> -->
                          <th scope="col">Название</th>
                          <th scope="col" style="width: 300px">Видимое<br>описание</th>
                          <th scope="col" style="width: 500px">Скрытое описание</th>
                          <th scope="col">Стоимость</th>
                          <th scope="col">Ед.<br>изм.<br>стоимости</th>
                          <th scope="col" style="width: 200px">Действия</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="table_service" v-for="service in services" :key="service.id">
                          <!-- <th scope="row" class="id">{{service.id}}</th> -->
                          <td class="name" v-html="service.name"></td>
                          <td class="short_description" v-html="service.short_description"></td>
                          <td class="long_description" v-html="service.long_description"></td>
                          <td class="price" v-html="service.price"></td>
                          <td class="value_measure" v-html="service.value_measure"></td>
                          <td>
                            <div class="func_btns">
                              <a class="btn_change" :href="`/admin/service/edit/${service.id}`">Изменить</a>
                              <button class="btn_delete" @click="deleteService(service.id)">Удалить</button>
                            </div>
                          </td>
                        </tr>
                      </tbody>
                    </table>
              </div>
          </div>
  </main>
</template>

<script>
// import '../assets/js/bootstrap.min.js';
import Navbar from '../components/Navbar.vue'

export default {
  name: 'ViewService',
  components: {
      Navbar
  },
  data() {  
      return {
          services: []
      }
  },
  beforeMount() {
     this.getServices()
  },
  methods: {
    getServices(){
        fetch(import.meta.env.VITE_APP_API_URL_SERVICE)
        .then(res => res.json())
        .then(data => {
            this.services = data
        })
    },
    deleteService(id){
      fetch(`${import.meta.env.VITE_APP_API_URL_SERVICE}/${id}`, {
          method: 'DELETE'
      })
      .then(data => {
          this.getServices()
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

.container {
width: 100%;
height: 100%;
min-height: 100vh;
background-color: #DDD;
display: flex;
justify-content: center;
padding: 20px;
font-family: 'Bitter-Light';
}

.row {
margin-top: 100px;
width: 90%;
max-width: 2000px;
}

.text_center {
text-align: center;
font-size: 40px;
font-weight: 600;
color: #222;
}

thead {
border-bottom: 2px solid #222;
}

table {
width: 100%;
border-collapse: collapse;
border-spacing: 20px;
font-size: 16px;
font-weight: 600;
text-align: center;
color: #222;
}

tr:nth-child(even) {
background-color: #CCC; /* Цвет для четных строк */
}

th {
font-size: 25px;
color: #222;
}

th, td {
padding: 10px;
vertical-align: middle;
}

.short_description, .long_description {
text-align: left;
}

.func_btns {
display: flex;
flex-direction: column;
align-items: center;
}

.btn_change, .btn_delete {
font-family: 'Bitter-Light';
color: #222;
text-align: center;
background-color: transparent;
width: 50%;
min-width: 130px;
height: 30px;
border: 2px solid #222;
border-radius: 10px;
transition: background-color 0.3s;
}

.btn_change {
margin-bottom: 20px;
}

.btn_change:hover, .btn_delete:hover {
background-color: #222;
color: #DDD;
}

.func_btns a {
display: flex;
justify-content: center;
align-items: center;
}

</style>