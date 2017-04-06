angular.module('PetApp').service('TokenService', function ($localStorage) {
    var service = this;
    service.getToken = function () {
        if ($localStorage.token !== '' && $localStorage.token !== undefined) {
            return service.token = "?accessToken=" + $localStorage.token;
        } else {
            return service.token = "";
        }
    };
});