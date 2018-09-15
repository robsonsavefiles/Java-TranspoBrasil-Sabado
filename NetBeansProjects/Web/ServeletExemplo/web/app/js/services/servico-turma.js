angular.module('curso')
 .factory('ServicoTurma',
          ['$http',
          '$rootScope',
       function($http,$rootScope){
           
           return {
               
               buscarTodos: function(){
                   $http.get('turmas')
                   .then(function(response){
                       $rootScope.$broadcast('servicoTurmaBuscarTodosSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoTurmaBuscarTodosFalha',error);
                   });
               },
               
               buscarTurma: function(id){
                  return  $http.get('turmas?id='+id);
               },
               editar: function(turma){
                   $http.put('turmas',JSON.stringify(turma))
                   .then(function(response){
                       $rootScope.$broadcast('servicoTurmaEditarSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoTurmaEditarFalha',error);
                   });
               },
               incluir: function(turma){
                   $http.post('turmas',angular.toJson(turma))
                   .then(function(response){
                       $rootScope.$broadcast('servicoTurmaIncluirSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoTurmaIncluirFalha',error);
                   });
               },
               remover: function(turma){
                   $http.delete('turmas?id='+turma.id)
                   .then(function(response){
                       $rootScope.$broadcast('servicoTurmaRemoverSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoTurmaRemoverFalha',error);
                   });
               }
               
           }
       }]);

