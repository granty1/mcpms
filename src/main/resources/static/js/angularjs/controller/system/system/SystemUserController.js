app.controller('SystemUserController',function ($scope,SystemUserService) {


    /**
     * 用户管理 模块
     */


    $scope.search = {}

    $scope.user = {}


    $scope.userPagination = {
        currentPage: 1,
        totalItems: 25,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40],
        onChange: function(){
            $scope.reloadUserList();//重新加载
        }
    }

    $scope.reloadUserList = function () {
        $scope.getAllUser($scope.userPagination.currentPage,$scope.userPagination.itemsPerPage)
    }


    $scope.getAllUser = function (page, size) {
        SystemUserService.getAll(page,size,$scope.search).success((response)=>{
            if (response.code == 200){
                $scope.userPagination.totalItems = response.data.total
                $scope.userList = response.data.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    $scope.findone = function (id) {
        SystemUserService.findone(id).success((response)=>{
            if (response.code == 200){
                $scope.user = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }
    
    $scope.saveInfo = function () {
        if($scope.user.id == null){
            //新增
            SystemUserService.add($scope.user).success((response)=>{
                if (response.code == 200){
                    $scope.reloadUserList()
                    successMessage('添加成功，初始密码为：111111')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }else{
            //修改
            SystemUserService.update($scope.user).success((response)=>{
                if (response.code == 200){
                    $scope.reloadUserList()
                    updateSuccess()
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        }
    }
    
    $scope.delpass = function (id) {
        layer.confirm('确认重置该用户的密码吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            SystemUserService.delpass(id).success((response)=>{
                if (response.code == 200){
                    successMessage('密码重置为：111111')
                } else{
                    requestError(response.msg)
                }
            }).error((e)=>{systemError()})
        })
    }

})