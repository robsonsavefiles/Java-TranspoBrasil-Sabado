angular.module('curso').controller('alunosNovoController', ['$scope',
                    'ServicoAlunos',
                    '$state',
                    '$stateParams',
                    function ($scope, ServicoAlunos, $state, $stateParams) {

                        var self = this;


                        this.inicializar = function () {

                            $scope.titulo = "Novo Aluno";
                            $scope.aluno = {};
                            if ($stateParams.idAluno) {
                                self.carregarCertificacao($stateParams.idAluno);
                                $scope.titulo = "Editar Aluno";
                            }
                        };

                        this.carregarCertificacao = function (id) {

                            ServicoAlunos.buscarAluno(id)
                                    .then(function (response) {
                                        $scope.aluno = response.data;
                                    }, function (erro) {
                                        alert('Não foi possível carregar o aluno');
                                    });

                        };

                        this.irParaLista = function () {
                            $state.go('alunos.lista');
                        };

                        this.mostrarMensagemErro = function () {
                            alert('Não foi possivel salvar o Aluno');
                        };


                        $scope.salvar = function (aluno) {
                            if (aluno.id) {
                                ServicoAlunos.editar(aluno);
                            } else {
                                ServicoAlunos.incluir(aluno);
                            }
                        };


                        $scope.$on('servicoAlunoIncluirSucesso', function (event, aluno) {
                            self.irParaLista();
                        });

                        $scope.$on('servicoAlunoIncluirFalha', function (event, aluno) {
                            self.mostrarMensagemErro();
                        });


                        $scope.$on('ServicoAlunoEditarSucesso', function (event, aluno) {
                            self.irParaLista();
                        });

                        $scope.$on('ServicoAlunoEditarFalha', function (event, aluno) {
                            self.mostrarMensagemErro();
                        });



                        this.inicializar();

                    }]);