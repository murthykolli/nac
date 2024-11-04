package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ClientPackageAndRenderingPaymentInfoSavingDAO;
import com.nookandcove.model.ClientPackageAndRenderingPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ClientPackageAndRenderingPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements ClientPackageAndRenderingPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientPackageAndRenderingPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ClientPackageAndRenderingPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List selectedClientPackagePaymentRowIdVerification(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoSavingId+"' and typeOfPayment = 'Package Payment' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public ClientPackageAndRenderingPaymentInfoSaving updatedClientPackagePaymentRowInDB(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoSavingId+"' and typeOfPayment = 'Package Payment' ";
			return (ClientPackageAndRenderingPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List selectedClientSecRenderingPaymentRowIdVerification(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoSavingId+"' and typeOfPayment = 'Rendering Payment' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientPackageAndRenderingPaymentInfoSaving updatedClientSecRenderingPaymentRowInDB(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoSavingId+"' and typeOfPayment = 'Rendering Payment' ";
			return (ClientPackageAndRenderingPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientPackagePaymentCountInAdmin() {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE typeOfPayment = 'Package Payment' and paymentStatus = 'This transaction has been approved.' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List client2ndRenderingPaymentCountInAdmin() {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE typeOfPayment = 'Rendering Payment' and paymentStatus = 'This transaction has been approved.' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientPackagePaymentRowVerUsingJoins() {
		try {
			String queryString = "select t1.createdDate, t1.typeOfSpace, t1.designPackage, t3.firstName, t3.lastName, t1.designerInfoSavingId from ClientInfoSaving t1, ClientPackageAndRenderingPaymentInfoSaving t2, UserInformation t3 WHERE t2.userId = t3.userId and t1.clientInfoSavingId = t2.clientInfoSavingId and t2.typeOfPayment = 'Package Payment' and t2.paymentStatus = 'This transaction has been approved.' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List client2ndRenderingPaymentRowVerUsingJoins() {
		try {
			String queryString = "select t1.createdDate, t1.typeOfSpace, t1.designPackage, t3.firstName, t3.lastName, t4.designerFullName from ClientInfoSaving t1, ClientPackageAndRenderingPaymentInfoSaving t2, UserInformation t3, DesignerInfoSaving t4 WHERE t2.userId = t3.userId and t1.clientInfoSavingId = t2.clientInfoSavingId and t1.designerInfoSavingId = t4.designerInfoSavingId and t2.typeOfPayment = 'Rendering Payment' and t2.paymentStatus = 'This transaction has been approved.' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ClientPackageAndRenderingPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public List allPackageInfoDailyReports(String todayDate) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE createdDateInSt = '"+todayDate+"' and typeOfPayment = 'Package Payment' order by clientPackageAndRenderingPaymentInfoSavingId";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List allPackageInfoTotalReports(String referenceDate, String todayDate) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE createdDateInSt between '"+todayDate+"' and '"+referenceDate+"' and typeOfPayment = 'Package Payment' order by clientPackageAndRenderingPaymentInfoSavingId";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List allRenderingInfoDailyReports(String todayDate) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE createdDateInSt = '"+todayDate+"' and typeOfPayment = 'Rendering Payment' order by clientPackageAndRenderingPaymentInfoSavingId";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public List allRenderingInfoTotalReports(String referenceDate, String todayDate) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving WHERE createdDateInSt between '"+todayDate+"' and '"+referenceDate+"' and typeOfPayment = 'Rendering Payment' order by clientPackageAndRenderingPaymentInfoSavingId";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public ClientPackageAndRenderingPaymentInfoSaving findById(long id) {
		try {
			ClientPackageAndRenderingPaymentInfoSaving instance = (ClientPackageAndRenderingPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.ClientPackageAndRenderingPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ClientPackageAndRenderingPaymentInfoSaving> findByExample(ClientPackageAndRenderingPaymentInfoSaving instance) {
		try {
			List<ClientPackageAndRenderingPaymentInfoSaving> results = (List<ClientPackageAndRenderingPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ClientPackageAndRenderingPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientPackageAndRenderingPaymentInfoSaving merge(ClientPackageAndRenderingPaymentInfoSaving detachedInstance) {
		try {
			ClientPackageAndRenderingPaymentInfoSaving result = (ClientPackageAndRenderingPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientPackageAndRenderingPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientPackageAndRenderingPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ClientPackageAndRenderingPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientPackageAndRenderingPaymentInfoSavingDAOImpl) ctx.getBean("ClientPackageAndRenderingPaymentInfoSavingDAO");
	}

}

