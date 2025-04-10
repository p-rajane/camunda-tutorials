package tutorial.servicetask;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import tutorial.feignclient.IFeignClient;

@RestController
@RequestMapping("call")
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	IFeignClient iFeignClient;
	
	@GetMapping("/executeRest")
	public String executeRest() {
		String forObject = restTemplate.getForObject("https://gorest.co.in/public/v2/users/1700731/posts", String.class, new HashMap<>());
		return forObject;
	}
	
	@GetMapping("/executeSoap")
	public String executeSoap() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/xml; charset=utf-8");
		String req = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>500</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		HttpEntity<String> request = 
			      new HttpEntity<String>(req.toString(), headers);
		String forObject = restTemplate.postForObject("https://www.dataaccess.com/webservicesserver/NumberConversion.wso", request, String.class);
		return forObject;
	}
	
	@GetMapping("/executeGetWebClient")
	public String executeGetWebClient() {
		WebClient client = WebClient.create();
		ResponseSpec retrieve = client.get().uri("https://reqres.in/api/users?page=2").retrieve();
		String response = retrieve.bodyToMono(String.class).block();
		return response;
	}
	
	@GetMapping("/executePostGetWebClient")
	public String executePostGetWebClient() throws URISyntaxException {
		
		WebClient client = WebClient.create();
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

		bodyValues.add("key", "value");
		bodyValues.add("another-key", "another-value");

		String response = client.post()
		    .uri(new URI("https://httpbin.org/post"))
		    .header("Authorization", "Bearer MY_SECRET_TOKEN")
		    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
		    .accept(MediaType.APPLICATION_JSON)
		    .body(BodyInserters.fromFormData(bodyValues))
		    .retrieve()
		    .bodyToMono(String.class)
		    .block();
		return response;
	}
	
	@GetMapping("/executeFeignClient/{pageNumber}")
	public String executeFeignClient(@PathVariable String pageNumber) {
		String posts = iFeignClient.getPosts(pageNumber);
		return posts;
	}

}
