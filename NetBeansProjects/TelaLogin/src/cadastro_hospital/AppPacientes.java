package cadastro_hospital;

import cadastro_hospital.CadastroPacientes;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class AppPacientes {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CadastroPacientes cadastro = new CadastroPacientes(teclado);
        RepositorioPaciente repositorio = new RepositorioPaciente();
        
        Usuario usuario1 = new Usuario("Robson","robinho123",TiposDeUsuario.ATENDENTE);
        Usuario usuario2 = new Usuario("Tiago","tiago123",TiposDeUsuario.GERENTE);
        Usuario usuario3 = new Usuario("Fernando","fernando",TiposDeUsuario.MEDICO);
        
        
        cadastro.mostrarMenu();
        
        
    }
}
