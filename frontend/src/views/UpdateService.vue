<template>
    <main>
        <Navbar/>
        <div class="my-5">
            <div class="mx-auto w-25 " style="max-width:100%;">
              <h2 class="text-center mb-3">Обновить услугу</h2>
              <form @submit.prevent="updateService">
                   <!--name-->
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="name" class="form-label">Название</label>
                    <input id="name"  type="text" name="name" class="form-control" required v-model="service.name">
                  </div>
                </div>

                
                <!--short_description-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                      <label for="short_description" class="form-label">Видимое описание</label>
                      <input id="short_description" type="text"  name="short_description" class="form-control" required v-model="service.short_description" >
                    </div>
                  </div>

                <!--long_description-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                      <label for="long_description" class="form-label">Скрытое описание</label>
                      <input id="long_description" type="text"  name="long_description" class="form-control" required v-model="service.long_description" >
                    </div>
                  </div>
      
                <!--price-->
                  <div class="row">
                    <div class="col-md-12 form-group mb-3">
                      <label for="price" class="form-label">Стоимость</label>
                      <input id="price" type="number"  name="price" class="form-control" required v-model="service.price" >
                    </div>
                  </div>

                <!--value_measure-->
                  <div class="row">
                    <div class="col-md-12 form-group mb-3">
                      <label for="value_measure" class="form-label">Ед. измерения стоимости</label>
                      <input id="value_measure" type="text"  name="value_measure" class="form-control" required v-model="service.value_measure" >
                    </div>
                  </div>
            
                
               
                <div class="row">
                  <div class="col-md-12 form-group">
                    <input class="btn btn-primary w-100" type="submit" value="Обновить">
                  </div>
                </div>
      
                <div>
                  
                </div>
              </form>
        
            </div>
          </div>

    </main>
</template>


<script>
import Navbar from '../components/Navbar.vue';

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
            fetch(`http://localhost:8080/service/${this.$route.params.id}`)
            .then(res => res.json())
            .then(data => {
                this.service = data;
                console.log(this.service);
            })

        },
        updateService(){
            fetch(`http://localhost:8080/service`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.service)
            })
            .then(data => {
                console.log(data);
                this.$router.push('/admin/service');
            })
        }
    },
    beforeMount(){
        this.getService();
    }
}

</script>