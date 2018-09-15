
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author 78522
 */
public class Serializador {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Pessoa pessoa = new Pessoa("Tiago", "tiago@gmail.com", new Telefone("+55", "47", "99246244"));
        File arquivo = new File("pessoas.txt");

//        FileOutputStream fOut = new FileOutputStream(arquivo);
//        ObjectOutputStream out = new ObjectOutputStream(fOut);
//
//        out.writeObject(pessoa);

        FileInputStream fIn = new FileInputStream(arquivo);
        ObjectInputStream in = new ObjectInputStream(fIn);
        Pessoa pessoaSerializada = (Pessoa) in.readObject();
        System.out.println("Nome: " + pessoaSerializada.getNome());
        System.out.println("Email: " + pessoaSerializada.getEmail());
        System.out.println("Telefone: " + pessoaSerializada.getTelefone());

        System.out.println(pessoa == pessoaSerializada);

    }
}
