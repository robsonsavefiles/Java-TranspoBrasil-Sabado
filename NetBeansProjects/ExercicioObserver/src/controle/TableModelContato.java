package controle;

import modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelContato extends AbstractTableModel {

    private String[] colunas = {"Nome", "CPF", "Telefone"};

    private List<Contato> lista = new ArrayList<Contato>();

    void addContato(Contato contato) {
        lista.add(contato);

        fireTableDataChanged();
    }

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
        Contato contato = lista.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return contato.getNome() != null ? contato.getNome() : "";
            case 1:
                return contato.getCpf() != null ? contato.getCpf() : "";
            case 2:
                return contato.getTelefone() != null ? contato.getTelefone() : "";
//            case 3:
//                return contato.getNumero() != null ? contato.getNumero() : "";
//            case 4:
//                return contato.getBairro() != null ? contato.getBairro() : "";
//            case 5:
//                return contato.getCidade() != null ? contato.getCidade() : "";

        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
