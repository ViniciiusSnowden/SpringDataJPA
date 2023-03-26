package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.repository.FuncionarioRepository;
import br.com.pauloviniciius.SpringData.specification.SpecificantionFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void inicial(Scanner scanner){
        System.out.println("Digite um nome");
        String nome = scanner.next();

        if(nome.equalsIgnoreCase("NULL")){
            nome = null;
        }

        System.out.println("Digite um CPF");
        String cpf = scanner.next();

        if(cpf.equalsIgnoreCase("NULL")){
            cpf = null;
        }

        System.out.println("Digite um salario");
        Double salario = scanner.nextDouble();

        if(salario == 0){
            salario = null;
        }

        System.out.println("Digite uma Data Contracacao");
        String data = scanner.next();
        LocalDate dataContratacao;
        if(data.equalsIgnoreCase("NULL")){
          dataContratacao = null;
        }else{
            dataContratacao = LocalDate.parse(data, formatter);
        }

        List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
                .where(SpecificantionFuncionario.nome(nome).or(
                        SpecificantionFuncionario.cpf(cpf)).or(
                                SpecificantionFuncionario.salario(salario).or(
                                        SpecificantionFuncionario.dataContratacao(dataContratacao)))
                )
        );
        funcionarios.forEach(System.out::println);
    }
}
