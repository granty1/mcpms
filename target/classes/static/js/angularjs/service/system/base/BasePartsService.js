app.service('BasePartsService',function ($http) {


    /**
     * 分页条件查询所有零件对象
     * @param page
     * @param size
     * @param search
     * @returns {*}
     */
    this.getAll = function (page, size, search) {
        return $http.post('../base/parts/getall?page='+page+'&size='+size,search)
    }

    /**
     * 添加零件对象
     * @param entity
     * @returns {*}
     */
    this.add = function (entity) {
        return $http.post('../base/parts/save',entity)
    }

    /**
     * 根据id查找对象
     * @param id
     * @returns {*}
     */
    this.findone = function (id) {
        return $http.get('../base/parts/findone?id='+id)
    }

    /**
     * 保存修改零件对象
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.update = function (entity) {
        return $http.put('../base/parts/save',entity)
    }

    /**
     * 批量删除
     * @param ids
     * @returns {*}
     */
    this.deleteBatch = function (ids) {
        return $http.delete('../base/parts/delete?ids='+ids)
    }

    /**
     * 根据零件id查找所有工序
     * @param id
     * @returns {*}
     */
    this.getAllProcess = function (id) {
        return $http.get('../base/parts/getallprocess?id='+id)
    }

    /**
     * 零件-工序添加保存
     * @param entity
     */
    this.processSave = function (entity) {
        return $http.post('../base/parts/processsave',entity)
    }

    /**
     * 根据零件-工序id查找对象
     * @param id
     * @returns {*}
     */
    this.findoneProcess = function (id) {
        return $http.get('../base/parts/findoneProcess?id='+id)
    }

    /**
     * 根据id删除零件-工序记录
     * @param id
     * @returns {*}
     */
    this.deleteProcess = function (id) {
        return $http.delete('../base/parts/deleteProcess?id='+id)
    }

    /**
     * 保存零件工序修改
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.processUpdate = function (entity) {
        return $http.put('../base/parts/processsave',entity)
    }

    this.initDataList = function () {
        return $http.get('../base/parts/initdata')
    }

    this.getCloneParts = function () {
        return $http.get('../produce/plan/initdata')
    }

    this.clone = function (id, targetId) {
        return $http.get('../base/parts/clone?id='+id+'&targetId='+targetId)
    }
})