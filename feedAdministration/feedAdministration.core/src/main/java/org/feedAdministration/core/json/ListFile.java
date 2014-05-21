package org.feedAdministration.core.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.feedAdministration.hibernate.domain.File;
import org.feedAdministration.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ListFile {
	
	private List<File> list;
	private int size;
	
	public ListFile() {
		list = getQuery(null);
		size = list.size();
	}

	public ListFile(List<File> _list) {
		list = _list;
		size = _list.size();
	}

	public List<File> getList() {
		return list;
	}

	public void setList(List<File> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addFile(File file) {
		addFileToBDD(file);
		list.add(file);
		size++;
	}
	
	public File deleteFile(Long id) {
		int index = findIndexToId(id);
		if (index != -1) {
			File tmp = list.get(index);
			deleteFileToBDD(tmp);
			list.remove(index);
			size--;
			return tmp;
		}
		return null;
	}
	
	public File modifyFile(Long id, File file) {
		int index = findIndexToId(id);
		if (index != -1) {
			list.get(index).replaceData(file);
			modifyFileToBDD(list.get(index));
			return list.get(index);
		}
		return null;
	}
	
	private int findIndexToId(Long id) {
		Iterator<File> it = list.iterator();
		for (int i = 0; it.hasNext(); i++) {
			File file = (File) it.next();
		   	if (file.getId().equals(id))
		   		return i;
		}
		return -1;
	}
	
	public File getFile(Long id) {
		Iterator<File> it = list.iterator();
		while (it.hasNext()) { 
	   		File file = (File) it.next();
	   		if (file.getId().equals(id))
	   			return file;
	   	}
		return null;
	}
	
	private void deleteFileToBDD(File file) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		session.delete(file);
        session.getTransaction().commit();
        session.close();
	}
	
	private void modifyFileToBDD(File newFile) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		session.update(newFile);
        session.getTransaction().commit();
        session.close();
	}
	
	private void addFileToBDD(File newFile) {
		SessionFactory sf = HibernateUtil.createSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.persist(newFile);
        session.getTransaction().commit();
        session.close();
	}
	
	private List<File> getQuery(String sql) {
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
}
