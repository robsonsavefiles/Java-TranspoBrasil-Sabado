angular.module('angular-base').controller('listaEstadosController',['$scope', function($scope){
        $scope.timezone ="-0300";
        $scope.valorHora=10000.0;
        $scope.dataAtual = new Date();
        $scope.estados = ['Acre (AC)','Alagoas (AL)','Amapá (AP)','Amazonas (AM)','Bahia (BA)','Ceará (CE)','Distrito Federal (DF)','Espírito Santo (ES)',
            'Goiás (GO)','Maranhão (MA)','Mato Grosso (MT)','Mato Grosso do Sul (MS)','Minas Gerais (MG)','Pará (PA) ','Paraíba (PB)','Paraná (PR)','Pernambuco (PE)',
        'Piauí (PI)','Rio de Janeiro (RJ)','Rio Grande do Norte (RN)','Rio Grande do Sul (RS)','Rondônia (RO)','Roraima (RR)','Santa Catarina (SC)','São Paulo (SP)',
        'Sergipe (SE)','Tocantins (TO)','Tocantins (TO)'
    ];
        
       
        $scope.atual =0;
        $scope.proximo = function(){
            $scope.atual = $scope.atual +=10;
        } ;
        $scope.atual =0;
        $scope.anterior = function(){
            $scope.atual = $scope.atual -=10;
        } ;
       

}]);

