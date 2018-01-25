package bg.keit.client.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckRestController {
    @Autowired
    CheckPerforationsClient checkPerforationsClient;


    @RequestMapping("/check")
    public String findme(@RequestParam(value="s", required=false) Integer Serial, @RequestParam(value="c", required=false) String EncCode, @RequestParam(value="t") int rtype) {
        return checkPerforationsClient.convertCtoF(Serial, EncCode, rtype);
    }


    }
