package bg.keit.api.perforations.service;

import bg.keit.model.domain.Perforations;

import java.util.Date;
import java.util.List;

public interface ListPerforationService {
    List<Perforations> findFromImportDateTime(Date var1);
}
