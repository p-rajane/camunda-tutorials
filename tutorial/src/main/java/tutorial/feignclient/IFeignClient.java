package tutorial.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jplaceholder", url = "https://reqres.in/api/users")
public interface IFeignClient {
	  @GetMapping("?page={pageNumber}")
	    String getPosts(@PathVariable(value = "pageNumber") String pageNumber);

}
