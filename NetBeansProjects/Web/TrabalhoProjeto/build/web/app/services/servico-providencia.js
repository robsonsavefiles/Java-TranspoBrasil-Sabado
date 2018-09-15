angular.module('projeto')
        .factory('ServicoProvidencia',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarProvidencia: function (id) {
                                return $http.get('providencias?id=' + id);
                            },
                            buscarProvidencias: function () {
                                $http.get('providencias')
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProvidenciaBuscarTodosSucesso',                                                 response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProvidenciaBuscarTodosFalha',
                                                            error);
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
                            editar: function (providencia) {
                                $http.put('providencias', angular.toJson(providencia))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProvidenciaEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProvidenciaEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (providencia) {
                                $http.post('providencias', angular.toJson(providencia))
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProvidenciaIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProvidenciaIncluirFalha',
                                                            error);
                                                });
                            },
                            deleteProvidencia: function (providencia) {
                                $http.delete('providencias?id=' + providencia.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoProvidenciaExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoProvidenciaExcluirFalha', error);
                                                });
                            }
                        };

                    }]);


