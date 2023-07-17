import md5 from 'js-md5'

/**
 * md5加盐加密
 */
function md5Encrypt (str, salt = 'zhong') {
  return md5(str + salt)
}

export default md5Encrypt