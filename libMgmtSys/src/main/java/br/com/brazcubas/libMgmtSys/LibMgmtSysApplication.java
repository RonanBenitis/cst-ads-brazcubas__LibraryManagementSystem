package br.com.brazcubas.libMgmtSys;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
	// Instrução marota pra importar a interface CommandLineRunner, usado pra executar algo logo quando starta.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brazcubas.libMgmtSys.config.DatabaseConfig;
import br.com.brazcubas.libMgmtSys.controller.LivroController;
import br.com.brazcubas.libMgmtSys.model.dao.LivroDAO;
import br.com.brazcubas.libMgmtSys.view.LivroView;

@SpringBootApplication
public class LibMgmtSysApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibMgmtSysApplication.class, args);
	}

	@Override
		// Sobrescrevendo o método startador da massa. Padrãozinho pro CommanLineRunner ;)
	public void run(String... args) throws Exception {
		
		// Inicialização das dependências
		LivroView livroView = new LivroView();
		LivroDAO livroDAO = new LivroDAO();
		LivroController livroController = new LivroController(livroDAO);
		
		// DB start
		DatabaseConfig.createTables();

		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);
		LibrarySystem sistema = new LibrarySystem(livroController, livroView, scanner);

		// Inicialização do sistema
		sistema.iniciar();
	}
}
