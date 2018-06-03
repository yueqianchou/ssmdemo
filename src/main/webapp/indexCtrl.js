(function () {
    angular.module('app').controller('indexCtrl',indexCtrl);
        function indexCtrl($scope,indexService) {
        console.log('indexCtrl');
        $scope.welcome='welcome to index.html';
        $scope.testController=function () {
            indexService.testController().success(function (data) {
                console.log("测试controller",data);
                $scope.message=data.message;
            })
        }

            var map = new AMap.Map('mapContainer', {
                zoom: 15,//缩放层级
                center:[113.947659,22.533588],//当前地图中心点
                resizeEnable: true//调整窗口大小
            });

    }
})()