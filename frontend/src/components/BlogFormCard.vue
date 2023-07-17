<template>
  <el-card>
    <template #header>
      <div class="card-header">
        <h2>我的博客</h2>
      </div>
    </template>
    <div class="card-body">
      <p class="title">{{ title }}</p>
      <slot>表单内容</slot>
    </div>
  </el-card>
</template>
<script setup>
defineProps({
  title: {
    type: String,
    default: '我的博客'
  }
})
</script>
<style scoped>
.title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
  text-align: center;
}
</style>