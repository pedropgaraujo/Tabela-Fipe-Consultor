package br.com.pedropgaraujo.tabela_fipe.controller;

import br.com.pedropgaraujo.tabela_fipe.service.APIService;
import br.com.pedropgaraujo.tabela_fipe.service.VehicleService;
import br.com.pedropgaraujo.tabela_fipe.util.DataConvert;

import java.util.Scanner;

public class VehicleController {

    private Scanner scan = new Scanner(System.in);
    private VehicleService vehicle = new VehicleService();
    private APIService apiService = new APIService();

    public void welcomeMessage(){
        System.out.println("Bem-vindo ao sistema de busca de carros na Tabela Fipe");
        System.out.println("O que você gostaria de consultar?");
        System.out.println("Carros/Motos/Caminhoes");
    }

    public void beginSearch (){
        String addres = vehicle.searchStart(scan.nextLine()) + "marcas/";
        var json = apiService.obterDados(addres);
        vehicle.returnBrandList(json);

        System.out.println("Digite o código da marca que gostaria de consultar:");
        addres = vehicle.searchTypeAndBrand(addres,scan.nextLine()) + "modelos/";
        json = apiService.obterDados(addres);
        vehicle.returnModelList(json);

        System.out.println("Digite o nome do modelo que gostaria de consultar:");
        vehicle.returnModelsFiltered(json, scan.nextLine());

        System.out.println("Digite o código do modelo que gostaria de consultar os valores:");
        addres = vehicle.searchTypeAndBrand(addres,scan.nextLine()) + "anos/";
        json = apiService.obterDados(addres);
        vehicle.returCarModelsYearsList(json, addres);

    }


}
