package br.com.biblioteca.service;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

public class UsuarioService {
    public static boolean cadastrarUsuario(String nome, String telefone){
        if(nome == null || nome.isBlank()) return false;
        if(telefone == null || telefone.isBlank()) return false;

        if(UsuarioDAO.buscarPorNome(nome) == null) return false;

        UsuarioDAO.inserirUsuario(new Usuario(nome, telefone));
        return true;
    }

    public static boolean usuarioExiste(String nome){
        return UsuarioDAO.buscarPorNome(nome) != null;
    }
}
