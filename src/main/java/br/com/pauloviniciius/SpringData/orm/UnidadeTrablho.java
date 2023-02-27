package br.com.pauloviniciius.SpringData.orm;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrablho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String setor;
}



