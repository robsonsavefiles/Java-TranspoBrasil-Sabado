
package controles;


import modeloUsuario.Usuario;
import modeloVisitante.Visitante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelVisitante extends AbstractTableModel{
    //colunas da tabela
    private String[] colunas = {"ID","ID_paciente","Nome","Status"};
    //itens da tabela
    private List<Visitante> lista = new ArrayList<Visitante>();
    
    //adiciona um contado ao tableModel
    void addVisitante(Visitante visitante) {
        lista.add(visitante);
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
        Visitante visitante = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return visitante.getId_paciente() != null ? visitante.getId_paciente(): "";
            case 1:
                return visitante.getNome()!= null ? visitante.getNome(): "";
            case 2:
                return visitante.getStatus()!= null ? visitante.getStatus(): "";
               
        }
        return "";
    }
    
    //retorna o nome a ser apresentado na coluna especificada por column
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
