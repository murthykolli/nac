package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ShopConceptBoardsProductsInfoSavingDAO;
import com.nookandcove.model.ShopConceptBoardsProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ShopConceptBoardsProductsInfoSavingDAOImpl extends HibernateDaoSupport implements ShopConceptBoardsProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopConceptBoardsProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ShopConceptBoardsProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List adminShopConceptBoardsDataTakeFromDB(String shopProductStatusRef) {
		try {
			String queryString = "from ShopConceptBoardsProductsInfoSaving WHERE shopProductStatus = '" + shopProductStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ShopConceptBoardsProductsInfoSaving adminShopPlaceOrderDataTakeFromDB(long shopCBProductManagementId) {
		try {
			String queryString = "from ShopConceptBoardsProductsInfoSaving WHERE shopConceptBoardsProductsInfoSavingId = '"+shopCBProductManagementId+"' ";	
			return (ShopConceptBoardsProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(ShopConceptBoardsProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}	

	public ShopConceptBoardsProductsInfoSaving findById(long id) {
		try {
			ShopConceptBoardsProductsInfoSaving instance = (ShopConceptBoardsProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.ShopConceptBoardsProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ShopConceptBoardsProductsInfoSaving> findByExample(ShopConceptBoardsProductsInfoSaving instance) {
		try {
			List<ShopConceptBoardsProductsInfoSaving> results = (List<ShopConceptBoardsProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ShopConceptBoardsProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ShopConceptBoardsProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ShopConceptBoardsProductsInfoSaving merge(ShopConceptBoardsProductsInfoSaving detachedInstance) {
		try {
			ShopConceptBoardsProductsInfoSaving result = (ShopConceptBoardsProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopConceptBoardsProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopConceptBoardsProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ShopConceptBoardsProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShopConceptBoardsProductsInfoSavingDAOImpl) ctx.getBean("ShopConceptBoardsProductsInfoSavingDAO");
	}

}

