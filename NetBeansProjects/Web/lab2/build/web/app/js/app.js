angular.module('lab', ['ui.router','ngCookies'])
        .config(['$stateProvider',
            '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise('/login');

                $stateProvider.state('login', {
                    url: '/login',
                    templateUrl: 'app/partials/login/login.html',
                    controller: 'loginController'
                })
                        .state('cadastro_aluno', {
                            url: '/cadastro_aluno',
                            templateUrl: 'app/partials/paginas/cadastro_alunos.html',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('pagina2', {
                            url: '/pagina2',
                            template: 'Pagina2',
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state('pagina3', {
                            url: '/pagina3',
                            template: 'Pagina3',
                            data: {
                                requerAutenticacao: true,
                                permissions: ['ADM']
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