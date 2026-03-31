package br.com.pedropgaraujo.tabela_fipe.controller;

import br.com.pedropgaraujo.tabela_fipe.service.APIService;
import br.com.pedropgaraujo.tabela_fipe.service.VehicleService;
import br.com.pedropgaraujo.tabela_fipe.util.DataConvert;

import java.util.Scanner;

public class VehicleController {

    private Scanner scan = new Scanner(System.in);
    private VehicleService vehicle = new VehicleService();
    private APIService apiService = new APIService();
    private DataConvert dataConvert = new DataConvert();

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
        String model = scan.nextLine();
        addres = vehicle.searchTypeAndBrand(addres,model) + "anos/";
        json = apiService.obterDados(addres);
        vehicle.returnYearList(json, model);

        System.out.println("Digite o código do modelo que gostaria de consultar os valores:");


//        System.out.println(json);
//        var brands = dataConvert.obterLista(json, BrandCarData.class);
//        brands.stream()
//                .sorted(Comparator.comparing(BrandCarData::code))
//                        .forEach(System.out::println);
//        BrandCarData brandCarData = dataConvert.obterDados(json, BrandCarData.class);
//        System.out.println(brandCarData);
//        vehicle.returnBrandList(addres);
//        addres = vehicle.searchBrandModelAndYear(addres, scan.nextLine()) + "modelos/";
//        json = apiService.obterDados(addres);
//        ModelCarData modelCarData = dataConvert.obterDados(json, ModelCarData.class);
//        System.out.println(modelCarData);
//        System.out.println("Digite o código do modelo que gostaria de consultar:");
//        addres = vehicle.searchBrandModelAndYear(addres, scan.nextLine()) + "anos/";
//        json = apiService.obterDados(addres);
//        YearCarData yearCarData = dataConvert.obterDados(json, YearCarData.class);
//        System.out.println(yearCarData);
//        System.out.println("Digite o código do ano que gostaria de consultar: ");
//        addres = vehicle.searchBrandModelAndYear(addres, scan.nextLine());
//        json =apiService.obterDados(addres);
//        CarData carData = dataConvert.obterDados(json, CarData.class);
//        System.out.println(carData);


    }


}
