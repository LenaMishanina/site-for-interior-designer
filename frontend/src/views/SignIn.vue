<template>
        <Navlogin/>
       
        <main class="form-signin w-100 m-auto">
  <form @submit.prevent="submit">
    <h1 class="h3 mb-3 fw-normal">Вход в систему</h1>

    <div class="form-floating">
      <input v-model="data.email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
      <label for="floatingInput">Email</label>
    </div>

    <div class="form-floating">
      <input v-model="data.password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Пароль</label>
    </div>
    
    <button class="btn btn-primary w-100 py-2" type="submit">Войти</button>
  </form>
</main>
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

<style>
@import '../assets/css/bootstrap.min.css';
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>