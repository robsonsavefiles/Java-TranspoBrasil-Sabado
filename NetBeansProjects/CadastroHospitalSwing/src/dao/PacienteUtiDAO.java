package dao;

import modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PacienteUtiDAO extends Dao {

    public static final String TABELA = "paciente";

    public static final String COLUNA_ID = "cd_paciente";
    public static final String COLUNA_DATA_CRIACAO = "dt_criacao";
    public static final String COLUNA_DATA_ALTERACAO = "dt_alteracao";
    public static final String COLUNA_NOME = "nm_paciente";
    public static final String COLUNA_DATA_ENTRADA = "dt_entrada";
    public static final String COLUNA_DATA_SAIDA = "dt_saida";
    public static final String COLUNA_SITUACAO = "ds_situacao";
    public static final String COLUNA_PROCEDIMENTO = "ds_procedimento";

    private static PacienteUtiDAO repositorio;

    public static PacienteUtiDAO getInstance() {
        if (repositorio == null) {
            repositorio = new PacienteUtiDAO();
        }
        return repositorio;
    }

    @Override
    public String getTabela() {
        return TABELA;
    }

    public Paciente salvar(Paciente obj) {
        if (obj == null) {
            return null;
        }

        if (obj.getId() == null) {
            obj.setDataCriacao(LocalDateTime.now());
            obj.setDataAlteracao(LocalDateTime.now());
            obj.setDataEntrada(LocalDateTime.now());
            return insert(obj);
        } else {
            obj.setDataAlteracao(LocalDateTime.now());
            return update(obj) ? obj : null;
        }
    }

    public Paciente insert(Paciente obj) {
        String sql = "INSERT INTO " + TABELA + "( "
                + COLUNA_DATA_CRIACAO + ", "
                + COLUNA_DATA_ALTERACAO + ", "
                + COLUNA_NOME + ", "
                + COLUNA_DATA_ENTRADA + ", "
                + (obj.getDataSaida() == null ? "" : (COLUNA_DATA_SAIDA + ", "))
                + COLUNA_SITUACAO + ", "
                + COLUNA_PROCEDIMENTO
                + ") VALUES("
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + obj.getNome() + "', "
                + "'" + Timestamp.valueOf(obj.getDataEntrada()) + "', "
                + (obj.getDataSaida() == null ? "" : ("'" + Timestamp.valueOf(obj.getDataSaida()) + "', "))
                + "'" + obj.getSituacao() + "', "
                + "'" + obj.getProcedimento() + "'"
                + ")";

        try {
            conectar();
            getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            long id = getStatement().getGeneratedKeys().getLong(COLUNA_ID);
//            return getPorId(id);
            return obj;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return null;
    }

    public boolean update(Paciente obj) {
        String sql = "UPDATE " + TABELA + " SET "
                + COLUNA_DATA_ALTERACAO + " ='" + Timestamp.valueOf(LocalDateTime.now()) + "',"
                + COLUNA_NOME + " ='" + obj.getNome() + "',"
                + COLUNA_DATA_ENTRADA + " ='" + Timestamp.valueOf(obj.getDataEntrada()) + "',"
                + (obj.getDataSaida() == null ? "" : (COLUNA_DATA_SAIDA + " ='" + Timestamp.valueOf(obj.getDataSaida()) + "',"))
                + COLUNA_SITUACAO + " ='" + obj.getSituacao() + "',"
                + COLUNA_PROCEDIMENTO + " ='" + obj.getProcedimento() + "'"
                + " WHERE "
                + COLUNA_ID + " = " + obj.getId();

        try {
            conectar();
            getStatement().executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    public boolean delete(Paciente obj) {
        String sql = "DELETE FROM " + TABELA + " WHERE "
                + COLUNA_ID + " = " + obj.getId();

        try {
            conectar();
            getStatement().executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
        return false;
    }

    @Override
    public List<Paciente> getTodos() {
        String sql = "SELECT * FROM " + TABELA;
        List<Paciente> result = new ArrayList();

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            while (rs.next()) {
                result.add(buildPacienteUti(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return result;
    }

    public List<Paciente> getTodosSemSaida() {
        String sql = "SELECT * FROM " + TABELA + " WHERE " + COLUNA_DATA_SAIDA + " IS NULL";
        List<Paciente> result = new ArrayList();

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            while (rs.next()) {
                result.add(buildPacienteUti(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return result;
    }

    public Paciente buildPacienteUti(ResultSet rs) throws SQLException {
        Paciente obj = new Paciente();

        obj.setId(rs.getLong(COLUNA_ID));
        obj.setDataCriacao(rs.getTimestamp(COLUNA_DATA_CRIACAO).toLocalDateTime());
        obj.setDataAlteracao(rs.getTimestamp(COLUNA_DATA_ALTERACAO).toLocalDateTime());
        obj.setNome(rs.getString(COLUNA_NOME));
        obj.setDataEntrada(rs.getTimestamp(COLUNA_DATA_ENTRADA).toLocalDateTime());

        Timestamp saida = rs.getTimestamp(COLUNA_DATA_SAIDA);
        if (saida != null) {
            obj.setDataSaida(saida.toLocalDateTime());
        }
        obj.setSituacao(Paciente.Situacao.valueOf(rs.getString(COLUNA_SITUACAO)));
        obj.setProcedimento(Paciente.Procedimento.valueOf(rs.getString(COLUNA_PROCEDIMENTO)));

        return obj;
    }

    public Paciente getPorId(long id) {
        String sql = "SELECT * FROM " + TABELA + " WHERE " + COLUNA_ID + " = " + id;

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            if (rs.next()) {
                return buildPacienteUti(rs);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return null;
    }

}
