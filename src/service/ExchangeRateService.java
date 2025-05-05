package service;

import com.google.gson.Gson;
import model.CurrencyDto;
import util.HttpClienteServicio;

public class ExchangeRateService {

    private final Gson gson;
    private final HttpClienteServicio httpClienteServicio;

    public ExchangeRateService(){
        this.gson = new Gson();
        this.httpClienteServicio = new HttpClienteServicio();
    }
    public CurrencyDto getTasas(String moneda){

        String API_URL= "https://v6.exchangerate-api.com/v6/9499baf964471de7da287d3b/latest/"+moneda;

        return httpClienteServicio.getBody(API_URL)
                .map(json -> gson.fromJson(json,CurrencyDto.class))
                .orElse(null);
    }
}
