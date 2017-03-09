angular.module('PetApp').controller('PetManagementController', function (PetManagementService, $scope) {
    var vm = $scope;

    vm.petInfo = {
        name: '',
        ownerName: '',
        ownerNo: '',
        ownerEmail: '',
        address: '',
        image: ''
    };

    vm.petImage = '';
    vm.petInfos = [];
    vm.savePetInfo = savePetInfo;
    vm.getAllPetInfos = getAllPetInfos;



    function savePetInfo() {
        var base64String = vm.petImage.base64;
        vm.petInfo.image = base64String;
        PetManagementService.savePetInfo(vm.petInfo)
                .then(
                        function (data) {
                            console.log('SUCCESS');
                            console.log(data);
                        },
                        function (err) {
                            console.log('ERROR');
                            console.log(err);
                        }
                );
    }

    getAllPetInfos();
    function getAllPetInfos() {
        PetManagementService.getPetInfo()
                .then(
                        function (success) {
                            vm.petInfos = success.data;
                            console.log('SUCCESS');
                            console.log(success);
                        },
                        function (err) {
                            console.log('ERRROR');
                            console.log(err);
                        }
                );
    }
});
