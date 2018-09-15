package cadastro_hospital;

import cadastro_hospital.Pacientes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 89087
 */
public class RepositorioPaciente {

    private final static ArrayList<Pacientes> pacientes = new ArrayList<>();
    private final static ArrayList<Pacientes> senha = new ArrayList<>();
    private final static ArrayList<Pacientes> login = new ArrayList<>();
    private final static ArrayList<Usuario> lista = new ArrayList<>();

    private Scanner teclado;

    public RepositorioPaciente() {
    }

    public RepositorioPaciente(Scanner teclado) {
        this.teclado = teclado;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public List<Pacientes> listar() {
        return pacientes;
    }

    public void salvar(Pacientes paciente) {
        if (paciente == null) {
            return;
        }

        if (paciente.getId() == null) {
            paciente.setId(System.currentTimeMillis());
        }

        int index = pacientes.indexOf(paciente);

        if (index > -1) {
            pacientes.set(index, paciente);
        } else {
            pacientes.add(paciente);
        }
    }

    public void remover(Pacientes paciente) {
        pacientes.remove(paciente);
    }

    public Pacientes getPorId(Long id) {
        for (Pacientes paciente : pacientes) {
            if (Objects.equals(id, paciente.getId())) {
                return paciente;
            }
        }
        return null;
    }

    public List<Pacientes> getPorNome(String nome) {
        ArrayList<Pacientes> retorno = new ArrayList<>();
        pacientes.stream().filter((paciente) -> (paciente.getNome().toLowerCase().contains(nome.toLowerCase()))).forEach((paciente) -> retorno.add(paciente));
        return retorno;
    }

    public Usuario validarLogin(String login, String senha) {

        for (Usuario usuario :lista) {
            if (usuario.getLogin().equals(login)) {
                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }

        }
        return null;
    }
}
