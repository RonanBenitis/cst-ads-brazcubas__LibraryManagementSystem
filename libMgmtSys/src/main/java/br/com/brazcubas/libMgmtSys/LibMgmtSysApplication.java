package br.com.brazcubas.libMgmtSys;

import org.springframework.boot.CommandLineRunner;
	// Instrução marota pra importar a interface CommandLineRunner, usado pra executar algo logo quando starta.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brazcubas.libMgmtSys.config.DatabaseConfig;

@SpringBootApplication
public class LibMgmtSysApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibMgmtSysApplication.class, args);
	}

	@Override
		// Sobrescrevendo o método startador da massa. Padrãozinho pro CommanLineRunner ;)
	public void run(String... args) throws Exception {

		// DB start
		DatabaseConfig.createTables();
	}
}
