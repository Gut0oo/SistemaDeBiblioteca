package br.com.biblioteca.service;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

public class UsuarioService {
    public static boolean cadastrarUsuario(String nome, String telefone){
        if(nome == null || nome.isBlank()) throw new RuntimeException("Nome vazio");
        if(telefone == null || telefone.isBlank()) throw new RuntimeException("Telefone vazio");

        if(UsuarioDAO.buscarPorNome(nome) != null) throw new RuntimeException("Usuario já está cadastro no App");

        UsuarioDAO.inserirUsuario(new Usuario(nome, telefone));
        return true;
    }

    public static boolean usuarioExiste(String nome){
        return UsuarioDAO.buscarPorNome(nome) != null;
    }
}
