
package telalogin;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.Date;

/**
 *
 * @author 89087
 */
public class PacienteUTIclass extends javax.swing.JFrame {
    
    private String nome;
    private String situacao;
    private Date dataEntrada;
    private Date dataSaida;

    public PacienteUTIclass(String nome, String situacao, Date dataEntrada, Date dataSaida) throws HeadlessException {
        this.nome = nome;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public PacienteUTIclass(String nome, String situacao, Date dataEntrada, Date dataSaida, GraphicsConfiguration gc) {
        super(gc);
        this.nome = nome;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public PacienteUTIclass(String nome, String situacao, Date dataEntrada, Date dataSaida, String title) throws HeadlessException {
        super(title);
        this.nome = nome;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public PacienteUTIclass(String nome, String situacao, Date dataEntrada, Date dataSaida, String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.nome = nome;
        this.situacao = situacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
}