package hospital.view.controller;

import hospital.model.Paciente;
import java.time.LocalDateTime;

/**
 *
 * @author 78522
 */
public interface TableInfoPaciente {

    public static String[] getColunas() {
        return new String[]{"ID", "Nome", "Situação", "Procedimento", "Data Entrada"};
    }

    default Object[] getLinha() {
        return new Object[]{getId(), getNome(), getSituacao(), getProcedimento(),
            Formatter.formatDateTime(getDataEntrada())};
    }

    public Long getId();

    public String getNome();

    public Paciente.Situacao getSituacao();

    public Paciente.Procedimento getProcedimento();

    public LocalDateTime getDataEntrada();

}
