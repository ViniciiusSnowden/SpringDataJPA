package br.com.pauloviniciius.SpringData.orm.DTO;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FuncionarioDto {
    private Integer id;
    private String nome;
    private Double salario;


    //Esse class funcionar que nem a interface de projeção
}
