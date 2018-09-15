package br.com.proway.java.eventbus;

import br.com.proway.java.builder.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 89087
 */
public class ClienteTableModel extends AbstractTableModel {

    private String[] colunas = {"Nome", "CPF"};
    private List<Cliente> lista;

    public ClienteTableModel(List<Cliente> lista) {
        this.lista = lista;
    }

    public void updateLista(List<Cliente> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return ClienteTableModel.getColunas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClienteTableModel cliente = getRow(rowIndex);
        return cliente.getLinha()[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return ClienteTableModel.getColunas()[column];
    }

    public Cliente getRow(int rowIndex) {
        return lista.get(rowIndex);
    }

}

    
   private void iniciarValores(){
       
   }
}
