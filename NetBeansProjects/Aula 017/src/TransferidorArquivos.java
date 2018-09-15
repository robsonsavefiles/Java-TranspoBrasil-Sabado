
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author 78522
 */
public class TransferidorArquivos {

    public static void transferir(File origem, File pastaDestino, boolean mover) {
        if (!origem.exists()) {
            return;
        }

        if (!pastaDestino.exists()) {
            pastaDestino.mkdirs();
        }

        try (FileInputStream in = new FileInputStream(origem);
                FileOutputStream out = new FileOutputStream(new File(pastaDestino, origem.getName()))) {
            byte[] buffer = new byte[1024];
            int pos;
            while ((pos = in.read(buffer)) != -1) {
                out.write(buffer, 0, pos);
            }
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (mover) {
            origem.delete();
        }
    }

    public static void transferir2(File origem, File pastaDestino, boolean mover) {
        if (!origem.exists()) {
            return;
        }

        if (!pastaDestino.exists()) {
            pastaDestino.mkdirs();
        }

        try {
            if (mover) {
                Files.move(origem.toPath(), new File(pastaDestino, origem.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(origem.toPath(), new File(pastaDestino, origem.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
