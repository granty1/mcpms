app.service('SystemUserService',function ($http) {


    /**
     * 分页条件查询所有用户
     * @param page
     * @param size
     * @param search
     * @returns {*}
     */
    this.getAll = function (page, size, search) {
        return $http.post('../system/user/getall?page='+page+'&size='+size,search)
    }

    /**
     * 根据Id查询用户
     * @param id
     * @returns {*}
     */
    this.findone = function (id) {
        return $http.get('../system/user/findone?id='+id)
    }

    /**
     * 添加用户
     * @param entity
     * @returns {*}
     */
    this.add = function (entity) {
        return $http.post('../system/user/add',entity)
    }

    /**
     * 更新用户
     * @param entity
     * @returns {*}
     */
    this.update = function (entity) {
        return $http.put('../system/user/update',entity)
    }

    /**
     * 重置密码
     * @param id
     * @returns {*}
     */
    this.delpass = function (id) {
        return $http.get('../system/user/delpass?id='+id)
    }
})