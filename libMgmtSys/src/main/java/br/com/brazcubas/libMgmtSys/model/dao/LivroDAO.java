package br.com.brazcubas.libMgmtSys.model.dao;

import java.util.List;

import br.com.brazcubas.libMgmtSys.config.DatabaseConfig;
import br.com.brazcubas.libMgmtSys.model.entity.Livro;
// query
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO implements IDAO<Livro> {

    // Entidade, queremos dizer instância de Livro
    @Override
    public void cadastrar(Livro entidade) {
        String sql = "INSERT INTO livro (titulo, autor, numPaginas) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, entidade.getTitulo());
                stmt.setString(2, entidade.getAutor());
                stmt.setInt(3, entidade.getNumPaginas());
                    // substituindo os placeholders (os ?, ?, ? do String sql) na consulta SQL pelos valores reais. Ou seja, stmt.setType(posicao_valor_nos_interrogacao, ação), que no caso estamos pegando atributos de entidade (que é nossa instancia)

                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Livro entidade) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, numPaginas = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, )
            }
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public Livro buscar(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<Livro> listar() {
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
}
