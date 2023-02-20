package br.com.pauloviniciius.SpringData;

import br.com.pauloviniciius.SpringData.orm.Cargo;
import br.com.pauloviniciius.SpringData.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	@Autowired
	private CargoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Cargo cargo = new Cargo();
		cargo.setDescricao("ANALISTA DE SISTEMA");

		repository.save(cargo);
	}

}
