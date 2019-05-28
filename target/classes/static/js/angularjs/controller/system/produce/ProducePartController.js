app.controller('ProducePartController',function ($scope,ProducePartService,ProduceApprovalService) {


    /**
     * 订单零件模块
     */

    $scope.search = {}

    /**
     * 初始化数据
     */
    $scope.initData = function(){
        ProduceApprovalService.initData().success((response)=>{
            if (response.code == 200){
                $scope.searchProductData = response.data.productData
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    $scope.producePartsPagination = {
        currentPage: 1,
        totalItems: 15,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadPartsList();//重新加载
        }
    }

    $scope.reloadPartsList = function () {
        $scope.getAllParts($scope.producePartsPagination.currentPage,$scope.producePartsPagination.itemsPerPage)
    }

    $scope.getAllParts = function (page, size) {
        ProducePartService.getAll(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.producePartsPagination.totalItems = response.data.total
                $scope.partsList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

})