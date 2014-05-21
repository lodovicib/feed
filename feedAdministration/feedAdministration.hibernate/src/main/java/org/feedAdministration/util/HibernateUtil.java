package org.feedAdministration.util;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {


	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
/*	public static <T> T unproxy(T proxy) {
        if (proxy == null) {
            return null;
        }

        if (proxy instanceof HibernateProxy) {
            Hibernate.initialize(proxy);

            HibernateProxy hibernateProxy = (HibernateProxy) proxy;
            T unproxiedObject = (T) hibernateProxy.getHibernateLazyInitializer().getImplementation();

            return unproxiedObject;
        }

        return proxy;
    }*/
}