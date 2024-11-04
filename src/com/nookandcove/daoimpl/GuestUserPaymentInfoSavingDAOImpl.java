package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GuestUserPaymentInfoSavingDAO;
import com.nookandcove.model.GuestUserPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GuestUserPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements GuestUserPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GuestUserPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GuestUserPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List guestPaymentRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestUserFirstNameCheckingInDB(long guestPaymentInfoSavingId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE guestUserPaymentInfoSavingId = '"+guestPaymentInfoSavingId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestUserPaymentInfoSaving guestUserFirstNameInfoTakingFromDB(long guestPaymentInfoSavingId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE guestUserPaymentInfoSavingId = '"+guestPaymentInfoSavingId+"' ";		
			return (GuestUserPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestRoomAndCashFundsPackageRowCheckingInDB(long guestRegUserId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminGuestUserPaymentDataTakeFromDB() {
		try {
			String queryString = "from GuestUserPaymentInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public GuestUserPaymentInfoSaving guestRegistrantPaymentInfoTakingFromDB(long guestPaymentInfoSavingId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE guestUserPaymentInfoSavingId = '"+guestPaymentInfoSavingId+"' ";		
			return (GuestUserPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestPaymentRowDataTakingFromDB(long guestRegUserId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestEmailDataChecking(String guestEmail) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE guestEmail = '"+guestEmail+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public GuestUserPaymentInfoSaving guestEmailDataDisplay(String guestEmail) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE guestEmail = '"+guestEmail+"' ";
			return (GuestUserPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List guestUserPaymentCheckUsingUniqueRefCode(long guestRegUserId) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving WHERE registrantUserId = '"+guestRegUserId+"' and checkoutPaymentStatus is not null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(GuestUserPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public GuestUserPaymentInfoSaving findById(long id) {
		try {
			GuestUserPaymentInfoSaving instance = (GuestUserPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.GuestUserPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GuestUserPaymentInfoSaving> findByExample(GuestUserPaymentInfoSaving instance) {
		try {
			List<GuestUserPaymentInfoSaving> results = (List<GuestUserPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GuestUserPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GuestUserPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GuestUserPaymentInfoSaving merge(GuestUserPaymentInfoSaving detachedInstance) {
		try {
			GuestUserPaymentInfoSaving result = (GuestUserPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GuestUserPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GuestUserPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GuestUserPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuestUserPaymentInfoSavingDAOImpl) ctx.getBean("GuestUserPaymentInfoSavingDAO");
	}

}

