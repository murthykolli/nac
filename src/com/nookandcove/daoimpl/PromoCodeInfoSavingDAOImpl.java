package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.PromoCodeInfoSavingDAO;
import com.nookandcove.model.PromoCodeInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class PromoCodeInfoSavingDAOImpl extends HibernateDaoSupport implements PromoCodeInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(PromoCodeInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(PromoCodeInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedPromocodeVerification() {
		try {
			String queryString = "from PromoCodeInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List promocodeDataListFromDB(long promoCodeId) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCodeInfoSavingId = '"+promoCodeId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public PromoCodeInfoSaving promocodeSelectedDataListFromDB(long promoCodeId) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCodeInfoSavingId = '"+promoCodeId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";			
			return (PromoCodeInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public PromoCodeInfoSaving updatedPromoCodeInDB() {
		try {
			String queryString = "from PromoCodeInfoSaving ";
			return (PromoCodeInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(PromoCodeInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}	

	public List selectedPromoCodeChecking(String promoCode) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCode = '"+promoCode+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public PromoCodeInfoSaving selectedPromoCodeUpdateInDB(String promoCode) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCode = '"+promoCode+"' ";			
			return (PromoCodeInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List selectedPromoCodeCheckingNotUsed(String promoCode) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCode = '"+promoCode+"' and status is not null";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public PromoCodeInfoSaving selectedPromoCodeUpdateInDBNotUsed(String promoCode) {
		try {
			String queryString = "from PromoCodeInfoSaving WHERE promoCode = '"+promoCode+"' and status is not null ";			
			return (PromoCodeInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public PromoCodeInfoSaving findById(long id) {
		try {
			PromoCodeInfoSaving instance = (PromoCodeInfoSaving) getHibernateTemplate().get("com.nookandcove.PromoCodeInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<PromoCodeInfoSaving> findByExample(PromoCodeInfoSaving instance) {
		try {
			List<PromoCodeInfoSaving> results = (List<PromoCodeInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from PromoCodeInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from PromoCodeInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public PromoCodeInfoSaving merge(PromoCodeInfoSaving detachedInstance) {
		try {
			PromoCodeInfoSaving result = (PromoCodeInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PromoCodeInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PromoCodeInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static PromoCodeInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (PromoCodeInfoSavingDAOImpl) ctx.getBean("PromoCodeInfoSavingDAO");
	}

}

