package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ShopUserPaymentInfoSavingDAO;
import com.nookandcove.model.ShopUserPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ShopUserPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements ShopUserPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopUserPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ShopUserPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List shopUserFullNameCheckInDataBase(long shopUserPaymentInfoSavingId) {
		try {
			String queryString = "from ShopUserPaymentInfoSaving WHERE shopUserPaymentInfoSavingId = '"+shopUserPaymentInfoSavingId+"' ";		
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ShopUserPaymentInfoSaving shopUserFullNameTakeFromDataBase(long shopUserPaymentInfoSavingId) {
		try {
			String queryString = "from ShopUserPaymentInfoSaving WHERE shopUserPaymentInfoSavingId = '"+shopUserPaymentInfoSavingId+"' ";		
			return (ShopUserPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List shopUserReferralCouponPaymenListFromDB(String uniqueRefCode) {
		try {
			String queryString = "from ShopUserPaymentInfoSaving WHERE shopCouponCode = '"+uniqueRefCode+"' and referralUserReferance = 'Refferral User' ";		
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(ShopUserPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}	

	public ShopUserPaymentInfoSaving findById(long id) {
		try {
			ShopUserPaymentInfoSaving instance = (ShopUserPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.ShopUserPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ShopUserPaymentInfoSaving> findByExample(ShopUserPaymentInfoSaving instance) {
		try {
			List<ShopUserPaymentInfoSaving> results = (List<ShopUserPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ShopUserPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ShopUserPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ShopUserPaymentInfoSaving merge(ShopUserPaymentInfoSaving detachedInstance) {
		try {
			ShopUserPaymentInfoSaving result = (ShopUserPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopUserPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopUserPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ShopUserPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShopUserPaymentInfoSavingDAOImpl) ctx.getBean("ShopUserPaymentInfoSavingDAO");
	}

}

