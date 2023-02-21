package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Cargo;
import br.com.pauloviniciius.SpringData.repository.CargoRepository;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    @Autowired
    private CargoRepository cargoRepository;
    private boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    public void pt(String msg){
        System.out.println(msg);
    }

    public void inicial(){

        Scanner scanner = new Scanner(System.in);
        while(system){
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar cargo");
            System.out.println("2 - Atualizar cargo");

            int action = scanner.nextInt();
            if(action == 1){
                salvar(scanner);
            }else if(action == 2){
                atualizar(scanner);
            }else{
                system = false;
            }
        };



    }

    private void salvar(Scanner scanner){
         pt("Descrição do Cargo");
         String descricao = scanner.next();
         Cargo cargo = new Cargo();
         cargo.setDescricao(descricao);
         cargoRepository.save(cargo);
         this.pt("Salvo");
    }

    private void atualizar(Scanner scanner){
        pt("id");
        int id = scanner.nextInt();
        pt("Descrição do Cargo");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        this.pt("Salvo");

    }
}
