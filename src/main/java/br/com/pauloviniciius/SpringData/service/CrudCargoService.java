package br.com.pauloviniciius.SpringData.service;

import br.com.pauloviniciius.SpringData.orm.Cargo;
import br.com.pauloviniciius.SpringData.repository.CargoRepository;
import lombok.Getter;
import lombok.Setter;
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
    public CrudCargoService(){
    }

    public void pt(String msg){
        System.out.println(msg);
    }

    public void inicial(Scanner scanner){

        while(system){
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar ");
            System.out.println("2 - Atualizar ");
            System.out.println("3 - Vizualizar ");
            System.out.println("4 - Deletar ");

            int action = scanner.nextInt();

            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    deletar(scanner);
                default:
                    system = false;
                    break;
            };
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

    public void listar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> pt(cargo.toString()));
    }

    private void deletar(Scanner scanner){
        listar();
        pt("Informe ID do cargo que deseja deletar");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        pt("Cargo deletado!!!");
    }
}
