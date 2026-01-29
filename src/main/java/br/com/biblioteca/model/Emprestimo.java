package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate data_emprestimo, date_devolucao;

    public Emprestimo(LocalDate data_emprestimo, Livro livro, Usuario user) {
        this.livro = livro;
        this.usuario = user;
        this.data_emprestimo = data_emprestimo;
    }

    public Emprestimo(LocalDate data_emprestimo, int id, Livro livro, Usuario user) {
        this.id = id;
        this.livro = livro;
        this.usuario = user;
        this.data_emprestimo = data_emprestimo;
    }

    public Emprestimo(LocalDate data_emprestimo, LocalDate date_devolucao, int id, Livro livro, Usuario user) {
        this.id = id;
        this.livro = livro;
        this.usuario = user;
        this.data_emprestimo = data_emprestimo;
        this.date_devolucao = date_devolucao;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getDate_devolucao() {
        return date_devolucao;
    }

    public void setDate_devolucao(LocalDate date_devolucao) {
        this.date_devolucao = date_devolucao;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario user) {
        this.usuario = user;
    }
}
