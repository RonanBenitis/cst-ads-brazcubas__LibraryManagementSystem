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
            ResultSet tables = dbm.getTables(null, null, "livro", null); // getTables(catalog, schemaPattern, tableNamePattern, types)
            if (!tables.next()) { // Se a tabela não existir, criar.
                String sql = "CREATE TABLE livro (" +
                                "id serial PRIMARY KEY," +
                                "titulo varchar(100)," +
                                "autor varchar(100)," +
                                "numPaginas int" +
                            ");" +
                            "CREATE TABLE livroEmprestado (" +
                                "id serial PRIMARY KEY," +
                                "titulo varchar(100)," +
                                "autor varchar(100)," +
                                "numPaginas int" +
                            ");";
                Statement statement = conexao.createStatement();
                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}