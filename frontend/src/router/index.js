import { createRouter, createWebHistory } from 'vue-router'
import main from '../views/main.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'main',
      component: main
    },
    {
      path: '/admin/service',
      name: 'service',
      component: () => import('../views/ViewService.vue'),
      meta: { requiresAuth: true } // Add meta field to require authentication
    },
    {
      path: '/admin/service/add',
      name: 'add',
      component: () => import('../views/AddService.vue'),
      meta: { requiresAuth: true } // Add meta field to require authentication
    },
    {
      path: '/admin/service/edit/:id',
      name: 'edit',
      component: () => import('../views/UpdateService.vue'),
      meta: { requiresAuth: true } // Add meta field to require authentication
    },
    {
      path: '/admin/portfolio',
      name: 'portfolio',
      component: () => import('../views/ViewPortfolio.vue'),
      meta: { requiresAuth: true } // Add meta field to require authentication
    },
    {
      path: '/admin',
      name: 'signin',
      component: () => import('../views/SignIn.vue')
    }
  ]
})

router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem('token');
  
  if (to.matched.some(record => record.meta.requiresAuth)) {
  if (!isAuthenticated) {
  next('/admin'); // Redirect to sign in if not authenticated
  } else {
  next(); // Continue to the desired route
  }
  } else {
  next(); // Continue for public routes
  }
  });

export default router

