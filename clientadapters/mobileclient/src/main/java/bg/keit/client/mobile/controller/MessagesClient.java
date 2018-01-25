package bg.keit.client.mobile.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("messages-service")
public interface MessagesClient {
    @RequestMapping("/code/{code}")
    public String getFromCode(@PathVariable(value="code")int code);

    @RequestMapping("/name/{value}")
    public String getFromValue(@PathVariable(value="value")String valeue) ;
}
