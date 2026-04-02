package br.com.pedropgaraujo.tabela_fipe;

import br.com.pedropgaraujo.tabela_fipe.controller.VehicleController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TabelaFipeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        VehicleController vehicleController = new VehicleController();
        vehicleController.welcomeMessage();
        vehicleController.beginSearch();
    }
}
