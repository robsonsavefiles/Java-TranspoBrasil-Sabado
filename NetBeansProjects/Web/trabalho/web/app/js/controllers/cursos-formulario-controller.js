angular.module('curso')
        .controller('cursosFormularioController',
                ['$scope',
                    'ServicoCurso',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoCurso, $state, $stateParams) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.curso = {};
                            $scope.titulo = "Novo Curso";
                            if ($stateParams.idCurso) {
                                self.carregarCurso($stateParams.idCurso);
                                $scope.titulo = "Editar Curso";
                            }
                        };
                        this.carregarCurso = function (id) {
                            ServicoCurso.buscarCurso(id)
                                    .then(function (response) {
                                        $scope.curso = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o curso [:(]');
                                    });
                        };

                        this.irParaLista = function () {
                            $state.go('cursos.lista');
                        };
                        this.mostrarMensagemErro = function () {
                            alert('Não foi possível  Salvar o Curso [:(]');
                        };

                        $scope.salvar = function (curso) {
                            if (curso.id) {
                                ServicoCurso.editar(curso);
                            } else {
                                ServicoCurso.incluir(curso);
                            }
                        };

                        $scope.$on('coordenadorSelecionado', function (event, coordenador) {
                            $scope.curso.coordenador = coordenador;
                        });

                        $scope.$on('servicoCursoIncluirSucesso', function (event, curso) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoCursoIncluirFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('servicoCursoEditarSucesso', function (event, curso) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoCursoEditarFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('professorSelecionado', function (event, coordenador) {
                            $scope.curso.coordenador = coordenador;
                        });


                        this.inicializar();

                    }]);


