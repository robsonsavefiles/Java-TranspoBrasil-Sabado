angular.module('curso')
        .factory('ServicoCertificacoes',
                ['$http',
                    '$rootScope',
                    function ($http, $rootScope) {

                        return {
                            buscarCertificacoes: function () {
                                $http.get('certificacoes')
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCertificacaoBuscarTodosSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCertificacaoBuscarTodosFalha',
                                                            error);
                                                });
                            },
                            
                            buscarCertificacao : function (id){
                              return $http.get('certificacoes?id='+id);  
                            },
                            
                            editar: function (certificacao) {
                                $http.put('certificacoes', angular.toJson(certificacao))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCertificacaoEditarSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCertificacaoEditarFalha',
                                                            error);
                                                });

                            },
                            incluir: function (certificacao) {
                                $http.post('certificacoes',angular.toJson(certificacao))
                                        .then(function (response) {
                                            $rootScope.$broadcast('servicoCertificacaoIncluirSucesso',
                                                    response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('servicoCertificacaoIncluirFalha',
                                                            error);
                                                });
                            },
                            deleteCertificacao: function (certificacao) {
                                $http.delete('certificacoes?id=' + certificacao.id)
                                        .then(function (response) {
                                            $rootScope.$broadcast('ServicoCertificacaoExcluirSucesso', response.data);
                                        },
                                                function (error) {
                                                    $rootScope.$broadcast('ServicoCertificacaoExcluirFalha', error);
                                                });
                            }
                        };

                    }]);


