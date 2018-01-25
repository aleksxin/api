package bg.keit.model.message.dao;

import bg.keit.model.message.domain.ResponseMessage;

public interface MessagesDao {
    ResponseMessage getFromCode(int code);
    ResponseMessage getFromValue(String valeue);
}
