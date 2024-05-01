package br.com.brazcubas.libMgmtSys.controller;

import java.util.List;

import br.com.brazcubas.libMgmtSys.model.dao.IDAO;
import br.com.brazcubas.libMgmtSys.model.entity.Livro;

public class LivroController {
    private final IDAO<Livro> livroDAO;

    //>>>>>> CONSTRUTOR
    public LivroController (IDAO<Livro> livroDAO) {
      this.livroDAO = livroDAO;
    }

    //>>>>>> CONTROLA CADASTRO LIVRO
    public String cadastrarLivro(Livro livro) {
      livroDAO.cadastrar(livro);
      return "Cadastro realizado!";
    }

    public String atualizarLivro(Livro livro) {
        livroDAO.atualizar(livro);
        return "Atualização realizada!";
      }
    
    public String excluirLivro(int id) {
      livroDAO.excluir(id);
      return "Exclusão realizada!";
    }
  
    public Livro buscarLivro(int id) {
      return (Livro) livroDAO.buscar(id);
    }
  
    public List<Livro> listarLivros() {
      return livroDAO.listar();
    }

    //>>>>>> CONTROLA EMPRESTIMO LIVRO
    public Livro buscarLivroEmpr(int id) {
      return (Livro) livroDAO.buscarEmpr(id);
    }

    public String emprestaLivro(Livro livro) {
      livroDAO.emprestar(livro);
      return "Livro emprestado com sucesso!";
    }

    public String devolverLivro(int id) {
      livroDAO.devolver(id);
      return "Livro devolvido com sucesso!";
    }

    public List<Livro> listarLivrosEmprestados() {
      return livroDAO.listarEmprest();
    }


}
