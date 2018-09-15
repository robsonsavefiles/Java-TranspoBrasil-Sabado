angular.module('projeto')
        .config(['$stateProvider',
            '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise('/login');
                $stateProvider
                        .state('login', {
                            url: '/login',
                            templateUrl: 'app/partials/login/login.html',
                            controller: 'loginController'
                        })

                        .state('projetos', {
                            url: '/projetos',
                            abstract: true,
                            templateUrl: 'app/partials/projeto/projetos.html',
                            controller: 'projetosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('projetos.lista', {
                            url: '',
                            templateUrl: 'app/partials/projeto/listaProjeto.html',
                            controller: 'projetosListaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('projetos.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/projeto/formularioProjeto.html',
                            controller: 'projetosNovosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('projetos.editar', {
                            url: '/{idProjeto}',
                            templateUrl: 'app/partials/projeto/formularioProjeto.html',
                            controller: 'projetosNovosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('chamados', {
                            url: '/chamados',
                            abstract: true,
                            templateUrl: 'app/partials/chamado/chamados.html',
                            controller: 'chamadosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('chamados.lista', {
                            url: '',
                            templateUrl: 'app/partials/chamado/listaChamados.html',
                            controller: 'chamadosListaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('chamados.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/chamado/novoChamado.html',
                            controller: 'chamadosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('chamados.editar', {
                            url: '/{idChamado}',
                            templateUrl: 'app/partials/chamado/NovoChamado.html',
                            controller: 'chamadosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('providencias', {
                            url: '/providencias',
                            abstract: true,
                            templateUrl: 'app/partials/providencia/providencias.html',
                            controller: 'providenciasController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('providencias.lista', {
                            url: '',
                            templateUrl: 'app/partials/providencia/listaProvidencia.html',
                            controller: 'providenciasListaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('providencias.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/providencia/formularioProvidencia.html',
                            controller: 'providenciasNovaController',
                            data: {
                                requerAutenticacao: true
                            }

                        })
                        .state('providencias.editar', {
                            url: '/{idProvidencia}',
                            templateUrl: 'app/partials/providencia/formularioProvidencia.html',
                            controller: 'providenciasNovaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })

                        ;
            }])

        .run(['$state', '$rootScope', 'AutenticacaoService', function ($state, $rootScope, AutenticacaoService) {
                $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
                    if (toState.data && toState.data.requerAutenticacao) {
                        var usuario = AutenticacaoService.getUsuario();
                        if (!usuario) {
                            event.preventDefault();
                            $state.go('login');
                        }
                        if (toState.data.permissions) {
                            if ($.inArray(usuario.rule, toState.data.permissions) === -1) {
                                event.preventDefault();
                            }
                        }
                    }
                });
            }]);



