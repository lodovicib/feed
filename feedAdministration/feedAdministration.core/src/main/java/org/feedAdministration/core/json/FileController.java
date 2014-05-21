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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller 
@RequestMapping("/dataset")
public class FileController {
	 
	private final ListFile listFile = new ListFile();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String getAllFile() {
	     return buildJson(listFile.getList());
	 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	    public @ResponseBody String getFile(@PathVariable Long id) {
	     return buildJson(listFile.getFile(id));
	 }
	
		@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody File addFile(@RequestBody File newFile) {
		listFile.addFile(newFile);
		return newFile;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public @ResponseBody String modifyFile(@PathVariable("id") Long id, @RequestBody File newFile) {
	        return buildJson(listFile.modifyFile(id, newFile));
		}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteFile(@PathVariable("id") Long id) {
        return buildJson(listFile.deleteFile(id));
	}

	public ListFile getList() {
		return listFile;
	}
	
	private String buildJson(List<File> listFile) {
		 GsonBuilder b = new GsonBuilder();
		 b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		 Gson gson = b.create();
		 if (listFile.size() == 1)
			 return gson.toJson(listFile.get(0));
		 return gson.toJson(listFile);
	 }
	
	private String buildJson(File file) {
		 GsonBuilder b = new GsonBuilder();
		 b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		 Gson gson = b.create();
		 return gson.toJson(file);
	 }
}
