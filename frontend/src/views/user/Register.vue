<script setup>
import { User } from '@element-plus/icons-vue'
import BlogFormCard from '@/components/BlogFormCard.vue'
import { reactive, ref } from 'vue';
import md5Encrypt from '@/utils/encrypt.js'
import { register } from '@/network/api/user.js'
import router from '@/router/index.js'

defineOptions({
  name: 'Register',
})

const labelPosition = 'left'

const registerFormRef = ref()
const rules = reactive({
  username: [
    {
      required: true,
      message: '用户名不能为空',
      trigger: 'change'
    }
  ],
  email: [
    {
      required: true,
      message: '邮箱不能为空',
      trigger: 'change'
    },
    {
      type: 'email',
      message: '邮箱格式不正确',
      trigger: 'blur'
    }
  ],
  password: [
    {
      required: true,
      message: '密码不能为空',
      trigger: 'change'
    }
  ],
  confirmPassword: [
    {
      required: true,
      message: '确认密码不能为空',
      trigger: 'change'
    }
  ]
})

const registerUser = reactive({
  username: '',
  email: '',
  password: '',
  confirmPassword: ''
})

function submitForm(formRef) {
  if (!formRef) return;
  formRef.validate((valid) => {
    if (!valid) {
      ElMessage.error('请填写正确的个人信息');
      return;
    }
    if (registerUser.password !== registerUser.confirmPassword) {
      ElMessage.error('两次输入的密码不一致');
      return;
    }
    // 使用md5加密密码
    let password = md5Encrypt(registerUser.password)
    register({
      username: registerUser.username,
      email: registerUser.email,
      password: password
    }).then(res => {
      console.log(res)
      if (res.code === 200) {
        ElMessage.success('注册成功');
        setTimeout(() => {
          router.push('/login');
        }, 3000);
      } else {
        ElMessage.error(res.message);
      }
    }).catch(err => {
      console.log(err);
    })
  })
}
</script>
<template>
  <div class="register">
    <blog-form-card title="注册账号">
      <el-form 
        ref="registerFormRef"
        :label-position="labelPosition"
        :rules="rules"
        label-width="80px"
        :model="registerUser"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="registerUser.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input type="email" v-model="registerUser.email" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="registerUser.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input type="password" v-model="registerUser.confirmPassword" placeholder="请再次输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm(registerFormRef)">注册</el-button>
        </el-form-item>
      </el-form>
    </blog-form-card>
  </div>
</template>
<style scoped>
.register {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: -moz-element();
}
</style>