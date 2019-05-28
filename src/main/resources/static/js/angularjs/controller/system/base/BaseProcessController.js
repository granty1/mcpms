app.controller('BaseProcessController',function ($scope,BaseProcessService) {


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
     * 加载所有工序
     */
    $scope.getAllProcess = function(){
        showLoad()
        BaseProcessService.getAll().success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.processList = response.data;
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 根据id查找
     * @param id
     */
    $scope.findone = function(id){
        showLoad()
        BaseProcessService.findone(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.process = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 保存工序编辑
     */
    $scope.processSave = function(){
        showLoad()
        if($scope.process.id==null){
            //新增
            BaseProcessService.add($scope.process).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.getAllProcess()
                    $scope.process = {}
                    $('#editProcess').modal('hide')
                    saveSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }else{
            //修改
            BaseProcessService.update($scope.process).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.getAllProcess()
                    $scope.process = {}
                    $('#editProcess').modal('hide')
                    updateSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
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
            showLoad()
            BaseProcessService.delete(id).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.getAllProcess()
                    deleteSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }

    /**
     * 批量删除
     * @type {*[]}
     */
    $scope.batchDelete = function(){
        if($scope.processSelectedIds.length==0){
            primaryMessage('请选择')
        }else{
            layer.confirm('您确定要删除吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){

                BaseProcessService.deleteBatch($scope.processSelectedIds).success((response)=>{
                    if (response.code == 200){
                        $scope.getAllProcess()
                        deleteSuccess(response.msg)
                        $scope.processSelectedIds = []
                    } else{
                        requestError(response.msg)
                    }
                }).error((e)=>{systemError()})

            })
        }
    }




});