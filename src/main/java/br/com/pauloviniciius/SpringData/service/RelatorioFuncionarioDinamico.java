package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.repository.FuncionarioRepository;
import br.com.pauloviniciius.SpringData.specification.SpecificantionFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public void inicial(Scanner scanner){
        System.out.printf("Digite um nome");
        String nome = scanner.next();

        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(SpecificantionFuncionario.nome(nome)));
    }
}
