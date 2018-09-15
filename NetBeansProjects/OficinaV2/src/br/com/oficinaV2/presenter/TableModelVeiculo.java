
package br.com.oficinaV2.presenter;



import br.com.oficinaV2.modelo.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelVeiculo extends AbstractTableModel{
    
    
    private String[] colunas = {"Placa","Cor","Marca","Modelo","Ano De Fabricação","Ano Modelo"};
   
    private List<Veiculo> lista = new ArrayList<Veiculo>();
    
   
    void addContato(Veiculo veiculo) {
        lista.add(veiculo);
        
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
        Veiculo veiculo = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo != null && veiculo.getPlaca() != null ? veiculo.getPlaca() : "";
            case 1:
                return veiculo != null && veiculo.getMarca() != null ? veiculo.getMarca() : "";
            case 2:
                return veiculo != null && veiculo.getModelo() != null ? veiculo.getModelo() : "";
            case 3:
                return veiculo != null ? String.valueOf(veiculo.getAnoFabricacao()) : "";
            case 4:
                return veiculo != null ? String.valueOf(veiculo.getAnoModelo()) : "";
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    void setVeiculos(List<Veiculo> lista) {
        this.lista.clear();
        this.lista.addAll(lista);
        fireTableDataChanged();
    }
}
