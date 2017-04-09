angular.module('PetApp').service('PetManagementService', function (HttpService) {
    var service = this;

    service.savePetInfo = function (petInfo) {
        return HttpService.post('save', petInfo);
    };

    service.getPetInfo = function () {
        return HttpService.get('get-all');
    };

    service.deletePetInfo = function (id) {
        return HttpService.delete('delete-pet/' + id);
    };

    service.updatePetInfo = function (data) {
        return HttpService.put('update/', data);
    };
});