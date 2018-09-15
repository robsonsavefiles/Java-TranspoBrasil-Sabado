angular.module('lab')
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
                            $state.go('cadastro_aluno');
                        });
                        $scope.$on('loginComErro', function (event) {
                            $scope.$emit('mostrarMensagem', "Email ou Senha incorretos");
//                            $state.go('Falha no login');
                        });
                    }]);

