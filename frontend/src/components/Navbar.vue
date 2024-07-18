<template>
<header class="p-3 text-bg-dark">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/admin/service" class="nav-link px-2 text-white no-hover">Услуги</a></li>
          <li><a href="/admin/service/add" class="nav-link px-2 text-white">Добавить услугу</a></li>
          <li><a href="/admin/portfolio" class="nav-link px-2 text-white">Портфолио</a></li>
          <!-- <li><a href="/admin/portfolio/add" class="nav-link px-2 text-white">Добавить фото</a></li> -->
        </ul>

        <div class="text-end">
          <router-link to="/admin" class="btn btn-outline-light me-2" @click="logout">Выйти</router-link>
        </div>
      </div>
    </div>
  </header>
 
</template>

<script>
import '../assets/js/bootstrap.min.js';
import axios from 'axios'

export default {
    name: "NavBar",
    setup() {
        const logout = async () => {
            try {
                await axios.post('http://localhost:8080/api/logout', {}, { withCredentials: true });
                localStorage.setItem('token', '');
                this.$router.push('/admin');
            } catch (error) {
                console.error("Был совершен выход из системы");
            }
        }
        return {
            logout
        }
    }
}
</script>
<style>
@import '../assets/css/bootstrap.min.css';
</style>