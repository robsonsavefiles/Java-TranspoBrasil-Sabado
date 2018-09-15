
public class FactoryPessoa {

    public static Pessoa getPessoa(String nome, String sexo) {
        if (sexo.equals("M")) {
            return new Homem(nome);
        } else if (sexo.equals("F")) {
            return new Mulher(nome);
        }
        return null;
    }
}
