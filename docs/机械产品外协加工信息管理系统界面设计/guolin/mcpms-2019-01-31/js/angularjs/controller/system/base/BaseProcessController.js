app.controller('BaseProcessController',function ($scope) {


    /**
     * 工序模块
     * @author guolin
     */


    /**
     * 选中工序ID集合
     * @type {Array}
     */
    $scope.processSelectedIds = [];

    /**
     * 当前工序实体
     * @type {{}}
     */
    $scope.process = {};

    /**
     * 更新ID集合
     * @param $event
     * @param id
     */
    $scope.processUpdateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.processSelectedIds.push( id);
        }else{
            var idx = $scope.processSelectedIds.indexOf(id);
            $scope.processSelectedIds.splice(idx, 1);//删除
        }
    }

    /**
     * 保存工序编辑
     */
    $scope.processSave = function(){
        if($scope.process.id==null){
            //新增
            layer.msg('新增成功!',{icon:1})
        }else{
            //修改
            layer.msg('修改成功!',{icon:1})
        }
    }

    /**
     * 删除工序
     * @type {*[]}
     */
    $scope.delete = function(id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }

    /**
     * 批量删除
     * @type {*[]}
     */
    $scope.batchDelete = function(){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('删除成功',{icon:1})
        })
    }










    $scope.processList = [
        {
            "id":1,
            "mc":"火焰下料",
            "order":1
        },
        {
            "id":2,
            "mc":"锯床下料",
            "order":2
        },
        {
            "id":3,
            "mc":"减板下料",
            "order":3
        },
        {
            "id":4,
            "mc":"焊接",
            "order":4
        },
        {
            "id":5,
            "mc":"车床",
            "order":5
        },
        {
            "id":6,
            "mc":"铣床",
            "order":6
        }
    ]

});