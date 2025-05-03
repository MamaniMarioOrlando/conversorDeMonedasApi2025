import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HttpClienteServicio {
    private final HttpClient client = HttpClient.newHttpClient();

    public Optional<String> getBody(String url){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse
                    .BodyHandlers.ofString());
            return Optional.ofNullable(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la consulta HTTP: "+ e.getMessage());
            return Optional.empty();
        }
    }
}
