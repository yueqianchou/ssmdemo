(function () {
    angular.module('app').service('indexService',
        function ($http,$log) {
        return {
            testController: function (params) {
                var url = 'testController/view';
                return $http.post(url,params);
            },
            getEntInfo2: function () {
                var url = 'testController/view';
                return $http.post(url,params);
            }
        }

    })
})()