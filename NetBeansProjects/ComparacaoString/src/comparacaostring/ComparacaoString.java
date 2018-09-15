
package comparacaostring;


public class ComparacaoString {

    public static void main(String[] args) {
      String nome1 = "Robson";
      String nome2 = "Robson";
      String nome3 = new String("Robson");
      String res;
      res = (nome1 == nome2)?"igual":"diferente";
        System.out.println(res);
    }
    
}
