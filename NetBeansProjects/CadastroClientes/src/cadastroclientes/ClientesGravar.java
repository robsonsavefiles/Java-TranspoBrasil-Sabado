package cadastroclientes;



import cadastroclientes.CadastroClientes;
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
public class ClientesGravar {

    /**
     * @param args the command line arguments
     */
    
    public static final String CONSTANTE = "Veiculo.txt";
    public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in);
   
        CadastroClientes cadastro = new CadastroClientes();
        cadastro.setTeclado(teclado);
        cadastro.menu();

         
        teclado.close();
    }

    public static void gravarUtilizandoFilerPrintWriter(File file, Cliente clientes) {
        Entidade et = new Entidade();
        try (PrintWriter print = new PrintWriter(new FileWriter(file, true))) {

            print.println(clientes.getId());
            print.println(";"+clientes.getNome());
            print.println(";"+clientes.getCpf(CONSTANTE));
            print.println(";" + clientes.getTelefone());
            

            print.flush();

        } catch (Exception e) {
            System.out.println("Falha na gravação do arquivo");
        }
    }
}
    