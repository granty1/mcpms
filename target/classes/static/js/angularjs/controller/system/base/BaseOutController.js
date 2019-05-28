app.controller('BaseOutController',function ($scope,BaseOutService) {

    /**
     * 外协管理模块
     * @author guolin
     */


    /**
     * 查询条件对象
     */
    $scope.search = {};

    /**
     * 外协单位实体
     * @type {{}}
     */
    $scope.out = {};

    /**
     * 外协单位列表分页
     */
    $scope.outPaginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadOutsList();//重新加载
        }
    };

    /**
     * 重载外协单位列表
     */
    $scope.reloadOutsList = function () {
        $scope.getAllOuts($scope.outPaginationConf.currentPage,$scope.outPaginationConf.itemsPerPage);
    }

    /**
     * 获取所有外协单位
     */
    $scope.getAllOuts = function (page, size) {
        showLoad()
        BaseOutService.getAllOuts(page,size,$scope.search).success(
            function (response) {
                closeLoad()
                if(response.code==200){
                    $scope.outPaginationConf.totalItems = response.data.total;
                    $scope.outList = response.data.data;
                }else {
                    requestError(response.msg)
                }
            }
        ).error(function (e) {
            systemError()
        });
    }

    /**
     * 外协单位编辑保存
     */
    $scope.outSave = function(){
        showLoad()
        if($scope.out.id!=null){
            //修改
            BaseOutService.save($scope.out).success((response)=>{
                closeLoad()
                if(response.code==200){
                    $scope.reloadOutsList()
                    $('#editOut').modal('hide')
                    updateSuccess();
                    $scope.out = {};
                }else {
                    requestError(response.msg)
                }
            }).error((e)=>{
                systemError()
            })
        }else{
            //新增
            BaseOutService.add($scope.out).success((response)=>{
                closeLoad()
                if(response.code==200){
                    $scope.reloadOutsList()
                    $('#editOut').modal('hide')
                    saveSuccess();
                    $scope.out = {};
                }else{
                    requestError(response.msg)
                }
            }).error((e)=>{
                systemError()
            });
        }
    }

    /**
     * 根据id查找外协单位对象
     * @param id
     */
    $scope.findOne = function(id){
        showLoad()
        BaseOutService.findOne(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.out = response.data
            } else{
                requestError()
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 根据id删除外协单位
     * @param id
     */
    $scope.outDelete= function(id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            showLoad()
            BaseOutService.del(id).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.reloadOutsList()
                    deleteSuccess()
                } else{
                    infoMessage(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }

})