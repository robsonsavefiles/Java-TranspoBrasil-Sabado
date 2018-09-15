angular.module('curso')
        .config(['$stateProvider',
            '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise('/login');

                $stateProvider.state('login', {
                    url: '/login',
                    templateUrl: 'app/partials/login/login.html',
                    controller: 'loginController'
                })
                        .state('cursos', {
                            url: '/cursos',
//                               abstract:true,
                            templateUrl: 'app/partials/cursos/cursos.html',
                            controller: 'cursosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('cursos.lista', {
                            url: '',
                            templateUrl: 'app/partials/cursos/lista.html',
                            controller: 'cursosListaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('cursos.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/cursos/formulario.html',
                            controller: 'cursosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores', {
                            url: '/professores',
                            abstract: true,
                            templateUrl: 'app/partials/professores/professores.html',
                            controller: 'cursosController',
                            data: {
                                requerAutenticacao: true
                            }

                        })
                        .state('professores.lista', {
                            url: '',
                            templateUrl: 'app/partials/professores/lista.html',
                            controller: 'cursosListaController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/professores/formulario.html',
                            controller: 'cursosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })

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
            }]);

