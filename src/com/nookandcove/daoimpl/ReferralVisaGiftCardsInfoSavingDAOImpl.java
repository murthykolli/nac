package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ReferralVisaGiftCardsInfoSavingDAO;
import com.nookandcove.model.ReferralVisaGiftCardsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ReferralVisaGiftCardsInfoSavingDAOImpl extends HibernateDaoSupport implements ReferralVisaGiftCardsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferralVisaGiftCardsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ReferralVisaGiftCardsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedReferralVisaGiftCardsInfoVerification(long referralUsersInfoSavingId, long registryUserId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and registrantUserId = '"+registryUserId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ReferralVisaGiftCardsInfoSaving updatedReferralVisaGiftCardsInfoInDataBasa(long referralUsersInfoSavingId, long registryUserId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and registrantUserId = '"+registryUserId+"' ";
			return (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralVisaGiftCardsInfoDisplay(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and (visaGiftCardStatus = 'Requested' or visaGiftCardStatus = 'Issued') order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralVisaGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Pending' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaGiftCardsInfoSaving referralVisaGiftCardsInfoUpdateinDB(long refVisaGiftCardsSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralVisaGiftCardsInfoSavingId = '"+refVisaGiftCardsSavingId+"' ";			
			return (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//  Admin side Dao coding display
	
	public List adminReferralVisaGiftCardsInfoDisplay() {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE typeOfCreditName = 'Visa Gift Card' and visaGiftCardStatus = 'Requested' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminReferralVisaGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Requested' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminIssuedReferralVisaGiftCardsInfoDisplay() {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE typeOfCreditName = 'Visa Gift Card' and visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminReferralIssuedVisaGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaGiftCardsInfoSaving adminReferralIssuedVisaGiftCardsDateTakeFromDB(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and visaGiftCardStatus = 'Issued' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralVisaGiftCardsInfoSaving adminRefIssuedVisaGiftCardsUpdatedInDB(long referralVisaGiftCardsInfoSavingId) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving WHERE referralUserId = '"+referralVisaGiftCardsInfoSavingId+"' ";			
			return (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int adminReferralIssuedVisaGiftCardsInfoUpdateInDB(long referralUsersInfoSavingId, Timestamp currentDate) {
		try {
			String queryString = "UPDATE ReferralVisaGiftCardsInfoSaving set visaGiftCardStatus = 'Issued', updatedDate = '"+currentDate+"' WHERE referralUserId = '"+referralUsersInfoSavingId+"' and typeOfCreditName = 'Visa Gift Card' and visaGiftCardStatus = 'Requested' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ReferralVisaGiftCardsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ReferralVisaGiftCardsInfoSaving findById(long id) {
		try {
			ReferralVisaGiftCardsInfoSaving instance = (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().get("com.nookandcove.ReferralVisaGiftCardsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ReferralVisaGiftCardsInfoSaving> findByExample(ReferralVisaGiftCardsInfoSaving instance) {
		try {
			List<ReferralVisaGiftCardsInfoSaving> results = (List<ReferralVisaGiftCardsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ReferralVisaGiftCardsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ReferralVisaGiftCardsInfoSaving merge(ReferralVisaGiftCardsInfoSaving detachedInstance) {
		try {
			ReferralVisaGiftCardsInfoSaving result = (ReferralVisaGiftCardsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReferralVisaGiftCardsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReferralVisaGiftCardsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ReferralVisaGiftCardsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ReferralVisaGiftCardsInfoSavingDAOImpl) ctx.getBean("ReferralVisaGiftCardsInfoSavingDAO");
	}

}

