angular.module('PetApp', [
    'ngRoute',
    'base64',
    'naif.base64',
    'ngTable',
    'ui.bootstrap',
    'ngStorage',
    'ngMessages',
    'ngStomp'
]);

angular.module('PetApp').config(function ($routeProvider) {
    $routeProvider
            .when('/add', {
                templateUrl: '/pages/petManagement/addPetInfo.jsp',
                controller: 'PetManagementController'
            })
            .when('/manage', {
                templateUrl: '/pages/petManagement/managePetInfo.jsp',
                controller: 'PetManagementController'
            })
            .when("/login", {
                templateUrl: '/pages/login/login.jsp',
                controller: 'LoginController'
            })
            .when("/dashboard", {
                templateUrl: '/pages/dashboard/dashboard.jsp',
                controller: 'LoginController'
            })
            .otherwise({redirectTo: '/login'});
});

angular.module('PetApp').config(['$locationProvider', function ($locationProvider) {
        $locationProvider.hashPrefix('');
    }]);

angular.module('PetApp').run(function ($rootScope, $location, $localStorage) {
    if ($localStorage.isLoggedIn !== undefined) {
        if ($localStorage.isLoggedIn === true) {
            $rootScope.isLoggedIn = true;
        } else {
            $location.path('/login');
        }
    } else {
        $location.path('/login');
    }
});