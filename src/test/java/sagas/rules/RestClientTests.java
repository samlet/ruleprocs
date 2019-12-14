package sagas.rules;

import org.acme.restclient.CountriesService;
import org.acme.restclient.Country;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public class RestClientTests {
    @Test
    public void testClient() throws URISyntaxException {
        URI apiUri = new URI("https://restcountries.eu/rest");
        CountriesService svc = RestClientBuilder.newBuilder()
                .baseUri(apiUri)
                .build(CountriesService.class);
        Set<Country> result=svc.getByName("greece");
        System.out.println(result);
    }

}
