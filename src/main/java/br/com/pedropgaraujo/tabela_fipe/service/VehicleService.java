package br.com.pedropgaraujo.tabela_fipe.service;

import br.com.pedropgaraujo.tabela_fipe.dto.CarData;
import br.com.pedropgaraujo.tabela_fipe.dto.ModelCarData;
import br.com.pedropgaraujo.tabela_fipe.dto.BrandCarData;
import br.com.pedropgaraujo.tabela_fipe.util.DataConvert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    private APIService api = new APIService();
    private DataConvert dataConvert = new DataConvert();

    public String searchStart (String typeVehicle){
            String addres =  api.getADDRES() + typeVehicle.toLowerCase() + "/";
        return addres;
    }

    public String searchTypeAndBrand(String addres, String type){
        addres = addres + type + "/";
        return addres;
    }

    public void returnBrandList(String json){
        var brandsJson = dataConvert.obterLista(json, ModelCarData.class);
        brandsJson.stream()
                .sorted(Comparator.comparing(ModelCarData::code))
                .forEach(System.out::println);
    }

    public void returnModelList(String json){
        var modelsList = dataConvert.obterDados(json, BrandCarData.class);
        System.out.println("Modelos da Marca: ");
        modelsList.models().stream()
                .sorted(Comparator.comparing(ModelCarData::code))
                .forEach(System.out::println);
    }

    public void returnModelsFiltered(String json, String model){
        var modelsList = dataConvert.obterDados(json, BrandCarData.class);
        List<ModelCarData> modelsFiltered = modelsList.models().stream()
                .filter(m -> m.name().toLowerCase().contains
                        (model.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Modelos Filtrados: ");
        modelsFiltered.forEach(System.out::println);
    }

    public void returCarModelsYearsList(String json, String addres){
        List<ModelCarData> year = dataConvert.obterLista(json, ModelCarData.class);
        List<CarData> vehicle = new ArrayList<>();

        for (int i= 0; i < year.size(); i++){
            var addresYears = addres + year.get(i).code();
            APIService apiService = new APIService();
            json = apiService.obterDados(addresYears);
            CarData carData = dataConvert.obterDados(json, CarData.class);
            vehicle.add(carData);
        }
        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: ");
        vehicle.forEach(System.out::println);
    }

}
