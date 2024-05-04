const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({  
  outputDir: 'docs',
  assetsDir: './',
  publicPath: './',
  transpileDependencies: true
})
