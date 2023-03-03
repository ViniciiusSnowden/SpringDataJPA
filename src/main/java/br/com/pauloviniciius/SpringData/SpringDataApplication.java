package br.com.pauloviniciius.SpringData;

import br.com.pauloviniciius.SpringData.orm.Cargo;

import br.com.pauloviniciius.SpringData.service.CrudCargoService;
import br.com.pauloviniciius.SpringData.service.CrudFuncionarioService;
import br.com.pauloviniciius.SpringData.service.CrudUnidadeTrabalhoService;
import br.com.pauloviniciius.SpringData.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;
	@Autowired
	private CrudCargoService crudCargoService;

	@Autowired
	private  CrudFuncionarioService funcionarioService;

	@Autowired
	private CrudUnidadeTrabalhoService unidadeTrabalhoService;

	@Autowired
	private RelatorioService relatorioService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorio");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					funcionarioService.inicial(scanner);
					break;
				case 2:
					crudCargoService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatorioService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}



	}

}
