angular.module('curso')
        .controller('pesquisaAlunosController',
['$scope', 'ServicoAlunos',
    function($scope, ServicoAlunos){
        
        var self = this;
        
        this.inicializar = function(){
            $scope.alunos = [];
            ServicoAlunos.buscarAlunos();
        };
        
        $scope.selecionar = function(aluno){
            $scope.$emit('alunoSelecionado', aluno);
        };
        
        $scope.$on('servicoAlunosBuscarTodosSucesso', function(event, alunos){
            $scope.alunos = alunos;
        });
        
        $scope.$on('ServicoAlunosBuscarTodosFalha', function(event, erro){
            alert('Não foi possível carregar os Alunos');
        });
        
        
        this.inicializar();
        
    }]);
