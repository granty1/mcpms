app.service('OutWarningService',function ($http) {



    this.getAll = function (page, size, entity) {
        return $http.post('../out/warning/getall?page='+page+'&size='+size,entity)
    }

    this.expediting = function (id) {
        return $http.get('../out/warning/expediting?id='+id)
    }


})