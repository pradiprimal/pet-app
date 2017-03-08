angular.module('PetApp').service('HttpService', function ($http) {
    var service = this;
    service.url = 'http://localhost:8080/api/';
    service.get = function (resource) {
        return $http.get(service.url + resource)
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return error;
                        }
                );
    };
    service.post = function (resource,data) {
        return $http.post(url + resource,data)
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return error;
                        }
                );
    };
});

