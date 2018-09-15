package br.com.proway.java.eventbus;

import br.com.proway.java.eventbus.Cliente;



import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelCliente extends AbstractTableModel {

    private String[] colunas = {"Nome", "CPF", "Telefone"};

    private List<Cliente> lista = new ArrayList<Cliente>();

    void addContato(Cliente contato) {
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

   public Cliente getItem(int rowIndex){
        return null;
   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


