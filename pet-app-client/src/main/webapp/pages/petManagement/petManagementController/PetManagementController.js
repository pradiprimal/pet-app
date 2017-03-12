angular.module('PetApp').controller('PetManagementController', function ($scope, PetManagementService,
        NgTableParams, $uibModal) {
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

    vm.tableParams = new NgTableParams();

    vm.successMessage = '';

    vm.errorMessage = '';

    vm.savePetInfo = savePetInfo;

    vm.getAllPetInfos = getAllPetInfos;

    vm.editPetInfo = editPetInfo;

    vm.deletePetInfo = deletePetInfo;



    function savePetInfo() {
        resetMessage();
        if (vm.petImage !== '') {
            var base64String = vm.petImage.base64;
            vm.petInfo.image = base64String;
        }
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
                            vm.tableParams = new NgTableParams({count: 2}, {dataset: vm.petInfos});
                            console.log('SUCCESS');
                            console.log(success);
                        },
                        function (err) {
                            console.log('ERRROR');
                            console.log(err);
                        }
                );
    }

    function editPetInfo(petInfo) {
        resetMessage();
        openEditPetInfoModal(petInfo);
    }

    function openEditPetInfoModal(petInfo) {
        var pet = angular.copy(petInfo);
        var modalInstance = $uibModal.open({
            templateUrl: 'pages/petManagement/modal/editPetInfo.jsp',
            controller: 'EditPetInfoModalCtrl',
            size: 'lg',
            resolve: {
                petInfo: function () {

                    return petInfo;
                }
            }
        });
        modalInstance.result
                .then(
                        function (petInfo) {
                            if (angular.equals(petInfo, pet)) {
                                vm.errorMessage = 'Nothing has change to update.';
                            } else {
                                updatePetInfo(petInfo);
                            }
                        }, function () {
                    console.log('Modal dismissed at: ' + new Date());
                });
    }


    function updatePetInfo(petInfo) {
        resetMessage();
        petInfo.imagePath = '';
        PetManagementService.savePetInfo(petInfo)
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


    function resetMessage() {
        vm.successMessage = '';

        vm.errorMessage = '';
    }

    function deletePetInfo(petInfo) {
        resetMessage();
        PetManagementService.deletePetInfo(petInfo.id)
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
});
