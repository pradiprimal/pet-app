angular.module('PetApp', ['ngRoute']);

angular.module('PetApp').config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: '/pages/petManagement/addPetInfo.jsp',
                controller: 'PetManagementController as pet'
            });
            
});