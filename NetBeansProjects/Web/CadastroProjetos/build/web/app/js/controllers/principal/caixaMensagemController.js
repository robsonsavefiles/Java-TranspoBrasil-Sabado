angular.module('projeto')
        .controller("caixaMensagemController", ["$scope", function ($scope) {
                $scope.mensagens = [];

                $scope.$on("mostrarMensagem", function (event, identificador, texto, tipo) {
                    for (var i = 0; i < $scope.mensagens.length; i++) {
                        if ($scope.mensagens[i].identificador === identificador) {
                            return;
                        }
                    }

                    $scope.mensagens.push(
                            {
                                "identificador": identificador,
                                "texto": texto,
                                "tipo": tipo
                            }
                    );
                });

                $scope.$on("removerMensagem", function (event, identificador) {
                    $scope.fechar(identificador);
                });

                $scope.fechar = function (identificador) {
                    for (var i = 0; i < $scope.mensagens.length; i++) {
                        if ($scope.mensagens[i].identificador === identificador) {
                            $scope.mensagens.splice(i, 1);
                        }
                    }
                };
            }]);

