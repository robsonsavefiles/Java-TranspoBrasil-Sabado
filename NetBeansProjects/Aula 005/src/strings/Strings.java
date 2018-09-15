package strings;

/**
 *
 * @author 78522
 */
public class Strings {

    public static void main(String[] args) {
        String texto = "Abacaxi abacaxi cadê o meu caqui?!";

        System.out.print("\nTamanho do texto: ");
        System.out.println(texto.length());

        String nome = "Felipe";
        String ultimoNome = "Oliveira";

        System.out.print("\nConcatenação 1: ");
        System.out.println(nome + " " + ultimoNome);

        System.out.print("\nConcatenação 2: ");
        System.out.println(nome.concat(" ").concat(ultimoNome));

        System.out.print("\nCharAt: \n");
        for (int i = 0; i < texto.length(); i++) {
            System.out.println(texto.charAt(i));
        }

        System.out.print("\nContains \"pe\": ");
        System.out.println(nome.contains("pe"));

        System.out.print("\nIndexOf \"pe\": ");
        System.out.println(nome.indexOf("pe"));

        System.out.print("\nIndexOf \"PE\": ");
        System.out.println(nome.indexOf("PE"));

        System.out.print("\nReplace \"e\" por \"i\": ");
        System.out.println(nome.replace('e', 'i'));

        String teste = "     Teste 123     ";

        System.out.print("\nSem Trim: ");
        System.out.println(">" + teste + "<");

        System.out.print("\nCom Trim: ");
        System.out.println(">" + teste.trim() + "<");
        teste = "                 ";
        System.out.print("\nEquals \"\": ");
        System.out.println("".equals(teste.trim()) ? " Vazio " : "Não Vazio");

        System.out.print("\nSubstring 10: ");
        System.out.println(texto.substring(10));

        System.out.print("\nSubstring 15,20: ");
        System.out.println(texto.substring(15, 20));

        System.out.print("\nToUpperCase: ");
        System.out.println(nome.toUpperCase());

        System.out.print("\nToLowerCase: ");
        System.out.println(nome.toLowerCase());

        System.out.print("\nSplit: \n");
        String[] palavras = texto.split(" ");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        System.out.print("\nSplit 2: \n");
        String dadosContato = "Tiago Dionesto;tiago@gmail.com;33234742";
        String[] dados = dadosContato.split(";");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }

}
