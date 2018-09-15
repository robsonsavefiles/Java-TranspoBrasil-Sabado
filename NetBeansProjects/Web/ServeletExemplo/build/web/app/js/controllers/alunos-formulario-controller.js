angular.module('curso')
        .controller('alunosFormularioController',
                ['$scope',
                    'ServicoAluno',
                    '$state',
                    '$stateParams',
                    function ($scope,ServicoAluno,$state,$stateParams) {

                        var self = this;
                        this.inicializar = function () {
                            $scope.aluno = {};
                            $scope.titulo = "Novo Aluno";
                            if ($stateParams.idAluno) {
                                self.carregarAluno($stateParams.idAluno);
                                $scope.titulo = "Editar Aluno";
                            }
                        };
                        this.carregarAluno = function (id) {
                            ServicoAluno.buscarAluno(id)
                                    .then(function (response) {
                                        $scope.aluno = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o Aluno [:(]');
                                    });
                        };

                        this.irParaLista = function () {
                            $state.go('alunos.lista');
                        };
                        this.mostrarMensagemErro = function () {
                            alert('Não foi possível  Salvar o Aluno [:(]');
                        };

                        $scope.salvar = function (aluno) {
                            if (aluno.id) {
                                ServicoAluno.editar(aluno);
                            } else {
                                ServicoAluno.incluir(aluno);
                            }
                        };

                        $scope.$on('alunoSelecionado', function (event, aluno) {
                            $scope.aluno.curso = aluno;
                        });

                        $scope.$on('servicoAlunoIncluirSucesso', function (event, aluno) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoAlunoIncluirFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });
                        $scope.$on('servicoAlunoEditarSucesso', function (event, curso) {
                            self.irParaLista();
                        });
                        $scope.$on('servicoAlunoEditarFalha', function (event, erro) {
                            self.mostrarMensagemErro();
                        });

                        $scope.$on('AlunoSelecionado', function (event, aluno) {
                            $scope.aluno.curso = aluno;
                        });


                        this.inicializar();

                    }]);


