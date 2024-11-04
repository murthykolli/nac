package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantFinishingTouchesContributedProductsInfoSavingDAO;
import com.nookandcove.model.RegistrantFinishingTouchesContributedProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantFinishingTouchesContributedProductsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantFinishingTouchesContributedProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantFinishingTouchesContributedProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantFinishingTouchesContributedProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryFinishingTouchesContributedDataCheckInDB(long registrantUserId, long adminRegFTProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + adminRegFTProductSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedProductsInfoSaving registryFinishingTouchesContributedDataTakeFromDB(long registrantUserId, long adminRegFTProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + adminRegFTProductSavingId + "' ";			
			return (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedTotalDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountFTContributedDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedProductsInfoSaving registryFinishingTouchesContributedDataEditInDB(long registrantUserId, long regiFTCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + regiFTCotributedProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesContributedLandingDeleteDataCheckInDB(long registrantUserId, long regiFTCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + regiFTCotributedProductSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedMyAccountsDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus is not null order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */

	public List guestRegAdminFTContributedGiftReceivedData(String contributedStatusRef) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE contributedStatus = '" + contributedStatusRef + "' order by updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedProductsInfoSaving registryFTGiftReceivedContributedPaymentDataTakeFromDB(long regiFTCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE registrantFinishingTouchesContributedProductsInfoSavingId = '" + regiFTCotributedProductSavingId + "' ";			
			return (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminFTContributedPricesListFromInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedProductsInfoSaving adminFTContributedPricesUpdatedInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving WHERE adminRegistryFinishingTouchesFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantFinishingTouchesContributedProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedProductsInfoSaving findById(long id) {
		try {
			RegistrantFinishingTouchesContributedProductsInfoSaving instance = (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantFinishingTouchesContributedProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantFinishingTouchesContributedProductsInfoSaving> findByExample(RegistrantFinishingTouchesContributedProductsInfoSaving instance) {
		try {
			List<RegistrantFinishingTouchesContributedProductsInfoSaving> results = (List<RegistrantFinishingTouchesContributedProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedProductsInfoSaving merge(RegistrantFinishingTouchesContributedProductsInfoSaving detachedInstance) {
		try {
			RegistrantFinishingTouchesContributedProductsInfoSaving result = (RegistrantFinishingTouchesContributedProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantFinishingTouchesContributedProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantFinishingTouchesContributedProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantFinishingTouchesContributedProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantFinishingTouchesContributedProductsInfoSavingDAOImpl) ctx.getBean("RegistrantFinishingTouchesContributedProductsInfoSavingDAO");
	}

}

