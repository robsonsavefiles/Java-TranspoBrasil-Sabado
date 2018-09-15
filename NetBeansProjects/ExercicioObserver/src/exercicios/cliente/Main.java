package exercicios.cliente;

import exercicios.cliente.dao.ClienteDao;
import exercicios.cliente.model.Cliente;
import exercicios.cliente.view.presenter.AppController;

/**
 *
 * @author 78522
 */
public class Main {

    public static void main(String[] args) {
        criarClientes();

        AppController app = new AppController();
        app.irPara(Telas.PRINCIPAL);

    }

    public static void criarClientes() {
        ClienteDao.getInstance().salvar(new Cliente("Cliente 01", "43253643665", "4494949495", "Rua Rapaz que Loucura", 50, "Zueiragem", "Éoqueópolis"));
        ClienteDao.getInstance().salvar(new Cliente("Cliente 02", "64886578788", "3564747475", "Rua Bem Loka", 44, "Empolgante", "Pastos Redundantes"));
        ClienteDao.getInstance().salvar(new Cliente("Cliente 03", "79565766868", "5784235446", "Rua Pão De", 16, "Batata", "Batatópolis"));
    }
}
