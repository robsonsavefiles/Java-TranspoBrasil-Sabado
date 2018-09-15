angular.module("projetos")
        .controller("mainController", ["$scope", "AutenticacaoService", "$state", function ($scope, AutenticacaoService, $state) {
                $scope.alert = {};
                $scope.usuario = AutenticacaoService.getUsuario();

                $scope.logout = function () {
                    AutenticacaoService.logout();
                };

                $scope.$on("loginComSucesso", function (event, usuario) {
                    $scope.usuario = usuario;
                });

                $scope.$on("logoutComSucesso", function (event) {
                    $scope.usuario = null;
                    $state.go("login");
                });
            }]);