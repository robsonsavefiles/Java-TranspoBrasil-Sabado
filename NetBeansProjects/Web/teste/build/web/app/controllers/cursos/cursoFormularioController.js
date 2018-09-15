angular.module('curso')
        .controller('cursosFormularioController',
                ['$scope',
                    'ServicoCurso',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoCurso, $state, $stateParams) {

                        var self = this;


                        this.inicializar = function () {

                            $scope.titulo = "Novo Curso";
                            $scope.curso = {};
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
                                        alert('Não foi possível carregar o curso');
                                    });

                        };

                        this.irParaLista = function () {
                            $state.go('cursos.lista');
                        };

                        this.mostrarMensagemErro = function () {
                            alert('Não foi possivel salvar o Curso');
                        };


                        $scope.salvar = function (curso) {
                            if (curso.id) {
                                ServicoCurso.editar(curso);
                            } else {
                                ServicoCurso.incluir(curso);
                            }
                        };


                        $scope.$on('professorSelecionado', function (event, professor) {
                            $scope.curso.professor = professor;
                        });

                        $scope.$on('ServicoCursoIncluirSucesso', function (event, curso) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoCursoIncluirFalha', function (event, curso) {
                            self.mostrarMensagemErro();
                        });


                        $scope.$on('ServicoCursoEditarSucesso', function (event, curso) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoCursoEditarFalha', function (event, curso) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('professorSelecionado', function (event, professor) {
                            $scope.curso.professor = professor;
                        });


                        this.inicializar();

                    }]);