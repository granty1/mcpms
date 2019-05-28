app.controller('BasePartsController',function ($scope) {


    /**
     * 初始化layui form
     */
    layui.use(['form','jquery'],function () {
        var form = layui.form;
        var $ = layui.jquery;

        form.on('select(method)',function (data) {
            if(data.value == 2 || data.value == 3){
                $('#outCompanyDiv').removeAttr("hidden");
                layer.msg('请选择外协单位')
            }else{
                $('#outCompanyDiv').attr("hidden",true);
            }
            form.render('select');
        })

        form.render('select');
    })



    /**
     * 零件模块
     * @author guolin
     */


    /**
     * 零件管理 分页
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
    $scope.partsPaginationConf = {
        currentPage: 1,
        totalItems: 22,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadPartsList();//重新加载
        }
    };

    /**
     * 重载零件数据列表
     */
    $scope.reloadPartsList = function(){
        $scope.getAllParts($scope.partsPaginationConf.currentPage,$scope.partsPaginationConf.itemsPerPage);
    }

    /**
     * 分页获取所有零件列表
     * @param page 当前页
     * @param size 页的大小
     */
    $scope.getAllParts = function(page,size){

    }


    /**
     * 选中零件id集合
     * @type {Array}
     */
    $scope.partsSelectIds=[];//选中的ID集合
    //更新复选
    $scope.updatePartsSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.partsSelectIds.push( id);
        }else{
            var idx = $scope.partsSelectIds.indexOf(id);
            $scope.partsSelectIds.splice(idx, 1);//删除
        }
    }

    /**
     * 单个零件实体
     * @type {{}}
     */
    $scope.parts = {};

    /**
     * 当前工序编辑零件名称
     * @type {*[]}
     */
    $scope.currentParts = {};

    /**
     * 更新当前编辑的零件对象
     * @param parts
     */
    $scope.updateCurrentParts = function(parts){
        $scope.currentParts = parts;
    }










    /**
     * 零件工序模块
     * @author guolin
     * @type {*[]}
     */


    /**
     * 工序实体
     * @type {{}}
     */
    $scope.process = {};


    /**
     * 工序编辑窗口
     * @type {*[]}
     */
    $scope.openProcessModal = function(id){
        if(id==null){
            //新增
        }else{
            //修改
        }

        $('#addProcessModal').modal();

    }

    $('#processMethod').change(function (e) {
        alert(1)
        document.getElementById('processMethod').setAttribute("hidden",false);
    })

    /**
     * 零件-工序 编辑 保存
     */
    $scope.processSave = function(){

        //自动选中
        /*var select = 'dd[lay-value='+2+']';
        $('#processMethod').siblings("div.layui-form-select").find('dl').find(select).click();*/

        //加工工序
        var processSelectedId = $('#processProcess').val();

        //加工方式
        var methodSelectedId = $('#processMethod').val();

        //外协单位
        var outCompanySelectedId = $('#outCompany').val();


        if(processSelectedId=="? undefined:undefined ?"){
            layer.msg('请选择加工工序',{icon:5})
        }else{
            if(methodSelectedId == "? undefined:undefined ?"){
                layer.msg('请选择加工方式',{icon:5})
            }else{
                $scope.process.gx = processSelectedId;
                $scope.process.fs = methodSelectedId;
                console.log(outCompanySelectedId)
                if((methodSelectedId == 3 || methodSelectedId == 4 )&& outCompanySelectedId == "? undefined:undefined ?"){
                    layer.msg('请选择一个外协单位',{icon:5})
                }else{
                    $scope.process.wx = outCompanySelectedId;
                    if($scope.process.id==null){
                        // 新增
                        layer.msg('新增成功',{icon:1})
                    }else{
                        //修改保存
                        layer.msg('修改成功',{icon:1})
                    }
                }

            }
        }
    }

    /**
     * 工序删除
     * @type {*[]}
     */
    $scope.processDelete = function(id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }







    $scope.partsList = [
        {
            "id":1,
            "bh":201801,
            "bm":"2019GBK",
            "mc":"手动挡杆",
            "th":"GTSG3-160-0505",
            "dw":"件",
            "ps":"2019新款"
        },
        {
            "id":2,
            "bh":201802,
            "bm":"2019KBB",
            "mc":"滑轮",
            "th":"GTSG3-160-109",
            "dw":"个",
            "ps":""
        },
        {
            "id":3,
            "bh":201803,
            "bm":"2019GBK",
            "mc":"操作箱",
            "th":"GTSG3-160-275",
            "dw":"件",
            "ps":""
        },
        {
            "id":4,
            "bh":201804,
            "bm":"2019GBK",
            "mc":"操作杆",
            "th":"GTSG3-160-0512",
            "dw":"件",
            "ps":""
        },
    ]



    $scope.processList = [
        {
            "fs":"火焰下料",
            "ts":10,
            "th":"GB11",
            "dj":12.8,
            "ps":""
        },
        {
            "fs":"锯床下料",
            "ts":8,
            "th":"GB11",
            "dj":20.0,
            "ps":""
        },
        {
            "fs":"焊接",
            "ts":5,
            "th":"GB12",
            "dj":45.0,
            "ps":""
        },
        {
            "fs":"车床",
            "ts":15,
            "th":"",
            "dj":null,
            "ps":""
        },
        {
            "fs":"铣床",
            "ts":10,
            "th":"GB13",
            "dj":null,
            "ps":""
        },
    ]

});