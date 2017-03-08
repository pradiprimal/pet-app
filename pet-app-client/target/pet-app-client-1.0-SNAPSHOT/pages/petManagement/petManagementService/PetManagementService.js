angular.module('PetApp').service('PetManagementService', function (HttpService) {
    var service = this;

    service.savePetInfo = function (petInfo) {
        return HttpService.post('save', petInfo);
    };

    service.getPetInfo = function () {
        return HttpService.get('get-all');
    };
});