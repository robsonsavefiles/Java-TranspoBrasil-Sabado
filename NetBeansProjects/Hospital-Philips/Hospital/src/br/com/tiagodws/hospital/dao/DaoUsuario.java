package br.com.tiagodws.hospital.dao;

import br.com.tiagodws.hospital.model.Usuario;
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
public class DaoUsuario extends Dao {

    public static final String TABELA = "usuario";

    public static final String COLUNA_ID = "cd_usuario";
    public static final String COLUNA_DATA_CRIACAO = "dt_criacao";
    public static final String COLUNA_DATA_ALTERACAO = "dt_alteracao";
    public static final String COLUNA_NOME = "nm_usuario";
    public static final String COLUNA_LOGIN = "ds_login";
    public static final String COLUNA_SENHA = "ds_senha";
    public static final String COLUNA_TIPO = "ds_tipo";

    private static DaoUsuario repositorio;

    public static DaoUsuario getInstance() {
        if (repositorio == null) {
            repositorio = new DaoUsuario();
        }
        return repositorio;
    }

    @Override
    public String getTabela() {
        return TABELA;
    }

    public Usuario salvar(Usuario obj) {
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

    public Usuario insert(Usuario obj) {
        String sql = "INSERT INTO " + TABELA + "( "
                + COLUNA_DATA_CRIACAO + ", "
                + COLUNA_DATA_ALTERACAO + ", "
                + COLUNA_NOME + ", "
                + COLUNA_LOGIN + ", "
                + COLUNA_SENHA + ", "
                + COLUNA_TIPO
                + ") VALUES("
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + Timestamp.valueOf(LocalDateTime.now()) + "', "
                + "'" + obj.getNome() + "', "
                + "'" + obj.getLogin() + "', "
                + "'" + obj.getSenha() + "', "
                + "'" + obj.getTipo() + "'"
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

    public boolean update(Usuario obj) {
        String sql = "UPDATE " + TABELA + " SET "
                + COLUNA_DATA_ALTERACAO + " ='" + Timestamp.valueOf(LocalDateTime.now()) + "',"
                + COLUNA_NOME + " ='" + obj.getNome() + "',"
                + COLUNA_LOGIN + " ='" + obj.getLogin() + "',"
                + COLUNA_SENHA + " ='" + obj.getSenha() + "',"
                + COLUNA_TIPO + " ='" + obj.getTipo() + "'"
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

    public boolean delete(Usuario obj) {
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

    public Usuario verificaLogin(String login, String senha) {
        String sql = "SELECT * FROM " + getTabela() + " WHERE " + COLUNA_LOGIN + " ='" + login + "'";

        try {
            conectar();
            ResultSet rs = getStatement().executeQuery(sql);
            if (rs.next()) {
                Usuario usuario = buildUsuario(rs);
                if (usuario.getSenha().equals(senha)) {
                    return usuario;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }

        return null;
    }

    @Override
    public List<Usuario> getTodos() {
        String sql = "SELECT * FROM " + TABELA;
        List<Usuario> result = new ArrayList();

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

    public Usuario buildUsuario(ResultSet rs) throws SQLException {
        Usuario obj = new Usuario();

        obj.setId(rs.getLong(COLUNA_ID));
        obj.setDataCriacao(rs.getTimestamp(COLUNA_DATA_CRIACAO).toLocalDateTime());
        obj.setDataAlteracao(rs.getTimestamp(COLUNA_DATA_ALTERACAO).toLocalDateTime());
        obj.setNome(rs.getString(COLUNA_NOME));
        obj.setLogin(rs.getString(COLUNA_LOGIN));
        obj.setSenha(rs.getString(COLUNA_SENHA));
        obj.setTipo(Usuario.Tipo.valueOf(rs.getString(COLUNA_TIPO)));

        return obj;
    }

    public Usuario getPorId(long id) {
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
