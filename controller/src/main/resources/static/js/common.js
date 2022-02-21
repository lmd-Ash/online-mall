/**
 * 通用js
 */


/**
 * 获取token
 */
function getToken() {
    return localStorage.getItem("token")
}

/**
 * 存入token
 */
function setToken(token) {
    localStorage.setItem("token", token)
}