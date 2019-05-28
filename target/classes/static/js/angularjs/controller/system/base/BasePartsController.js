app.controller('BasePartsController',function ($scope,BasePartsService) {

    /**
     * 零件模块
     * @author guolin
     */


    /**
     * 查询条件对象
     * @type {{}}
     */
    $scope.search = {};


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
        showLoad()
        BasePartsService.getAll(page,size,$scope.search).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.partsPaginationConf.totalItems = response.data.total
                $scope.partsList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
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
     * 查找当前零件的所有工序
     * @param parts
     */
    $scope.updateCurrentParts = function(parts){
        $scope.currentParts = parts

        $scope.getAllProcess($scope.currentParts.id)
    }


    /**
     * 根据id获取所有工序
     * @param id 零件id
     */
    $scope.getAllProcess = function(id){
        showLoad()
        BasePartsService.getAllProcess(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.processList = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    $scope.findone = function(id){
        showLoad()
        BasePartsService.findone(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.parts = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 保存零件编辑
     */
    $scope.partsSave = function(){
        showLoad()
        if($scope.parts.id==null){
            //新增
            BasePartsService.add($scope.parts).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.reloadPartsList()
                    $scope.parts = {}
                    $('#editParts').modal('hide')
                    saveSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)    =>{systemError()})
        }else {
            //修改
            BasePartsService.update($scope.parts).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    $scope.reloadPartsList()
                    $scope.parts = {}
                    $('#editParts').modal('hide')
                    saveSuccess()
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
    $scope.delete = function(id){
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
     * 批量删除
     */
    $scope.deleteBatch = function(){
        if($scope.partsSelectIds.length==0){
            primaryMessage('请选择')
        }else{
            layer.confirm('您确定要删除吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                deleteBase($scope.partsSelectIds)
                $scope.partsSelectIds = []
            })
        }
    }

    /**
     * 删除公共方法
     * @param ids
     */
    var deleteBase = function(ids){
        showLoad()
        BasePartsService.deleteBatch(ids).success((response)=>{
            closeLoad()
            if (response.code == 200){
                successMessage(response.msg)
                $scope.reloadPartsList()
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
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
     * 修改的工序id
     * @type {null}
     */
    $scope.clickId = null

    /**
     * 工序编辑窗口
     * @type {*[]}
     */
    $scope.openProcessModal = function(id){
        if(id==null){
        }else{
            $scope.clickId = id
            $scope.findoneProcess(id)
        }
        $('#addProcessModal').modal();
    }

    /**
     * 根据零件-工序id查找零件-工序对象
     * @param id
     */
    $scope.findoneProcess = function(id){
        showLoad()
        BasePartsService.findoneProcess(id).success((response)=>{
            closeLoad()
            if (response.code == 200){
                $scope.process = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    /**
     * 零件-工序 编辑 保存
     */
    $scope.processSave = function(){
        showLoad()
        if($scope.process.id!=null){
            //修改保存
            BasePartsService.processUpdate($scope.process).success((response)=>{
                closeLoad()
                if (response.code == 200){
                $scope.getAllProcess($scope.currentParts.id)
                $('#addProcessModal').modal('hide')
                updateSuccess()
                $scope.process = {}
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        }else{
            $scope.process.partsId = $scope.currentParts.id
            // 新增
            BasePartsService.processSave($scope.process).success((response)=>{
                closeLoad()
                if (response.code == 200){
                $scope.getAllProcess($scope.currentParts.id)
                $('#addProcessModal').modal('hide')
                saveSuccess()
                $scope.process = {}
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        }
    }

    /**
     * 清空对象
     */
    $scope.clearProcess = function(){
        $scope.process = {}
        $('#outCompanyDiv').attr("hidden",true);
    }

    /**
     * 工序删除
     * @type {*[]}
     */
    $scope.processDelete = function(id){
        layer.confirm('您确定要删除吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            showLoad()
            BasePartsService.deleteProcess(id).success((response)=>{
                closeLoad()
                if (response.code == 200){
                    deleteSuccess()
                    $scope.getAllProcess($scope.currentParts.id)
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }


    $scope.cloneProcess = function(){
        $('#cloneProcessModal').modal()
    }


    $scope.cloneSave = function(){

        layer.confirm('克隆目标零件工序会清楚当前所有工序，确定此操作吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            showLoad()
            if($scope.targetId == null){
                closeLoad()
                infoMessage('请选择目标零件')
            }else{
                if($scope.targetId == $scope.currentParts.id){
                    closeLoad()
                    infoMessage('不能选择同种零件')
                }else {
                    BasePartsService.clone($scope.currentParts.id,$scope.targetId).success((response)=>{
                        closeLoad()
                        if (response.code == 200){
                            $scope.getAllProcess($scope.currentParts.id)
                            $('#cloneProcessModal').modal('hide')
                            successMessage('操作成功')
                        } else{
                            requestError(response.msg)
                        }
                    }).error((e)=>{systemError()})

                }
            }
        })

    }

    $scope.cloneList = []

    $scope.initData = function(){
        BasePartsService.initDataList().success((response)=>{
            if (response.code == 200){
                $scope.processMethodList = response.data.methodList
                $scope.outSourceList = response.data.outList
                $scope.processDataList = response.data.processList
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
        BasePartsService.getCloneParts().success((response)=>{
            if (response.code == 200){
                $scope.cloneList = response.data.partsData
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }



});