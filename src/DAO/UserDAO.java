package DAO;

import connection.Connection;
import entity.usuario.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void cadastrarUsuario(User user){
        String sql = "INSERT INTO USUARIOS(TIPO, NOME, CURSOS, ID) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try{
            ps = Connection.getConnect().prepareStatement(sql);

            ps.setString(1, user.getType());
            ps.setString(2, user.getName());
            ps.setString(3, user.getCourse());
            ps.setInt(4, user.getId());

            ps.execute();
            ps.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultarUsuario(int id) {
        String sql = "SELECT * FROM USUARIOS WHERE Id = ?";

        PreparedStatement ps = null;

        try{
            ps = Connection.getConnect().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Usuario Encontrado: \n");
                System.out.println("ID: " + rs.getInt("Id"));
                System.out.println("Nome: " + rs.getString("Nome"));
                System.out.println("Tipo: " + rs.getString("Tipo"));
                System.out.println("Curso: " + rs.getString("Cursos"));
            }else{
                System.out.println("Usuário não encontrado!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarUsuario(){

    }

    public void listarUsuarios(){

    }
}
