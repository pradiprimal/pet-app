angular.module('PetApp').controller('LoginController', function ($scope, LoginService, $localStorage, $location, $rootScope, $route) {

    var vm = $scope;
    vm.loginData = {
        userName: '',
        password: ''
    };

    vm.errorMessage = '';

    vm.authenticate = authenticate;

    vm.fetchUserMenu = fetchUserMenu;
    

    function authenticate() {
        LoginService.authenticate(vm.loginData)
                .then(
                        function (success) {
                            console.log(success.data);
                            $localStorage.token = success.data.message;
                            $localStorage.isLoggedIn = true;
                            $rootScope.isLoggedIn = true;
                            fetchUserMenu();
//                            $location.path("/dashboard");
                        },
                        function (error) {
                            console.log(error);
                            vm.errorMessage = error.data.message;
                            console.log(error.data.message);
                        }
                );
    }

    function fetchUserMenu() {
        LoginService.fetchUserMenu()
                .then(
                        function (success) {
                            console.log(success.data);
                            $localStorage.menus = success.data;
                            $location.path("/dashboard");
                        },
                        function (error) {
                            console.log(error);
                        }
                );
    }

});