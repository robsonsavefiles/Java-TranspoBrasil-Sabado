angular.module('projeto')
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise("/login");

                $stateProvider
                        .state("login", {
                            url: "/login",
                            templateUrl: "app/partials/login/login.html",
                            controller: "loginController"
                        })
                        .state("sempermissao", {
                            url: "/sempermissao",
                            template: "Sem Permissão"
                        })
                        .state("projetos", {
                            url: "/projetos",
                            abstract: true,
                            templateUrl: "app/partials/lista-novo/lista-novo.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("projetos.lista", {
                            url: "",
                            templateUrl: "app/partials/projetos/listaProjeto.html",
                            controller: "projetosListaController"
                        })
                        .state("projetos.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/projetos/formularioProjeto.html",
                            controller: "projetosCadastroController"
                        })
                        .state("projetos.editar", {
                            url: "/editar?id",
                            templateUrl: "app/partials/projetos/formularioProjeto.html",
                            controller: "projetosCadastroController"
                        })
                        .state("projetos.detalhes", {
                            url: "/detalhes?id",
                            templateUrl: "app/partials/projetos/detalhesProjeto.html",
                            controller: "projetosCadastroController"
                        })
                        .state("chamados", {
                            url: "/chamados",
                            abstract: true,
                            templateUrl: "app/partials/lista-novo/lista-novo.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("chamados.lista", {
                            url: "",
                            templateUrl: "app/partials/chamados/listaChamado.html",
                            controller: "chamadosListaController"
                        })
                        .state("chamados.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/chamados/formularioChamado.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("chamados.editar", {
                            url: "/editar?id",
                            templateUrl: "app/partials/chamados/formularioChamado.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("chamados.detalhes", {
                            url: "/detalhes?id",
                            templateUrl: "app/partials/chamados/detalhesChamado.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("providencias", {
                            url: "/providencias",
                            abstract: true,
                            templateUrl: "app/partials/lista-novo/lista-novo.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("providencias.lista", {
                            url: "",
                            templateUrl: "app/partials/providencias/listaProvidencia.html",
                            controller: "providenciasListaController"
                        })
                        .state("providencias.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/providencias/formularioProvidencia.html",
                            controller: "providenciasCadastroController"
                        })
                        .state("providencias.editar", {
                            url: "/editar/{chamadoId}/{id}",
                            templateUrl: "app/partials/providencias/formularioProvidencia.html",
                            controller: "providenciasCadastroController"
                        })
                        .state("providencias.detalhes", {
                            url: "/detalhes/{chamadoId}/{id}",
                            templateUrl: "app/partials/providencias/detalhesProvidencia.html",
                            controller: "providenciasCadastroController"
                        })
                        ;
            }])
        .run(["$state", "$rootScope", "AutenticacaoService", function ($state, $rootScope, AutenticacaoService) {
                $rootScope.$on("$stateChangeStart", function (event, toState, toParams, fromState, fromParams) {
                    if (toState.data && toState.data.requerAutenticacao) {
                        var usuario = AutenticacaoService.getUsuario();
                        if (!usuario) {
                            event.preventDefault();
                            $state.go("login");
                        } else {
                            var permissions = toState.data.permissions;
                            if (permissions) {
                                if ($.inArray(usuario.rule, permissions) === -1) {
                                    event.preventDefault();
                                    $state.go("sempermissao");
                                }
                            }
                        }
                    }
                });
            }]);

