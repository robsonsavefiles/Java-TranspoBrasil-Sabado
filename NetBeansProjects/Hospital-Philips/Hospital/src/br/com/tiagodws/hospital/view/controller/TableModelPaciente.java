package br.com.tiagodws.hospital.view.controller;

import br.com.tiagodws.hospital.model.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 78522
 */
public class TableModelPaciente extends AbstractTableModel {

    private List<Paciente> lista;

    public TableModelPaciente(List<Paciente> lista) {
        this.lista = lista;
    }

    public void updateLista(List<Paciente> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return TableInfoPaciente.getColunas().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableInfoPaciente paciente = getRow(rowIndex);
        return paciente.getLinha()[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return TableInfoPaciente.getColunas()[column];
    }

    public Paciente getRow(int rowIndex) {
        return lista.get(rowIndex);
    }

}
