package bg.keit.api.service;

import bg.keit.model.message.dao.MessagesDao;
import bg.keit.model.message.domain.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessagesDao messagesDao;

    @Override
    public ResponseMessage getFromCode(int code) {
        return messagesDao.getFromCode(code);
    }

    @Override
    public ResponseMessage getFromValue(String valeue) {
        return messagesDao.getFromValue(valeue);
    }
}
