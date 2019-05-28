app.controller('ProduceOrderController',function ($scope,ProduceOrderService) {

    /**
     * 日期控件
     */
    layui.use(['laydate','form'],function () {
        var laydate = layui.laydate
        var form = layui.form

        form.render('select')

        //签订时间
        laydate.render({
            elem: '#signTimeDate'
            //,format: 'yyyy年MM月dd日'
            //,value: new Date(1989,9,14)
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
        //交货时间
        laydate.render({
            elem: '#deliverTimeDate'
            //,format: 'yyyy年MM月dd日'
            //,value: new Date(1989,9,14)
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

    })

    $scope.productDataList = []


    /**
     * 初始化数据
     */
    $scope.initData = function(){
        ProduceOrderService.initData().success((response)=>{
            if (response.code == 200){
                $scope.productDataList = response.data.productDataList
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 生产管理-订单管理
     * @author guolin
     */


    /**
     * 订单数据列表
     */

    /**
     * 订单列表分页配置
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.orderPaginationConf = {
        currentPage: 1,
        totalItems: 15,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 15, 20],
        onChange: function(){
            $scope.reloadOrderList();//重新加载
        }
    };

    /**
     * 订单实体
     * @type {{}}
     */
    $scope.order = {};


    /**
     * 订单id集合
     */
    $scope.orderIds = [];

    /**
     * 当前选中订单对象
     * @type {{}}
     */
    $scope.currentOrder = {};


    /**
     * 条件查询对象
     * @type {{}}
     */
    $scope.search = {}


    //更新复选
    $scope.updateOrderSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.orderIds.push( id);
        }else{
            var idx = $scope.orderIds.indexOf(id);
            $scope.orderIds.splice(idx, 1);//删除
        }
    }

    /**
     * 重载订单列表
     */
    $scope.reloadOrderList = function () {
        $scope.getAllOrder($scope.orderPaginationConf.currentPage,$scope.orderPaginationConf.itemsPerPage)
    }
    /**
     * 获取所有订单
     * @param page
     * @param size
     */
    $scope.getAllOrder = function (page, size) {
        ProduceOrderService.getAll(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.orderPaginationConf.totalItems = response.data.total
                $scope.orderList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 保存订单
     */
    $scope.saveOrder = function(){
        //签订时间
        $scope.order.signTime = $('#signTimeDate').val()
        //交货时间
        $scope.order.deliverTime = $('#deliverTimeDate').val()

        if($scope.order.signTime=="" || $scope.order.deliverTime==""){
            infoMessage('请选择时间')
        }else{
            if($scope.order.id==null){
                //新增
                ProduceOrderService.add($scope.order).success((response)=>{
                    if (response.code == 200){
                        $scope.reloadOrderList()
                        saveSuccess()
                    } else{
                        requestError(response.msg)
                    }
                }).error((e)=>{systemError()})
            }else{
                //修改
                ProduceOrderService.save($scope.order).success((response)=>{
                    if (response.code == 200){
                        $scope.reloadOrderList()
                        updateSuccess()
                    } else{
                        requestError(response.msg)
                    }
                }).error((e)=>{systemError()})
            }

        }
    }

    /**
     * 根据id查找订单对象
     * @param id
     */
    $scope.findone = function(id){
        ProduceOrderService.findone(id).success((response)=>{
            if (response.code == 200){
                $scope.order = response.data
                //签订时间
                $('#signTimeDate').val($scope.order.signTime)
                //交货时间
                $('#deliverTimeDate').val($scope.order.deliverTime)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }



    /**
     * 订单手动完成
     * @param id
     */
    $scope.orderFinish = function(id){
        layer.confirm('确定该订单已完成无误吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            ProduceOrderService.finshOrder(id).success((response)=>{
                if (response.code == 200){
                    $scope.reloadOrderList()
                    successMessage('操作成功')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})

        })
    }

    /**
     * 删除订单
     * @param id
     */
    $scope.delete = function(id){
        layer.confirm('确定删除选中项吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.ids = []
            $scope.ids.push(id)
            deleteBase($scope.ids)
            $scope.ids = []
        })
    }
    /**
     * 批量删除
     */
    $scope.deleteBatch = function(){
        if($scope.orderIds.length==0){
            layer.msg('您还未选择')
        }else{
            layer.confirm('确定删除选中项吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                deleteBase($scope.orderIds)
                $scope.orderIds = []
            })
        }

    }

    /**
     * 删除公共方法
     * @param ids
     */
    var deleteBase = function(ids){
        ProduceOrderService.deleteBatch(ids).success((response)=>{
            if (response.code == 200){
                $scope.reloadOrderList()
                deleteSuccess(response.msg)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 更新当前选中订单对象
     * @param order
     */
    $scope.orderSelect = function(order){
        $('#orderProductDIV').removeAttr('hidden')
        $scope.currentOrder = order

        $scope.getAllProducts()
    }


    /**
     * 订单->产品模块
     * @author guolin
     */


    /**
     * 产品Id集合
     */
    $scope.productIds = [];

    /**
     * 产品实体
     */
    $scope.product = {};


    //更新复选
    $scope.updateProductSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.productIds.push( id);
        }else{
            var idx = $scope.productIds.indexOf(id);
            $scope.productIds.splice(idx, 1);//删除
        }
    }


    /**
     * 获取所有产品
     */
    $scope.getAllProducts = function(){

        ProduceOrderService.getAllPro($scope.currentOrder.id).success((response)=>{
            if (response.code == 200){
                $scope.productList = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 根据Id查找产品实体
     * @param id
     */
    $scope.findOnePro = function(id){
        ProduceOrderService.findonePro(id).success((response)=>{
            if (response.code == 200){
                $scope.product = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 保存产品编辑
     */
    $scope.saveProduct = function(){
        if($scope.product.id==null){
            //新增
            $scope.product.orderId = $scope.currentOrder.id
            ProduceOrderService.addPro($scope.product).success((response)=>{
                if (response.code == 200){
                    $scope.reloadOrderList();
                    $scope.getAllProducts()
                    saveSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }else{
            //更新
            ProduceOrderService.savePro($scope.product).success((response)=>{
                if (response.code == 200){
                    $scope.reloadOrderList();
                    $scope.getAllProducts()
                    updateSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }
    }

    /**
     * 根据id删除
     * @param id
     */
    $scope.deletePro = function(id){
        layer.confirm('确定删除选中项吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.proIds = []
            $scope.proIds.push(id)
            deleteProBase($scope.proIds)
            $scope.proIds = []
        })
    }
    /**
     * 批量删除
     */
    $scope.deleteBatchPro = function(){
        if ($scope.productIds.length==0){
            layer.msg('您还未选择')
        }else{
            layer.confirm('确定删除选中项吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                deleteProBase($scope.productIds)
                $scope.productIds = []
            })
        }
    }


    /**
     * 删除公共方法
     * @param ids
     */
    var deleteProBase = function(ids){
        ProduceOrderService.deleteProBatch(ids).success((response)=>{
            if (response.code == 200){
                $scope.reloadOrderList();
                $scope.getAllProducts()
                deleteSuccess(response.msg)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    /**
     * 订单作废
     */
    $scope.orderScrap = function (id) {
        layer.confirm('该订单可能还有计划未完成，确定作废吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            ProduceOrderService.orderScrap(id).success((response)=>{
                if (response.code == 200){
                    $scope.reloadOrderList();
                    $scope.getAllProducts()
                    successMessage('操作成功')
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        })
    }


});