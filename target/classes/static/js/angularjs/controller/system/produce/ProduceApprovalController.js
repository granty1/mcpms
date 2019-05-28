app.controller('ProduceApprovalController',function ($scope,ProduceApprovalService,ProducePlanService) {


    /**
     * 审批管理模块
     */

    /**
     * 产品列表
     * @type {Array}
     */
    $scope.searchProductData = []

    /**
     * 零件列表
     * @type {Array}
     */
    $scope.searchPartsData = []

    /**
     * 条件查询
     * @type {{}}
     */
    $scope.search = {}

    /**
     * 初始化数据
     */
    $scope.initData = function(){
        ProduceApprovalService.initData().success((response)=>{
            if (response.code == 200){
                $scope.searchProductData = response.data.productData
                $scope.searchPartsData = response.data.partsData
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }



    $scope.produceApprovalPagination = {
        currentPage: 1,
        totalItems: 22,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadApproveList();//重新加载
        }
    };



    $scope.reloadApproveList = function () {
        $scope.getAllApproval($scope.produceApprovalPagination.currentPage,$scope.produceApprovalPagination.itemsPerPage)
    }

    $scope.getAllApproval = function(page,size){
        ProduceApprovalService.getAllApproval(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.produceApprovalPagination.totalItems = response.data.total
                $scope.approvalList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    $scope.ids = []

    /**
     * 通过
     * @param id
     */
    $scope.pass = function(id){
        layer.confirm('确认通过吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.ids.push(id)
            passBase($scope.ids)
            $scope.ids = []
        })
    }

    /**
     * 批量通过
     */
    $scope.batchPass = function(){
        if($scope.approvalSelectIds.length!=0){

            layer.confirm('确认批量通过吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                passBase($scope.approvalSelectIds)
                $scope.approvalSelectIds = []
            })
        }else{
            primaryMessage('请选择')
        }
    }

    /**
     * 通过公共方法
     * @param ids
     */
    var passBase = function(ids){
        ProduceApprovalService.passBase(ids).success((response)=>{
            if (response.code == 200){
                $scope.reloadApproveList()
                successMessage('操作成功!')
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 驳回
     * @param id
     */
    $scope.back = function(id){
        layer.confirm('确认驳回吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            ProduceApprovalService.back(id).success((response)=>{
                if (response.code == 200){
                    $scope.reloadApproveList()
                    successMessage('操作成功!')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }

    $scope.currentApproval = {}

    /**
     * 更新当前查看的生产计划对象
     * @param entity
     */
    $scope.updateCurrentApproval = function(entity){
        $scope.currentApproval = entity
        $scope.getAllProcessByPlanId()
    }

    $scope.getAllProcessByPlanId = function(){
        ProducePlanService.getAllProcessByPlanId($scope.currentApproval.orderProductPartId).success((response)=>{
            if (response.code == 200){
                $scope.processList = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }



    /**
     * 选中零件id集合
     * @type {Array}
     */
    $scope.approvalSelectIds=[];//选中的ID集合
    //更新复选
    $scope.updateApprovalSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.approvalSelectIds.push( id);
        }else{
            var idx = $scope.approvalSelectIds.indexOf(id);
            $scope.approvalSelectIds.splice(idx, 1);//删除
        }
    }

    /**
     * 通过外协审批
     * @param id
     */
    $scope.passProcess = function(id){
        layer.confirm('确认通过吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            ProduceApprovalService.passProcess(id).success((response)=>{
                if (response.code == 200){
                    successMessage('操作成功!')
                    $scope.getAllProcessByPlanId()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }



})