import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import { viteStaticCopy } from 'vite-plugin-static-copy';
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    viteStaticCopy({
      targets: [
          {
              src: 'src/assets/images', // путь к вашей папке
              dest: 'src/assets' // путь назначения в dist
          }
      ]
  })
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  build: {
    rollupOptions: {
      output: {
        // Настройка для перемещения всех ассетов в папку `assets`
        assetFileNames: 'assets/[name].[hash][extname]',
      },
    },
  },
})
