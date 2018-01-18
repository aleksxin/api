package bg.keit.api.perforations.rest;

import bg.keit.perforations.check.service.ListPerforationsService;
import bg.keit.perforations.domain.Perforations;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
//import bg.keit.perforaitons.check.service.perforationsServiceHibernateImpl;


@Path("/")
public class ListPerforations {

	@Inject
	ListPerforationsService listPerfService;// = new EncryptedMarkReader(getClass().getClassLoader().getResourceAsStream("SecreadParamsLogo.xml"),getClass().getClassLoader().getResourceAsStream("secmark.xml"));

	@GET
	@Path("/update")
	@Produces("application/json")
	//@Path("/check")
	
	public Response convertCtoF(@QueryParam("tm") long timeStampValue) {
		String resp="";
        try
        {
        	Calendar start = Calendar.getInstance();
        	start.setTimeInMillis(timeStampValue*1000);
        	//start.setTimeInMillis( timeStampValue.getTime() );
        
        	List<Perforations> lPerfs = listPerfService.findFromImportDateTime(start.getTime());
        	
        	//List<integer> temp;
        	//temp.siz
        	//resp=start.getTime().toString()+'\n';
        	if (lPerfs.size()>0) {
        		StringBuilder sb = new StringBuilder();
        		//sb.append("Test String");
        		
        		
        	
        		for (int i = 0; i < lPerfs.size(); i++) {
        			Calendar c = Calendar.getInstance();
        		    c.setTime(lPerfs.get(i).getImportDatetime());
        		    sb.append(lPerfs.get(i).getId().getMachineId());
        		    sb.append("\t");
        		    sb.append(Integer.toString(lPerfs.get(i).getId().getJobId()));
        		    sb.append("\t");
        		    sb.append(Integer.toString(lPerfs.get(i).getId().getSerialNumber()));
        		    sb.append("\t");
        		    sb.append(lPerfs.get(i).getOCRNumber());
        		    sb.append("\t");
        		    sb.append(lPerfs.get(i).getEncryptionCode());
        		    sb.append("\t");
        		    sb.append(lPerfs.get(i).getExecutionDate().toString());
        		    sb.append("\t");
        		    sb.append(lPerfs.get(i).getExecutionTime().toString());
        		    sb.append("\t");
        		    sb.append(Long.toString(c.getTimeInMillis()/(long)1000));
        		    sb.append("\n");
        			//resp=resp+lPerfs.get(i).getId().getMachineId()+"\t"+ Integer.toString(lPerfs.get(i).getId().getJobId())+"\t"+ Integer.toString(lPerfs.get(i).getId().getSerialNumber())+"\t"+lPerfs.get(i).getOCRNumber()+"\t"+lPerfs.get(i).getEncryptionCode()+"\t"+lPerfs.get(i).getExecutionDate().toString()+"\t"+lPerfs.get(i).getExecutionTime().toString()+"\t"+ Long.toString(c.getTimeInMillis())+" | \n";
        		}
        		try
        		{
        		File f = File.createTempFile("update"+ Long.toString(timeStampValue),".zip");
        			//	new File("d:\\test.zip");
        		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        		ZipEntry e = new ZipEntry("update.csv");
        		out.putNextEntry(e);

        		byte[] data = sb.toString().getBytes();
        		out.write(data, 0, data.length);
        		out.closeEntry();

        		out.close();

        		ResponseBuilder response = Response.ok((Object) f).status(200);
        		response.header("Content-Disposition",
        			"attachment; filename=\"update.zip\"");
        		return response.build();
        		}
        		catch(IOException e) {
        	        // TODO Auto-generated catch block
        	        e.printStackTrace();
        	        
        	      //  tx.rollback();
        	      //  throw e;
        	        ResponseBuilder responseBuilder=Response.serverError();
        	       
        	        return responseBuilder.build();
        	    }
        		
        	}
        	else
        	{
        		ResponseBuilder responseBuilder=Response.ok().status(200);
    	        responseBuilder.entity("no data");
    	        return responseBuilder.build();
        	}
	}catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        ResponseBuilder responseBuilder=Response.serverError();
        throw e; 
      //  return responseBuilder.build();
      //  tx.rollback();
        
    }finally{
      //  session.close();
    }
     //   return "{\nresponse:"+resp+"\n}";

       
	}
	

	@GET
	@Path("/get")
	@Produces("text/plain")
	public Response getFile(@QueryParam("tm") long timeStampValue) {

		StringBuilder sb = new StringBuilder();
		sb.append("Test String");
		try
		{
		File f = File.createTempFile("update"+ Long.toString(timeStampValue),".zip");
			//	new File("d:\\test.zip");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("update.csv");
		out.putNextEntry(e);

		byte[] data = sb.toString().getBytes();
		out.write(data, 0, data.length);
		out.closeEntry();

		out.close();

		ResponseBuilder response = Response.ok((Object) f);
		response.header("Content-Disposition",
			"attachment; filename=\"update.zip\"");
		return response.build();
		}
		catch(IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        
	      //  tx.rollback();
	      //  throw e;
	        return null;
	    }
		
	}

	


	
}
