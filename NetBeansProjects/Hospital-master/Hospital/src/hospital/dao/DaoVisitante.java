package hospital.dao;

import hospital.model.Visitante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 78522
 */
public class DaoVisitante extends Dao {

    public static final String TABELA = "visitante";

    public static final String COLUNA_ID = "cd_visitante";
    public static final String COLUNA_DATA_CRIACAO = "dt_criacao";
    public static final String COLUNA_DATA_ALTERACAO = "dt_alteracao";
    public static final String COLUNA_NOME = "nm_visitante";
    public static final String COLUNA_ID_PACIENTE = "cd_paciente";
    public static final String COLUNA_STATUS = "ds_status";

    private static DaoVisitante repositorio;

    public static DaoVisitante getInstance() {
        if (repositorio == null) {
            repositorio = new DaoVisitante();
        }
        return repositorio;
    }

    @Override
    public String getTabela() {
        return TABELA;
    }

    public Visitante salvar(Visitante obj) {
        if (obj == null) {
            return null;
        }

        if (obj.getId() == null) {
            obj.setDataCriacao(LocalDateTime.now());
            obj.setDataAlteracao(LocalDateTime.now());
            return insert(obj);
        } else {
            obj.setDataAlteracao(LocalDateTime.now());
            return update(obj) ? obj : null;
        }
    }

    public Visitante insert(Visitante obj) {
        String sql = "INSERT INTO " + TABELA + "( "
                + COLUNA_DATA_CRIACAO + ", "
                + COLUNA_DATA_ALTERACAO + ", "
                + COLUNA_NOME + ", "
                + COLUNA_ID_PACIENTE + ", "
                + COLUNA_STATUS
                + ") VALUES("
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + obj.getNome() + "', "
                + "'" + obj.getPaciente().getId() + "', "
                + "'" + obj.getStatus() + "'"
                + ")";

        try {
            conectar();
            getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            long id = getStatement().getGeneratedKeys().getLong(COLUNA_ID);
//            return getPorId(id);
            return obj;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return null;
    }

    public boolean update(Visitante obj) {
        String sql = "UPDATE " + TABELA + " SET "
                + COLUNA_DATA_ALTERACAO + " ='" + Timestamp.valueOf(LocalDateTime.now()) + "',"
                + COLUNA_NOME + " ='" + obj.getNome() + "',"
                + COLUNA_ID_PACIENTE + " ='" + obj.getPaciente().getId() + "',"
                + COLUNA_STATUS + " ='" + obj.getStatus() + "'"
                + " WHERE "
                + COLUNA_ID + " = " + obj.getId();

        try {
            conectar();
            getStatement().executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    public boolean delete(Visitante obj) {
        String sql = "DELETE FROM " + TABELA + " WHERE "
                + COLUNA_ID + " = " + obj.getId();

        try {
            conectar();
            getStatement().executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    @Override
    public List<Visitante> getTodos() {
        String sql = "SELECT * FROM " + TABELA;
        List<Visitante> result = new ArrayList();

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            while (rs.next()) {
                result.add(buildUsuario(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return result;
    }

    public Visitante buildUsuario(ResultSet rs) throws SQLException {
        Visitante obj = new Visitante();
        DaoPaciente daoPaciente = DaoPaciente.getInstance();

        obj.setId(rs.getLong(COLUNA_ID));
        obj.setDataCriacao(rs.getTimestamp(COLUNA_DATA_CRIACAO).toLocalDateTime());
        obj.setDataAlteracao(rs.getTimestamp(COLUNA_DATA_ALTERACAO).toLocalDateTime());
        obj.setNome(rs.getString(COLUNA_NOME));
        obj.setPaciente(daoPaciente.getPorId(rs.getLong(COLUNA_ID_PACIENTE)));
        obj.setStatus(Visitante.Status.valueOf(rs.getString(COLUNA_STATUS)));

        return obj;
    }

    public Visitante getPorId(long id) {
        String sql = "SELECT * FROM " + TABELA + " WHERE " + COLUNA_ID + " = " + id;

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            if (rs.next()) {
                return buildUsuario(rs);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return null;
    }
}
