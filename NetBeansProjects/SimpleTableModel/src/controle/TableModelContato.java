
package controle;

import modelo.Contato;
import modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelContato extends AbstractTableModel{
    private String[] colunas = {"Nome","ID","Telefone"};
    private List<Contato> lista = new ArrayList<Contato>();
    
    public void addContato(Contato contato) {
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
        switch(columnIndex){
            case 0:
                return contato.getId();
            case 1:
                return contato.getNome();
            case 2:
                return contato.getTelefone();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
