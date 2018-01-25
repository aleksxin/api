package bg.keit.api.service;

import bg.keit.model.message.domain.ResponseMessage;

public interface MessageService {
    ResponseMessage getFromCode(int code);
    ResponseMessage getFromValue(String valeue);
}
