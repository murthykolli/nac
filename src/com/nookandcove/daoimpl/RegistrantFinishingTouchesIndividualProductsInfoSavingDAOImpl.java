package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantFinishingTouchesIndividualProductsInfoSavingDAO;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantFinishingTouchesIndividualProductsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantFinishingTouchesIndividualProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantFinishingTouchesIndividualProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantFinishingTouchesIndividualProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}


	public List registryFinishingTouchesIndividualDataCheckInDB(long registrantUserId, long adminRegFTFSpecsSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + adminRegFTFSpecsSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualProductsInfoSaving registryFinishingTouchesIndividualDataTakeFromDB(long registrantUserId, long adminRegFTFSpecsSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + adminRegFTFSpecsSavingId + "' ";			
			return (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualTotalDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualProductsInfoSaving registryFinishingTouchesIndividualDataEditInDB(long registrantUserId, long regiFTIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + regiFTIndividualProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesIndividualLandingDeleteDataCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountFTIndividualDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Admin Gift Received Data Take From DB

	public RegistrantFinishingTouchesIndividualProductsInfoSaving registryFinishingTouchesIndividualDataForAdminGiftReceived(long regiFTIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE registrantFinishingTouchesIndividualProductsInfoSavingId = '" + regiFTIndividualProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminFTIndividualPricesListFromInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualProductsInfoSaving adminFTIndividualPricesUpdatedInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving WHERE adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public void delete(RegistrantFinishingTouchesIndividualProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualProductsInfoSaving findById(long id) {
		try {
			RegistrantFinishingTouchesIndividualProductsInfoSaving instance = (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantFinishingTouchesIndividualProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantFinishingTouchesIndividualProductsInfoSaving> findByExample(RegistrantFinishingTouchesIndividualProductsInfoSaving instance) {
		try {
			List<RegistrantFinishingTouchesIndividualProductsInfoSaving> results = (List<RegistrantFinishingTouchesIndividualProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualProductsInfoSaving merge(RegistrantFinishingTouchesIndividualProductsInfoSaving detachedInstance) {
		try {
			RegistrantFinishingTouchesIndividualProductsInfoSaving result = (RegistrantFinishingTouchesIndividualProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantFinishingTouchesIndividualProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantFinishingTouchesIndividualProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantFinishingTouchesIndividualProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantFinishingTouchesIndividualProductsInfoSavingDAOImpl) ctx.getBean("RegistrantFinishingTouchesIndividualProductsInfoSavingDAO");
	}

}

