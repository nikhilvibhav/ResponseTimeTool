/**
 * 
 */
package com.estar.responsetimetool.helper;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@SuppressWarnings("unused")
	private ResponseTime responseTime;
	
	public void insertIntoDB(ResponseTime responseTime) {
		
		LOGGER.info("Inserting into DB started");
		
		session = HibernateUtil.getSessionFactory().openSession();
		this.responseTime = responseTime;

		try {
			
			session.beginTransaction();
			
			String stringQuery = "INSERT INTO 'eurostar_dashboard'.'site_response_tool' ('id', 'domain_name', 'page_title', 'page_id', "
					+ "'browser_name', 'browser_version', 'response_time', 'session_id', 'added_on') "
					+ "VALUES ('', :domain_name, :page_title, :page_id, :browser_name, :browser_version, :response_time, :session_id, :added_on)";
		
			Query query = session.createQuery(stringQuery);
		
			query.setParameter("domain_name", responseTime.getDomainName());
			query.setParameter("page_title", responseTime.getPageTitle());
			query.setParameter("page_id", responseTime.getPageID());
			query.setParameter("browser_name", responseTime.getBrowserName());
			query.setParameter("browser_version", responseTime.getBrowserVersion());
			query.setParameter("response_time", Objects.toString(responseTime.getResponseTime()));
			query.setParameter("session_id", Objects.toString(responseTime.getSessionID()));
			query.setParameter("added_on", Objects.toString(responseTime.getDateAdded()));
		
			int result = query.executeUpdate();
			
			session.getTransaction().commit();
			
			LOGGER.info("Added into DB: " + result + "row/s");
		
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
