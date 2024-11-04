package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestRoomFundPaymentInfoSavingDAO;
import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestRoomFundPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements GuestRoomFundPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestRoomFundPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GuestRoomFundPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List guestPaymentRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestOnlyRoomsPaymentRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' and guestRoomCombValues is not null order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestOnlyCashFundsPaymentRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestRoomAndCashFundsPackageRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestRoomAndCashFundsPackageInfoRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' and guestRoomCombValues is not null and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestUserPaymentDataTakeFromDB() {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestRoomFundPaymentInfoSaving guestRegistrantPaymentInfoTakingFromDB(long guestPaymentInfoSavingId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE guestRoomFundPaymentInfoSavingId = '"+guestPaymentInfoSavingId+"' ";		
			return (GuestRoomFundPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestPaymentRowDataTakingFromDB(long guestRegUserId) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestEmailDataChecking(String guestEmail) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE guestEmail = '"+guestEmail+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public GuestRoomFundPaymentInfoSaving guestEmailDataDisplay(String guestEmail) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE guestEmail = '"+guestEmail+"' ";
			return (GuestRoomFundPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Admin Registry Cash Fund Display

	public List adminGuestOnlyCashFundsPaymentRowCheckingInDB() {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving WHERE checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(GuestRoomFundPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestRoomFundPaymentInfoSaving findById(long id) {
		try {
			GuestRoomFundPaymentInfoSaving instance = (GuestRoomFundPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.GuestRoomFundPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestRoomFundPaymentInfoSaving> findByExample(GuestRoomFundPaymentInfoSaving instance) {
		try {
			List<GuestRoomFundPaymentInfoSaving> results = (List<GuestRoomFundPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestRoomFundPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestRoomFundPaymentInfoSaving merge(GuestRoomFundPaymentInfoSaving detachedInstance) {
		try {
			GuestRoomFundPaymentInfoSaving result = (GuestRoomFundPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestRoomFundPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestRoomFundPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestRoomFundPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestRoomFundPaymentInfoSavingDAOImpl) ctx.getBean("GuestRoomFundPaymentInfoSavingDAO");
	}

}

