angular.module('curso')
        .controller('mainController',
                ['$scope',
                    'AutenticacaoService',
                    '$state',
                    function ($scope, AutenticacaoService, $state) {
                        $scope.user = AutenticacaoService.getUsuario();
                        $scope.logout = function () {
                            AutenticacaoService.logout();

                        };
                        $scope.$on('loginComSucesso', function (event, user) {
                            $scope.user = user;
                        });
                        $scope.$on('logoutComSucesso', function (event) {
                            $scope.user = null;
                            $state.go('login');
                        });
                        $scope.$on('mostrarMensagem', function (event, mensagem) {
                            $scope.alertaLogin = true;
                            $scope.alert = mensagem;
                        });
                        $scope.$on('removerMensagem', function (event) {
                            $scope.alertaLogin = false;
                            $scope.alert = null;
                        });
                    }]);
