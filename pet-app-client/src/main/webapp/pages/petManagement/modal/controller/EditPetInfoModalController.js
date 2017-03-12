angular.module('PetApp').controller('EditPetInfoModalCtrl', function ($scope, petInfo, $uibModalInstance) {
    var vm = $scope;
    vm.petInfo = petInfo;

    vm.ok = function () {
        $uibModalInstance.close(vm.petInfo);
    };

    vm.cancel = function () {
        $uibModalInstance.dismiss('CANCEL');
    };
});


