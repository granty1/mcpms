app.controller('ProducePlanController',function ($scope,$http,ProducePlanService,BasePartsService) {

    /**
     * 生产计划管理模块
     */


    /**
     * 日期控件
     */
    layui.use(['laydate'],function () {
        var laydate = layui.laydate
        //签订时间
        laydate.render({
            elem: '#planFinishTime'
            ,isInitValue: false
            ,format: 'yyyy-MM-dd'
            ,value: getNowFormatDate()
            ,ready: function(date){
                console.log(date);
            }
            ,done: function(value, date, endDate){
                console.log(value, date, endDate);
            }
        });

        var laydate = layui.laydate
        //签订时间
        laydate.render({
            elem: '#processPlanTime'
            ,isInitValue: false
            ,format: 'yyyy-MM-dd'
            ,value: getNowFormatDate()
            ,ready: function(date){
                console.log(date);
            }
            ,done: function(value, date, endDate){
                console.log(value, date, endDate);
            }
        });

        laydate.render({
            elem: '#searchTime'
            ,type: 'month'
            ,isInitValue: false
            ,value: getNowFormatMonth()
        })

    })


    /**
     * 产品基础数据
     * @type {Array}
     */
    $scope.searchProductData = []

    /**
     * 零件基础数据
     * @type {Array}
     */
    $scope.searchPartsData = []

    /**
     * 条件查询对象
     * @type {{}}
     */
    $scope.search = {}


    /**
     * 当前查看的生产计划对象
     * @type {{}}
     */
    $scope.currentPlan = {}


    /**
     * 生产计划对象
     * @type {{}}
     */
    $scope.plan = {}


    /**
     * 生产计划-工序对象
     * @type {{}}
     */
    $scope.process = {}


    /**
     * 初始化数据
     */
    $scope.initData = function(){
        ProducePlanService.initData().success((response)=>{
            if (response.code == 200){
                $scope.searchProductData = response.data.productData
                $scope.searchPartsData = response.data.partsData
                $scope.modeData = response.data.modeData
                $scope.outData = response.data.outData
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})

        $http.get('../current').success((response)=>{
            if(response.code==200){
                $scope.user = response.data
            }else {
                requestError(response.msg)
            }
        }).error((e)=>{
            systemError()
        })
    }


    /**
     * 生产计划分页控件配置
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.producePlanPagination = {
        currentPage: 1,
        totalItems: 25,
        itemsPerPage: 15,
        perPageOptions: [15, 30, 45, 60],
        onChange: function(){
            $scope.reloadProducePlanList();//重新加载
        }
    }

    /**
     * 刷新生产计划列表
     */
    $scope.reloadProducePlanList = function () {
        $scope.getAllProducePlan($scope.producePlanPagination.currentPage,$scope.producePlanPagination.itemsPerPage)
    }

    $scope.empty = function(){
        $scope.search = {}
        $('#searchTime').val('')
    }

    /**
     * 分页条件获取所有生产计划列表
     * @param page
     * @param size
     */
    $scope.getAllProducePlan = function (page, size) {

        $scope.search.createTime = $('#searchTime').val()

        showLoad()
        ProducePlanService.getAllPlan(page,size,$scope.search).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.producePlanPagination.totalItems = response.data.total
                $scope.producePlanList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    /**
     * 根据id查找生产计划对象
     * @param id
     */
    $scope.findone = function(id){
        ProducePlanService.findone(id).success((response)=>{
            if (response.code == 200){
                $scope.plan = response.data
                $('#planFinishTime').val($scope.plan.planFinishTime)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        $('#processEdit').modal()
    }


    /**
     * 保存生产计划编辑
     */
    $scope.save = function(){
        $scope.plan.planFinishTime = $('#planFinishTime').val()
        ProducePlanService.save($scope.plan).success((response)=>{
            if (response.code == 200){
                $('#planFinishTime').val('')
                $('#processEdit').modal('hide')
                $scope.reloadProducePlanList()
                updateSuccess()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 更新当前查看的生产计划对象
     * @param entity
     */
    $scope.updateCurrentPlan = function(entity){
        $scope.currentPlan = entity
        $scope.getAllProcessByPlanId()
    }

    $scope.getAllProcessByPlanId = function(){
        ProducePlanService.getAllProcessByPlanId($scope.currentPlan.id).success((response)=>{
            if (response.code == 200){
                $scope.processList = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    /**
     * 生产计划 - 工序模块
     * @type {*[]}
     */


    /**
     * 打开生产计划-工序修改模态窗
     * @param id
     */
    $scope.openProcessModal = function(id){
        ProducePlanService.findoneProcess(id).success((response)=>{
            if (response.code == 200){
                $scope.process = response.data
                $('#processPlanTime').val($scope.process.planFinishTime)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        $('#editNum').modal()
    }

    /**
     * 保存工序编辑
     */
    $scope.saveProcess = function(){

        $scope.process.planFinishTime = $('#processPlanTime').val()

        ProducePlanService.saveProcess($scope.process).success((response)=>{
            if (response.code == 200){
                $('#editNum').modal('hide')
                $scope.getAllProcessByPlanId()
                $scope.reloadProducePlanList()
                updateSuccess()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    /**
     * 插单模块
     */


    /**
     * 根据产品id查询产品下的所有零件
     */
    $scope.findPartsByProductId = function () {
        ProducePlanService.findPartsByProductId($scope.insert.productId).success((response)=>{
            if (response.code == 200){
                $scope.partsByProductIdList = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    $scope.saveInsertOrder = function () {
        ProducePlanService.saveInsertOrder($scope.insert).success((response)=>{
            if (response.code == 200){
                successMessage('插入成功！')
                $scope.reloadProducePlanList()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }




    /**
     * 插单模块
     * @type {{}}
     */

    $scope.part = {}

    $scope.partList = []

    $scope.choosedParts = []

    $scope.partsPaginationConf = {
        currentPage: 1,
        totalItems: 25,
        itemsPerPage: 6,
        perPageOptions: [6, 10, 20, 30],
        onChange: function () {
            $scope.reloadPartsList();//重新加载
        }
    }

    $scope.reloadPartsList = function () {
        $scope.getAll($scope.partsPaginationConf.currentPage,$scope.partsPaginationConf.itemsPerPage)
    }


    $scope.getAll = function (page, size) {
        showLoad()
        BasePartsService.getAll(page, size, $scope.part).success((response) => {
            closeLoad()
            if (response.code == 200) {
                $scope.partsPaginationConf.totalItems = response.data.total
                $scope.partList = response.data.data
            } else {
                requestError(response.msg)
            }
        }).error((e) => {
            systemError()
        })
    }

    $scope.updateSelection = function ($event,entity) {
        if(isChoosed(entity)==-1){
            entity.num = 1
            $scope.choosedParts.push( entity);
        }else{
            let index = isChoosed(entity)
            $scope.choosedParts[index].num++;
        }
        successMessage(entity.name+' +1')
    }

    $scope.deleteChoosed = function (entity) {
        if (isChoosed(entity)!=-1){
            let index = isChoosed(entity)
            $scope.choosedParts.splice(index,1)
        }
    }

    $scope.closeInsertOrder = function () {

        $scope.choosedParts = []
        $('#insertOrder').modal('hide')
    }

    var isChoosed = function (entity) {
        if ($scope.choosedParts.length!=0){
            for (let i = 0; i < $scope.choosedParts.length; i++) {
                if ($scope.choosedParts[i].id == entity.id){
                    return i;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    $scope.entity = {}

    $scope.inserOrderNext = function () {
        if ($scope.choosedParts.length != 0){
            showLoad()
            setTimeout(function () {
                $scope.entity.list = $scope.choosedParts
                ProducePlanService.saveInsertOrder($scope.entity).success((response)=>{
                    closeLoad()
                    if (response.code == 200){
                        successMessage('生产计划建立成功')
                        $scope.reloadProducePlanList()
                        $scope.closeInsertOrder()
                    } else{
                        infoMessage(response.msg)
                    }
                }).error((e)=>{systemError()})
            },0)
        }else {
            infoMessage('还没有选择零件')
        }
    }



    $scope.circule = function (id) {
        showLoad()
        ProducePlanService.circule(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.reloadProducePlanList()
                successMessage(response.msg)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }




    $scope.preCircule = function (id) {
        showLoad()
        ProducePlanService.preCircule(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                // 预查成功
                layer.confirm('确认流转吗？', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $scope.circule(id);
                })
            } else if (response.code == 500) {
                // 预差失败，有空字段
                layer.confirm(response.msg, {
                    btn: ['不填写，直接流转','取消'] //按钮
                }, function(){
                    $scope.circule(id);
                })
            }else {
                infoMessage(response.msg)
            }
        }).error((e)=>{systemError()})
    }

})