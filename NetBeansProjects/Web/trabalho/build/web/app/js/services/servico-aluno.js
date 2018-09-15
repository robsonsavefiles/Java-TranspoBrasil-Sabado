angular.module('curso')
 .factory('ServicoAluno',
          ['$http',
           '$rootScope',
       function($http,$rootScope){
           
           return {
               
               buscarTodos: function(){
                   $http.get('alunos')
                   .then(function(response){
                       $rootScope.$broadcast('servicoAlunoBuscarTodosSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoAlunoBuscarTodosFalha',error);
                   });
               },
               
               buscarAluno: function(id){
                  return  $http.get('alunos?id='+id);
               },
               editar: function(aluno){
                   $http.put('alunos',JSON.stringify(aluno))
                   .then(function(response){
                       $rootScope.$broadcast('servicoAlunoEditarSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoAlunoEditarFalha',error);
                   });
               },
               incluir: function(aluno){
                   $http.post('alunos',angular.toJson(aluno))
                   .then(function(response){
                       $rootScope.$broadcast('servicoAlunoIncluirSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoAlunoIncluirFalha',error);
                   });
               },
               remover: function(aluno){
                   $http.delete('alunos?id='+aluno.id)
                   .then(function(response){
                       $rootScope.$broadcast('servicoAlunoRemoverSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoAlunoRemoverFalha',error);
                   });
               }
               
           };
       }]);

