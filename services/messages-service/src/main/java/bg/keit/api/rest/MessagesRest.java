package bg.keit.api.rest;

import bg.keit.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesRest {
    @Autowired
    MessageService messageService;


}
