package  com.biblioteca;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.config.DBConfig;
import com.biblioteca.controller.LivroController;
import com.biblioteca.model.dao.LivroDAO;
import com.biblioteca.view.LivroView;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inicialização das dependências
    LivroView livroView = new LivroView();
    LivroDAO livroDAO = new LivroDAO();
    LivroController livroController = new LivroController(livroDAO);

    // Inicialização do Banco de Dados
    DBConfig.createTables();

    // Inicialização da CLI
    Scanner scanner = new Scanner(System.in);
    SistemaBiblioteca sistema = new SistemaBiblioteca(livroController, livroView, scanner);

    // Inicialização do sistema
    sistema.iniciar();
	}

}
