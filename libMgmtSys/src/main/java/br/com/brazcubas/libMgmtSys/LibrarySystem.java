package br.com.brazcubas.libMgmtSys;

import java.util.List;
import java.util.Scanner;

import br.com.brazcubas.libMgmtSys.controller.LivroController;
import br.com.brazcubas.libMgmtSys.model.entity.Livro;
import br.com.brazcubas.libMgmtSys.view.LivroView;

public class LibrarySystem {
    private LivroController livroController;
    private LivroView livroView;
    private Scanner scanner;

    // Construtor do Sistema
    public LibrarySystem(LivroController livroController, LivroView livroView, Scanner scanner) {
        this.livroController = livroController;
        this.livroView = livroView;
        this.scanner = scanner;
    }

    // Métodos de Sistema
    public void iniciar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            switch(opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> listarLivros();
                case 3 -> atualizarLivro();
                case 4 -> excluirLivro();
                case 5 -> buscarLivro();
                case 8 -> listarLivrosEmprestados();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida.");
            }
        } while(opcao != 0);
    }

    private void mostrarMenu() {
        System.out.println("======= MENU =======");
        System.out.println("|>>>> CADASTRADOS <<<<");
        System.out.println("|> 1. Cadastrar Livro");
        System.out.println("|> 2. Listar Livros");
        System.out.println("|> 3. Atualizar Livro");
        System.out.println("|> 4. Excluir Livro");
        System.out.println("|> 5. Buscar Livro");
        System.out.println("|>>>> EMPRESTADOS <<<<");
        System.out.println("|> 6. Emprestar Livro");
        System.out.println("|> 7. Devolver Livro");
        System.out.println("|> 8. Listar Livros Emprestados");
        System.out.println("|> 0. Sair");
        System.out.println("====================");
        System.out.println("Escolha uma opção: ");
      }

    private void cadastrarLivro() {
        scanner.nextLine(); // Limpar buffer
        System.out.println("Digite o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Digite o número de páginas do livro:");
        int numPaginas = scanner.nextInt();

        Livro novoLivro = new Livro(titulo, autor, numPaginas);
        String retorno = livroController.cadastrarLivro(novoLivro);
        System.out.println(retorno);
    }

    private void listarLivros() {
        System.out.println("=== Livros Cadastrados ===");
        List<Livro> livros = livroController.listarLivros();
        livroView.mostrarListaLivros(livros);
        System.out.println("===========================");
    }

    private void atualizarLivro() {
        System.out.println("Digite o ID do livro a ser atualizado: ");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivro(id);
        if (livro != null) {
            scanner.nextLine(); // Limpar buffer
            System.out.println("Digite o novo título do livro: ");
            String titulo = scanner.nextLine();
            livro.setTitulo(titulo);
            System.out.println("Digite o novo autor do livro: ");
            String autor = scanner.nextLine();
            livro.setAutor(autor);
            System.out.println("Digite o novo número de páginas do livro: ");
            int numPaginas = scanner.nextInt();
            livro.setNumPaginas(numPaginas);
            String retorno = livroController.atualizarLivro(livro);
            System.out.println(retorno);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void excluirLivro() {
        System.out.println("Digite o ID do livro a ser excluído: ");
        int id = scanner.nextInt();
        String retorno = livroController.excluirLivro(id);
        System.out.println(retorno);
    }

    private void buscarLivro() {
        System.out.println("Digite o ID do livro a ser buscado: ");
        int id = scanner.nextInt();
        Livro livro = livroController.buscarLivro(id);
        if (livro != null) {
            livroView.mostrarDetalhesLivro(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void emprestarLivro() {
        // colcoar listagem de emprestados
    };

    private void devolverLivro() {
        // colcoar listagem de emprestados
    };

    private void listarLivrosEmprestados() {
        System.out.println("=+=+=+= Livros Emprestados =+=+=");
        List<Livro> livros = livroController.listarLivrosEmprestados();
        livroView.mostrarListaLivros(livros);
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
    }
}
