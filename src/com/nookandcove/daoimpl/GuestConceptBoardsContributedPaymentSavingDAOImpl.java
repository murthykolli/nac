package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestConceptBoardsContributedPaymentSavingDAO;
import com.nookandcove.model.GuestConceptBoardsContributedPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestConceptBoardsContributedPaymentSavingDAOImpl extends HibernateDaoSupport implements GuestConceptBoardsContributedPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestConceptBoardsContributedPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GuestConceptBoardsContributedPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryConceptBoardsContributedPriceCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsContributedPaymentSaving registryConceptBoardsContributedPriceTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedPaymentStatusCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsContributedPaymentSaving registryConceptBoardsContributedPaymentStatusTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryConceptBoardsPaymentDataCheckInDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsContributedPaymentSaving registryConceptBoardsPaymentDataTakeFromDB(long registrantUserId, long cbContributedProductSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedProductsInfoSavingId = '" + cbContributedProductSavingId + "' ";
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsContributedTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBContributedAddCartPaymentDataCheckInDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsContributedPaymentSaving registryCBContributedAddCartPaymentDataTakeFromDB(long registrantUserId, long cbContributedPaymentSavingId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsContributedPaymentSavingId = '" + cbContributedPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regConceptBoardsContributedPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE GuestConceptBoardsContributedPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("GuestConceptBoardsContributedPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regConceptBoardsContributedMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List guestStoreCreditCBContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsContributedProductsInfoSavingId, registrantUserId from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestStoreCreditCBContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and (contributedStatus = 'Converted to Store Credit' or contributedStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestGiftReceivedCBContributeRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsContributedProductsInfoSavingId, registrantUserId from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestGiftReceivedCBContributeAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsContributedPaymentSaving guestCBContributeGiftReceivedStatusFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestCBGiftReceivedContributedPaymentInfoList(long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsContributedPaymentSaving guestCBGiftReceivedContributedPaymentDataTakeFromDB(long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestCBContributedGRConToCreditDataList(long registrantUserId, long regSelectedProdsId, String contributedStatusRef) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and contributedStatus = '" + contributedStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestMyAccountCBPaymentContributedPriceFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'No Action' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestMyAccountCBPaymentContributedInBOTDPriceFromDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and contributedStatus = 'Back Ordered Till' and registrantConceptBoardsContributedProductsInfoSavingId = '"+regSelectedProdsId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(GuestConceptBoardsContributedPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestConceptBoardsContributedPaymentSaving findById(long id) {
		try {
			GuestConceptBoardsContributedPaymentSaving instance = (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().get("com.nookandcove.GuestConceptBoardsContributedPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestConceptBoardsContributedPaymentSaving> findByExample(GuestConceptBoardsContributedPaymentSaving instance) {
		try {
			List<GuestConceptBoardsContributedPaymentSaving> results = (List<GuestConceptBoardsContributedPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestConceptBoardsContributedPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestConceptBoardsContributedPaymentSaving merge(GuestConceptBoardsContributedPaymentSaving detachedInstance) {
		try {
			GuestConceptBoardsContributedPaymentSaving result = (GuestConceptBoardsContributedPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestConceptBoardsContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestConceptBoardsContributedPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestConceptBoardsContributedPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestConceptBoardsContributedPaymentSavingDAOImpl) ctx.getBean("GuestConceptBoardsContributedPaymentSavingDAO");
	}

}

