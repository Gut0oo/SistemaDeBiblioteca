package br.com.biblioteca;


import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.service.EmprestimoService;
import br.com.biblioteca.service.LivroService;
import br.com.biblioteca.service.UsuarioService;
import br.com.biblioteca.util.ConexaoDB;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        testarConexao();

        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1 -> cadastrarUsuario();
                    case 2 -> cadastrarLivro();
                    case 3 -> registrarEmprestimo();
                    case 4 -> encerrarEmprestimo();
                    case 5 -> listarEmprestimosAbertos();
                    case 0 -> System.out.println("👋 Encerrando sistema...");
                    default -> System.out.println("❌ Opção inválida.");
                }
            } catch (RuntimeException e) {
                System.out.println("⚠️ Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    private static void testarConexao() {
        try (Connection conn = ConexaoDB.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexão com o banco realizada com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar com o banco.");
            e.printStackTrace();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA BIBLIOTECA =====");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar livro");
        System.out.println("3 - Registrar empréstimo");
        System.out.println("4 - Encerrar empréstimo");
        System.out.println("5 - Listar empréstimos abertos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        boolean sucesso = UsuarioService.cadastrarUsuario(nome, telefone);

        if (sucesso) {
            System.out.println("✅ Usuário cadastrado com sucesso!");
        } else {
            System.out.println("❌ Não foi possível cadastrar o usuário.");
        }
    }

    private static void cadastrarLivro() {
        System.out.print("Nome do livro: ");
        String nome = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        boolean sucesso = LivroService.cadastrarLivro(nome, autor);

        if (sucesso) {
            System.out.println("✅ Livro cadastrado com sucesso!");
        } else {
            System.out.println("❌ Não foi possível cadastrar o livro.");
        }
    }

    private static void registrarEmprestimo() {
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Nome do usuário: ");
        String usuario = scanner.nextLine();

        LocalDate hoje = LocalDate.now();

        EmprestimoService.registrarEmprestimo(titulo, usuario, hoje);
        System.out.println("✅ Empréstimo registrado com sucesso!");
    }

    private static void encerrarEmprestimo() {
        System.out.print("ID do empréstimo: ");
        int id = scanner.nextInt();

        boolean sucesso = EmprestimoService.encerrarEmprestimo(id);

        if (sucesso) {
            System.out.println("✅ Empréstimo encerrado com sucesso!");
        } else {
            System.out.println("❌ Não foi possível encerrar o empréstimo.");
        }
    }

    private static void listarEmprestimosAbertos() {
        List<Emprestimo> lista = EmprestimoService.listarEmprestimosAbertos();

        if (lista.isEmpty()) {
            System.out.println("📭 Nenhum empréstimo em aberto.");
            return;
        }

        System.out.println("\n📚 Empréstimos em aberto:");
        for (Emprestimo e : lista) {
            System.out.println(
                    "ID: " + e.getId() +
                            " | Livro: " + e.getLivro().getNome() +
                            " | Usuário: " + e.getUsuario().getNome() +
                            " | Data: " + e.getData_emprestimo()
            );
        }
    }
}