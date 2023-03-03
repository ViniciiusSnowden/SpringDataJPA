package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Funcionario;
import br.com.pauloviniciius.SpringData.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class RelatorioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private boolean system = true;
    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar Funcionario por nome");
//        System.out.println("2 - Atualizar ");
//        System.out.println("3 - Vizualizar ");
//        System.out.println("4 - Deletar ");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
//            case 2:
//                atualizar(scanner);
//                break;
//            case 3:
//                listar();
//                break;
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

}
