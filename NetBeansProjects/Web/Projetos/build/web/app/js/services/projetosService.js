angular.module("projetos")
        .factory("ProjetosService", ["$http", "$rootScope",
            function ($http, $rootScope) {
                return{
                    buscar: function (id) {
                        return $http.get("projetos?id=" + id);
                    },
                    buscarTodos: function () {
                        $http.get("projetos").then(
                                function (response) {
                                    $rootScope.$broadcast("projetosServiceBuscarTodosSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("projetosServiceBuscarTodosFalha", error);
                                });
                    },
                    editar: function (projeto) {
                        $http.put("projetos", angular.toJson(projeto)).then(
                                function (response) {
                                    $rootScope.$broadcast("projetosServiceEditarSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("projetosServiceEditarFalha", error);
                                });
                    },
                    incluir: function (projeto) {
                        $http.post("projetos", angular.toJson(projeto)).then(
                                function (response) {
                                    $rootScope.$broadcast("projetosServiceIncluirSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("projetosServiceIncluirFalha", error);
                                });
                    },
                    remover: function (projeto) {
                        $http.delete("projetos?id=" + projeto.id).then(
                                function (response) {
                                    $rootScope.$broadcast("projetosServiceRemoverSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("projetosServiceRemoverFalha", error);
                                });
                    }
                };
            }]);

