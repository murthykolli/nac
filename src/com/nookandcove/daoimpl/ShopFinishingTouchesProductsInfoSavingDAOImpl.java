package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ShopFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.model.ShopFinishingTouchesProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ShopFinishingTouchesProductsInfoSavingDAOImpl extends HibernateDaoSupport implements ShopFinishingTouchesProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopFinishingTouchesProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ShopFinishingTouchesProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List adminShopFinishingTouchesDataTakeFromDB(String shopProductStatusRef) {
		try {
			String queryString = "from ShopFinishingTouchesProductsInfoSaving WHERE shopProductStatus = '" + shopProductStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ShopFinishingTouchesProductsInfoSaving adminShopPlaceOrderDataTakeFromDB(long shopFTProductManagementId) {
		try {
			String queryString = "from ShopFinishingTouchesProductsInfoSaving WHERE shopFinishingTouchesProductsInfoSavingId = '"+shopFTProductManagementId+"' ";	
			return (ShopFinishingTouchesProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(ShopFinishingTouchesProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}	

	public ShopFinishingTouchesProductsInfoSaving findById(long id) {
		try {
			ShopFinishingTouchesProductsInfoSaving instance = (ShopFinishingTouchesProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.ShopFinishingTouchesProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ShopFinishingTouchesProductsInfoSaving> findByExample(ShopFinishingTouchesProductsInfoSaving instance) {
		try {
			List<ShopFinishingTouchesProductsInfoSaving> results = (List<ShopFinishingTouchesProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ShopFinishingTouchesProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ShopFinishingTouchesProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ShopFinishingTouchesProductsInfoSaving merge(ShopFinishingTouchesProductsInfoSaving detachedInstance) {
		try {
			ShopFinishingTouchesProductsInfoSaving result = (ShopFinishingTouchesProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopFinishingTouchesProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopFinishingTouchesProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ShopFinishingTouchesProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShopFinishingTouchesProductsInfoSavingDAOImpl) ctx.getBean("ShopFinishingTouchesProductsInfoSavingDAO");
	}

}

