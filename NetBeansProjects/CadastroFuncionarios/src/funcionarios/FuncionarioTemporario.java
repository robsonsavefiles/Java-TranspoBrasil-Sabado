/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionarios;

/**
 *
 * @author Robinho
 */

   
    
 
public class FuncionarioTemporario extends Funcionario{
 
    private String dataInicio;
    private String duracaoMeses;
 
    public FuncionarioTemporario() {
    }
 
    public FuncionarioTemporario(int _numeroRegistro, String _nome, String _funcao, float _salario, String _situacao, String _dataInicio, String _duracaoMeses){
        numeroRegistro = _numeroRegistro;
        nome = _nome;
        funcao = _funcao;
        salario = _salario;
        situacao = _situacao;
        dataInicio = _dataInicio;
        duracaoMeses = _duracaoMeses;
    }
 
    public void DefinirDataInicio(String _dataInicio){
        dataInicio = _dataInicio;
    }
 
    public String ObterDataInicio(){
        return(dataInicio);
    }
 
    public void DefinirDuracaoMeses(String _duracaoMeses){
        duracaoMeses = _duracaoMeses;
    }
 
    public String ObterDuracaoMeses(){
        return(duracaoMeses);
    }
}
    
    
    

