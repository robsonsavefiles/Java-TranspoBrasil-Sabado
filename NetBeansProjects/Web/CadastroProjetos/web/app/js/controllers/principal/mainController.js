angular.module("projeto")
        .controller("mainController", ["$scope", "AutenticacaoService", "$state", function ($scope, AutenticacaoService, $state) {
                $scope.alert = {};
                $scope.user = AutenticacaoService.getUsuario();

                $scope.logout = function () {
                    AutenticacaoService.logout();
                };

                $scope.$on("loginComSucesso", function (event, usuario) {
                    $scope.user = usuario;
                });

                $scope.$on("logoutComSucesso", function (event) {
                    $scope.user = null;
                    $state.go("login");
                });
            }]);