angular.module('PetApp').controller('CreateMenuController', function (CreateMenuService, $scope) {

    var vm = $scope;
    vm.userMenuTabName = {
        name: '',
        parentId: ''
        
    };

    vm.errorMessage = '';
    vm.successMessage = '';

    function createUserMenuTab() {
        CreateMenuService.createUserMenuTab()
                .thean(
                        function (success) {

                        },
                        function (err) {

                        }
                );
    }

});