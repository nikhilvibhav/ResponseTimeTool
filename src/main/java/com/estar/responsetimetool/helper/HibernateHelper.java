/**
 * 
 */
package com.estar.responsetimetool.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.estar.responsetimetool.pojo.ResponseTime;
import com.estar.responsetimetool.util.HibernateUtil;

/**
 * @author nvibhav on 31 Jul 2015
 *
 */
public class HibernateHelper {

	final static Logger LOGGER = LogManager.getLogger(HibernateHelper.class.getName());
	
	private static Session session;
	
	public static void insertIntoDB(ResponseTime responseTime) {
		
		LOGGER.info("Inserting into DB started");
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
		
			session.save(responseTime);
			session.getTransaction().commit();
			
			LOGGER.info("Added into DB 1 row");
		
		} catch (HibernateException ex) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error("Insert into DB threw an error: " + ex.getMessage());
		} finally {
			session.close();
		}
	}
}
