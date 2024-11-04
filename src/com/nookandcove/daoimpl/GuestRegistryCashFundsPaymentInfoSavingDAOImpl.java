package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestRegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.model.GuestRegistryCashFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestRegistryCashFundsPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements GuestRegistryCashFundsPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestRegistryCashFundsPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GuestRegistryCashFundsPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List guestCashFundsPackageRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestCashFundsAddToCartInfoRowCheckingInDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status ='Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestRegistryCashFundsPaymentInfoSaving guestCashFundsAddCartDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status ='Cash Fund Only' and checkoutPaymentStatus is null ";		
			return (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestCashFundsAddCartRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}


	
//	Custom Funds Coding

	public List guestCustomFundsAddCartInfoCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestRegistryCashFundsPaymentInfoSaving guestCustomFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";		
			return (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestCustomFundsAddCartRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	Guest My Accounts data display
	
	public List guestCashFundsMyAccountDataCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestRegistryCashFundsPaymentInfoSaving guestMyAccountInfoUpdateInDB(long registrantUserId, long guestCashFundsPaymentSavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and guestRegistryCashFundsPaymentInfoSavingId = '"+guestCashFundsPaymentSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";			
			return (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

	public int updateAllGuestCashFundsInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE GuestRegistryCashFundsPaymentInfoSaving set checkoutPaymentStatus = '"+returnType+"', guestUserPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("GuestRegistryCashFundsPaymentInfoSaving functionality Update failed", re);
			throw re;
		}
	}
	
//	Admin Registry Cash Fund Info
	
	public List adminGuestCashFundsInfoCheckInDB() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestPendingCashFundsInfoCheckInDB() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Funds Pending' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestClearedNotRequestedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Now' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GuestRegistryCashFundsPaymentInfoSaving adminGuestCashFundColumnUpdateInDataBase(long guestCFPaySavingId) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE guestRegistryCashFundsPaymentInfoSavingId = '"+guestCFPaySavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestTransferRequestedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Requested' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestTransferCompletedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Completed' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(GuestRegistryCashFundsPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestRegistryCashFundsPaymentInfoSaving findById(long id) {
		try {
			GuestRegistryCashFundsPaymentInfoSaving instance = (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.GuestRegistryCashFundsPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestRegistryCashFundsPaymentInfoSaving> findByExample(GuestRegistryCashFundsPaymentInfoSaving instance) {
		try {
			List<GuestRegistryCashFundsPaymentInfoSaving> results = (List<GuestRegistryCashFundsPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestRegistryCashFundsPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestRegistryCashFundsPaymentInfoSaving merge(GuestRegistryCashFundsPaymentInfoSaving detachedInstance) {
		try {
			GuestRegistryCashFundsPaymentInfoSaving result = (GuestRegistryCashFundsPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestRegistryCashFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestRegistryCashFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestRegistryCashFundsPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestRegistryCashFundsPaymentInfoSavingDAOImpl) ctx.getBean("GuestRegistryCashFundsPaymentInfoSavingDAO");
	}

}

