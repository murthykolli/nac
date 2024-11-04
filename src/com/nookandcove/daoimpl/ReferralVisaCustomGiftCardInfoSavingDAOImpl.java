package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ReferralVisaCustomGiftCardInfoSavingDAO;
import com.nookandcove.model.ReferralVisaCustomGiftCardInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ReferralVisaCustomGiftCardInfoSavingDAOImpl extends HibernateDaoSupport implements ReferralVisaCustomGiftCardInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferralVisaCustomGiftCardInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ReferralVisaCustomGiftCardInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedReferralVisaCustomGiftCardsInfoVerification(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ReferralVisaCustomGiftCardInfoSaving updatedReferralVisaCustomGiftCardsInfoInDataBasa(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' ";
			return (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralVisaCustomGiftCardsInfoDisplay(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and typeOfCreditName = 'Visa Gift Card' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Pending' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaCustomGiftCardInfoSaving referralVisaCustomGiftCardsInfoUpdateinDB(long refVisaCustomGiftCardsSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralVisaCustomGiftCardsInfoSavingId = '"+refVisaCustomGiftCardsSavingId+"' ";			
			return (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//  Admin side Dao coding display
	
	public List adminReferralGiftCardsTotalCountDisplay() {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminReferralVisaCustomGiftCardsInfoDisplay() {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE visaGiftCardStatus = 'Requested' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminReferralVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Requested' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminIssuedReferralVisaCustomGiftCardsInfoDisplay() {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminReferralIssuedVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaCustomGiftCardInfoSaving adminReferralIssuedVisaCustomGiftCardsDateTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaCustomGiftCardInfoSaving adminRefIssuedVisaCustomGiftCardsUpdatedInDB(long referralVisaCustomGiftCardsInfoSavingId) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving WHERE referralVisaCustomGiftCardInfoSavingId = '"+referralVisaCustomGiftCardsInfoSavingId+"' ";			
			return (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ReferralVisaCustomGiftCardInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ReferralVisaCustomGiftCardInfoSaving findById(long id) {
		try {
			ReferralVisaCustomGiftCardInfoSaving instance = (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().get("com.nookandcove.ReferralVisaCustomGiftCardInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ReferralVisaCustomGiftCardInfoSaving> findByExample(ReferralVisaCustomGiftCardInfoSaving instance) {
		try {
			List<ReferralVisaCustomGiftCardInfoSaving> results = (List<ReferralVisaCustomGiftCardInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ReferralVisaCustomGiftCardInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ReferralVisaCustomGiftCardInfoSaving merge(ReferralVisaCustomGiftCardInfoSaving detachedInstance) {
		try {
			ReferralVisaCustomGiftCardInfoSaving result = (ReferralVisaCustomGiftCardInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReferralVisaCustomGiftCardInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReferralVisaCustomGiftCardInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ReferralVisaCustomGiftCardInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ReferralVisaCustomGiftCardInfoSavingDAOImpl) ctx.getBean("ReferralVisaCustomGiftCardInfoSavingDAO");
	}

}

