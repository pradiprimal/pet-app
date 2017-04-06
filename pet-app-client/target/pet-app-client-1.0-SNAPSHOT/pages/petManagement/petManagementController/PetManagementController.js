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

    vm.serverSideMessage = '';



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
//                            console.log(data);
                            vm.successMessage = 'Pet name ' + vm.petInfo.name + ' created successfully';
                            resetData();
                        },
                        function (err) {
                            if (err.data.code === 409) {
                                vm.errorMessage = err.data.message;
                            } else if (err.status === 400) {
                                vm.errorMessage = err.data.errorMessage;
                                vm.serverSideMessage = err.data;
                            } else {
                                vm.errorMessage = err.data.message;
                            }
//                            console.log(err);
                        }
                );
    }

    getAllPetInfos();
    function getAllPetInfos() {
        PetManagementService.getPetInfo()
                .then(
                        function (success) {
                            vm.petInfos = success.data;
                            vm.tableParams = new NgTableParams({count: 5}, {dataset: vm.petInfos});
//                            console.log(success);
                        },
                        function (err) {
//                            console.log(err);
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
        PetManagementService.updatePetInfo(petInfo)
                .then(
                        function (data) {
                            vm.successMessage = 'Pet name ' + petInfo.name + ' updated successfully';
//                            console.log(data);
                            getAllPetInfos();
                        },
                        function (err) {
//                            console.log(err);
                        }
                );
    }


    function resetMessage() {
        vm.successMessage = '';
        vm.errorMessage = '';
        vm.serverSideMessage = '';
    }

    function deletePetInfo(petInfo) {
        resetMessage();
        PetManagementService.deletePetInfo(petInfo.id)
                .then(
                        function (data) {
                            vm.successMessage = 'Pet name ' + petInfo.name + ' deleted successfully';
                            getAllPetInfos();
                        },
                        function (err) {
//                            console.log(err);
                        }
                );
    }

    function resetData() {
        vm.petInfo = {
            name: '',
            ownerName: '',
            ownerNo: '',
            ownerEmail: '',
            address: '',
            image: ''
        };
    }

});
