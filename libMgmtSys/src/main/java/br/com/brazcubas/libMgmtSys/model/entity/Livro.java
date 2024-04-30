package br.com.brazcubas.libMgmtSys.model.entity;

// Versão simplificando, sem quantitativo.
// Ideal, na proxima versão, considerar quantitativo e validar o emprestimo considerando este atributo

public class Livro extends AbstractEntity {
    private String titulo;
    private String autor;
    private int numPaginas;
    // Construtorzin sem id
    // Usado para lançar dados no banco de dados caso este ainda não foi persistido. Por isso não temos ID
    public Livro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }
    // Construtorzin com id
    // Usado para caso o dado já persiste em BD, o ID, então, será usado para buscá-lo
    public Livro(int id, String titulo, String autor, int numPaginas) {
        super.setId(id);
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Getter n setters da massa
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public int getNumPaginas() { return numPaginas; }
    public void setNumPaginas(int numPaginas) { this.numPaginas = numPaginas; }
}
