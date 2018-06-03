(function () {
    angular.module('app').controller('computeCtrl',['$scope','computeService','Upload',
        function ($scope,computeService,Upload) {
        console.log('computeCtrl');
        $scope.compute='神州精盾K470P-i7d3';


        $scope.openSelectFile=function(){
            $("#file_div_id").click();
        }

        $scope.uploadFile=function($file){
           if($file&&$file.length<1){
               return;
           }
            Upload.upload({
               url:'test/upload',
               method:'post',
               file:$file
           }).success(function (data) {
               console.log('上传结果--->' ,data);
               $scope.upMessage=data.message;

           })

        }

        $scope.downLoadFile=function(){
            window.location.href="test/downLoadFile";
        }

            $scope.downLoadFile_doc=function(){
                window.location.href="test/downLoadFile_doc";
            }


        }])
})()