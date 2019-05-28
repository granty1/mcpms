app.service('BaseProcessService',function ($http) {

    /**
     * 获取所有工序列表
     * @returns {*}
     */
    this.getAll = function () {
        return $http.get('../base/process/getall')
    }

    /**
     * 添加工序
     * @param entity
     * @returns {*}
     */
    this.add = function (entity) {
        return $http.post('../base/process/save',entity)
    }

    /**
     * 根据id查找
     * @param id
     * @returns {*}
     */
    this.findone = function (id) {
        return $http.get('../base/process/findone?id='+id)
    }

    /**
     * 保存工序修改
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.update = function (entity) {
        return $http.put('../base/process/save',entity)
    }

    /**
     * 根据id删除工序对象
     * @param id
     * @returns {void|*|boolean|Promise<boolean>|IDBRequest}
     */
    this.delete = function (id) {
        return $http.delete('../base/process/delete?id='+id)
    }

    /**
     * 批量删除
     * @param ids
     * @returns {*}
     */
    this.deleteBatch = function (ids) {
        return $http.get('../base/process/delete?ids='+ids)
    }


})