angular.module('curso')
.controller('professoresListaController',
            ['$scope',
             'ServicoProfessor',
             '$state',
             function($scope,ServicoProfessor,$state){
        $scope.professores = [];
        
        $scope.editar = function(professor){
            $state.go('professores.editar',{idProfessor:professor.id});
        };
        
        $scope.remover = function(professor){
            ServicoProfessor.remover(professor);
        };
        
        $scope.$on('servicoProfessorBuscarTodosSucesso',
        function(event,professores){
            $scope.professores = professores;
        });
        
        $scope.$on('servicoProfessorBuscarTodosFalha',
        function(event,erro){
            alert('Falha ao carregar os Professores');
        });
        
         $scope.$on('servicoProfessorRemoverSucesso',
        function(event,professorRemovido){
            var item = null;
            angular.forEach($scope.professores,function(professor){
                if(professor.id === professorRemovido.id){
                    item = professor;
                }
            });
            var index = $scope.professores.indexOf(item);
            if(index > -1){
                $scope.professores.splice(index,1);
            }
            
        });
        
        $scope.$on('servicoProfessorRemoverFalha',
        function(event,erro){
            alert('Falha ao excluir o Professor');
        });
        
        ServicoProfessor.buscarTodos();
        
        
}]);


