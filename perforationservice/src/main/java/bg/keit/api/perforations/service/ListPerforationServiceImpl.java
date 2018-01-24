package bg.keit.api.perforations.service;

import bg.keit.model.dao.PerforationsDAO;
import bg.keit.model.domain.Perforations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ListPerforationServiceImpl implements ListPerforationService {
    @Autowired
    PerforationsDAO perforationsDAO;

    @Override
    public List<Perforations> findFromImportDateTime(Date var1) {

        return perforationsDAO.findFromImportDateTime(var1);
    }
}
