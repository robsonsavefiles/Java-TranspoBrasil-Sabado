 angular.module('lab').directive('philInput',function (){
                                    
                                    return{
                                        restrict:'E',
                                        replace:true,
                                        scope:{
                                            colClass:'@',
                                            label:'@',
                                            inputName:'@',
                                            placeholder:'@',
                                            type:'@',
                                            model:'='
                                        },
                                        templateUrl:'app/partials/paginas/directives/inputForm.html',
                                        
                                    };
                        });

