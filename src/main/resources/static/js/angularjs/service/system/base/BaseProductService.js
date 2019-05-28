app.service('BaseProductService',function ($http) {

    /**
     * 分页条件获取所有产品
     * @param page
     * @param size
     * @param search
     * @returns {*}
     */
    this.getAllProdct = function (page, size, search) {
        return $http.post('../base/product/getall?page='+page+'&size='+size,search)
    }

    /**
     * 新增产品对象
     * @param entity
     * @returns {*}
     */
    this.add  = function (entity) {
        return $http.post('../base/product/add',entity)
    }

    /**
     * 保存修改
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.update = function (entity) {
        return $http.put('../base/product/save',entity)
    }

    /**
     * 根据Id批量删除产品
     * @param ids
     * @returns {*}
     */
    this.deleteBatch = function (ids) {
        return $http.delete('../base/product/delete?ids='+ids)
    }

    /**
     * 根据id查找产品对象
     * @param id
     * @returns {*}
     * @constructor
     */
    this.findone = function (id) {
        return $http.get('../base/product/findone?id='+id)
    }

    /**
     * 根据id分页条件查询产品下的所有零件
     * @param id
     * @param page
     * @param size
     * @param search
     * @returns {*}
     */
    this.findPartsByProductId = function (id,page,size,search) {
        return $http.post('../base/product/findpartsbyproductid?id='+id+'&page='+page+'&size='+size,search)
    }

    /**
     * 根据产品-零件id查询数量
     * @param id
     * @returns {*}
     */
    this.findNumByPartId = function (id) {
        return $http.get('../base/product/findnumbypartid?id='+id)
    }

    /**
     * 修改产品-零件id对应的数量
     * @param id
     * @param num
     * @returns {*}
     */
    this.savePartsNum = function (id, num) {
        return $http.get('../base/product/savepartsnum?id='+id+'&num='+num)
    }

    /**
     * 批量删除产品-零件的零件
     * @param ids
     * @returns {*}
     */
    this.deleteProductPartsBase = function (ids) {
        return $http.delete('../base/product/deleteproductpartsbatch?ids='+ids)
    }

    /**
     * 根据产品id，查询所有不属于该产品的零件
     * @param id
     * @param page
     * @param size
     * @returns {*}
     */
    this.getAllNoChoiceParts = function (id, page, size,name) {
        return $http.get('../base/product/getallnochoiceparts?id='+id+'&page='+page+'&size='+size+'&name='+name)
    }

    /**
     * 批量添加零件
     * @param id
     * @param ids
     * @returns {*}
     */
    this.batchAddParts = function (id,ids) {
        return $http.get('../base/product/batchaddparts?id='+id+'&ids='+ids)
    }


})