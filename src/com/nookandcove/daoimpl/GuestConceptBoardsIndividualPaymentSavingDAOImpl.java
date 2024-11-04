package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.model.GuestConceptBoardsIndividualPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestConceptBoardsIndividualPaymentSavingDAOImpl extends HibernateDaoSupport implements GuestConceptBoardsIndividualPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestConceptBoardsIndividualPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(GuestConceptBoardsIndividualPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryConceptBoardsIndividualPriceCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPriceTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualPaymentStatusCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPaymentStatusTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsIndividualPaymentSaving regConceptBoardsIndividualCartCountFromDB(long registrantUserId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBIndividualAddCartPaymentDataCheckInDB(long registrantUserId, long regCBIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + regCBIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsIndividualPaymentSaving registryCBIndividualAddCartPaymentDataTakeFromDB(long registrantUserId, long regCBIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + regCBIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regConceptBoardsIndividualPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE GuestConceptBoardsIndividualPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("GuestConceptBoardsIndividualPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regConceptBoardsIndividualMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditCBIndividualRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsIndividualProductsInfoSavingId, registrantUserId from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditCBIndividualAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsIndividualProductsInfoSavingId = '"+regSelectedProdsId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

/* My Account GiftReceived Data Display */

	public List guestCBMyAccountIndividualPaymentDataCheckInDB(long registrantUserId, long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and guestConceptBoardsIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsIndividualPaymentSaving guestCBMyAccountIndividualPaymentDataTakeFromDB(long registrantUserId, long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and guestConceptBoardsIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
/* Admin Gift Received Data Display */

	public List guestAdminCBIndividualGiftReceivedDataTakeFromDB(String individualStatusRef) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE individualStatus = '" + individualStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsIndividualPaymentSaving guestCBGiftReceivedIndividualPaymentDataTakeFromDB(long cbIndividualPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE guestConceptBoardsIndividualPaymentSavingId = '" + cbIndividualPaymentSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List guestAdminCBIndividualNoActionGiftReceivedData() {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE individualStatus = 'No Action' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestAdminCBIndividualConvertedToCreditGiftReceivedData() {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving WHERE individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
	public void delete(GuestConceptBoardsIndividualPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsIndividualPaymentSaving findById(long id) {
		try {
			GuestConceptBoardsIndividualPaymentSaving instance = (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().get("com.nookandcove.GuestConceptBoardsIndividualPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestConceptBoardsIndividualPaymentSaving> findByExample(GuestConceptBoardsIndividualPaymentSaving instance) {
		try {
			List<GuestConceptBoardsIndividualPaymentSaving> results = (List<GuestConceptBoardsIndividualPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestConceptBoardsIndividualPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsIndividualPaymentSaving merge(GuestConceptBoardsIndividualPaymentSaving detachedInstance) {
		try {
			GuestConceptBoardsIndividualPaymentSaving result = (GuestConceptBoardsIndividualPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestConceptBoardsIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestConceptBoardsIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestConceptBoardsIndividualPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestConceptBoardsIndividualPaymentSavingDAOImpl) ctx.getBean("GuestConceptBoardsIndividualPaymentSavingDAO");
	}

}

