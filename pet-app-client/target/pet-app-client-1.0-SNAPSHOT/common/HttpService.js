angular.module('PetApp').service('HttpService', function ($http, $q, TokenService) {
    var service = this;
    service.url = 'http://localhost:8080/api/';

    service.get = function (resource) {
        return $http.get(service.url + resource + TokenService.getToken())
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return $q.reject(error);
                        }
                );
    };
    service.post = function (resource, data) {
        return $http.post(service.url + resource + TokenService.getToken(), data)
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return $q.reject(error);
                        }
                );
    };

    service.delete = function (resource) {
        return $http.delete(service.url + resource + TokenService.getToken())
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return $q.reject(error);
                        }
                );
    };
    service.put = function (resource, data) {
        return $http.put(service.url + resource + TokenService.getToken(), data)
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            return $q.reject(error);
                        }
                );
    };
});

