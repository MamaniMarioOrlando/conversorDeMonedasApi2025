import com.google.gson.Gson;
import model.CurrencyDto;

public class ExchangeRateService {
    private static final String API_URL= "https://v6.exchangerate-api.com/v6/9499baf964471de7da287d3b/latest/USD";

    private final Gson gson;
    private final HttpClienteServicio httpClienteServicio;

    public ExchangeRateService(){
        this.gson = new Gson();
        this.httpClienteServicio = new HttpClienteServicio();
    }
    public CurrencyDto getTasas(){
        return httpClienteServicio.getBody(API_URL)
                .map(json -> gson.fromJson(json,CurrencyDto.class))
                .orElse(null);
    }
}
