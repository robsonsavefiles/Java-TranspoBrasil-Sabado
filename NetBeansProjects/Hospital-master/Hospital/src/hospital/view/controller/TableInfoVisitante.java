package hospital.view.controller;

import hospital.model.Paciente;
import hospital.model.Visitante;

/**
 *
 * @author 78522
 */
public interface TableInfoVisitante {

    public static String[] getColunas() {
        return new String[]{"ID", "Nome", "Paciente", "Status"};
    }

    default Object[] getLinha() {
        return new Object[]{getId(), getNome(), getPaciente().getNome(), getStatus()};
    }

    public Long getId();

    public String getNome();

    public Paciente getPaciente();

    public Visitante.Status getStatus();

}
