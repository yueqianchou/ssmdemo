(function () {
    angular.module('app').controller('computeCtrl',['$scope','computeService','Upload',
        function ($scope,computeService,Upload) {
        console.log('computeCtrl');
        $scope.compute='这里是文件上传下载页面';


        $scope.openSelectFile=function(){
            $("#file_div_id").click();
        }

        $scope.uploadFile=function($file){
           if($file&&$file.length<1){
               return;
           }
            Upload.upload({
               url:'testController/test/upload',
               method:'post',
               file:$file[0]
           }).success(function (data) {
               $scope.upMessage=data.message;
               swal(data.message);

           })

        }

        $scope.downLoadFile=function(){
            window.location.href="testController/test/downLoadFile";
        }

            $scope.downLoadFile_doc=function(){
                window.location.href="testController/test/downLoadFile_doc";
            }


        }])
})()