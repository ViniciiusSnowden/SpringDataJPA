package br.com.pauloviniciius.SpringData.repository;

import br.com.pauloviniciius.SpringData.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}
