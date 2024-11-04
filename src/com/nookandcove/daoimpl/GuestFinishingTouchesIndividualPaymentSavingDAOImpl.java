package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestFinishingTouchesIndividualPaymentSavingDAO;
import com.nookandcove.model.GuestFinishingTouchesIndividualPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestFinishingTouchesIndividualPaymentSavingDAOImpl extends HibernateDaoSupport implements GuestFinishingTouchesIndividualPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestFinishingTouchesIndividualPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(GuestFinishingTouchesIndividualPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryFinishingTouchesIndividualPriceCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesIndividualPaymentSaving registryFinishingTouchesIndividualPriceTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualPaymentStatusCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesIndividualPaymentSaving registryFinishingTouchesIndividualPaymentStatusTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesIndividualTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesIndividualPaymentSaving regFinishingTouchesIndividualCartCountFromDB(long registrantUserId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTIndividualAddCartPaymentDataCheckInDB(long registrantUserId, long regFTIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + regFTIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesIndividualPaymentSaving registryFTIndividualAddCartPaymentDataTakeFromDB(long registrantUserId, long regFTIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesIndividualPaymentSavingId = '" + regFTIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regFinishingTouchesIndividualPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE GuestFinishingTouchesIndividualPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("GuestFinishingTouchesIndividualPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesIndividualMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditFTIndividualRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesIndividualProductsInfoSavingId, registrantUserId from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditFTIndividualAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesIndividualProductsInfoSavingId = '"+regSelectedProdsId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

/* My Account GiftReceived Data Display */

	public List guestFTMyAccountIndividualPaymentDataCheckInDB(long registrantUserId, long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and guestFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesIndividualPaymentSaving guestFTMyAccountIndividualPaymentDataTakeFromDB(long registrantUserId, long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and guestFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
/* Admin Gift Received Data Display */

	public List guestAdminFTIndividualGiftReceivedDataTakeFromDB(String individualStatusRef) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE individualStatus = '" + individualStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesIndividualPaymentSaving guestFTGiftReceivedIndividualPaymentDataTakeFromDB(long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE guestFinishingTouchesIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List guestAdminFTIndividualNoActionGiftReceivedData() {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE individualStatus = 'No Action' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestAdminFTIndividualConvertedToCreditGiftReceivedData() {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving WHERE individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
	public void delete(GuestFinishingTouchesIndividualPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesIndividualPaymentSaving findById(long id) {
		try {
			GuestFinishingTouchesIndividualPaymentSaving instance = (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().get("com.nookandcove.GuestFinishingTouchesIndividualPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestFinishingTouchesIndividualPaymentSaving> findByExample(GuestFinishingTouchesIndividualPaymentSaving instance) {
		try {
			List<GuestFinishingTouchesIndividualPaymentSaving> results = (List<GuestFinishingTouchesIndividualPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestFinishingTouchesIndividualPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesIndividualPaymentSaving merge(GuestFinishingTouchesIndividualPaymentSaving detachedInstance) {
		try {
			GuestFinishingTouchesIndividualPaymentSaving result = (GuestFinishingTouchesIndividualPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestFinishingTouchesIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestFinishingTouchesIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestFinishingTouchesIndividualPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestFinishingTouchesIndividualPaymentSavingDAOImpl) ctx.getBean("GuestFinishingTouchesIndividualPaymentSavingDAO");
	}

}

