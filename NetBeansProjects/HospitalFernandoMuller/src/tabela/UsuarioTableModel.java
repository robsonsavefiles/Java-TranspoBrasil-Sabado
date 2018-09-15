/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

import dados.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 88178
 */
public class UsuarioTableModel extends AbstractTableModel {

    //colunas da tabela
    private final String[] colunas = {"Id", "Login", "Senha", "Tipo"};
    //itens da tabela
    private List<Usuario> lista;

    public UsuarioTableModel(List<Usuario> lista) {
        this.lista = lista;

    }

    public void atualizarTabela(List<Usuario> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    //adiciona um contado ao tableModel

    void addContato(Usuario usuario) {
        lista.add(usuario);
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
        Usuario usuario = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return usuario.getId() != null ? usuario.getId() : "";
            case 1:
                return usuario.getLogin() != null ? usuario.getLogin() : "";
            case 2:
                return usuario.getSenha() != null ? usuario.getSenha() : "";
            case 3:
                return usuario.getTipo() != null ? usuario.getTipo() : "";
        }
        return "";
    }

    //retorna o nome a ser apresentado na coluna especificada por column
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public Usuario getRow(int row) {
        return lista.get(row);
    }
}
