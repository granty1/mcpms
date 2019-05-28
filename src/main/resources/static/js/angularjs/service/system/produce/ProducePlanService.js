app.service('ProducePlanService',function ($http) {

    /**
     * 初始化数据
     * @returns {*}
     */
    this.initData = function () {
        return $http.get('../produce/plan/initdata')
    }

    /**
     * 分页条件查询所有计划
     * @param page
     * @param size
     * @param search
     * @returns {*}
     */
    this.getAllPlan = function (page, size, search) {
        return $http.post('../produce/plan/getall?page='+page+'&size='+size,search)
    }

    /**
     * 根据id查询计划对象
     * @param id
     * @returns {*}
     */
    this.findone = function (id) {
        return $http.get('../produce/plan/findone?id='+id)
    }

    /**
     * 保存生产计划修改
     * @param id
     * @param num
     * @returns {*}
     */
    this.save = function ( entity) {
        return $http.put('../produce/plan/save',entity)
    }

    /**
     * 根据id查询一条生产计划的所有工序
     * @param id
     */
    this.getAllProcessByPlanId = function (id) {
        return $http.get('../produce/plan/getprocess?id='+id)
    }

    /**
     * 根据id查找生产计划-工序对象
     * @param id
     * @returns {*}
     */
    this.findoneProcess = function (id) {
        return $http.get('../produce/plan/findonePro?id='+id)
    }

    /**
     * 保存工序编辑
     * @param entity
     * @returns {*}
     */
    this.saveProcess = function (entity) {
        return $http.post('../produce/plan/saveprocess',entity)
    }

    /**
     * 根据产品id获取所有的零件
     * @param id
     * @returns {*}
     */
    this.findPartsByProductId = function (id) {
        return $http.get('../produce/plan/findPartsByProductId?id='+id)
    }

    /**
     * 保存插单
     * @param entity
     * @returns {*}
     */
    this.saveInsertOrder = function (entity) {
        return $http.post('../produce/plan/insertOrder',entity)
    }

    /**
     * 流转
     */
    this.circule = function (id) {
        return $http.get('../produce/plan/circule?id='+id)
    }

    /**
     * 预流转
     */
    this.preCircule = function (id) {
        return $http.get('../produce/plan/precircule?id='+id)
    }

})