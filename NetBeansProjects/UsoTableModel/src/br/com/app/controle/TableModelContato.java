
package br.com.app.controle;

import br.com.app.modelo.Contato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelContato extends AbstractTableModel{
    //colunas da tabela
    private String[] colunas = {"ID","Nome","Telefone"};
    //itens da tabela
    private List<Contato> lista = new ArrayList<Contato>();
    
    //adiciona um contado ao tableModel
    void addContato(Contato contato) {
        lista.add(contato);
        //notifica a tabela que ela deve se atualizar
        fireTableDataChanged();
    }

    //informa a quantidade de linhas da tabela
    @Override
    public int getRowCount() {
        return lista.size();
    }

       //informa a quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

        //pupula a tabela coluna por coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contato contato = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return contato.getId() != null ? contato.getId() : "";
            case 1:
                return contato.getNome()!= null ? contato.getNome(): "";
            case 2:
                return contato.getTelefone()!= null ? contato.getTelefone(): "";
        }
        return "";
    }
    
    //retorna o nome a ser apresentado na coluna especificada por column
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
