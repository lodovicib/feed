package feedAdministration.dispatch;


import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import org.feedAdministration.hibernate.domain.File;
import org.feedAdministration.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("getInfoController")
public class GetInfoController {
	
	final Logger logger=Logger.getLogger(getClass().getName());
    /**
     * Handler de la méthode Get pour l'URL /getInfos.html.  
     * @param model une map des données qui sont utilisables dans la vue
     * @return <code>null</code> donc la vue choisie par défaut,càd ici /WEB-INF/jsp/getInfos.jsp.
     **/
    @RequestMapping(value="/getinfo.html",method = RequestMethod.GET)
    public String getInfos(ModelMap model){
    	 logger.info("method getInfos called in the controller");
    	 
    	 SessionFactory sf = HibernateUtil.createSessionFactory();
         Session session = sf.openSession();
      /*  session.beginTransaction();
         
         File f1 = new File("File One", "OK", new Date());
         File f2 = new File("File Two", true,"ceci est un message", new Date());
         File f3 = new File("File Treeeee", "NOK", new Date());
         File f4 = new File("File fouuuur", false,"ceci est un message nul", new Date());
         session.persist(f1);
         session.persist(f2);
         session.persist(f3);
         session.persist(f4);

         session.getTransaction().commit();*/
         model.addAttribute("infos",new String("\tL'environnement Spring MVC est OK"));
         
         try { 
         	Query query =  session.createQuery("FROM File"); 
         	Iterator<?> it = query.iterate();
         	int i=0;
         	while (it.hasNext()) { 
         		File file = (File) it.next();
         		if (file.getMessage() != null)
         		model.addAttribute("line"+ i++, new String(("<tr><td>" + file.getName() + 
         				"</td><td>" + file.getStatus() + "</td><td>" + file.getMessage()
         				+ "</td><td>" + file.getDate() + "</td></tr>")));
         		else
         			model.addAttribute("line"+ i++, new String(("<tr><td>" + file.getName() + 
             				"</td><td>" + file.getStatus() + "</td><td></td><td>" + file.getDate() + "</td></tr>")));
         	}
         	model.addAttribute("count", new String(String.valueOf(i)));
         } finally { 
           session.close(); 
         } 
         
        sf.close(); 
       
        return null;
    }
}