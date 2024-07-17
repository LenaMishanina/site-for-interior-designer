<template>
    <main>
          <Navbar />

           <div>
    <input type="file" @change="uploadPhoto">
  </div>

        <!-- Table-->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">View Portfolio</h1>
                    <table class="table table-striped">
                        <thead>
                          <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Path</th>
                            <th scope="col">Index</th>
                            <!-- <th scope="col">Image</th> -->
                          </tr>
                        </thead>
                        <tbody>
                          <tr v-for="image in portfolio" :key="image.id">
                            <th scope="row">{{image.id}}</th>
                            <td>{{image.path}}</td>
                            <td>{{image.index}}</td>
                            <td>
                                <!-- <a class="btn btn-primary" :href="`/admin/portfolio/edit/${image.id}`">Edit</a> -->
                                <button class="btn btn-danger mx-2" @click="deleteImage(image.id)">Delete</button>
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
            fetch('http://localhost:8080/portfolio')
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
