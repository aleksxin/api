package bg.keit.model.message.dao;

import bg.keit.model.message.domain.ResponseMessage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MessagesDaoImpl implements MessagesDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ResponseMessage getFromCode(int code) {
        return (ResponseMessage) entityManager.createQuery(
                "from ResponseMessage p where p.code = :pid")
                .setParameter("pid", code)
                .getSingleResult();
    }

    @Override
    public ResponseMessage getFromValue(String valeue) {
        return (ResponseMessage) entityManager.createQuery(
                "from ResponseMessage p where p.value = :pid")
                .setParameter("pid", valeue)
                .getSingleResult();

    }
}
