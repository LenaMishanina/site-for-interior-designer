// import './assets/main.css'

// import './assets/css/1_navigation_menu.css'
// import './assets/css/2_small_section_about_me.css'
// import './assets/css/3_calculate_prices.css'
// import './assets/css/4_about_me.css'
// import './assets/css/5_my_advantages.css'
// import './assets/css/6_service.css'
// import './assets/css/7_stages.css'
// import './assets/css/8_portfolio.css'
// import './assets/css/9_request.css'
// import './assets/css/10_bottom.css'
// import './assets/css/fonts.css'

import './interceptors/axios.js'

import router from "./router";

import { createApp } from 'vue'
import App from './App.vue'

createApp(App).use(router).mount('#app')