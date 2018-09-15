package br.com.oficinaV2.presenter;

import br.com.oficinaV2.modelo.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 89087
 */
class TableModelCliente extends AbstractTableModel {

    String[] colunas = {"Nome", "CPF", "Placa do Veiculo", "Telefone", "Endereço"};
    List<Cliente> lista = new ArrayList<>();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cliente != null && cliente.getNome()!= null ? cliente.getNome() : "";
            case 1:
                return cliente != null && cliente.getCpf() != null ? cliente.getCpf() : "";
            case 2:
                return cliente != null && cliente.getPlacadocarro()!= null ? cliente.getPlacadocarro(): "";
            case 3:
                return cliente != null && cliente.getTelefone()!= null ? cliente.getTelefone(): "";
            case 4:
              return cliente != null && cliente.getEndereco()!= null ? cliente.getEndereco(): "";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    void setCliente(List<Cliente> lista) {
        this.lista.clear();
        this.lista.addAll(lista);
        fireTableDataChanged();
    }
}
