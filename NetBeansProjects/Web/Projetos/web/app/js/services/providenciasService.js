angular.module("projetos")
        .factory("ProvidenciasService", ["$http", "$rootScope",
            function ($http, $rootScope) {
                return{
                    buscar: function (chamadoId, id) {
                        return $http.get("providencias?chamadoId=" + chamadoId + "&id=" + id);
                    },
                    buscarTodos: function () {
                        $http.get("providencias").then(
                                function (response) {
                                    $rootScope.$broadcast("providenciasServiceBuscarTodosSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("providenciasServiceBuscarTodosFalha", error);
                                });
                    },
                    buscarEstagios: function () {
                        $http.get("providencias/estagios").then(
                                function (response) {
                                    $rootScope.$broadcast("providenciasServiceBuscarEstagiosSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("providenciasServiceBuscarEstagiosFalha", error);
                                });
                    },
                    editar: function (chamado, providencia) {
                        var chamadoProvidencia = {};
                        chamadoProvidencia.chamadoId = chamado.id;
                        chamadoProvidencia.providencia = providencia;
                        $http.put("providencias", angular.toJson(chamadoProvidencia)).then(
                                function (response) {
                                    $rootScope.$broadcast("providenciasServiceEditarSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("providenciasServiceEditarFalha", error);
                                });
                    },
                    incluir: function (chamado, providencia) {
                        var chamadoProvidencia = {};
                        chamadoProvidencia.chamadoId = chamado.id;
                        chamadoProvidencia.providencia = providencia;
                        $http.post("providencias", angular.toJson(chamadoProvidencia)).then(
                                function (response) {
                                    $rootScope.$broadcast("providenciasServiceIncluirSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("providenciasServiceIncluirFalha", error);
                                });
                    },
                    remover: function (chamadoId, providenciaId) {
                        $http.delete("providencias?chamadoId=" + chamadoId + "&id=" + providenciaId).then(
                                function (response) {
                                    $rootScope.$broadcast("providenciasServiceRemoverSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("providenciasServiceRemoverFalha", error);
                                });
                    }
                };
            }]);

