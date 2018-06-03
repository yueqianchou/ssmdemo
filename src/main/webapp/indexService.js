(function () {
    angular.module('app').service('indexService',
        function ($http,$log) {
        return {
            testController: function () {
                var url = 'ceshi.do';
                return $http.get(url);
            },
            getEntInfo2: function () {
                var url = 'ceshi.do';
                return $http.get(url);
            }
        }

    })
})()