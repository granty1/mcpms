app.controller('OutinStockController',function ($scope,OutinStockService,ProducePlanService) {


    /**
     * 外协入库模块
     */


    $scope.search = {}

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



    /**
     * 分页控件
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.inStockPagination = {
        currentPage: 1,
        totalItems: 22,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadInStockList();//重新加载
        }
    }


    $scope.reloadInStockList = function () {
        $scope.getAllInStock($scope.inStockPagination.currentPage,$scope.inStockPagination.itemsPerPage)
    }

    $scope.getAllInStock = function (page, size) {
        OutinStockService.getAllInStock(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.inStockPagination.totalItems = response.data.total
                $scope.inStockList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    $scope.instockObj = {}

    $scope.instockId = null

    $scope.setInStockId = function (id) {
        $scope.instockId = id
    }

    $scope.instock = function () {
        layer.confirm('确定无误入库吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            if($scope.instockObj.actualNum == null){
                $scope.instockObj.actualNum == 0
            }
            OutinStockService.inStock($scope.instockId,$scope.instockObj).success((response)=>{
                if (response.code == 200){
                    $scope.reloadInStockList()
                    successMessage('入库成功！')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }





})