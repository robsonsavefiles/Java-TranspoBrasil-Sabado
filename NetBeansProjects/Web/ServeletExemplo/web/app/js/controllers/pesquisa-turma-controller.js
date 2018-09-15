angular.module('curso')
        .controller('pesquisaTurmaController',
['$scope','ServicoTurma',function($scope,ServicoTurma){
    
    var self = this;
    
    this.inicializar = function(){
      $scope.turmas = [];
      ServicoTurma.buscarTodos();  
    };
    
    $scope.selecionar = function(turma){
        $scope.$emit('turmaSelecionado',turma);
    };
    
    $scope.$on('servicoTurmaBuscarTodosSucesso',
    function(event, turmas){
        $scope.turmas = turmas;
    });
    $scope.$on('servicoTurmaBuscarTodosFalha',
    function(event, erro){
        alert('Não foi possível carregar as turmas');
    });
    
    this.inicializar();
        
}]);

