package br.com.pauloviniciius.SpringData;

import br.com.pauloviniciius.SpringData.orm.Cargo;

import br.com.pauloviniciius.SpringData.service.CrudCargoService;
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

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{


		crudCargoService.inicial();

	}

}
