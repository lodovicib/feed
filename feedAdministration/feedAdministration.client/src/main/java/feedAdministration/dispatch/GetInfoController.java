package feedAdministration.dispatch;


import java.util.Iterator;
import java.util.logging.Logger;

import org.feedAdministration.core.json.FileController;
import org.feedAdministration.core.json.ListFile;
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
	private ListFile listFile = new ListFile();
	private final FileController f = new FileController();

    @RequestMapping(value="/getinfo.html",method = RequestMethod.GET)
    public String getInfos(ModelMap model){
    	 logger.info("method getInfos called in the controller");
    	 listFile = f.getList();
    	 model.addAttribute("infos",new String("\tL'environnement Spring MVC est OK"));
         	Iterator<File> it = listFile.getList().iterator();
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
         	model.addAttribute("count", new String(String.valueOf(listFile.getSize())));
        return null;
    }
}