package br.com.biblioteca.service;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.enums.EmprestimoStatus;
import br.com.biblioteca.enums.LivroStatus;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {

    public static boolean registrarEmprestimo(String titulo, String nome, LocalDate data_empre){
        Livro livro = LivroDAO.buscarLivro(titulo);
        Usuario user = UsuarioDAO.buscarPorNome(nome);

        if(livro == null) throw new RuntimeException("Livro não existe na Base de Dados.");
        if(livro.getDisponivel() == LivroStatus.EMPRESTADO) throw new RuntimeException("Livro não está disponivel para Emprestimo");

        if(user == null) throw new RuntimeException("Usuário não encontrado no Banco de dados. Por favor realizar o cadastro do usuário antes de realizar um emprestimo.");

        Emprestimo emprestimo = new Emprestimo(data_empre, livro, user);
        EmprestimoDAO.inserirEmprestimo(emprestimo);
        return true;
    }

    public static List<Emprestimo> listarEmprestimosAbertos(){
        return EmprestimoDAO.buscarEmprestimosPorStatus(EmprestimoStatus.ABERTO);
    }

    public static List<Emprestimo> listarEmprestimosEncerrados(){
        return EmprestimoDAO.buscarEmprestimosPorStatus(EmprestimoStatus.ENCERRADO);
    }

    public static boolean encerrarEmprestimo(int id){
        Emprestimo emprestimo = EmprestimoDAO.buscarEmprestimo(id);

        if(emprestimo == null) throw new RuntimeException("Emprestimo não existe no banco de dados");
        if(emprestimo.getStatus() == EmprestimoStatus.ENCERRADO) throw new RuntimeException("O Emprestimo já foi encerrado.");

        return EmprestimoDAO.registrarDevolucao(id);
    }



}
