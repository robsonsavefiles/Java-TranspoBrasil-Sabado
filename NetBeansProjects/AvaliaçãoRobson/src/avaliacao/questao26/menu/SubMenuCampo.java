package avaliacao.questao26.menu;

import avaliacao.questao26.info.InfoCampo;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class SubMenuCampo extends SubMenu {

    public static final OpcaoMenu OPCAO_SAIR = new OpcaoMenu(null, "Cancelar e voltar ao menu anterior");

    public SubMenuCampo(String titulo, Scanner teclado, List<InfoCampo> campos) {
        super(titulo, teclado);
        int i = 1;
        for (InfoCampo campo : campos) {
            addOpcao(new OpcaoMenu(String.valueOf(i), campo.getNome(), campo));
            i++;
        }
        OPCAO_SAIR.setId(String.valueOf(i));
        addOpcao(OPCAO_SAIR);
    }

    @Override
    public boolean tratarOpcao(OpcaoMenu opcao) {
        if (opcao == OPCAO_SAIR) {
            return false;
        }
        return super.tratarOpcao(opcao);
    }

}
