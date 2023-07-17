<script setup>
import BlogFormCard from '@/components/BlogFormCard.vue'
import { reactive, ref } from 'vue'
defineOptions({
  name: 'Login',
})

const labelPosition = ref('left')
const loginFormRef = ref()
const rules = reactive({
  username: [
    {
      required: true,
      message: '用户名不能为空',
      trigger: 'change'
    }
  ],
  password: [
    {
      required: true,
      message: '密码不能为空',
      trigger: 'change'
    }
  ]
})

const loginUser = reactive({
  username: '',
  password: ''
})
</script>
<template>
  <div class="login">
    <blog-form-card title="登录账号">
      <el-form
        ref="loginFormRef"
        :label-position="labelPosition"
        :rules="rules"
        label-width="80px"
        :model="loginUser"
        >
        <el-form-item label="用户名" prop="username">
          <el-input :model="loginUser.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" :model="loginUser.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(loginFormRef)">登录</el-button>
        </el-form-item>
        <el-form-item>
          <router-link to="/register">没有账号？去注册</router-link>
        </el-form-item>
      </el-form>
    </blog-form-card>
  </div>
</template>