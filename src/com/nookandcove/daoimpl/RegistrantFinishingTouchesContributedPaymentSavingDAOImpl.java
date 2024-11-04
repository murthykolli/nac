package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.model.RegistrantFinishingTouchesContributedPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantFinishingTouchesContributedPaymentSavingDAOImpl extends HibernateDaoSupport implements RegistrantFinishingTouchesContributedPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantFinishingTouchesContributedPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantFinishingTouchesContributedPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryFinishingTouchesContributedPriceCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedPaymentSaving registryFinishingTouchesContributedPriceTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedPaymentStatusCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedPaymentSaving registryFinishingTouchesContributedPaymentStatusTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryFinishingTouchesPaymentDataCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedPaymentSaving registryFinishingTouchesPaymentDataTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTContributedAddCartPaymentDataCheckInDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedPaymentSaving registryFTContributedAddCartPaymentDataTakeFromDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regFinishingTouchesContributedPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistrantFinishingTouchesContributedPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"', contributedStatus = 'No Action', refferanceDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistrantFinishingTouchesContributedPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List registryMyAccountFTPaymentContributedPriceFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and (contributedStatus = 'No Action' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryMyAccountFTPaymentContributedInBOTDPriceFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and contributedStatus = 'Back Ordered Till' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesContributedMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registrantStoreCreditFTContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesContributedProductsInfoSavingId, registrantUserId from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditFTContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantGiftReceivedFTContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesContributedProductsInfoSavingId, registrantUserId from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantGiftReceivedFTContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedPaymentSaving registrantFTContributeGiftReceivedStatusFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTContributedGRConToCreditDataList(long registrantUserId, long regSelectedProdsId, String contributedStatusRef) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */

	public List registryAdminFTContributedGiftReceivedDataTakeFromDB(String contributedStatusRef) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTGiftReceivedContributedPaymentInfoList(long cbContributedProductsSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantFinishingTouchesContributedProductsInfoSavingId = '"+cbContributedProductsSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedPaymentSaving registryFTGiftReceivedContributedPaymentDataTakeFromDB(long cbContributedProductsSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving WHERE registrantFinishingTouchesContributedProductsInfoSavingId = '"+cbContributedProductsSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantFinishingTouchesContributedPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesContributedPaymentSaving findById(long id) {
		try {
			RegistrantFinishingTouchesContributedPaymentSaving instance = (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().get("com.nookandcove.RegistrantFinishingTouchesContributedPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantFinishingTouchesContributedPaymentSaving> findByExample(RegistrantFinishingTouchesContributedPaymentSaving instance) {
		try {
			List<RegistrantFinishingTouchesContributedPaymentSaving> results = (List<RegistrantFinishingTouchesContributedPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantFinishingTouchesContributedPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesContributedPaymentSaving merge(RegistrantFinishingTouchesContributedPaymentSaving detachedInstance) {
		try {
			RegistrantFinishingTouchesContributedPaymentSaving result = (RegistrantFinishingTouchesContributedPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantFinishingTouchesContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantFinishingTouchesContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantFinishingTouchesContributedPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantFinishingTouchesContributedPaymentSavingDAOImpl) ctx.getBean("RegistrantFinishingTouchesContributedPaymentSavingDAO");
	}

}

