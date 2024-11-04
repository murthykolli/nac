package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantShippingInfoSavingDAO;
import com.nookandcove.model.RegistrantShippingInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantShippingInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantShippingInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantShippingInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantShippingInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedShippingAddressRowIdVerification(long registryUserId) {
		try {
			String queryString = "from RegistrantShippingInfoSaving WHERE registrantUserId = '"+registryUserId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantShippingInfoSaving updatedShippingAddressRowInDataBasa(long registryUserId) {
		try {
			String queryString = "from RegistrantShippingInfoSaving WHERE registrantUserId = '"+registryUserId+"' ";
			return (RegistrantShippingInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(RegistrantShippingInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantShippingInfoSaving findById(long id) {
		try {
			RegistrantShippingInfoSaving instance = (RegistrantShippingInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantShippingInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantShippingInfoSaving> findByExample(RegistrantShippingInfoSaving instance) {
		try {
			List<RegistrantShippingInfoSaving> results = (List<RegistrantShippingInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantShippingInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantShippingInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantShippingInfoSaving merge(RegistrantShippingInfoSaving detachedInstance) {
		try {
			RegistrantShippingInfoSaving result = (RegistrantShippingInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantShippingInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantShippingInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantShippingInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantShippingInfoSavingDAOImpl) ctx.getBean("RegistrantShippingInfoSavingDAO");
	}

}

