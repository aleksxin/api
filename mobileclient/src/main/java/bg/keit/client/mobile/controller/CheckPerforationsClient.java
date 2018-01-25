package bg.keit.client.mobile.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("check-perforations")
public interface CheckPerforationsClient {
    @RequestMapping("/")
     String convertCtoF(@RequestParam(value="s", required=false) Integer Serial, @RequestParam(value="c", required=false) String EncCode, @RequestParam(value="t") int rtype) ;
}
