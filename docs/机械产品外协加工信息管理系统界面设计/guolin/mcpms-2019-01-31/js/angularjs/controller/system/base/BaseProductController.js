app.controller('BaseProductController',function ($scope) {


    /**
     * 产品 模块
     * @author guolin
     */

    /**
     * 产品对象  新增/修改
     * @type {{}}
     */
    $scope.product = {};

    /**
     * 当前选中产品id
     * @type {null}
     */
    $scope.currentProductId = null;


    /**
     * 产品列表分页
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.productPaginationConf = {
        currentPage: 1,
        totalItems: 15,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30],
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


    $scope.saveProduct = function () {
        if($scope.product.name==null || $scope.product.type==null){
            layer.msg('请填写完整',{icon:5})
        }else{
            layer.msg('保存成功',{icon:1})
            $scope.productList.push($scope.product)
        }
    }

    /**
     * 产品批量删除
     */
    $scope.deleteBatch = function (){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }
    /**
     * 单个删除产品
     * @param id 产品id
     */
    $scope.delete = function (id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }

    /**
     * 更新当前产品Id
     * @param id 当前产品id
     */
    $scope.updateCurrentProductId = function(id){
        $scope.currentProductId = id;
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
     * 当前选中零件Id
     * @type {null}
     */
    $scope.currentPartId = null;

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


    $scope.savePartsNum = function () {
            layer.msg('保存成功',{icon:1})
    }

    /**
     * 零件批量删除
     */
    $scope.partsDeleteBatch = function (){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }
    /**
     * 零件单个删除
     * @param id 零件id
     */
    $scope.partsDelete = function (id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }

    $scope.openPartsModal = function(id){
        if (id==null){
            //新增
            $('#batchAddParts').modal();
        } else{
            //修改
            $('#secondmodal').modal();
        }

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
     * 加载未选择的零件列表
     * @param page 当前页
     * @param size 页的大小
     */
    $scope.getAllNoChoiceParts = function(page,size){

    }

    /**
     * 批量添加
     */
    $scope.batchAddParts = function(){
        if($scope.noChoiceSelectId.length==0){
            layer.msg('您还未选择任何零件',{icon:5});
        }else{
            layer.msg('添加成功,每个零件的数量默认为1。',{icon:1});
        }
    }





    $scope.partsList = [
        {
            "id":1,
            "bh":201801,
            "bm":"2019GBK",
            "mc":"手动挡杆",
            "th":"GTSG3-160-0505",
            "num":1,
            "dw":"件",
        },
        {
            "id":2,
            "bh":201802,
            "bm":"2019KBB",
            "mc":"滑轮",
            "th":"GTSG3-160-109",
            "num":1,
            "dw":"个",
        },
        {
            "id":3,
            "bh":201803,
            "bm":"2019GBK",
            "mc":"操作箱",
            "th":"GTSG3-160-275",
            "num":1,
            "dw":"件",
        },
        {
            "id":4,
            "bh":201804,
            "bm":"2019GBK",
            "mc":"操作杆",
            "th":"GTSG3-160-0512",
            "num":1,
            "dw":"件",
        },
        {
            "id":3,
            "bh":201803,
            "bm":"2019GBK",
            "mc":"操作箱",
            "th":"GTSG3-160-275",
            "num":1,
            "dw":"件",
        },
        {
            "id":4,
            "bh":201804,
            "bm":"2019GBK",
            "mc":"操作杆",
            "th":"GTSG3-160-0512",
            "num":1,
            "dw":"件",
        },
        {
            "id":3,
            "bh":201803,
            "bm":"2019GBK",
            "mc":"操作箱",
            "th":"GTSG3-160-275",
            "num":1,
            "dw":"件",
        },
        {
            "id":4,
            "bh":201804,
            "bm":"2019GBK",
            "mc":"操作杆",
            "th":"GTSG3-160-0512",
            "num":1,
            "dw":"件",
        }
    ]

    $scope.productList = [
        {
            "id":1,
            "type":2018122,
            "name":"超纤革机",
            "ps":""
        },
        {
            "id":2,
            "type":2019122,
            "name":"超纤革机",
            "ps":""
        },
        {
            "id":3,
            "type":20181982,
            "name":"超纤革机",
            "ps":""
        },
        {
            "id":4,
            "type":2019432,
            "name":"超纤革机",
            "ps":""
        }
    ]

    $scope.noChoicepartsList = [
        {
            "id":1,
            "mc":"操作杆"
        },
        {
            "id":2,
            "mc":"操作杆"
        },
        {
            "id":3,
            "mc":"操作杆"
        },
        {
            "id":4,
            "mc":"操作杆"
        },
        {
            "id":5,
            "mc":"操作杆"
        }
    ]
});