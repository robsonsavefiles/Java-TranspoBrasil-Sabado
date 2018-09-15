angular.module('curso').controller('turmasNovoController', ['$scope',
    'ServicoTurmas',
    '$state',
    '$stateParams',
    function ($scope, ServicoTurmas, $state, $stateParams) {

        var self = this;
        $scope.turma = {};
        $scope.alunos = [];

        this.inicializar = function () {

            $scope.titulo = "Nova Turma";
            $scope.certificacao = {};
            if ($stateParams.idTurma) {
                self.carregarTurma($stateParams.idTurma);
                $scope.titulo = "Editar Turma";
            }
        };

        this.carregarTurma = function (id) {

            ServicoTurmas.buscarTurma(id)
                    .then(function (response) {
                        $scope.certificacao = response.data;
                    }, function (erro) {
                        alert('Não foi possível carregar a turma');
                    });

        };

        this.irParaLista = function () {
            $state.go('turmas.lista');
        };

        this.mostrarMensagemErro = function () {
            alert('Não foi possivel salvar a turma');
        };


        $scope.salvar = function (turma) {
            if (turma.id) {
                ServicoTurmas.editar(turma);
            } else {
                ServicoTurmas.incluir(turma);
            }
        };

        $scope.$on('servicoTurmasIncluirSucesso', function (event, turma) {
            self.irParaLista();
        });

        $scope.$on('servicoTurmasIncluirFalha', function (event, turma) {
            self.mostrarMensagemErro();
        });


        $scope.$on('ServicoTurmasEditarSucesso', function (event, turma) {
            self.irParaLista();
        });

        $scope.$on('ServicoTurmasEditarFalha', function (event, turma) {
            self.mostrarMensagemErro();
        });
        $scope.$on('professorSelecionado', function (event, professor) {
            $scope.turma.professor = professor;
        });

        $scope.$on('cursoSelecionado', function (event, curso) {
            $scope.turma.curso = curso;
        });

        $scope.$on('alunoSelecionado', function (event, aluno) {
            var exist = false;
            angular.forEach($scope.turmas, function (cert, key) {
                if (angular.equals(cert, aluno)) {
                    $scope.alunos.splice(key, 1);
                    $scope.turma.alunos = $scope.alunos;
                    exist = true;
                }
            });
            if (!exist) {
                $scope.alunos.push(aluno);
                $scope.turma.alunos = $scope.alunos;
            }
        });




        this.inicializar();

    }]);