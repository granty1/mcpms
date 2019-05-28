app.controller('BaseWarningController',function ($scope, BaseWarningService) {


    $scope.dataObj = {}

    $scope.initDays = function(){
        BaseWarningService.initDays().success((response)=>{
            if (response.code == 200){
                $scope.dataObj = response.data
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

    $scope.save = function(){
        BaseWarningService.save($scope.dataObj).success((response)=>{
            if (response.code == 200){
                successMessage('保存成功！')
            } else{
                requestError(response.msg)
            }
        }).error((e)=>{systemError()})
    }

})