/*
 * Seu João é dono de uma oficina e necessita de um sistema para cadastrar informações dos veículos que passam pela sua oficina
 Após uma análise inicial foi decidido que o sistema será construido e disponibilizado em iterações e, para a primeira iteração,
 ficou definido que o sistema deve disponibilizar o cadastro de veículos, sendo que para cada veículo cadastrado deve ser armazenada
 as informações referente a placa, cor, modelo, marca, ano fabricação, ano modelo. O analista também identificou que as informações 
 cadastradas devem possuir a data de criação e a data da ultima alteração(dataHora), as informações referente a placa modelo ano de 
 fabricação e ano modelo são obrigatórias e não devem possuir valores vazios, o ano de fabricação e ano modelo não deve ser menor que 1900,
 o ano de fabricação não pode ser maior que o ano da data atual, e o ano modelo não pode ser maior que o ano da data atual mais um . 
 O Arquiteto do projeto decidiu que inicialmente as informações de cadastro devem ser armazenadas em arquivos e todos os dados de
 veiculos devem ser armazenados do arquivo veiculos.txt.


 Requisitos
 #######Cadatro de veiculos######
 Inserir;
 Editar;
 Buscar;
 Remover;

 ######Informaçoes Veiculos#######
 Id
 placa
 modelo
 anoModelo;
 anoFabricacao
 cor
 marca
 dataCricao
 dataAlteraçao

 ######Restriçoes##########
 anoFabricacao >=1900 && anoFabricacao <= anoAtual
 anoModelo >= 1900 E anoModelo <=anoAtual + 1(nao podem ficar vazios)
 id => nao vazio
 dataCriacao => nao vazio
 dataAlteracao => nao vazio
 placa => nao vazio
 modelo => nao vazio

 ===============================================================================
 Classe Base : Entidade
 Id
 dataCricao
 dataAlteraçao
 ===============================================================================
 Classe Veiculo extends Entidade
 placa
 cor 
 marca
 modelo
 anoFabricao
 anoModelo
 ===============================================================================
 ValidadorVeiculo
 metodo:
 + isValido(veiculo) : boolean
 + getErros() : ArrayList<Erro>
 ######Restriçoes##########
 anoFabricacao >=1900 && anoFabricacao <= anoAtual
 anoModelo >= 1900 E anoModelo <=anoAtual + 1(nao podem ficar vazios)
 id => nao vazio
 dataCriacao => nao vazio
 dataAlteracao => nao vazio
 placa => nao vazio
 modelo => nao vazio

 ===============================================================================
 CadastroVeiculo
 +listar();
 +adicionar();
 +editar();
 +remover();
 +buscarPorPlaca();
 +listarPorMarca();
 +listarModelo();
 +listarPorAnoFabricacao();
 +listarPorAnoModelo();
 ===============================================================================
 RepositorioVeiculo
 +salvar
 +remover;
 +buscarPorId();
 +buscarTodos();
 +buscarPorPlaca();
 +buscarPorMarca();
 +buscarModelo();
 +buscarPorAnoFabricacao();
 +buscarPorAnoModelo();
 ===============================================================================
 Erro
 campo
 descrição
 */
package projetomecanica;

import java.io.File;

public class ProjetoMecanicaApp {
    private static String nomeArquivo;

    public static void main(String[] args) {
        
        Entidade entidade = new Entidade();
        Veiculo veiculo = new Veiculo();
        ValidadorVeiculo validadorveiculo = new ValidadorVeiculo();
        CadastroVeiculo cadastroveiculo = new CadastroVeiculo();
        RepositorioMecanica repositoriomecanica = new RepositorioMecanica();
        DadosMecanica dadosmecanica = new DadosMecanica();
        ErroMecanica erromecanica = new ErroMecanica();
        LerOsDados lerdados = new LerOsDados();
        

        cadastroveiculo.menu();
        DadosMecanica.gravarDadosMecanica(veiculo, new File("veiculos.txt"));
        LerOsDados.lerDados(nomeArquivo);
    }

}
