
package controles;

import modeloUsuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelUsuario extends AbstractTableModel{
    //colunas da tabela
    private String[] colunas = {"ID","Login","Senha","Tipo"};
    //itens da tabela
    private List<Usuario> lista = new ArrayList<Usuario>();
    
    //adiciona um contado ao tableModel
    void addContato(Usuario contato) {
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
        Usuario contato = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return contato.getId() != null ? contato.getId() : "";
            case 1:
                return contato.getLogin()!= null ? contato.getLogin(): "";
            case 2:
                return contato.getSenha()!= null ? contato.getSenha(): "";
            case 3:
                return contato.getTipo()!= null ? contato.getTipo(): "";
                    
        }
        return "";
    }
    
    //retorna o nome a ser apresentado na coluna especificada por column
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
