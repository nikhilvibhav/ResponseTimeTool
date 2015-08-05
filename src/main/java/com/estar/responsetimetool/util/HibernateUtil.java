package com.estar.responsetimetool.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * Created by nvibhav on 30 Jul 2015
 *
 */
public class HibernateUtil {

	final static Logger LOGGER = LogManager.getLogger(HibernateUtil.class.getName());

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {
		
		try {
			//Create SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			return new Configuration().configure().buildSessionFactory(serviceRegistry);
			
		} catch (Throwable ex) {
			LOGGER.error("Failed to create SessionFactory object: " + ex.getMessage());
			throw new ExceptionInInitializerError(ex.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		//Close caches and connection pools
		getSessionFactory().close();
	}
}
