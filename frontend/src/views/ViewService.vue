  <template>
      <main>
            <Navbar />

          <!-- Table-->
          <div class="container">
              <div class="row">
                  <div class="col-md-12">
                      <h1 class="text-center">Услуги</h1>
                      <table class="table table-striped">
                          <thead>
                            <tr>
                              <th scope="col">Id</th>
                              <th scope="col">Название</th>
                              <th scope="col">Видимое описание</th>
                              <th scope="col">Скрытое описание</th>
                              <th scope="col">Стоимость</th>
                              <th scope="col">Ед. изм. стоимости</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr v-for="service in services" :key="service.id">
                              <th scope="row">{{service.id}}</th>
                              <td>{{service.name}}</td>
                              <td>{{service.short_description}}</td>
                              <td>{{service.long_description}}</td>
                              <td>{{service.price}}</td>
                              <td>{{service.value_measure}}</td>
                              <td>
                                <a class="btn btn-primary" :href="`/admin/service/edit/${service.id}`">Редактировать</a>
                                <button class="btn btn-danger mx-2" @click="deleteService(service.id)">Удалить</button>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                  </div>
              </div>
          </div>
      </main>
  </template>

  <script>
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
            fetch('http://localhost:8080/service')
            .then(res => res.json())
            .then(data => {
                this.services = data
                console.log(data)
            })
        },
        deleteService(id){
          fetch(`http://localhost:8080/service/${id}`, {
              method: 'DELETE'
          })
          .then(data => {
              console.log(data)
              this.getServices()
          })
        }
      }
  }

  </script>
