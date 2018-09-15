angular.module("projetos")
        .controller("loginController", ["$rootScope", "$scope", "AutenticacaoService", "$state", function ($rootScope, $scope, AutenticacaoService, $state) {
                $scope.credencial = {};

                $scope.login = function (credencial) {
                    AutenticacaoService.login(credencial);
                };

                $scope.$on("loginComSucesso", function (event, usuario) {
                    $state.go("projetos.lista");
                    $rootScope.$broadcast("removerMensagem", "login");
                });

                $scope.$on("loginComErro", function (event) {
                    $rootScope.$broadcast("mostrarMensagem", "login", "Usuário ou senha inválidos!", "danger");
                });
            }]);