package br.com.brazcubas.libMgmtSys.view;

import java.util.List;

import br.com.brazcubas.libMgmtSys.model.entity.Livro;

public class LivroView {
    public void mostrarDetalhesLivro(Livro livro) {
        System.out.println(">>> Detalhes do livro <<<");
        System.out.println("ID " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Número de páginas: " + livro.getNumPaginas());
    }

    public void mostrarDetalhesEmprestimo(Livro livro) {
        System.out.println(">>> Detalhes do Emprestimo <<<");
        System.out.println("ID " + livro.getId());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Data do emprestimo: " + livro.getDt_emprestimo());
        System.out.println("Emprestado para: " + livro.getEmprestimoMembro());
        System.out.println("Realizado por: " + livro.getEmprestimoResponsavel());
    }

    public void mostrarListaLivros(List<Livro> livros) {
        System.out.println("Lista de livros: ");
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
        }
    }
}