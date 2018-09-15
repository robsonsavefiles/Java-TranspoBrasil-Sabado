
package controlePacienteUti;

import controleUsuario.*;
import modeloUsuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Paciente;

public class TableModelPaciente extends AbstractTableModel{
   
    private String[] colunas = {"ID","Situaçao","Nome","Procedimento","Data Entrada","Data Saida"};
    
    private List<Paciente> lista = new ArrayList<Paciente>();
    
    
    void addPaciente(Paciente paciente ){
        lista.add(paciente);
       
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
        Paciente paciente = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return paciente.getId() != null ? paciente.getId() : "";
            case 1:
                return paciente.getSituacao()!= null ? paciente.getSituacao(): "";
            case 2:
                return paciente.getNome()!= null ? paciente.getNome(): "";
            case 3:
                return paciente.getDataEntrada()!= null ? paciente.getDataEntrada(): "";
            case 4:
                  return paciente.getDatasaida()!= null ? paciente.getDatasaida(): "";  
        }
        return "";
    }
    
    //retorna o nome a ser apresentado na coluna especificada por column
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
