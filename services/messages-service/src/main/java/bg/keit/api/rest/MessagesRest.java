package bg.keit.api.rest;

import bg.keit.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesRest {
    @Autowired
    MessageService messageService;

    @RequestMapping("/code/{code}")
    public String getFromCode(@PathVariable(value="code")int code) {
        return messageService.getFromCode(code).getMessage();
    }

    @RequestMapping("/name/{value}")
    public String getFromValue(@PathVariable(value="value")String valeue) {
        return messageService.getFromValue(valeue).getMessage();
    }
}
