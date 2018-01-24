package bg.keit.api.perforations.service;

import bg.keit.model.dao.PerforationsDAO;
import bg.keit.model.domain.Perforations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PerforationSeviceImpl implements PerforationSevice {
    @Autowired
    PerforationsDAO perforationsDAO;

    @Override
    public Perforations findByJobID(int i) {
        return perforationsDAO.findByJobID(i);
    }

    @Override
    public Perforations findBySerNumberAndEncCode(Integer integer, String s) {

        return perforationsDAO.findBySerNumberAndEncCode(integer,s);
    }

    @Override
    public Perforations findByEncCode(String s) {

        return perforationsDAO.findByEncCode(s);
    }
}
