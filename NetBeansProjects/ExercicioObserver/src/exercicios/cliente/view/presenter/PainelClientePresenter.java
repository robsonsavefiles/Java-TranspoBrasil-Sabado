package exercicios.cliente.view.presenter;

import exercicios.cliente.EventoClienteSelecionado;
import exercicios.cliente.NotificadorDeEventos;
import exercicios.cliente.OuvinteDeEventos;
import exercicios.cliente.model.Cliente;

/**
 *
 * @author 78522
 */
public class PainelClientePresenter implements OuvinteDeEventos<EventoClienteSelecionado>, Presenter {

    public static interface Display {

        void setNome(String nome);

        void setCpf(String cpf);

        void setTelefone(String telefone);

        void setEndereco(String endereco);

        void setNumero(String numero);

        void setBairro(String bairro);

        void setCidade(String cidade);

        String getNome();

        String getCpf();

        String getTelefone();

        String getEndereco();

        String getNumero();

        String getBairro();

        String getCidade();

    }

    private final Display display;
    private Cliente obj;

    public PainelClientePresenter(Display display) {
        this.display = display;
    }

    public void atualizarDados() {
        display.setNome(obj.getNome());
        display.setCpf(obj.getCpf());
        display.setTelefone(obj.getTelefone());
        display.setEndereco(obj.getEndereco());
        display.setNumero(String.valueOf(obj.getNumero()));
        display.setBairro(obj.getBairro());
        display.setCidade(obj.getCidade());
    }

    @Override
    public void bind() {
        NotificadorDeEventos instance = NotificadorDeEventos.getInstance();
        instance.registrarOuvinte(this);
    }

    @Override
    public void onEventoDisparado(EventoClienteSelecionado item) {
        this.obj = item.getCliente();
        atualizarDados();
    }

    @Override
    public String getTipo() {
        return EventoClienteSelecionado.class.getName();
    }

}
