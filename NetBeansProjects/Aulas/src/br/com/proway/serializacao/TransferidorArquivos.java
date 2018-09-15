
package br.com.proway.serializacao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class TransferidorArquivos {

//    public void transferir(File origem, File pastaDestino, boolean mover) {
//        if(!origem.exists()){
//            return;
//        }
//        
//        if(!pastaDestino.exists()){
//            pastaDestino.mkdirs();
//        }
//        try (FileInputStream in = new FileInputStream(origem);
//                FileOutputStream out = new FileOutputStream(new File(pastaDestino, origem.getName()))) {
//            byte[] buffer = new byte[1024];
//            int pos = -1;
//            while ((pos = in.read(buffer)) != -1) {
//                out.write(buffer, 0, pos);
//            }
//            out.flush();
//            
//        } catch (IOException ex) {
//            if (mover) {
//                origem.delete();
//            }
//        }
//
//    }
//    
    public void transferir2(File origem ,File pastaDestino, boolean mover){
        if(!origem.exists()){
            return;
        }
        if(!pastaDestino.exists()){
            pastaDestino.mkdirs();
        }
        try{
            if(mover){
                Files.move(origem.toPath(),new File(pastaDestino,
                        origem.getName()).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            }else{
                Files.copy(origem.toPath(), new File(pastaDestino,
                origem.getName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
                
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    

}
}