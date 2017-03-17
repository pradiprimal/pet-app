angular.module('PetApp').controller('LoginController', function ($scope, LoginService, $localStorage, $location, $rootScope, $route) {

    var vm = $scope;
    vm.loginData = {
        userName: '',
        password: ''
    };

    vm.authenticate = authenticate;

    function authenticate() {
        LoginService.authenticate(vm.loginData)
                .then(
                        function (success) {
                            console.log(success.data);
                            $localStorage.token = success.data.message;
                            $localStorage.isLoggedIn = true;
                            $rootScope.isLoggedIn = true;
                            $location.path("/dashboard");
                        },
                        function (error) {
                            console.log(error.data);
                        }
                );
    }

});