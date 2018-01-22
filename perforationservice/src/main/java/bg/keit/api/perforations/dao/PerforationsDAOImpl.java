package bg.keit.api.perforations.dao;

import bg.keit.api.perforations.domain.Perforations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class PerforationsDAOImpl implements PerforationsDAO{
	private SessionFactory sessionFactory;
	
	
	public PerforationsDAOImpl(){
	}

	public PerforationsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Perforations findByJobID(int job_id){
    	return (Perforations)currentSession().createQuery(
                "from Perforations p where p.id.jobId = :pid")
                    .setParameter("pid", job_id)
                    .uniqueResult();
    }
    
    @Override
    public Perforations findBySerNumberAndEncCode(Integer serial, String code){
    	return (Perforations)currentSession().createQuery("from Perforations p where p.id.serialNumber=:ser and p.encryptionCode = :enc")
                .setParameter("ser", serial)
                .setParameter("enc", code)
                .uniqueResult();
    }
    
    @Override
    public Perforations findByEncCode(String code){
    	return (Perforations)currentSession().createQuery("from Perforations p where p.encryptionCode = :enc")
                .setParameter("enc", code)
                .uniqueResult();
    }
    
    @Override
    public List<Perforations> findFromImportDateTime(Date importDT){
    	return (List<Perforations>)currentSession().createQuery("from Perforations p where p.importDatetime>:imp")
                .setParameter("imp", importDT)
                .list();
    }
}
