package exercicios.veiculo.cadastro.formatters;

import exercicios.veiculo.model.Endereco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 78522
 */
public class ClienteFormatter {

    public static String getNome(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    public static LocalDate getDataNascimento(String input) {
        if (input.isEmpty()) {
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(input, dtf);
    }

    public static String getCpf(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    public static String getTelefone(String input) {
        if (input.isEmpty()) {
            return null;
        }
        return input;
    }

    public static Endereco getEndereco(String input) {
        if (input.isEmpty()) {
            return null;
        }
        String[] infos = input.split(",");
        int i = 0;
        Endereco e = new Endereco();
        e.setRua(infos[i++].trim());
        e.setNumero(Integer.parseInt(infos[i++].trim()));
        e.setComplemento(infos[i++].trim());
        e.setBairro(infos[i++].trim());
        e.setCidade(infos[i++].trim());
        e.setEstado(infos[i++].trim());
        e.setCep(infos[i++].trim());
        return e;
    }

}
