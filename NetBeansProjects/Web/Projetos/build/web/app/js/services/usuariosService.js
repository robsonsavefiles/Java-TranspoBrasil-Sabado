angular.module("projetos")
        .factory("UsuariosService", ["$http", "$rootScope",
            function ($http, $rootScope) {
                return{
                    buscar: function (id) {
                        return $http.get("usuarios?id=" + id);
                    },
                    buscarTodos: function () {
                        $http.get("usuarios").then(
                                function (response) {
                                    $rootScope.$broadcast("usuariosServiceBuscarTodosSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("usuariosServiceBuscarTodosFalha", error);
                                });
                    },
                    buscarPermissoes: function () {
                        $http.get("usuarios/permissoes").then(
                                function (response) {
                                    $rootScope.$broadcast("usuariosServiceBuscarPermissoesSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("usuariosServiceBuscarPermissoesFalha", error);
                                });
                    },
                    editar: function (usuario) {
                        $http.put("usuarios", angular.toJson(usuario)).then(
                                function (response) {
                                    $rootScope.$broadcast("usuariosServiceEditarSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("usuariosServiceEditarFalha", error);
                                });
                    },
                    incluir: function (usuario) {
                        $http.post("usuarios", angular.toJson(usuario)).then(
                                function (response) {
                                    $rootScope.$broadcast("usuariosServiceIncluirSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("usuariosServiceIncluirFalha", error);
                                });
                    },
                    remover: function (usuario) {
                        $http.delete("usuarios?id=" + usuario.id).then(
                                function (response) {
                                    $rootScope.$broadcast("usuariosServiceRemoverSucesso", response.data);
                                },
                                function (error) {
                                    $rootScope.$broadcast("usuariosServiceRemoverFalha", error);
                                });
                    }
                };
            }]);

