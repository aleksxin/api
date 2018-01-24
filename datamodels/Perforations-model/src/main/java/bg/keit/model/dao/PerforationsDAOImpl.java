package bg.keit.model.dao;

import bg.keit.model.domain.Perforations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
public class PerforationsDAOImpl implements PerforationsDAO{

    @PersistenceContext
	private EntityManager entityManager;
	
	
	public PerforationsDAOImpl(){
	}

	/*public PerforationsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }*/
    
    @Override
    public Perforations findByJobID(int job_id){
    	return (Perforations)entityManager.createQuery(
                "from Perforations p where p.id.jobId = :pid")
                    .setParameter("pid", job_id)
                    .getSingleResult();
    }
    
    @Override
    public Perforations findBySerNumberAndEncCode(Integer serial, String code){
    	return (Perforations)entityManager.createQuery("from Perforations p where p.id.serialNumber=:ser and p.encryptionCode = :enc")
                .setParameter("ser", serial)
                .setParameter("enc", code)
                .getSingleResult();
    }
    
    @Override
    public Perforations findByEncCode(String code){
    	return (Perforations)entityManager.createQuery("from Perforations p where p.encryptionCode = :enc")
                .setParameter("enc", code)
                .getSingleResult();
    }
    
    @Override
    public List<Perforations> findFromImportDateTime(Date importDT){
    	return (List<Perforations>)entityManager.createQuery("from Perforations p where p.importDatetime>:imp")
                .setParameter("imp", importDT)
                .getResultList();
    }
}
