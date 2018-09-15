package hospital.view.controller;

import modelo.Visitante;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelVisitante extends AbstractTableModel {

    private List<Visitante> lista;

    public TableModelVisitante(List<Visitante> lista) {
        this.lista = lista;
    }

    public void updateLista(List<Visitante> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return TableInfoVisitante.getColunas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableInfoVisitante visitante = getRow(rowIndex);
        return visitante.getLinha()[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return TableInfoVisitante.getColunas()[column];
    }

    public Long getRowId(int rowIndex) {
        return lista.get(rowIndex).getId();
    }

    public Visitante getRow(int rowIndex) {
        return lista.get(rowIndex);
    }

}
