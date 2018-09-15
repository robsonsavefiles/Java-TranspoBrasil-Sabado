package hospital.view.controller;

import modelo.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelUsuario extends AbstractTableModel {

    private List<Usuario> lista;

    public TableModelUsuario(List<Usuario> lista) {
        this.lista = lista;
    }

    public void updateLista(List<Usuario> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return TableInfoUsuario.getColunas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableInfoUsuario usuario = getRow(rowIndex);
        return usuario.getLinha()[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return TableInfoUsuario.getColunas()[column];
    }

    public Usuario getRow(int rowIndex) {
        return lista.get(rowIndex);
    }

}
