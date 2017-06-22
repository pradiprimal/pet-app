angular.module('PetApp').service('CreateMenuService', function (HttpService) {
    var service = this;

    service.createUserMenuTab = function (data) {
        return HttpService.post("/tab", data);
    };

});

