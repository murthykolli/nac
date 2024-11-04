package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantConceptBoardsContributedProductsInfoSavingDAO;
import com.nookandcove.model.RegistrantConceptBoardsContributedProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantConceptBoardsContributedProductsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantConceptBoardsContributedProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantConceptBoardsContributedProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantConceptBoardsContributedProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryConceptBoardsContributedDataCheckInDB(long registrantUserId, long adminRegCBFSpecsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + adminRegCBFSpecsSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedProductsInfoSaving registryConceptBoardsContributedDataTakeFromDB(long registrantUserId, long adminRegCBFSpecsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + adminRegCBFSpecsSavingId + "' ";			
			return (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedTotalDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountCBContributedDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedProductsInfoSaving registryConceptBoardsContributedDataEditInDB(long registrantUserId, long regiCBCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + regiCBCotributedProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regConceptBoardsContributedLandingDeleteDataCheckInDB(long registrantUserId, long regiCBCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + regiCBCotributedProductSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedMyAccountsDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus is not null order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */

	public List guestRegAdminCBContributedGiftReceivedData(String contributedStatusRef) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE contributedStatus = '" + contributedStatusRef + "' order by updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedProductsInfoSaving registryCBGiftReceivedContributedPaymentDataTakeFromDB(long regiCBCotributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE registrantConceptBoardsContributedProductsInfoSavingId = '" + regiCBCotributedProductSavingId + "' ";			
			return (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminCBContributedPricesListFromInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedProductsInfoSaving adminCBContributedPricesUpdatedInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantConceptBoardsContributedProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedProductsInfoSaving findById(long id) {
		try {
			RegistrantConceptBoardsContributedProductsInfoSaving instance = (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantConceptBoardsContributedProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantConceptBoardsContributedProductsInfoSaving> findByExample(RegistrantConceptBoardsContributedProductsInfoSaving instance) {
		try {
			List<RegistrantConceptBoardsContributedProductsInfoSaving> results = (List<RegistrantConceptBoardsContributedProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantConceptBoardsContributedProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedProductsInfoSaving merge(RegistrantConceptBoardsContributedProductsInfoSaving detachedInstance) {
		try {
			RegistrantConceptBoardsContributedProductsInfoSaving result = (RegistrantConceptBoardsContributedProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantConceptBoardsContributedProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantConceptBoardsContributedProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantConceptBoardsContributedProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantConceptBoardsContributedProductsInfoSavingDAOImpl) ctx.getBean("RegistrantConceptBoardsContributedProductsInfoSavingDAO");
	}

}

