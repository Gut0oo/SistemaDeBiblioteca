package br.com.biblioteca.model;

import br.com.biblioteca.enums.LivroStatus;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private LivroStatus disponivel;

    public Livro(String nome, String autor){
        this.nome = nome;
        this.autor = autor;
        this.disponivel = LivroStatus.DISPONIVEL;
    }

    public Livro(String nome, String autor, LivroStatus disponivel){
        this.nome = nome;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public Livro(int id, String nome, String autor, LivroStatus disponivel){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LivroStatus getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(LivroStatus disponivel) {
        this.disponivel = disponivel;
    }

    public int getId(){ return id; }
}
