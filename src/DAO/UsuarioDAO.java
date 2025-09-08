package DAO;

import connection.Connection;
import entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario){
        String sql = "INSERT INTO USUARIOS(TIPO, NOME, CURSOS, ID) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try{
            ps = Connection.getConnect().prepareStatement(sql);

            ps.setString(1, usuario.getType());
            ps.setString(2, usuario.getName());
            ps.setString(3, usuario.getCourse());
            ps.setInt(4, usuario.getId());

            ps.execute();
            ps.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
