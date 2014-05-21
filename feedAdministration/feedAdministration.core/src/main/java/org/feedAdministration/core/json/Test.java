package org.feedAdministration.core.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.feedAdministration.hibernate.domain.File;
import org.feedAdministration.util.HibernateProxyTypeAdapter;
import org.feedAdministration.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//@Path("/dataset")
public class Test {
	 @GET 
	    @Produces("application/json")
	    public String getAllData() {
		 
         List<File> listFile =  getQuery(null);
	     return buildJson(listFile);
	 }
	 
	 @GET 
	 @Path("/{id}")
	 @Produces("application/json")
	    public String getId(@PathParam("id") String id) {
		 List<File> listFile =  getQuery("WHERE id_file="+id);
	     return buildJson(listFile);
	 }
	 
	/* @GET 
	 @Path("search")
	 @Produces("application/json")
	    public String getName(@DefaultValue("all") @QueryParam("name") String name,
	    		@DefaultValue("OK") @QueryParam("status") String status) {
		List<File> listFile =  getQuery("WHERE status_file="+status);
		System.out.println(listFile.size());
	     //return buildJson(listFile);
		 return name + status;
	 }
	*/ 
	 public List<File> getQuery(String sql) {
		 List<File> listFile = new ArrayList<File>();
		 SessionFactory sf = HibernateUtil.createSessionFactory();
         Session session = sf.openSession();
         try {
        	 Query query;
        	 if (sql != null)
        	 	query =  session.createQuery("FROM File "+sql);
        	 else
        		 query =  session.createQuery("FROM File");
			 Iterator<?> it = query.iterate();
			 while (it.hasNext()) { 
		   		File file = (File) it.next();
		   		// a laisser sinon ça ne marche pas...
		   		file.getName();
		   		listFile.add(file);
		   	}
         } finally { 
             session.close(); 
         }
          sf.close();
          return listFile;
	 }
	 
	 public String buildJson(List<File> listFile) {
		 GsonBuilder b = new GsonBuilder();
		 b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		 Gson gson = b.create();
		 if (listFile.size() == 1)
			 return gson.toJson(listFile.get(0));
		 return gson.toJson(listFile);
	 }
}
