angular.module('PetApp').controller('LoginController', function ($scope, LoginService, $localStorage, $location, $rootScope, $route, TokenService) {

    var vm = $scope;
    vm.loginData = {
        userName: '',
        password: ''
    };

    vm.errorMessage = '';

    vm.authenticate = authenticate;

    vm.fetchUserMenu = fetchUserMenu;

    vm.userMenus = [];


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
                            getProfile();
                        },
                        function (error) {
                            console.log(error);
                        }
                );
    }

    getProfile();
    function getProfile() {
        vm.userMenus = (TokenService.getMenus());
        console.log(vm.userMenus);
    }

});