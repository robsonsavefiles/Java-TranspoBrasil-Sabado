
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 78522
 */
public class AppTransferidor {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("=== TRANSFERIDOR DE ARQUIVOS ===");
        System.out.println("Informe o caminho de origem:");
        String origem = leitor.nextLine();
        System.out.println("Informe a pasta de destino:");
        String destino = leitor.nextLine();

        File arquivoOrigem = new File(origem);
        File pastaDestino = new File(destino);

        TransferidorArquivos.transferir2(arquivoOrigem, pastaDestino, true);
    }
}
