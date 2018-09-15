
package br.com.proway.java.eventbus;

/**
 *
 * @author 89087
 */
public class FormularioClientePresenter implements Presenter,OuvinteDeEventos<EventoClienteSelecionado>{
    
    private Display view;

    @Override
    public void onEventoDisparado(EventoClienteSelecionado item) {
        
        
    }

    
    private static interface Display{
        public void setNome(String nome);
        public void setCpf(String cpf);
        public void setTelefone(String telefone);
        public void setEndereco(String endereco);
        public void setNumero(String numero);
        public void setBairro(String cidade);
        
    }

    public FormularioClientePresenter(Display view) {
        this.view = view;
    }
    
   
    @Override
    public void bind() {
        
        
    }
    @Override
    public void onEventoDisparado(Object item) {
        Cliente cliente  = item.getCliente();
        view.setNome(cliente.getNome());
        view.setCpf(cliente.getCpf());
        view.setEndereco(cliente.getEndereco);
        view.setBairro(cliente.getBairro());
        view.setCidade(cliente.getCidade());
    }

    @Override
    public String getTipo() {
        return EventosClienteSelecionado.class.getName();
    }
}
