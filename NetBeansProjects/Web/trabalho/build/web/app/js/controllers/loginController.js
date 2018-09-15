angular.module('curso')
        .controller('loginController',
                ['$scope',
                    'AutenticacaoService',
                    '$state', function ($scope, AutenticacaoService, $state) {
                        $scope.credencial = {};

                        $scope.login = function (credencial) {
                            AutenticacaoService.login(credencial);
                        };

                        $scope.$on('loginComSucesso', function (event, user) {
                            $scope.$emit('removerMensagem');
                            $state.go('cursos');
                        });
                        $scope.$on('loginComErro', function (event) {
                            $scope.$emit('mostrarMensagem', "Email ou Senha incorretos");
//                            $state.go('Falha no login');
                        });
                    }]);

