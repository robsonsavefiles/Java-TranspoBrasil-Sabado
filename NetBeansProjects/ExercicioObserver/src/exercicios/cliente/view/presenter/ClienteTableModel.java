package exercicios.cliente.view.presenter;

import exercicios.cliente.ClienteTableInfo;
import exercicios.cliente.model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 78522
 */
public class ClienteTableModel extends AbstractTableModel {

    private List<Cliente> lista;

    public ClienteTableModel(List<Cliente> lista) {
        this.lista = lista;
    }

    public void update(List<Cliente> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return ClienteTableInfo.getColunas().length;
    }

    @Override
    public String getColumnName(int column) {
        return ClienteTableInfo.getColunas()[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        ClienteTableInfo linha = lista.get(row);
        return linha.getLinha()[column];
    }

    public Cliente getLinha(int linha) {
        return lista.get(linha);
    }

}
