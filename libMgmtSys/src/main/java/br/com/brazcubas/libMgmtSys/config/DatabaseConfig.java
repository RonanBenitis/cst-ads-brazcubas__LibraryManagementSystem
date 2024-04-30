package br.com.brazcubas.libMgmtSys.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DatabaseConfig {
    // using postgreSQL as DB
    private static final String URL = "jdbc:postgresql://localhost:5432/db_libMgmtSys";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() throws SQLException {
        try (Connection conexao = getConnection()) {
            DatabaseMetaData dbm = conexao.getMetaData();
            // Snipet de validação existencia tabela livro
            ResultSet tablesLivro = dbm.getTables(null, null, "livro", null); // getTables(catalog, schemaPattern, tableNamePattern, types)
            if (!tablesLivro.next()) {
                String sqlLivro = 
                            "CREATE TABLE livro (" +
                                "id serial PRIMARY KEY," +
                                "titulo varchar(100) NOT NULL," +
                                "autor varchar(100) NOT NULL," +
                                "numPaginas int NOT NULL" +
                            ");";
                Statement statement = conexao.createStatement();
                statement.execute(sqlLivro);
            }
            // Snipet de validação da existencia tabela livroEmprestimo
            ResultSet tablesLivroEmpr = dbm.getTables(null, null, "livroemprestado", null); 
            if (!tablesLivroEmpr.next()) {
                // Detalhe! Postgres, se não citarmos tipo \"LivroEmprestado\" no CREATE TABLE, ele cria tudo em minusculo por padrao, viu?
                String sqlLivroEmpr = 
                            "CREATE TABLE livroemprestado (" +
                                "id serial PRIMARY KEY," +
                                "id_livro int unique," +
                                
                                "CONSTRAINT id_livro_fk FOREIGN KEY (id_livro)" +
                                    "REFERENCES livro(id)" +
                            ");";
                Statement statement = conexao.createStatement();
                statement.execute(sqlLivroEmpr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}