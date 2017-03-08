angular.module('PetApp').controller('PetManagementController', function (PetManagementService, $scope) {
    var vm = $scope;

    vm.getAllPetInfos = getAllPetInfos;

    getAllPetInfos();
    function getAllPetInfos() {
        PetManagementService.getPetInfo()
                .then(
                        function (data) {
                            console.log(data);
                        },
                        function (err) {
                            console.log(err);
                        }
                );
    }
});
