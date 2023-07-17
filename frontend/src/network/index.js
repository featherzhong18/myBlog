import axios from "axios";
import { ElLoading, ElMessage } from "element-plus";

// 创建axios实例
const instance = axios.create({
  baseURL: "http://localhost:8000/",
  timeout: 2000 * 1000,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8',
    'X-Requested-With': 'XMLHttpRequest',
    'token': localStorage.getItem('token') || ''
  }
})

// loading设置
let loading
let requestCount = 0

const showLoading = () => {
  if (requestCount == 0 && !loading) {
    loading = ElLoading.service({
      text: "Loading  ",
      background: 'rgba(0, 0, 0, 0.7)',
      spinner: 'el-icon-loading'
    })
  }
  requestCount++;
}

const hideLoading = () => {
  requestCount--
  if (requestCount == 0) {
    loading.close()
  }
}

// 请求拦截
instance.interceptors.request.use(
  (config) => {
    showLoading()
    // token验证
    const token = window.localStorage.getItem('token')
    token && (config.headers.Authorization = token)
    // 若请求方式为post，则将data参数转为JSON字符串
    if (config.method === 'POST') {
      config.data = JSON.stringify(config.data);
    }
    return config
  },
  (error) => {
    Promise.reject(error)
  }
)

// 响应拦截
instance.interceptors.response.use(
  (result) => {
    hideLoading()
    return result.data
  },
  (error) => {
    console.log(error)
    let message = null;
    if (error.response && error.response.status) {
      switch (error.response.status) {
        case 302:
          message = "接口重定向了！";
          break;
        case 400:
          message = "请求错误";
          break;
        case 401:
          message = "您未登录，或者登录已经超时，请先登录！";
          break;
        case 403:
          message = "您没有权限操作！";
          break;
        case 404:
          message = `请求地址出错: ${error.response.config.url}`;
          break;
        case 408:
          message = "请求超时！";
          break;
        case 409:
          message = "系统已存在相同数据！";
          break;
        case 500:
          message = "服务器内部错误！";
          break;
        default:
          message = "异常问题，请联系管理员！";
          break;
      }
      ElMessage.error(message)
      return Promise.reject(error)
    }
    return Promise.reject(error)
  }
)

export default instance;