
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author 78522
 */
public class Pessoa extends Animal implements Serializable {

    private static final long serialVersionUID = 5L;

    private String email;
    private transient Telefone telefone;

    public Pessoa() {
        System.out.println("Criando pessoa...");
    }

    public Pessoa(String nome, String email, Telefone telefone) {
        this();
        setNome(nome);
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setNome((String) in.readObject());
        telefone = new Telefone();
        telefone.setCodigoPais((String) in.readObject());
        telefone.setCodigoArea((String) in.readObject());
        telefone.setNumero((String) in.readObject());
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeObject(getNome());

        out.writeObject(telefone.getCodigoPais());
        out.writeObject(telefone.getCodigoArea());
        out.writeObject(telefone.getNumero());
//        out.writeObject(telefone.getCodigoPais() != null ? telefone.getCodigoPais() : null);
//        out.writeObject(telefone.getCodigoArea() != null ? telefone.getCodigoArea() : null);
//        out.writeObject(telefone.getNumero() != null ? telefone.getNumero() : null);
    }

}
