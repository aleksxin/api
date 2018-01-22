package bg.keit.api.perforations.dao;

import bg.keit.api.perforations.domain.Perforations;

import java.util.Date;
import java.util.List;

public interface PerforationsDAO {
	Perforations findByJobID(int job_id);
	Perforations findBySerNumberAndEncCode(Integer serial, String code);
	Perforations findByEncCode(String code);
	List<Perforations> findFromImportDateTime(Date importDT);
}
