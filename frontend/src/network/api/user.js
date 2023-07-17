import request from '@/network/request'

function login (data) {

}

function logout () {
}

/**
 * 注册
 * @param {注册信息} data 
 * @returns 
 */
function register (data) {
  return request({
    url: '/user/register',
    method: 'post',
    data: data
  })
}

export { login, logout, register }