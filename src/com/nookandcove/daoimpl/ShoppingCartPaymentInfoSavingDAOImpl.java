package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ShoppingCartPaymentInfoSavingDAO;
import com.nookandcove.model.ShoppingCartPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ShoppingCartPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements ShoppingCartPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ShoppingCartPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedShoppingCartRowVerification(long userId) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE userId = '"+userId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ShoppingCartPaymentInfoSaving updatedShoppingCartPaymentRowInDB(long userId) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE userId = '"+userId+"' and checkoutPaymentStatus is null ";
			return (ShoppingCartPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminPurchasesInfoRowVerification() {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE (checkoutPaymentStatus is not null and checkoutPaymentStatus != '') and status is null order by createdDate DESC nulls last, updatedDate DESC nulls last";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminPurchasedArchiveInfoDisplay() {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE (checkoutPaymentStatus is not null and checkoutPaymentStatus != '') and status = 'Archive' order by createdDate DESC nulls last, updatedDate DESC nulls last";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ShoppingCartPaymentInfoSaving purchaseClientShippingDataTakeFromDB(long shopCartPaymentRef) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE shoppingCartPaymentInfoSavingId = '"+shopCartPaymentRef+"' and checkoutPaymentStatus is not null and status is null ";
			return (ShoppingCartPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ShoppingCartPaymentInfoSaving archivePurchaseClientShippingData(long shopCartPaymentRef) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE shoppingCartPaymentInfoSavingId = '"+shopCartPaymentRef+"' and checkoutPaymentStatus is not null and status = 'Archive' ";
			return (ShoppingCartPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List allShoppingCartInfoDailyReports(String todayDate) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE createdDateInSt = '"+todayDate+"' order by shoppingCartPaymentInfoSavingId";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List allShoppingCartInfoTotalReports(String referenceDate, String todayDate) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving WHERE createdDateInSt between '"+todayDate+"' and '"+referenceDate+"' order by shoppingCartPaymentInfoSavingId";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(ShoppingCartPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ShoppingCartPaymentInfoSaving findById(long id) {
		try {
			ShoppingCartPaymentInfoSaving instance = (ShoppingCartPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.ShoppingCartPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ShoppingCartPaymentInfoSaving> findByExample(ShoppingCartPaymentInfoSaving instance) {
		try {
			List<ShoppingCartPaymentInfoSaving> results = (List<ShoppingCartPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ShoppingCartPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ShoppingCartPaymentInfoSaving merge(ShoppingCartPaymentInfoSaving detachedInstance) {
		try {
			ShoppingCartPaymentInfoSaving result = (ShoppingCartPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShoppingCartPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShoppingCartPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ShoppingCartPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShoppingCartPaymentInfoSavingDAOImpl) ctx.getBean("ShoppingCartPaymentInfoSavingDAO");
	}

}

