app.service('BaseWarningService',function ($http) {

    
    this.initDays = function () {
        return $http.get('../base/warning/init')
    }

    this.save = function (entity) {
        return $http.post('../base/warning/save',entity)
    }
})