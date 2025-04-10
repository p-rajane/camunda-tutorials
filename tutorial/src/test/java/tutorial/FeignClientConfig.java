package tutorial;

import java.io.IOException;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

@TestConfiguration
@ActiveProfiles("test")
public class FeignClientConfig {
	
	@Bean
	public WireMockServer mockServer() {
		return new WireMockServer(80);
	}

	public static void setupMockBooksResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/books"))
          .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())
            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .withBody("[\r\n"
            		+ "  {\r\n"
            		+ "    \"title\": \"Dune\",\r\n"
            		+ "    \"author\": \"Frank Herbert\"\r\n"
            		+ "  },\r\n"
            		+ "  {\r\n"
            		+ "    \"title\": \"Foundation\",\r\n"
            		+ "    \"author\": \"Isaac Asimov\"\r\n"
            		+ "  }\r\n"
            		+ "]")));
    }
	
}
