app.service('ProduceApprovalService',function ($http) {

    var base_url = '../produce/approval/';

    /**
     * 初始化数据
     * @returns {*}
     */
    this.initData = function () {
        return $http.get(base_url+'initdata')
    }

    /**
     * 分页条件查询所有计划审批
     * @param page
     * @param size
     * @param entity
     * @returns {*}
     */
    this.getAllApproval = function (page, size, entity) {
        return $http.post(base_url+'getall?page='+page+'&size='+size,entity)
    }

    /**
     * 批量通过计划审批
     * @param ids
     * @returns {*}
     */
    this.passBase = function (ids) {
        return $http.get(base_url+'pass?ids='+ids)
    }

    /**
     * 驳回
     * @param id
     * @returns {*}
     */
    this.back = function (id) {
        return $http.get(base_url+'back?id='+id)
    }

    /**
     * 通过外协审批d
     * @param id
     * @returns {*}
     */
    this.passProcess = function (id) {
        return $http.get(base_url+'passprocess?id='+id)
    }

})