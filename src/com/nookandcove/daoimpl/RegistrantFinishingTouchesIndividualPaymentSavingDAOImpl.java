package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.model.RegistrantFinishingTouchesIndividualPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantFinishingTouchesIndividualPaymentSavingDAOImpl extends HibernateDaoSupport implements RegistrantFinishingTouchesIndividualPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantFinishingTouchesIndividualPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(RegistrantFinishingTouchesIndividualPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryFinishingTouchesIndividualPriceCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualPaymentStatusCheck(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualPaymentSaving registryFinishingTouchesIndividualPriceTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualPaymentSaving registryFinishingTouchesIndividualPaymentStatusValue(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualPaymentStatusCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualPaymentSaving registryFinishingTouchesIndividualPaymentStatusTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualPaymentSaving regFinishingTouchesIndividualCartCountFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTIndividualAddCartPaymentDataCheckInDB(long registrantUserId, long regFTIndividualPaymentSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + regFTIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualPaymentSaving registryFTIndividualAddCartPaymentDataTakeFromDB(long registrantUserId, long regFTIndividualPaymentSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + regFTIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regFinishingTouchesIndividualPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistrantFinishingTouchesIndividualPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"', individualStatus = 'No Action', refferanceDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistrantFinishingTouchesIndividualPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesIndividualMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditFTIndividualRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesIndividualProductsInfoSavingId, registrantUserId from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditFTIndividualAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesIndividualProductsInfoSavingId = '"+regSelectedProdsId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
/* My Account GiftReceived Data Display */

	public List registryFTMyAccountIndividualPaymentDataCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualPaymentSaving registryFTMyAccountIndividualPaymentDataTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */
	
	public List registryAdminFTIndividualGiftReceivedDataTakeFromDB(String individualStatusRef) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE individualStatus = '" + individualStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualPaymentSaving registryFTGiftReceivedIndividualPaymentDataTakeFromDB(long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE registrantFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryAdminFTIndividualNoActionGiftReceivedData() {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE individualStatus = 'No Action' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryAdminFTIndividualConvertedToCreditGiftReceivedData() {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving WHERE individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
	public void delete(RegistrantFinishingTouchesIndividualPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantFinishingTouchesIndividualPaymentSaving findById(long id) {
		try {
			RegistrantFinishingTouchesIndividualPaymentSaving instance = (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().get("com.nookandcove.RegistrantFinishingTouchesIndividualPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantFinishingTouchesIndividualPaymentSaving> findByExample(RegistrantFinishingTouchesIndividualPaymentSaving instance) {
		try {
			List<RegistrantFinishingTouchesIndividualPaymentSaving> results = (List<RegistrantFinishingTouchesIndividualPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantFinishingTouchesIndividualPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantFinishingTouchesIndividualPaymentSaving merge(RegistrantFinishingTouchesIndividualPaymentSaving detachedInstance) {
		try {
			RegistrantFinishingTouchesIndividualPaymentSaving result = (RegistrantFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantFinishingTouchesIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantFinishingTouchesIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantFinishingTouchesIndividualPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantFinishingTouchesIndividualPaymentSavingDAOImpl) ctx.getBean("RegistrantFinishingTouchesIndividualPaymentSavingDAO");
	}

}

