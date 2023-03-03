package br.com.pauloviniciius.SpringData.orm;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String endereco;
    @ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;


    @Override
    public String toString() {
        return "Unidades: " + "id:" + id +
                "| descricao:" + descricao +
                "| endereco:" + endereco;
    }
}



