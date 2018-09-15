/*

 */
package cadastroclientes;

import exer26_cadastroProdutos.CadastrarVeiculo;
import exer26_cadastroProdutos.Entidade;
import exer26_cadastroProdutos.Veiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 88178
 */
public class ProdutoApp {

    /**
     * @param args the command line arguments
     */
    public static final String CONSTANTE = "Veiculo.txt";

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CadastrarVeiculo cadastro = new CadastrarVeiculo();
        cadastro.setTeclado(teclado);
        cadastro.menu();

        teclado.close();
    }

    public static void gravarUtilizandoFilerPrintWriter(File file, Veiculo veiculos) {
        Entidade et = new Entidade();
        try (PrintWriter print = new PrintWriter(new FileWriter(file, true))) {

            print.println(veiculos.getId());
            print.println(";" + veiculos.getDataCriacao());
            print.println(";" + veiculos.getDataAltercao());
            print.println(";" + veiculos.getPlaca());
            print.println(";" + veiculos.getModelo());
            print.println(";" + veiculos.getMarca());
            print.println(";" + veiculos.getCor());
            print.println(";" + veiculos.getAnoModelo());
            print.println(";" + veiculos.getAnoFabricacao());

            print.flush();

        } catch (Exception e) {
            System.out.println("Falha na gravação do arquivo");
        }
    }

//    public static void leitorEasy(Veiculo veiculo){
//        String filename ="P:\\Material Java Philips\\ProjetosNetBeans\\Aula12\\Veiculo.txt";
//         
//        RepositorioVeiculos repositorio = new RepositorioVeiculos();
//      FileReader filerR = null;
//      String line =null;
//        try {
//            filerR = new FileReader("Veiculo.txt");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ProdutoApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//			BufferedReader bufferR = new BufferedReader(filerR);
//			
//			StringBuilder sb = new StringBuilder();
//			
//        try {
//            while ((line = bufferR.readLine()) != null) {
//                String[] arr = line.split("-");
//                
//                Veiculo novoVeiculo = new Veiculo(Long id, String placa, String modelo, 
//                String marca, int anoModelo,int anoFabricao);
//                
//                novoVeiculo.setPlaca(arr[0]);
//               
//                novoVeiculo.setModelo(arr[3]);
//                novoVeiculo.setMarca(arr[4]);
//                novoVeiculo.setCor(arr[5]);
//                novoVeiculo.setAnoModelo(Integer.parseInt(arr[6]));
//                novoVeiculo.setAnoFabricacao(Integer.parseInt(arr[7]));
//                
//                
//                
//                repositorio.salvar(novoVeiculo);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ProdutoApp.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Arquivo não encontrado");
//        }
//    }
}
