package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.GiftInfoSavingDAO;
import com.nookandcove.model.GiftInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class GiftInfoSavingDAOImpl extends HibernateDaoSupport implements GiftInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(GiftInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(GiftInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(GiftInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public List selectedGiftCardInfoDataChecking(long giftCardInfoId) {
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardInfoSavingId = '"+giftCardInfoId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public GiftInfoSaving viewGiftCardInfoDataDisplay(long giftCardInfoId) {
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardInfoSavingId = '"+giftCardInfoId+"' ";
			return (GiftInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List selectedGiftCardUsedVerification(String couponCode) {
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardCouponCode = '"+couponCode+"' and status = 'SENT' and usedGiftStatus = 'NO USED' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public GiftInfoSaving selectedGiftCardUsedStatusUpdateInDB(String couponCode) {
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardCouponCode = '"+couponCode+"' and status = 'SENT' and usedGiftStatus = 'NO USED' ";
			return (GiftInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List giftCardVerificationInDB(String couponCode) {
		LOGGER.debug("finding GiftInfoSaving instance with property: "+ couponCode);
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardCouponCode = '"+couponCode+"' and usedGiftStatus = 'NO USED' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public GiftInfoSaving giftCardUsedStatusUpdateInDB(String couponCode) {
		try {
			String queryString = "from GiftInfoSaving WHERE giftCardCouponCode = '"+couponCode+"' and usedGiftStatus = 'NO USED' ";
			return (GiftInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List allGiftCardInfoDailyReports(String todayDate) {
		try {
			String queryString = "from GiftInfoSaving WHERE createdDateInSt = '"+todayDate+"' order by giftCardInfoSavingId";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List allGiftCardInfoTotalReports(String referenceDate, String todayDate) {
		try {
			String queryString = "from GiftInfoSaving WHERE createdDateInSt between '"+todayDate+"' and '"+referenceDate+"' order by giftCardInfoSavingId";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public GiftInfoSaving findById(long id) {
		try {
			GiftInfoSaving instance = (GiftInfoSaving) getHibernateTemplate().get("com.nookandcove.GiftInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<GiftInfoSaving> findByExample(GiftInfoSaving instance) {
		try {
			List<GiftInfoSaving> results = (List<GiftInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from GiftInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List newGiftCardsDataTakeFromDB() {
		try {
			String queryString = "from GiftInfoSaving WHERE status = 'NEW' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List sentGiftCardsDataTakeFromDB() {
		try {
			String queryString = "from GiftInfoSaving WHERE status = 'SENT' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List adminCreatedGiftCardsDataTakeFromDB() {
		try {
			String queryString = "from GiftInfoSaving WHERE status = 'NEW' and yourName = 'Admin' and yourEmail = 'admin@nookandcove.com' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from GiftInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public GiftInfoSaving merge(GiftInfoSaving detachedInstance) {
		try {
			GiftInfoSaving result = (GiftInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GiftInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GiftInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static GiftInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (GiftInfoSavingDAOImpl) ctx.getBean("GiftInfoSavingDAOImpl");
	}
}