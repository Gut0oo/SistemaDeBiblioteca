package br.com.biblioteca.dao;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.ConexaoDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class EmprestimoDAO {
    public static void inserirEmprestimo(Emprestimo emprestimo){
        String command = "INSERT INTO emprestimo (livro_id, usuario_id, data_emprestimo) VALUES (?, ?, ?)";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setInt(1, emprestimo.getLivro().getId());
            ps.setInt(2, emprestimo.getUsuario().getId());
            ps.setDate(3, Date.valueOf(emprestimo.getData_emprestimo()));

            ps.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Emprestimo buscarEmprestimo(int id){
        String command = "SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao FROM emprestimo WHERE id = ?";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if(result.next()){
                int id_livro = result.getInt("livro_id");
                int id_usuario = result.getInt("usuario_id");
                LocalDate data_emprestimo = result.getDate("data_emprestimo").toLocalDate();
                Date SqlData_devolucao = result.getDate("data_devolucao");

                LocalDate data_devolucao = (SqlData_devolucao != null) ? SqlData_devolucao.toLocalDate() : null;
                Livro livro = LivroDAO.buscarPorId(id_livro);
                Usuario user = UsuarioDAO.buscarPorId(id_usuario);

                return (data_devolucao != null)
                        ? new Emprestimo(data_emprestimo, data_devolucao, id, livro, user)
                        : new Emprestimo(data_emprestimo, id, livro, user);
            }else
                return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean registrarDevolucao(int id){ //vai atualizar quando houver a devolução do livro
        String command = "UPDATE emprestimo SET data_devolucao = ? WHERE id = ?";

        try(Connection conn = ConexaoDB.getConnection()){
            PreparedStatement ps = conn.prepareStatement(command);
            LocalDate date = LocalDate.now();

            ps.setDate(1, Date.valueOf(date));
            ps.setInt(2, id);

            int linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
