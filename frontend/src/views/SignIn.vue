<template>
  <div>
    <Navlogin/>
   
    <main class="auth_form">
      <form @submit.prevent="submit">
        <h1 class="enter">Вход в систему</h1>

        <div class="email">
          <label for="floatingInput">Email:</label>
          <input v-model="data.email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        </div>

        <div class="password">
          <label for="floatingPassword">Пароль:</label>
          <input v-model="data.password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
        </div>

        <button class="btn_enter" type="submit">Войти</button>
      </form>
    </main>

  </div>
</template>

<script>
import '../assets/js/bootstrap.min.js';
import Navlogin from '../components/Navlogin.vue';
import { reactive } from "vue"
import axios from "axios"
import { useRouter } from 'vue-router';

export default {
name: 'SignIn',
components: {
    Navlogin
}, 
setup() {
    const data = reactive (
        {
            email: '',
            password: ''
        }
    );
    const router = useRouter();

    const submit = async () => {
        try {
        const response = await axios.post('http://localhost:8080/api/login', data, {
            withCredentials: true
        });
        axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.token}`;
        localStorage.setItem('token', response.data.token); // Store token in local storage
        await router.push('/admin/service')
        } catch (error) {
            console.error("Неверно введены данные");
        }
    }

    return {
        data,
        submit
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

*:hover {
background-color: unset;
}

.auth_form {
height: 100vh;
overflow: hidden;
display: flex;
justify-content: center;
align-items: center;
background-color: #DDD;
}

.auth_form form {
margin-bottom: 50px;
width: 30%;
display: flex;
flex-direction: column;
align-items: center;
}

.enter {
margin-bottom: 20px;
text-align: center;
font-family: 'Bitter-Light';
font-size: 40px;
font-weight: 600;
color: #222;
}

.email, .password {
width: 50%;
display: flex;
flex-direction: column;
font-weight: 600;
margin-bottom: 20px;
color: #222;
}

.email label, .password label {
font-family: 'Bitter-Light';
font-size: 20px;
margin-bottom: 5px;
}

.form-control {
min-width: 200px;
height: 30px;
padding: 0 10px;
border-radius: 10px;
font-family: 'Bitter-Light';
}

.email input, .password input {
background-color: white;
}

.btn_enter {
width: 35%;
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

.btn_enter:hover {
background-color: #222;
border: 2px solid #222;
color: #DDD;
}

.btn_enter:active {
transition: background-color 0.03s;
background-color: transparent;
border: 2px solid #777;
color: #777;
}

/* .email  */
/* .form-signin input[type="email"] {
margin-bottom: -1px;
border-bottom-right-radius: 0;
border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
margin-bottom: 10px;
border-top-left-radius: 0;
border-top-right-radius: 0;
} */
</style>