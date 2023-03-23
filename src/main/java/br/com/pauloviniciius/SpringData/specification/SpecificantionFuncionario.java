package br.com.pauloviniciius.SpringData.specification;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificantionFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"),"%" + nome +"%");
    };

    public static Specification<Funcionario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), (cpf));
    };

    public static Specification<Funcionario> salario(Double salario) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("salario"),"%" + salario +"%");
    };

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"),"%" + nome +"%");
    };
}
