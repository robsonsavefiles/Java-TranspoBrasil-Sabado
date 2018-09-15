angular.module('projeto')
        .factory('ServicoChamado',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return{
                            buscarChamado: function (id) {
                                return $http.get('chamados?id=' + id);
                            },
                            buscarChamados: function () {
                                $http.get('chamados')
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoChamadoBuscarTodosSucesso', response.data);
                                        }, function (error) {
                                            $rootScope.$broadcast('ServicoChamadoBuscarTodosFalha', error);
                                        });
                            },
                            buscarPorProjeto: function (projeto) {
                                $http.get('chamados?idProjeto=' + projeto.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoChamadoBuscarTodosSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoChamadoBuscarTodosFalha', error);
                                                });
                            },
                            buscarStatos: function () {
                                $http.get("chamados/statos").then(
                                        function (response) {
                                            $rootScope.$broadcast("ServicoChamadoBuscarStatosSucesso", response.data);
                                        },
                                        function (error) {
                                            $rootScope.$broadcast("ServicoChamadoBuscarStatosFalha", error);
                                        });
                            },
                            editar: function (chamado) {
                                $http.put('chamados', angular.toJson(chamado))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoChamadoEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoChamadoEditarFalha',
                                                            error);
                                                });

                            },
                            deleteChamado: function (chamado) {
                                $http.delete('chamados?id=' + chamado.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoChamadoExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoChamadoExcluirFalha', error);
                                                });
                            },
                            incluir: function (chamado) {
                                $http.post('chamados', angular.toJson(chamado))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoChamadoIncluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoChamadoIncluirFalha', error);
                                                });
                            }

                        };

                    }]);