package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantConceptBoardsIndividualProductsInfoSavingDAO;
import com.nookandcove.model.RegistrantConceptBoardsIndividualProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantConceptBoardsIndividualProductsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantConceptBoardsIndividualProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantConceptBoardsIndividualProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantConceptBoardsIndividualProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}


	public List registryConceptBoardsIndividualDataCheckInDB(long registrantUserId, long adminRegCBFSpecsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + adminRegCBFSpecsSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualProductsInfoSaving registryConceptBoardsIndividualDataTakeFromDB(long registrantUserId, long adminRegCBFSpecsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + adminRegCBFSpecsSavingId + "' ";			
			return (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualTotalDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualProductsInfoSaving registryConceptBoardsIndividualDataEditInDB(long registrantUserId, long regiCBIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + regiCBIndividualProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regConceptBoardsIndividualLandingDeleteDataCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountCBIndividualDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Admin Gift Received Data Take From DB

	public RegistrantConceptBoardsIndividualProductsInfoSaving registryConceptBoardsIndividualDataForAdminGiftReceived(long regiCBIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE registrantConceptBoardsIndividualProductsInfoSavingId = '" + regiCBIndividualProductSavingId + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminCBIndividualPricesListFromInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualProductsInfoSaving adminCBIndividualPricesUpdatedInDB(long productInfoSavingId, String productsPrice) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '" + productInfoSavingId + "' and productPrice = '" + productsPrice + "' ";	
			return (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public void delete(RegistrantConceptBoardsIndividualProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualProductsInfoSaving findById(long id) {
		try {
			RegistrantConceptBoardsIndividualProductsInfoSaving instance = (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantConceptBoardsIndividualProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantConceptBoardsIndividualProductsInfoSaving> findByExample(RegistrantConceptBoardsIndividualProductsInfoSaving instance) {
		try {
			List<RegistrantConceptBoardsIndividualProductsInfoSaving> results = (List<RegistrantConceptBoardsIndividualProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualProductsInfoSaving merge(RegistrantConceptBoardsIndividualProductsInfoSaving detachedInstance) {
		try {
			RegistrantConceptBoardsIndividualProductsInfoSaving result = (RegistrantConceptBoardsIndividualProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantConceptBoardsIndividualProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantConceptBoardsIndividualProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantConceptBoardsIndividualProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantConceptBoardsIndividualProductsInfoSavingDAOImpl) ctx.getBean("RegistrantConceptBoardsIndividualProductsInfoSavingDAO");
	}

}

