/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import dados.Usuario;

/**
 *
 * @author 88178
 */
public class UtilitarioLogin {

    public static Usuario usuarioLogado;

    public static boolean login(String login, String senha) {
       
        Usuario usuario = UsuarioDAO.getInstance().validarLogin(login, senha);
        if (usuario != null) {
            usuarioLogado = usuario;
            return true;
        }
        return false;
    }

}
