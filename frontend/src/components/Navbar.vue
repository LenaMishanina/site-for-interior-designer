<template>
  <div class="navbar">
    <div class="navbar_main">

      <div class="nav_buttons">
        <a href="/admin/service" class="nav_link">Услуги</a>
        <a href="/admin/service/add" class="nav_link">Добавить услугу</a>
        <a href="/admin/portfolio" class="nav_link">Портфолио</a>
        <!-- <li><a href="/admin/portfolio/add" class="nav-link px-2 text-white">Добавить фото</a></li> -->
      </div>

      <div class="text_end">
        <router-link to="/admin" class="nav_link" @click="logout">Выйти</router-link>
      </div>
    </div>
  </div>
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
/* @import '../assets/css/bootstrap.min.css'; */

.navbar {
width: 100%;
background-color: #222;
height: 70px;
display: flex;
justify-content: center;
position: fixed;
font-family: 'Bitter-Light';
}

.navbar_main {
width: 100%;
max-width: 2000px;
display: flex;
justify-content: space-around;
align-items: center;
}

.nav_buttons {
width: 50%;
display: flex;
float: left;
justify-content: space-between;
}

.nav_buttons a {
font-family: 'Bitter-Light';
width: 25%;
height: 35px;
display: flex;
justify-content: center;
align-items: center;
font-size: 18px;
font-weight: 100;
color: #DDD;
border: 1px solid #DDD;
border-radius: 10px;
}

.nav_buttons a:hover, .text_end a:hover {
background-color: #DDD;
color: #222;
font-weight: 600;
}

.nav_buttons a:active, .text_end a:active {
background-color: transparent;
color: #777;
border: 1px solid #777;
font-weight: 100;
}

.text_end a {
font-family: 'Bitter-Light';
width: 100%;
height: 35px;
display: flex;
justify-content: center;
align-items: center;
font-size: 18px;
font-weight: 100;
color: #DDD;
border: 1px solid #DDD;
border-radius: 10px;
}
</style>