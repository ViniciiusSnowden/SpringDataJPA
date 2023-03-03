package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
@Service
public class RelatorioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private boolean system = true;
    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar Funcionario por nome");
            System.out.println("2 - Buscar maior salario por nome");
            System.out.println("3 - Busca funcionario data contratacao ");
//        System.out.println("4 - Deletar ");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncioaniroNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscaFuncionarioDataContratcao(scanner);
                    break;
//            case 4:
//                deletar(scanner);
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioNome(Scanner scanner){
        System.out.println("Qual nome deseja pesquisar:");
        List<Funcionario> funcianrios = funcionarioRepository.findByNome(scanner.next());
        funcianrios.forEach(System.out::println);
    }

    private void buscaFuncioaniroNomeSalarioMaiorData(Scanner scanner){
        System.out.printf("Qual nome funcionario deseja buscar");
        String nome = scanner.next();

        System.out.println("Qual data de contratacao");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario");
        Double salario  = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome,salario, localDate);
        list.forEach(System.out::println);

    }

    private void buscaFuncionarioDataContratcao(Scanner scanner){
        System.out.println("Qual data contratacao");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);
        List<Funcionario> list = funcionarioRepository.findDataContracacaoMaior(localDate);
        list.forEach(System.out::println);
    }

}
