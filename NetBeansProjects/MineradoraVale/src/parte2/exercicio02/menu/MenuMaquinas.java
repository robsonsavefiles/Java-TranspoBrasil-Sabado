package parte2.exercicio02.menu;

import parte2.exercicio02.maquina.MaquinaGrande;
import parte2.exercicio02.maquina.MaquinaPequena;
import java.util.Scanner;
import parte2.exercicio02.Mineradora;

/**
 *
 * @author 78522
 */
public class MenuMaquinas extends Menu {

    private static final OpcaoMenu OPCAO_ADD_GRANDE = new OpcaoMenu("1", "Adicionar Máquina Grande");
    private static final OpcaoMenu OPCAO_REMOVE_GRANDE = new OpcaoMenu("2", "Remover Máquina Grande");
    private static final OpcaoMenu OPCAO_ADD_PEQUENA = new OpcaoMenu("3", "Adicionar Máquina Pequena");
    private static final OpcaoMenu OPCAO_REMOVE_PEQUENA = new OpcaoMenu("4", "Remover Máquina Pequena");
    private static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("5", "Voltar");

    private final Mineradora mineradora;

    public MenuMaquinas(Scanner scanner, Mineradora mineradora) {
        super(scanner);
        this.mineradora = mineradora;
        addOpcao(OPCAO_ADD_GRANDE);
        addOpcao(OPCAO_REMOVE_GRANDE);
        addOpcao(OPCAO_ADD_PEQUENA);
        addOpcao(OPCAO_REMOVE_PEQUENA);
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_ADD_GRANDE) {
            mineradora.addMaquina(new MaquinaGrande(mineradora.getDeposito(), mineradora.getFonte()));
        }
        if (opcao == OPCAO_REMOVE_GRANDE) {
            mineradora.removeMaquinaGrande();
        }
        if (opcao == OPCAO_ADD_PEQUENA) {
            mineradora.addMaquina(new MaquinaPequena(mineradora.getDeposito(), mineradora.getFonte()));
        }
        if (opcao == OPCAO_REMOVE_PEQUENA) {
            mineradora.removeMaquinaPequena();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

}
