package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestFinishingTouchesContributedPaymentSavingDAO;
import com.nookandcove.model.GuestFinishingTouchesContributedPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestFinishingTouchesContributedPaymentSavingDAOImpl extends HibernateDaoSupport implements GuestFinishingTouchesContributedPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestFinishingTouchesContributedPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GuestFinishingTouchesContributedPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryFinishingTouchesContributedPriceCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesContributedPaymentSaving registryFinishingTouchesContributedPriceTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedPaymentStatusCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesContributedPaymentSaving registryFinishingTouchesContributedPaymentStatusTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryFinishingTouchesPaymentDataCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesContributedPaymentSaving registryFinishingTouchesPaymentDataTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFinishingTouchesContributedTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryFTContributedAddCartPaymentDataCheckInDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesContributedPaymentSaving registryFTContributedAddCartPaymentDataTakeFromDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantFinishingTouchesContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regFinishingTouchesContributedPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE GuestFinishingTouchesContributedPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("GuestFinishingTouchesContributedPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regFinishingTouchesContributedMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List guestStoreCreditFTContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesContributedProductsInfoSavingId, registrantUserId from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditFTContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestGiftReceivedFTContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantFinishingTouchesContributedProductsInfoSavingId, registrantUserId from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestGiftReceivedFTContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesContributedPaymentSaving guestFTContributeGiftReceivedStatusFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestFTGiftReceivedContributedPaymentInfoList(long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesContributedPaymentSaving guestFTGiftReceivedContributedPaymentDataTakeFromDB(long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestFTContributedGRConToCreditDataList(long registrantUserId, long regSelectedProdsId, String contributedStatusRef) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestMyAccountFTPaymentContributedPriceFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'No Action' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestMyAccountFTPaymentContributedInBOTDPriceFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Back Ordered Till' and registrantFinishingTouchesContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(GuestFinishingTouchesContributedPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestFinishingTouchesContributedPaymentSaving findById(long id) {
		try {
			GuestFinishingTouchesContributedPaymentSaving instance = (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().get("com.nookandcove.GuestFinishingTouchesContributedPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestFinishingTouchesContributedPaymentSaving> findByExample(GuestFinishingTouchesContributedPaymentSaving instance) {
		try {
			List<GuestFinishingTouchesContributedPaymentSaving> results = (List<GuestFinishingTouchesContributedPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestFinishingTouchesContributedPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestFinishingTouchesContributedPaymentSaving merge(GuestFinishingTouchesContributedPaymentSaving detachedInstance) {
		try {
			GuestFinishingTouchesContributedPaymentSaving result = (GuestFinishingTouchesContributedPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestFinishingTouchesContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestFinishingTouchesContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestFinishingTouchesContributedPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestFinishingTouchesContributedPaymentSavingDAOImpl) ctx.getBean("GuestFinishingTouchesContributedPaymentSavingDAO");
	}

}

