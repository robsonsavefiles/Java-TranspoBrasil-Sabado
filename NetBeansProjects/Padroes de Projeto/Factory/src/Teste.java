
public class Teste {

    public static void main(String args[]) {
        String nome = "Carlos";
        String sexo = "F";
        Pessoa p = FactoryPessoa.getPessoa(nome, sexo);
        
        System.out.println(p);
    }
}
