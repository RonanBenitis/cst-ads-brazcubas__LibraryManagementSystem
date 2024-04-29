package  com.biblioteca.model.entity;

public class Livro extends AbstractEntity {

  private String titulo;

  private String autor;

  private int numPaginas;

  public Livro(String titulo, String autor, int numPaginas) {
    this.titulo = titulo;
    this.autor = autor;
    this.numPaginas = numPaginas;
  }

  public Livro(int id, String titulo, String autor, int numPaginas) {
    super.setId(id);
    this.titulo = titulo;
    this.autor = autor;
    this.numPaginas = numPaginas;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumPaginas() {
    return numPaginas;
  }

  public void setNumPaginas(int numPaginas) {
    this.numPaginas = numPaginas;
  }
}
