package bg.keit.client.mobile.controller;

import bg.keit.client.mobile.json.RespMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CheckRestController {
    @Autowired
    CheckPerforationsClient checkPerforationsClient;

    @Autowired
    MessagesClient messagesClient;


    @RequestMapping("/check")
    public RespMessage findme(@RequestParam(value="s", required=false) Integer Serial, @RequestParam(value="c", required=false) String EncCode, @RequestParam(value="t") int rtype) {
        RespMessage respMessage = new RespMessage();
        respMessage.setCode(200);
        //respMessage.setStatus(messagesClient);
        respMessage.setMessage(messagesClient.getFromValue(checkPerforationsClient.convertCtoF(Serial, EncCode, rtype)));
        respMessage.setMessage_date(new Date());
        return respMessage;
    }


    }
