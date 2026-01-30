package br.com.biblioteca.service;

import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.enums.LivroStatus;
import br.com.biblioteca.model.Livro;

import java.util.List;

public class LivroService {
    public static boolean cadastrarLivro(String nome, String autor){
        if(nome == null || nome.isBlank()) return false;
        if(autor == null || autor.isBlank()) return false;
        if(LivroDAO.buscarLivro(nome) != null) return false;

        Livro livro = new Livro(nome, autor);

        LivroDAO.insertLivro(livro);

        return true;
    }

    public static boolean marcarStatusEmprestado(int id){
        Livro livroBD = LivroDAO.buscarPorId(id);
        if(livroBD == null) return false;

        if(livroBD.getDisponivel() == LivroStatus.EMPRESTADO) return false;

        return LivroDAO.updateStatusLivro(livroBD, LivroStatus.EMPRESTADO);
    }

    public static boolean marcarStatusDisponivel(int id){
        Livro livroBD = LivroDAO.buscarPorId(id);
        if(livroBD == null) return false;

        if(livroBD.getDisponivel() == LivroStatus.DISPONIVEL) return false;

        return LivroDAO.updateStatusLivro(livroBD, LivroStatus.DISPONIVEL);
    }

    public static Livro buscarLivroPorID(int id){
        return LivroDAO.buscarPorId(id);
    }


    public static boolean livroExiste(String nome){
        return LivroDAO.buscarLivro(nome) != null;
    }
}
