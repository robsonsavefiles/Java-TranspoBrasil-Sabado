angular.module('projeto')
        .controller("caixaMensagemController", ["$scope", function ($scope) {
                $scope.msg = [];
                $scope.$on("mostrarMensagem", function (event, identificador, texto, tipo) {
                    for (var i = 0; i < $scope.msg.length; i++) {
                        if ($scope.msg[i].identificador === identificador) {
                            return;
                        }
                    }
                    $scope.msg.push({
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
                    for (var i = 0; i < $scope.msg.length; i++) {
                        if ($scope.msg[i].identificador === identificador) {
                            $scope.msg.splice(i, 1);
                        }
                    }
                };
            }]);

