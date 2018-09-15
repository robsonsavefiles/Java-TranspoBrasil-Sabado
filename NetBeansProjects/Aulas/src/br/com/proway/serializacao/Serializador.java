/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proway.serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author 89087
 */
public class Serializador {
    
    public static void main (String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        
        Telefone fone = new Telefone("55","47","92633291");
        List<Pessoa> lista = new ArrayList<Pessoa>();
        lista.add(new Pessoa("ROBSON","robson.ferreiramelo@gmail.com",fone));
        lista.add(new Pessoa("RICARDO","ricardo.ferreiramelo@gmail.com",fone));
        lista.add(new Pessoa("FERNANDO","fernando.ferreiramelo@gmail.com",fone));
        lista.add(new Pessoa("TIAGO","tiago.ferreiramelo@gmail.com",fone));
        //Pessoa pessoa = new Pessoa("Robson","Robson.ferreiramelo@gmail.com",fone);
        File arquivo = new File("objeto.ser");
        FileOutputStream fOut = new FileOutputStream(arquivo);
        ObjectOutputStream out = new ObjectOutputStream(fOut);
        out.writeObject(lista);
        out.flush();
        out.close();
        //out.writeObject(pessoa);
//        
        //PARA SERIALIZAR UM OBJETO A CLASSE PRECISA IMPLEMENTAR SERIALIZABLE
        System.out.println("Deserializando....");
        FileInputStream fIn = new FileInputStream(arquivo);
        ObjectInputStream in = new ObjectInputStream(fIn);
        //Pessoa pessoaSerializada = (Pessoa) in.readObject();//CAST
        List<Pessoa> pessoaSerializada = (ArrayList<Pessoa>) in.readObject();
        System.out.println("Nome:"+pessoaSerializada.get(0).getNome());
        System.out.println("Email:"+pessoaSerializada.get(0).getEmail());
        System.out.println("Telefone:"+pessoaSerializada.get(0).getTelefone());
      
        System.out.println("Nome " + pessoaSerializada.get(3).getNome());
        System.out.println("Email" + pessoaSerializada.get(3).getEmail());
        System.out.println("Telefone"+pessoaSerializada.get(3).getTelefone());
        
    }
    
}
