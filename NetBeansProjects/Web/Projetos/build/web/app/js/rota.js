angular.module('projetos')
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise("/naoencontrado");
                $urlRouterProvider.when('', '/login');


                $stateProvider
                        .state("login", {
                            url: "/login",
                            templateUrl: "app/partials/login/login.html",
                            controller: "loginController"
                        })
                        .state("naoencontrado", {
                            url: "/naoencontrado",
                            templateUrl: "app/partials/outros/naoEncontrado.html"
                        })
                        .state("sempermissao", {
                            url: "/sempermissao",
                            templateUrl: "app/partials/outros/semPermissao.html"
                        })
                        .state("usuarios", {
                            url: "/usuarios",
                            abstract: true,
                            templateUrl: "app/partials/template.html",
                            data: {
                                requerAutenticacao: true,
                                permissao: "ADMINISTRADOR"
                            }
                        })
                        .state("usuarios.lista", {
                            url: "",
                            templateUrl: "app/partials/usuarios/lista.html",
                            controller: "usuariosListaController"
                        })
                        .state("usuarios.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/usuarios/cadastro.html",
                            controller: "usuariosCadastroController"
                        })
                        .state("usuarios.editar", {
                            url: "/editar?id",
                            templateUrl: "app/partials/usuarios/cadastro.html",
                            controller: "usuariosCadastroController"
                        })
                        .state("usuarios.detalhes", {
                            url: "/detalhes?id",
                            templateUrl: "app/partials/usuarios/detalhes.html",
                            controller: "usuariosCadastroController"
                        })
                        .state("projetos", {
                            url: "/projetos",
                            abstract: true,
                            templateUrl: "app/partials/template.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("projetos.lista", {
                            url: "",
                            templateUrl: "app/partials/projetos/lista.html",
                            controller: "projetosListaController"
                        })
                        .state("projetos.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/projetos/cadastro.html",
                            controller: "projetosCadastroController"
                        })
                        .state("projetos.editar", {
                            url: "/editar?id",
                            templateUrl: "app/partials/projetos/cadastro.html",
                            controller: "projetosCadastroController"
                        })
                        .state("projetos.detalhes", {
                            url: "/detalhes?id",
                            templateUrl: "app/partials/projetos/detalhes.html",
                            controller: "projetosCadastroController"
                        })
                        .state("chamados", {
                            url: "/chamados",
                            abstract: true,
                            templateUrl: "app/partials/template.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("chamados.lista", {
                            url: "",
                            templateUrl: "app/partials/chamados/lista.html",
                            controller: "chamadosListaController"
                        })
                        .state("chamados.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/chamados/cadastro.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("chamados.editar", {
                            url: "/editar?id",
                            templateUrl: "app/partials/chamados/cadastro.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("chamados.detalhes", {
                            url: "/detalhes?id",
                            templateUrl: "app/partials/chamados/detalhes.html",
                            controller: "chamadosCadastroController"
                        })
                        .state("providencias", {
                            url: "^/chamados/providencias",
                            abstract: true,
                            templateUrl: "app/partials/template.html",
                            data: {
                                requerAutenticacao: true
                            }
                        })
                        .state("providencias.lista", {
                            url: "",
                            templateUrl: "app/partials/providencias/lista.html",
                            controller: "providenciasListaController"
                        })
                        .state("providencias.novo", {
                            url: "/novo",
                            templateUrl: "app/partials/providencias/cadastro.html",
                            controller: "providenciasCadastroController"
                        })
                        .state("providencias.editar", {
                            url: "^/chamados/{chamadoId}/providencias/{id}",
                            templateUrl: "app/partials/providencias/cadastro.html",
                            controller: "providenciasCadastroController"
                        })
                        .state("providencias.detalhes", {
                            url: "^/chamados/{chamadoId}/providencias/{id}/info",
                            templateUrl: "app/partials/providencias/detalhes.html",
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
                            var permissao = toState.data.permissao;
                            if (permissao) {
                                if ($.inArray(permissao, usuario.permissoes) === -1) {
                                    event.preventDefault();
                                    $state.go("sempermissao");
                                }
                            }
                        }
                    }
                });
            }]);

