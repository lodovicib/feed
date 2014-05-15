package feedAdministrationTest.dispatch;


import java.util.logging.Logger;

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
        model.addAttribute("infos",new String("\tL'environnement Spring MVC est OK"));
        return null;
    }
}