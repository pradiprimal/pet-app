angular.module('PetApp').service('LoginService', function (HttpService) {
    var service = this;

    service.authenticate = function (data) {
        return HttpService.post("authenticate/",data);
    };
    
    service.fetchUserMenu=function (){
        return HttpService.get("menus/");  
    };
});
    