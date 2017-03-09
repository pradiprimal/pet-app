angular.module('PetApp', ['ngRoute','base64','naif.base64']);

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
            .when("/home", {
                templateUrl: '/index.jsp'
            })
            .otherwise({redirectTo: '/add'});
});

angular.module('PetApp').config(['$locationProvider', function ($locationProvider) {
        $locationProvider.hashPrefix('');
    }]);