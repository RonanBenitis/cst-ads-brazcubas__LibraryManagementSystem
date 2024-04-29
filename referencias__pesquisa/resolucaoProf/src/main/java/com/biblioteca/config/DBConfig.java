package  com.biblioteca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

  private static final String URL = "ulr_do_banco";

  private static final String USER = "user";

  private static final String PASSWORD = "pass";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public static void createTables() {
    // TODO: Query para criar as tabelas no banco e executar ao iniciar o sistema
  }
}
