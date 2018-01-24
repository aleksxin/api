package bg.keit.api.perforations.rest;

import bg.keit.api.perforations.service.PerforationSevice;
import bg.keit.model.domain.Perforations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
//import bg.keit.perforaitons.check.service.perforationsServiceHibernateImpl;


@RestController
public class CheckPerforations {

	@Autowired
	PerforationSevice checkPerfService;// = new EncryptedMarkReader(getClass().getClassLoader().getResourceAsStream("SecreadParamsLogo.xml"),getClass().getClassLoader().getResourceAsStream("secmark.xml"));

	//@GET
	@RequestMapping("/")
	//@Produces("application/json")
	//@Path("/check")
	
	public String convertCtoF(@QueryParam("s") Integer Serial, @QueryParam("c") String EncCode, @QueryParam("t") int rtype) {
		String resp="Invalid request";
        try
        {
        if ((rtype==1)&&(Serial!=null)&&(EncCode!=null))
        {
        	Perforations Perf = checkPerfService.findByJobID(rtype);

        	if (Perf!=null)
        	{
        		resp="true";
        	}
        	else
        	{
        		resp="false";
        	}
        }
        if ((rtype==0)&&(Serial!=null)&&(EncCode!=null))
        {
        	Perforations Perf =  checkPerfService.findBySerNumberAndEncCode(Serial,EncCode);
        	/*		(Perforations) session
                    .createQuery("from Perforations p where p.id.serialNumber=:ser and p.encryptionCode = :enc")
                    .setParameter("ser", Serial)
                    .setParameter("enc", EncCode)
                    .uniqueResult();*/
        	if (Perf!=null)
        	{
        		resp="true";
        	}
        	else
        	{
        		resp="false";
        	}
        }
        if ((rtype!=0)&&(EncCode!=null))
        {
       Perforations Perf =  checkPerfService.findByEncCode(EncCode);
        	if (Perf!=null)
        	{
        		resp="true";
        	}
        	else
        	{
        		resp="false";
        	}
	}
         // Eager fetch the collection so we can use it detached
      //  session.getTransaction().commit();
	}catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        
      //  tx.rollback();
        throw e;
    }finally{
      //  session.close();
    }
        return "{\nresponse:"+resp+"\n}";

       
	}
}
