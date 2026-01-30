package br.com.biblioteca.dao;

import br.com.biblioteca.enums.LivroStatus;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.util.ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public static void insertLivro(Livro livro){
        String command = "INSERT INTO livro (titulo, autor, disponivel) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection()){
            String nome = livro.getNome();
            String autor = livro.getAutor();
            LivroStatus dispo = livro.getDisponivel();

            //Aqui a gente monta o comando
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setString(1, nome);
            ps.setString(2, autor);
            ps.setString(3, dispo.name()); //toString() funciona mas é mais seguro conceitualmente usar o name()

            ps.execute();//executa o comando

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Livro buscarLivro(String titulo){
        String command = "SELECT id, titulo, autor, disponivel FROM livro WHERE titulo = ?";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setString(1, titulo);

            ResultSet result = ps.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                String tit = result.getString("titulo");
                String autor = result.getString("autor");
                LivroStatus disponivel = LivroStatus.valueOf(result.getString("disponivel"));

                return new Livro(id, tit, autor, disponivel);
            }else
                return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Livro buscarPorId(int id){
        String command = "SELECT * FROM livro WHERE id = ?";
        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if(result.next()) {

                String titulo = result.getString("titulo");
                String autor = result.getString("autor");
                LivroStatus status = LivroStatus.valueOf(result.getString("disponivel"));

                return new Livro(id, titulo, autor, status);
            }else
                return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Livro> buscarTodos(){
        String command = "SELECT * from livro";

        List<Livro> livros = new ArrayList<>();

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);

            ResultSet result = ps.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String titulo = result.getString("titulo");
                String autor = result.getString("autor");
                LivroStatus status = LivroStatus.valueOf(result.getString("disponivel"));

                Livro livro = new Livro(id, titulo, autor, status);

                livros.add(livro);
            }

            return livros;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean updateStatusLivro(Livro livro, LivroStatus status){
        String command = "UPDATE livro SET disponivel = ? WHERE id = ?";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setString(1, status.name());
            ps.setInt(2, livro.getId());

            int linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
