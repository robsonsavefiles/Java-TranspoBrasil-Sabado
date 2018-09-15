angular.module("projeto")
        .factory("ChamadosService", ["$http", "$rootScope",
            function ($http, $rootScope) {
                return{
                    buscar: function (id) {
                        return $http.get("chamados?id=" + id);
                    },
                    buscarTodos: function () {
                        $http.get("chamados").then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceBuscarTodosSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceBuscarTodosFalha", error);
                                });
                    },
                    buscarPorProjeto: function (idProjeto) {
                        $http.get("chamados/projeto?id=" + idProjeto).then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceBuscarPorProjetoSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceBuscarPorProjetoFalha", error);
                                });
                    },
                    buscarStatuses: function () {
                        $http.get("chamados/statuses").then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceBuscarStatusesSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceBuscarStatusesFalha", error);
                                });
                    },
                    editar: function (chamado) {
                        $http.put("chamados", angular.toJson(chamado)).then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceEditarSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceEditarFalha", error);
                                });
                    },
                    incluir: function (chamado) {
                        $http.post("chamados", angular.toJson(chamado)).then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceIncluirSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceIncluirFalha", error);
                                });
                    },
                    remover: function (chamado) {
                        $http.delete("chamados?id=" + chamado.id).then(
                                function (response) {
                                    $rootScope.$broadcast("chamadosServiceRemoverSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("chamadosServiceRemoverFalha", error);
                                });
                    }
                };
            }]);

