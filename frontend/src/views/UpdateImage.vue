<template>
    <main>
        <Navbar/>
        <div class="my-5">
            <div class="mx-auto w-25 " style="max-width:100%;">
              <h2 class="text-center mb-3">Update Image</h2>
              <form @submit.prevent="updateImage">
                 <!--path-->
                <div class="row">
                  <div class="col-md-12 form-group mb-3">
                    <label for="path" class="form-label">Path</label>
                    <input id="path"  type="text" name="path" class="form-control" placeholder="Path" required v-model="image.path">
                  </div>
                </div>

                <!--index-->
                  <div class="row">
                    <div class="col-md-12 form-group mb-3">
                      <label for="index" class="form-label">Index</label>
                      <input id="index" type="number"  name="index" class="form-control" placeholder="Index" required v-model="image.index" >
                    </div>
                  </div>

               
                <div class="row">
                  <div class="col-md-12 form-group">
                    <input class="btn btn-primary w-100" type="submit" value="Submit">
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
    name: 'UpdateImage',
    components: {
        Navbar
    },

    data(){
        return {
            image: {
                id: '',
                path: '',
                index: ''
            }
        }
    },

    
    methods: {
        getImage(){
            fetch(`http://localhost:8080/portfolio/${this.$route.params.id}`)
            .then(res => res.json())
            .then(data => {
                this.image = data;
                console.log(this.image);
            })

        },
        updateImage(){
            fetch(`http://localhost:8080/portfolio`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.image)
            })
            .then(data => {
                console.log(data);
                this.$router.push('/admin/portfolio');
            })
        }
    },
    beforeMount(){
        this.getImage();
    }
}

</script>