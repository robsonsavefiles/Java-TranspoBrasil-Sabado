
package br.com.proway.serializacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pessoa extends Animal implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private transient Telefone telefone;

    public Pessoa() {
        System.out.println("Criando Pessoa...");
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
        telefone.setCodigo((String) in.readObject());
        telefone.setNumero((String) in.readObject());

    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //Guarda mais  essas aqui pra mim 
        out.writeObject(getNome() != null? getNome():"");
        
        if (telefone.getCodigoPais() != null) {
            out.writeObject(telefone.getCodigoPais());
        }
        if (telefone.getCodigo() != null) {
            out.writeObject(telefone.getCodigo());
        }
        if (telefone.getNumero() != null) {
            out.writeObject(telefone.getNumero());
        }

    }
}
