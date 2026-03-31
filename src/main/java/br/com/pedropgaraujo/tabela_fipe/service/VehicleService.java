package br.com.pedropgaraujo.tabela_fipe.service;

import br.com.pedropgaraujo.tabela_fipe.dto.BrandCarData;
import br.com.pedropgaraujo.tabela_fipe.dto.ModelCarData;
import br.com.pedropgaraujo.tabela_fipe.dto.YearCarData;
import br.com.pedropgaraujo.tabela_fipe.util.DataConvert;

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

    public String searchModels(String addres, String model){
        addres = addres + model + "/";
        return addres;

    }

    public void returnBrandList(String json){
        var brandsJson = dataConvert.obterLista(json, BrandCarData.class);
        brandsJson.stream()
                .sorted(Comparator.comparing(BrandCarData::code))
                .forEach(System.out::println);

    }

    public void returnModelList(String json){
        var modelsList = dataConvert.obterDados(json, ModelCarData.class);
        System.out.println("Modelos da Marca: ");
        modelsList.models().stream()
                .sorted(Comparator.comparing(BrandCarData::code))
                .forEach(System.out::println);

    }

    public void returnYearList(String json, String model){
        var modelsList = dataConvert.obterDados(json, ModelCarData.class);
        System.out.println("Modelos da Marca: ");
        List<BrandCarData> filtersModel = modelsList.models().stream()
                .filter(m -> m.name().toLowerCase().contains(model.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Modelos Filtrados: ");
        filtersModel.forEach(System.out::println);

    }

}
