app.service('ProducePartService',function ($http) {


    this.getAll = function (page, size, entity) {
        return $http.post('../produce/parts/getall?page='+page+'&size='+size,entity)
    }

})