angular.module('curso')
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

                        .state('cursos', {
                            url: '/cursos',
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
                        .state('cursos.editar', {
                            url: '/{idCurso}',
                            templateUrl: 'app/partials/cursos/formulario.html',
                            controller: 'cursosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores', {
                            url: '/professores',
                            templateUrl: 'app/partials/professores/professores.html',
                            controller: 'professoresController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores.lista', {
                            url: '',
                            templateUrl: 'app/partials/professores/lista.html',
                            controller: 'professoresListaController',
                             data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/professores/formulario.html',
                            controller: 'professoresFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('professores.editar', {
                            url: '/{idProfessor}',
                            templateUrl: 'app/partials/professores/formulario.html',
                            controller: 'professoresFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('alunos', {
                            url: '/alunos',
                            templateUrl: 'app/partials/alunos/alunos.html',
                            controller: 'alunosController',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('alunos.lista', {
                            url: '',
                            templateUrl: 'app/partials/alunos/lista.html',
                            controller: 'alunosListaController',
                             data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('alunos.novo', {
                            url: '/novo',
                            templateUrl: 'app/partials/alunos/formulario.html',
                            controller: 'alunosFormularioController',
                            data: {
                                requerAutenticacao: true
                            }
                            
                        });
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



