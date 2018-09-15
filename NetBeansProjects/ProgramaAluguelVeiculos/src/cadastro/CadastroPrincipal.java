package cadastro;
 
import sistema.Teclado;
 
public class CadastroPrincipal {
 
    public static void main(String[] args){
 
        CadastroEsporte cadastroEsporte = new CadastroEsporte();
        CadastroCaminhao cadastroCaminhao = new CadastroCaminhao();
        CadastroOffRoad cadastroOffRoad = new CadastroOffRoad();
        CadastroOnibus cadastroOnibus = new CadastroOnibus();
 
        System.out.println("Menu");
        System.out.println("Qual tipo de veículo deseja cadastrar?:");
        System.out.println("1 - Esportivo");
        System.out.println("2 - Caminhão");
        System.out.println("3 - Off Road");
        System.out.println("4 - Onibus");
        System.out.println("5 - Sair");
        System.out.println("Opção: ");
 
        int opcao = Teclado.LerInteiro();
 
        switch(opcao){
            case 1:
                cadastroEsporte.ExecutaCadastro();
            break;
            case 2:
                cadastroCaminhao.ExecutaCadastro();
            break;
            case 3:
                cadastroOffRoad.ExecutaCadastro();
            break;
            case 4:
                cadastroOnibus.ExecutaCadastro();
            break;
            case 5:
                System.out.println("Até Logo...");
            break;
            default:
                System.out.println("Por favor, digite uma opção válida");
            break;
        }
 
    }
 
}