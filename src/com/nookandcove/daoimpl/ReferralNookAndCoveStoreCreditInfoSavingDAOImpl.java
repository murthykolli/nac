package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ReferralNookAndCoveStoreCreditInfoSavingDAO;
import com.nookandcove.model.ReferralNookAndCoveStoreCreditInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ReferralNookAndCoveStoreCreditInfoSavingDAOImpl extends HibernateDaoSupport implements ReferralNookAndCoveStoreCreditInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferralNookAndCoveStoreCreditInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ReferralNookAndCoveStoreCreditInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedReferralRewardClientsInfoVerification(long referralUsersInfoSavingId, long registryUserId) {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and registrantUserId = '"+registryUserId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ReferralNookAndCoveStoreCreditInfoSaving updatedReferralRewardClientsInfoInDataBasa(long referralUsersInfoSavingId, long registryUserId) {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and registrantUserId = '"+registryUserId+"' ";
			return (ReferralNookAndCoveStoreCreditInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralRewardNookAndCoveCreditWithId(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and typeOfCreditName = 'Nook and Cove Credit' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralRewardNookAndCoveCredit() {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving WHERE typeOfCreditName = 'Nook and Cove Credit' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedReferralRewardVisaGiftCard(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' and typeOfCreditName = 'Visa Gift Card' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//  Admin side Dao coding display
	
	public List adminReferralRewardVisaGiftCardsDspl() {
		try {
			String queryString = "SELECT DISTINCT referralUserId from ReferralNookAndCoveStoreCreditInfoSaving WHERE typeOfCreditName = 'Visa Gift Card' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ReferralNookAndCoveStoreCreditInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ReferralNookAndCoveStoreCreditInfoSaving findById(long id) {
		try {
			ReferralNookAndCoveStoreCreditInfoSaving instance = (ReferralNookAndCoveStoreCreditInfoSaving) getHibernateTemplate().get("com.nookandcove.ReferralNookAndCoveStoreCreditInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ReferralNookAndCoveStoreCreditInfoSaving> findByExample(ReferralNookAndCoveStoreCreditInfoSaving instance) {
		try {
			List<ReferralNookAndCoveStoreCreditInfoSaving> results = (List<ReferralNookAndCoveStoreCreditInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ReferralNookAndCoveStoreCreditInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ReferralNookAndCoveStoreCreditInfoSaving merge(ReferralNookAndCoveStoreCreditInfoSaving detachedInstance) {
		try {
			ReferralNookAndCoveStoreCreditInfoSaving result = (ReferralNookAndCoveStoreCreditInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReferralNookAndCoveStoreCreditInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReferralNookAndCoveStoreCreditInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ReferralNookAndCoveStoreCreditInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ReferralNookAndCoveStoreCreditInfoSavingDAOImpl) ctx.getBean("ReferralNookAndCoveStoreCreditInfoSavingDAO");
	}

}

