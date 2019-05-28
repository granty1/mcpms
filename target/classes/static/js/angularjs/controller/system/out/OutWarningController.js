app.controller('OutWarningController',function ($scope,OutWarningService,ProducePlanService) {

    /**
     * 初始化数据
     */
    $scope.initData = function(){
        ProducePlanService.initData().success((response)=>{
            if (response.code == 200){
                $scope.searchProductData = response.data.productData
                $scope.searchPartsData = response.data.partsData
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})

    }

    $scope.search = {}

    $scope.outWarningPagination = {
        currentPage: 1,
        totalItems: 25,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadOutWarningList();//重新加载
        }
    }

    $scope.reloadOutWarningList = function () {
        $scope.getAllOutWarning($scope.outWarningPagination.currentPage,$scope.outWarningPagination.itemsPerPage)
    }

    $scope.getAllOutWarning = function (page, size) {
        OutWarningService.getAll(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.outWarningPagination.totalItems = response.data.total
                $scope.outWarningList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }
    
    $scope.expediting = function (id) {
        OutWarningService.expediting(id).success((response)=>{
            if (response.code == 200){
                $scope.reloadOutWarningList()
                successMessage('催单成功')
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

})