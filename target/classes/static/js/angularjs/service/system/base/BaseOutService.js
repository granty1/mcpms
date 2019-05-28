app.service('BaseOutService',function ($http) {

    /**
     * 获取分页外协单位列表
     * @param page
     * @param size
     * @param entity
     * @returns {*}
     */
    this.getAllOuts = function (page, size, entity) {
        return $http.post('../base/out/getall?page='+page+'&size='+size,entity);
    }

    /**
     * 新增外协单位
     * @param entity
     * @returns {*}
     */
    this.add = function (entity) {
        return $http.post('../base/out/save',entity);
    }

    /**
     * 更新外协单位
     * @param entity
     * @returns
     */
    this.save = function (entity) {
        return $http.put('../base/out/save',entity);
    }

    /**
     * 根据Id查找外协单位实体
     * @param id
     * @returns {*}
     */
    this.findOne = function (id) {
        return $http.get('../base/out/findone?id='+id);
    }

    /**
     * 根据id删除外协单位
     * @param id
     * @returns {void|*|boolean|Promise<boolean>|IDBRequest}
     */
    this.del = function (id) {
        return $http.delete('../base/out/del?id='+id);
    }

})