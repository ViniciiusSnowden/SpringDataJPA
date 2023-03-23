package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.repository.FuncionarioRepository;
import br.com.pauloviniciius.SpringData.specification.SpecificantionFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public void inicial(Scanner scanner){
        System.out.printf("Digite um nome");
        String nome = scanner.next();

        if(nome.equalsIgnoreCase("NULL")){
            nome = null;
        }

        System.out.printf("Digite um nome");
        String cpf = scanner.next();

        if(cpf.equalsIgnoreCase("NULL")){
            cpf = null;
        }

        System.out.printf("Digite um nome");
        Double salario = scanner.nextDouble();

        if(salario == null){
            salario = null;
        }


        System.out.printf("Digite um Data Contracacao");
        String dataContratacao = scanner.next();

        if(nome.equalsIgnoreCase("NULL")){
            nome = null;
        }


        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(SpecificantionFuncionario.nome(nome)));
    }
}
