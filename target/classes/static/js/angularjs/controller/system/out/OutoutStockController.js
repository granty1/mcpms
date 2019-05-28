app.controller('OutoutStockController',function ($scope,OutoutStockService,ProducePlanService) {

    /**
     * 外协出库模块
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
    $scope.outStockPagination = {
        currentPage: 1,
        totalItems: 22,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadOutStockList();//重新加载
        }
    }


    $scope.reloadOutStockList = function () {
        $scope.getAllOutStocks($scope.outStockPagination.currentPage,$scope.outStockPagination.itemsPerPage)
    }

    $scope.getAllOutStocks = function (page, size) {
        OutoutStockService.getAll(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.outStockPagination.totalItems = response.data.total
                $scope.outStockList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    $scope.outstock = function(id){
        layer.confirm('确定出库吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            OutoutStockService.outStock(id).success((response)=>{
                if (response.code == 200){
                    $scope.reloadOutStockList()
                    successMessage('出库成功！')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }


})