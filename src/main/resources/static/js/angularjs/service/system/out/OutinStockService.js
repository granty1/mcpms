app.service('OutinStockService',function ($http) {


    var base_url = "../out/in/";

    /**
     * 获取所有入库记录
     * @param page
     * @param size
     * @param entity
     * @returns {*}
     */
    this.getAllInStock = function (page, size,entity) {
        return $http.post(base_url+'getall?page='+page+'&size='+size,entity)
    }

    /**
     * 外协入库
     * @param id
     * @returns {*}
     */
    this.inStock = function (id,entity) {
        return $http.post(base_url+'instock?id='+id,entity)
    }


})