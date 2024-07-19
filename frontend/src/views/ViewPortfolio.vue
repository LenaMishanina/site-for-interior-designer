<template>
  <main>
        <Navbar />
      <!-- Table-->
      <div class="container">
          <div class="row">
                  <h1 class="text_center">Портфолио</h1>
                  <table class="table">
                      <thead>
                        <tr>
                          <th scope="col">Id</th>
                          <th scope="col">Путь к файлу</th>
                          <th scope="col">Индекс</th>
                          <th scope="col">Действие</th>
                          <!-- <th scope="col">Image</th> -->
                        </tr>
                      </thead>
                      <tbody>
                        <tr v-for="image in portfolio" :key="image.id">
                          <th scope="row">{{image.id}}</th>
                          <td>{{image.path}}</td>
                          <td>{{image.index}}</td>
                          <td>
                              <button class="btn_delete" @click="deleteImage(image.id)">Удалить</button>
                          </td>
                        </tr>
                      </tbody>
                    </table>
              </div>
              <div>
                <input type="file" @change="uploadPhoto">
              </div>
      </div>
  </main>
</template>

<script>
import '../assets/js/bootstrap.min.js';
import Navbar from '../components/Navbar.vue'

export default {
  name: 'ViewPortfolio',
  components: {
      Navbar
  },
  data() {
      return {
          portfolio: []
      }
  },
  beforeMount() {
      this.getPortfolio()
  },
  methods: {
      getPortfolio(){
          fetch(import.meta.env.VITE_APP_API_URL_PORTFOLIO)
          .then(res => res.json())
          .then(data => {
              this.portfolio = data
              console.log(data)
          })
      },
      deleteImage(id){
        fetch(`http://localhost:8080/portfolio/${id}`, {
            method: 'DELETE'
        })
        .then(data => {
            console.log(data)
            this.getPortfolio()
        })
      },
      uploadPhoto(event) {
    const file = event.target.files[0];
    const formData = new FormData();
    formData.append('file', file);

    fetch('http://localhost:8080/portfolio/uploadPhoto', {
      method: 'POST',
      body: formData
    })
    .then(response => {
      if (response.ok) {
        console.log('Photo uploaded successfully');
        this.getPortfolio();
      } else {
        console.error('Failed to upload photo');
      }
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
padding: 20px;
font-family: 'Bitter-Light';
display: flex;
flex-direction: column;
align-items: center;
}

.row {
margin-top: 100px;
width: 60%;
max-width: 2000px;
display: flex;
flex-direction: column;
align-items: center;
margin-bottom: 20px;
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

.btn_delete {
font-family: 'Bitter-Light';
color: #222;
text-align: center;
background-color: transparent;
width: 50%;
min-width: 130px;
height: 30px;
border: 2px solid #222;
border-radius: 10px;
cursor: pointer;
transition: background-color 0.3s;
}

.btn_delete:hover {
background-color: #222;
color: #DDD;
}

</style>