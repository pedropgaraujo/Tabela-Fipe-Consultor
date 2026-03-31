package br.com.pedropgaraujo.tabela_fipe.service;

import br.com.pedropgaraujo.tabela_fipe.dto.BrandCarData;
import br.com.pedropgaraujo.tabela_fipe.util.DataConvert;

import java.util.Comparator;


public class VehicleService {

    private APIService api = new APIService();
    private DataConvert dataConvert = new DataConvert();

    public String searchStart (String typeVehicle){
            String addres =  api.getADDRES() + typeVehicle.toLowerCase() + "/";
        return addres;
    }

    public String searchBrandModelAndYear (String addres, String type){
        addres = addres + type + "/";
        return addres;

    }

    public void returnList(String json){
        var brands = dataConvert.obterLista(json, BrandCarData.class);
        brands.stream()
                .sorted(Comparator.comparing(BrandCarData::code))
                .forEach(System.out::println);

    }

}
