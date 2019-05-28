app.service('ProduceOrderService',function ($http) {


    /**
     * 初始化数据
     * @returns {*}
     */
    this.initData = function () {
        return $http.get('../produce/order/initdata')
    }

    /**
     * 分页获取所有订单
     */
    this.getAll = function (page, size,search) {
        return $http.post('../produce/order/getall?page='+page+'&size='+size,search)
    }

    /**
     * 新建订单
     * @param entity
     * @returns {*}
     */
    this.add = function (entity) {
        return $http.post('../produce/order/save',entity)
    }

    /**
     * 保存修改订单
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.save = function (entity) {
        return $http.put('../produce/order/save',entity)
    }

    /**
     * 根据id查找订单对象
     * @param id
     * @returns {*}
     */
    this.findone = function (id) {
        return $http.get('../produce/order/findone?id='+id)
    }

    /**
     * 手动完成订单
     * @param id
     * @returns {*}
     */
    this.finshOrder = function (id) {
        return $http.get('../produce/order/finshorder?id='+id)
    }

    /**
     * 批量删除订单
     * @param ids
     * @returns {*}
     */
    this.deleteBatch = function (ids) {
        return $http.delete('../produce/order/delete?ids='+ids)
    }

    /**
     * 根据订单id获取所有产品
     * @param id
     * @returns {*}
     */
    this.getAllPro = function (id) {
        return $http.get('../produce/order/getallpro?id='+id)
    }

    /**
     * 根据id查找订单-产品对象
     * @param id
     * @returns {*}
     */
    this.findonePro = function (id) {
        return $http.get('../produce/order/findonePro?id='+id)
    }

    /**
     * 根据订单id 新增产品
     * @param entity
     * @returns {*}
     */
    this.addPro = function (entity) {
        return $http.post('../produce/order/savepro',entity)
    }

    /**
     * 保存修改订单下的产品
     * @param id
     * @param entity
     * @returns {IDBRequest | Promise<void> | * | void}
     */
    this.savePro = function (entity) {
        return $http.put('../produce/order/savepro',entity)
    }

    /**
     * 批量删除订单-产品
     * @param ids
     * @returns {*}
     */
    this.deleteProBatch = function (ids) {
        return $http.delete('../produce/order/deletepro?ids='+ids)
    }

    /**
     * 订单作废
     * @param id
     * @returns {*}
     */
    this.orderScrap = function (id) {
        return $http.get('../produce/order/scrap?id='+id)
    }
})