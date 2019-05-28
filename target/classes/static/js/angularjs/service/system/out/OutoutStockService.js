app.service('OutoutStockService',function ($http) {


    var base_url = "../out/out/";

    /**
     * 分页条件查询所有出库记录
     * @param page
     * @param size
     * @param entity
     * @returns {*}
     */
    this.getAll = function (page, size, entity) {
        return $http.post(base_url+'getall?page='+page+'&size='+size,entity)
    }

    /**
     * 根据计划工序id出库
     * @param id
     * @returns {*}
     */
    this.outStock = function (id) {
        return $http.get(base_url+'outstock?id='+id)
    }

})