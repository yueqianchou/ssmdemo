(function () {
    angular.module('app').controller('indexCtrl',indexCtrl);
        function indexCtrl($scope,indexService) {
        console.log('indexCtrl');

        init();
        function init() {
            $scope.welcome='欢迎体验angularjs';
            $scope.thisProject={
                longitude:112.176419,
                latitude:31.97284
            }
            getGaodeMap($scope.thisProject.longitude,$scope.thisProject.latitude);
        }

        $scope.closeMap=function () {
            $scope.thisProject.longitude=  $scope.longitudeValue;
            $scope.thisProject.latitude=  $scope.latitudeValue;
            $scope.showMap=false;
            //搜索地图
            getGaodeMap($scope.thisProject.longitude,$scope.thisProject.latitude);
        }

            function getGaodeMap(longitude,latitude){
            var map = new AMap.Map('mapGaoDe', {
                zoom: 10,//缩放层级
                center:[longitude,latitude],//当前地图中心点
                resizeEnable: true//调整窗口大小
            });
        }


            $scope.testController=function () {
                var params =[
                    {name:'张无忌',age:24,phone:18571200201},
                    {name:'小昭',age:26,phone:18571200202},
                    {name:'杨逍',age:24,phone:18571200203},
                    {name:'杨不悔',age:23,phone:18571200204},
                ]
                indexService.testController(params).success(function (data) {
                    if(data.message === 'success'){
                        swal("Good!", "操作成功", "success");
                    }else{
                        swal("OMG!", "操作失败", "error");
                    }

                    $scope.message=data.message;
                })
            }


            $scope.downloadStudent=function(){
            window.location.href="testController/download/excel"
            }
    }
})()