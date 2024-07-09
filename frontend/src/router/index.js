import { createRouter, createWebHistory } from 'vue-router'
import ModalButton from '../views/main.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'site',
      component: ModalButton
    }
  ]
})

export default router