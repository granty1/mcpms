app.controller('BaseProductController',function ($scope,BaseProductService) {


    /**
     * 产品 模块
     * @author guolin
     */

    /**
     * 产品对象  新增/修改
     * @type {{}}
     */
    $scope.product = {}

    /**
     * 搜索条件
     * @type {{}}
     */
    $scope.search = {}

    /**
     * 当前选中产品对象
     * @type {null}
     */
    $scope.currentProduct = {}


    /**
     * 产品列表分页
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.productPaginationConf = {
        currentPage: 1,
        totalItems: 15,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadProductList();//重新加载
        }
    };

    //重载产品列表
    $scope.reloadProductList = function(){
        $scope.getAllProducts($scope.productPaginationConf.currentPage,$scope.productPaginationConf.itemsPerPage);
    }

    //获取所有产品列表
    $scope.getAllProducts = function(page,size){
        BaseProductService.getAllProdct(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.productPaginationConf.totalItems = response.data.total
                $scope.productList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }


    $scope.productSelectIds=[];//选中的productID集合

    //更新复选
    $scope.productUpdateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.productSelectIds.push( id);
        }else{
            var idx = $scope.productSelectIds.indexOf(id);
            $scope.productSelectIds.splice(idx, 1);//删除
        }
    }


    /**
     * 保存产品编辑
     */
    $scope.saveProduct = function () {
        if($scope.product.name==null || $scope.product.type==null){
            infoMessage('请填写完整')
        }else{
            if($scope.product.id==null){
                //新增
                BaseProductService.add($scope.product).success((response)=>{
                    if (response.code == 200){
                        $scope.reloadProductList()
                        saveSuccess()
                    } else{
                        requestError(response.msg)
                    }
                }).error((e)=>{systemError()})
            }else{
                //保存修改
                BaseProductService.update($scope.product).success((response)=>{
                    if (response.code == 200){
                        $scope.reloadProductList()
                        updateSuccess()
                    } else{
                        requestError(response.msg)
                    }
                }).error((e)=>{systemError()})
            }

        }
    }

    /**
     * 产品批量删除
     */
    $scope.deleteBatch = function (){
        if($scope.productSelectIds.length==0){
            primaryMessage('请选择')
        }else{
            layer.confirm('您确定要删除吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                deleteBase($scope.productSelectIds)
                $scope.productSelectIds = []
            })
        }
    }
    /**
     * 单个删除产品
     * @param id 产品id
     */
    $scope.delete = function (id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.ids = []
            $scope.ids.push(id)
            deleteBase($scope.ids)
            $scope.ids = []
        })
    }


    /**
     * 删除公共方法
     * @param ids
     */
    var deleteBase = function(ids){
        BaseProductService.deleteBatch(ids).success((response)=>{
            if (response.code == 200){
                $scope.reloadProductList()
                deleteSuccess(response.msg)
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 查找单个产品对象
     * @param id
     */
    $scope.findoneProduct = function(id){
        BaseProductService.findone(id).success((response)=>{
            if (response.code == 200){
                $scope.product = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 更新当前产品对象
     * @param 产品对象
     */
    $scope.updateCurrentProduct = function(product){
        $scope.currentProduct = product
        $scope.reloadPartsList()
    }

    /**
     * 当前产品-零件id
     * @type {null}
     */
    $scope.currentPartId = null

    /**
     * 产品-零件数量
     */
    $scope.num = null

    /**
     * 判断批量添加 / 修改数量
     * @param id
     */
    $scope.openPartsModal = function(id){
        if (id==null){
            //批量添加零件
            $('#batchAddParts').modal();
            $scope.reloadNoChoicePartsList()
        } else{
            //修改数量
            $scope.currentPartId = id
            BaseProductService.findNumByPartId(id).success((response)=>{
                if (response.code == 200){
                    $scope.num = response.data.num
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
            $('#secondmodal').modal();
        }
    }








    /**
     * 产品-零件 模块
     * @author guolin
     */







    /**
     * 零件管理数据列表分页
     * @type {*[]}
     */
    $scope.productPartsPaginationConf = {
        currentPage: 1,
        totalItems: 22,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadPartsList();//重新加载
        }
    };


    /**
     * 零件查询对象
     * @type {{}}
     */
    $scope.partSearch = {}

    /**
     * 刷新零件列表
     */
    $scope.reloadPartsList = function(){
        $scope.getAllPartsByProductId($scope.productPartsPaginationConf.currentPage,$scope.productPartsPaginationConf.itemsPerPage);
    }

    /**
     * 获取零件列表
     * @param page 页数
     * @param size 页大小
     */
    $scope.getAllPartsByProductId = function(page,size){
        if($scope.currentProduct.id!=null){
            BaseProductService.findPartsByProductId($scope.currentProduct.id,page,size,$scope.partSearch).success((response)=>{
                if (response.code == 200){
                    $scope.productPartsPaginationConf.totalItems = response.data.total
                    $scope.partsList = response.data.data
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }
    }

    /**
     * 选中的parts ID
     * @type {Array}
     */
    $scope.partsSelectIds = [];

    /**
     * 零件对象  新增/修改
     * @type {{}}
     */
    $scope.parts = {};


    /**
     * 更新零件列表序号多选
     * @param $event
     * @param id
     */
    $scope.updatePartsSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.partsSelectIds.push( id);
        }else{
            var idx = $scope.partsSelectIds.indexOf(id);
            $scope.partsSelectIds.splice(idx, 1);//删除
        }
    }

    /**
     * 修改产品-零件id对应的数量
     */
    $scope.savePartsNum = function () {
        BaseProductService.savePartsNum($scope.currentPartId,$scope.num).success((response)=>{
            if (response.code == 200){
                saveSuccess()
                $scope.reloadPartsList()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 零件批量删除
     */
    $scope.partsDeleteBatch = function (){
        if($scope.partsSelectIds.length==0){
            primaryMessage('请选择')
        }else{
            layer.confirm('您确定要删除吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                deleteProductPartsBase($scope.partsSelectIds)
                $scope.partsSelectIds = []
            })
        }
    }
    /**
     * 零件单个删除
     * @param id 零件id
     */
    $scope.partsDelete = function (id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $scope.partids = []
            $scope.partids.push(id)
            deleteProductPartsBase($scope.partids)
            $scope.partids = []
        })
    }


    /**
     * 删除产品-零件公共方法
     * @param ids
     */
    var deleteProductPartsBase = function(ids){
        BaseProductService.deleteProductPartsBase(ids).success((response)=>{
            if (response.code == 200){
                deleteSuccess()
                $scope.reloadPartsList()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }









    /**
     * 批量添加零件模块
     * @type {*[]}
     */






    /**
     * 批量添加零件的id集合
     * @type {Array}
     */
    $scope.noChoiceSelectId = [];

    //更新复选
    $scope.noChoiceUpdateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.noChoiceSelectId.push( id);
        }else{
            var idx = $scope.noChoiceSelectId.indexOf(id);
            $scope.noChoiceSelectId.splice(idx, 1);//删除
        }
    }

    /**
     * 批量添加零件分页
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.productNoChoicePartsPaginationConf = {
        currentPage: 1,
        totalItems: 15,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30],
        onChange: function(){
            $scope.reloadNoChoicePartsList();//重新加载
        }
    };

    /**
     * 刷新未选择的零件列表
     */
    $scope.reloadNoChoicePartsList = function(){
        $scope.getAllNoChoiceParts($scope.productNoChoicePartsPaginationConf.currentPage,$scope.productNoChoicePartsPaginationConf.itemsPerPage);
    }

    /**
     * 零件批量添加查询条件
     * @type {{}}
     */
    $scope.noChoicePartname = null

    /**
     * 加载未选择的零件列表
     * @param page 当前页
     * @param size 页的大小
     */
    $scope.getAllNoChoiceParts = function(page,size){
        if($scope.currentProduct.id!=null){
            BaseProductService.getAllNoChoiceParts($scope.currentProduct.id,page,size,$scope.noChoicePartname).success((response)=>{
                if (response.code == 200){
                    $scope.productNoChoicePartsPaginationConf.totalItems = response.data.total
                    $scope.noChoicepartsList = response.data.data
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }
    }

    /**
     * 批量添加
     */
    $scope.batchAddParts = function(){
        if($scope.noChoiceSelectId.length==0){
            primaryMessage('您还未选择任何零件')
        }else{
            BaseProductService.batchAddParts($scope.currentProduct.id,$scope.noChoiceSelectId).success((response)=>{
                if (response.code == 200){
                    layer.msg('添加成功,每个零件的数量默认为1。',{icon:1});
                    $scope.noChoiceSelectId = []
                    $scope.reloadNoChoicePartsList()
                    $scope.reloadPartsList()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }
    }


});