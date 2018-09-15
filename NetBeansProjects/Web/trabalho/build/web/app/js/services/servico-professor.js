angular.module('curso')
 .factory('ServicoProfessor',
          ['$http',
           '$rootScope',
       function($http,$rootScope){
           
           return {
               buscarTodos: function(){
                   $http.get('professores')
                   .then(function(response){
                       $rootScope.$broadcast('servicoProfessorBuscarTodosSucesso',response.data);
                   },function(error){
                       $rootScope.$broadcast('servicoProfessorBuscarTodosFalha',error);
                   });
               }
           };
       }]);

