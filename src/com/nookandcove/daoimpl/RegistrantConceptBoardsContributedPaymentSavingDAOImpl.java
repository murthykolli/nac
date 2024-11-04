package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.model.RegistrantConceptBoardsContributedPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantConceptBoardsContributedPaymentSavingDAOImpl extends HibernateDaoSupport implements RegistrantConceptBoardsContributedPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantConceptBoardsContributedPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantConceptBoardsContributedPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryConceptBoardsContributedPriceCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedPaymentSaving registryConceptBoardsContributedPriceTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedPaymentStatusCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedPaymentSaving registryConceptBoardsContributedPaymentStatusTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryConceptBoardsPaymentDataCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedPaymentSaving registryConceptBoardsPaymentDataTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBContributedAddCartPaymentDataCheckInDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedPaymentSaving registryCBContributedAddCartPaymentDataTakeFromDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regConceptBoardsContributedPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistrantConceptBoardsContributedPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"', contributedStatus = 'No Action', refferanceDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistrantConceptBoardsContributedPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List registryMyAccountCBPaymentContributedPriceFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and (contributedStatus = 'No Action' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountCBPaymentContributedInBOTDPriceFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and contributedStatus = 'Back Ordered Till' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regConceptBoardsContributedMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registrantStoreCreditCBContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsContributedProductsInfoSavingId, registrantUserId from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditCBContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantGiftReceivedCBContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsContributedProductsInfoSavingId, registrantUserId from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantGiftReceivedCBContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedPaymentSaving registrantCBContributeGiftReceivedStatusFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBContributedGRConToCreditDataList(long registrantUserId, long regSelectedProdsId, String contributedStatusRef) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */

	public List registryAdminCBContributedGiftReceivedDataTakeFromDB(String contributedStatusRef) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBGiftReceivedContributedPaymentInfoList(long cbContributedProductsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantConceptBoardsContributedProductsInfoSavingId = '"+cbContributedProductsSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedPaymentSaving registryCBGiftReceivedContributedPaymentDataTakeFromDB(long cbContributedProductsSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving WHERE registrantConceptBoardsContributedProductsInfoSavingId = '"+cbContributedProductsSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantConceptBoardsContributedPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsContributedPaymentSaving findById(long id) {
		try {
			RegistrantConceptBoardsContributedPaymentSaving instance = (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().get("com.nookandcove.RegistrantConceptBoardsContributedPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantConceptBoardsContributedPaymentSaving> findByExample(RegistrantConceptBoardsContributedPaymentSaving instance) {
		try {
			List<RegistrantConceptBoardsContributedPaymentSaving> results = (List<RegistrantConceptBoardsContributedPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantConceptBoardsContributedPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsContributedPaymentSaving merge(RegistrantConceptBoardsContributedPaymentSaving detachedInstance) {
		try {
			RegistrantConceptBoardsContributedPaymentSaving result = (RegistrantConceptBoardsContributedPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantConceptBoardsContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantConceptBoardsContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantConceptBoardsContributedPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantConceptBoardsContributedPaymentSavingDAOImpl) ctx.getBean("RegistrantConceptBoardsContributedPaymentSavingDAO");
	}

}

