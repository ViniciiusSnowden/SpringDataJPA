package br.com.pauloviniciius.SpringData.repository;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

    //JPQL
    @Query("SELECT f FROM Funcionario  f where f.nome = :nome " +
            "and f.salario >= :salario and f.dataContratacao = :data")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

    //NativeQuery
    @Query(value = "SELECT * FROM funcionario f where f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataContracacaoMaior(LocalDate data);

    @Query(value = "SELECT f.id , f.nome , f.salario FROM funcionario f", nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();

}
