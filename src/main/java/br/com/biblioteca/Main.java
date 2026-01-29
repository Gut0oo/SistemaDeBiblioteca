package br.com.biblioteca;

import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.ConexaoDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConexaoDB.getConnection()){
            if(conn != null)
                System.out.println("✅ Conexão com o banco realizada com sucesso!");
        }catch (Exception e){
            System.out.println("❌ Erro ao conectar com o banco.");
            e.printStackTrace();
        }

        Usuario user1 = new Usuario("Gustavo Melo", "11 963325533");
        Usuario user2 = new Usuario("Jose da Silva", "11 996311273");
        Usuario user3 = new Usuario("Matheus Gonsalves", "11 904126412");

        UsuarioDAO.inserirUsuario(user2);
        UsuarioDAO.inserirUsuario(user3);
    }
}