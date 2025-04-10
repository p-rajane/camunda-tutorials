package tutorial;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

@SpringBootTest
@ActiveProfiles("test")
@EnableFeignClients
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FeignClientConfig.class})
public class FeignClientTest {

	@Autowired
	private WireMockServer wireMockServer;
	
	
	@BeforeEach
    void setUp() throws IOException {
		setupMockBooksResponse(wireMockServer);
    }
	
	public void setupMockBooksResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("?page"))
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
