package parte2.exercicio02.menu;

import parte2.exercicio02.operario.OperarioKg;
import parte2.exercicio02.operario.OperarioEnergia;
import java.util.Scanner;
import parte2.exercicio02.Mineradora;

/**
 *
 * @author 78522
 */
public class MenuOperarios extends Menu {

    private static final OpcaoMenu OPCAO_ADD_ENERGIA = new OpcaoMenu("1", "Adicionar Operário Energia");
    private static final OpcaoMenu OPCAO_REMOVE_ENERGIA = new OpcaoMenu("2", "Remover Operário Energia");
    private static final OpcaoMenu OPCAO_ADD_KG = new OpcaoMenu("3", "Adicionar Operário Kg");
    private static final OpcaoMenu OPCAO_REMOVE_KG = new OpcaoMenu("4", "Remover Operário Kg");
    private static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu("5", "Voltar");

    private final Mineradora mineradora;

    public MenuOperarios(Scanner scanner, Mineradora mineradora) {
        super(scanner);
        this.mineradora = mineradora;
        addOpcao(OPCAO_ADD_ENERGIA);
        addOpcao(OPCAO_REMOVE_ENERGIA);
        addOpcao(OPCAO_ADD_KG);
        addOpcao(OPCAO_REMOVE_KG);
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_ADD_ENERGIA) {
            mineradora.addOperario(new OperarioEnergia(mineradora.getFonte()));
        }
        if (opcao == OPCAO_REMOVE_ENERGIA) {
            mineradora.removeOperarioEnergia();
        }
        if (opcao == OPCAO_ADD_KG) {
            mineradora.addOperario(new OperarioKg(mineradora.getDeposito()));
        }
        if (opcao == OPCAO_REMOVE_KG) {
            mineradora.removeOperarioKg();
        }
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

}
