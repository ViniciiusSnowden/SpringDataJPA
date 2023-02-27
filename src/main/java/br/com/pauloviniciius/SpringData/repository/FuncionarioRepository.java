package br.com.pauloviniciius.SpringData.repository;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
