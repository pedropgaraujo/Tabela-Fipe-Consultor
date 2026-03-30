package br.com.pedropgaraujo.tabela_fipe.controller;

public class VehicleController {

    public void welcomeMessage(){
        System.out.println("Bem-vindo ao sistema de busca de carros na Tabela Fipe");
        System.out.println("O que você gostaria de consultar?");
        System.out.println("Carros/Motos/Caminhoes");
    }

    public String searchBrand (String addres, int code){
        addres = addres + code;
        return addres;
    }
}
