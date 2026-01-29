package br.com.biblioteca.dao;

import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public static void inserirUsuario(Usuario usuario) {
        String command = "INSERT INTO usuario (nome, telefone) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getTelefone());

            ps.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Usuario buscarPorId(int id) {
        String command = "SELECT id, nome, telefone FROM usuario WHERE id = ?";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setInt(1, id);
            ps.executeQuery();

            ResultSet result = ps.getResultSet();

            if(result.next()){
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");

                return  new Usuario(id, nome, telefone);
            }else
                return null;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
