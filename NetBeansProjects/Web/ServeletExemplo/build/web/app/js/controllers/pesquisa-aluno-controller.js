angular.module('curso')
        .controller('pesquisaAlunoController',
['$scope','ServicoAluno',function($scope,ServicoAluno){
    
    var self = this;
    
    this.inicializar = function(){
      $scope.alunos = [];
      ServicoAluno.buscarTodos();  
    };
    
    $scope.selecionar = function(aluno){
        $scope.$emit('alunoSelecionado',aluno);
    };
    
    $scope.$on('servicoAlunoBuscarTodosSucesso',
    function(event, alunos){
        $scope.alunos = alunos;
    });
    $scope.$on('servicoAlunoBuscarTodosFalha',
    function(event, erro){
        alert('Não foi possível carregar as Alunos');
    });
    
    this.inicializar();
        
}]);

