<template>
  <div class="nav_login">
    <div class="container">
      <router-link to="/">Вернуться на сайт</router-link>
    </div>
  </div>
</template>

<script>
// import '../assets/js/bootstrap.min.js';
export default {
    name: "Navlogin"
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

*:hover {
  background-color: unset;
}

.nav_login {
  width: 100%;
  background-color: #222;
  height: 70px;
  display: flex;
  justify-content: center;
  position: fixed;
}

.container {
  width: 100%;
  max-width: 2000px;
  background-color: #222;
  display: flex;
  justify-content: right;
  align-items: center;
  text-align: center;
}

.container a {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 35px;
  font-family: 'Bitter-Light';
  font-size: 18px;
  margin-right: 100px;
  background-color: transparent;
  color: #DDD;
  border: 1px solid #DDD;
  border-radius: 10px;
}

.container a:hover {
  background-color: #DDD;
  color: #222;
  font-weight: 600;
}

.container a:active {
  background-color: transparent;
  color: #777;
  border: 1px solid #777;
  font-weight: 100;
}
</style>