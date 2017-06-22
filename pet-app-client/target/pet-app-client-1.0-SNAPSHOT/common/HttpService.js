angular.module('PetApp').service('HttpService', function ($http, $q, TokenService, $location, $localStorage, $rootScope) {
    var service = this;
    service.url = 'http://localhost:8080/api/';

    service.get = function (resource) {
        return $http.get(service.url + resource + TokenService.getToken())
                .then(
                        function (success) {
                            return success;
                        },
                        function (error) {
                            if (error.status === 401) {
                                $localStorage.$reset();
                                $rootScope.isLoggedIn = false;
                                $location.path('login');
                            }
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
                            if (error.status === 401) {
                                $localStorage.$reset();
                                $rootScope.isLoggedIn = false;
                                $location.path('login');
                            }
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
                            if (error.status === 401) {
                                $localStorage.$reset();
                                $rootScope.isLoggedIn = false;
                                $location.path('login');
                            }
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
                            if (error.status === 401) {
                                $localStorage.$reset();
                                $rootScope.isLoggedIn = false;
                                $location.path('login');
                            }
                            return $q.reject(error);
                        }
                );
    };
});
