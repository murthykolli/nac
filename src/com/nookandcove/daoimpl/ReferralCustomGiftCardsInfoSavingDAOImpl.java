package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ReferralCustomGiftCardsInfoSavingDAO;
import com.nookandcove.model.ReferralCustomGiftCardsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ReferralCustomGiftCardsInfoSavingDAOImpl extends HibernateDaoSupport implements ReferralCustomGiftCardsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferralCustomGiftCardsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ReferralCustomGiftCardsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List referralCustomGiftCardInfoVerification(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ReferralCustomGiftCardsInfoSaving updatedReferralCustomGiftCardInfoInDataBasa(long referralUsersInfoSavingId) {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving WHERE referralUserId = '"+referralUsersInfoSavingId+"' ";
			return (ReferralCustomGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List referralCustomGiftCardCodeCheckInDB(String CustomGiftCardName) {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving WHERE referralCustomGiftCard = '"+CustomGiftCardName+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ReferralCustomGiftCardsInfoSaving referralCustomGiftCardCodeInfoTakeFromDB(String CustomGiftCardName) {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving WHERE referralCustomGiftCard = '"+CustomGiftCardName+"' ";			
			return (ReferralCustomGiftCardsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ReferralCustomGiftCardsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ReferralCustomGiftCardsInfoSaving findById(long id) {
		try {
			ReferralCustomGiftCardsInfoSaving instance = (ReferralCustomGiftCardsInfoSaving) getHibernateTemplate().get("com.nookandcove.ReferralCustomGiftCardsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ReferralCustomGiftCardsInfoSaving> findByExample(ReferralCustomGiftCardsInfoSaving instance) {
		try {
			List<ReferralCustomGiftCardsInfoSaving> results = (List<ReferralCustomGiftCardsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ReferralCustomGiftCardsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ReferralCustomGiftCardsInfoSaving merge(ReferralCustomGiftCardsInfoSaving detachedInstance) {
		try {
			ReferralCustomGiftCardsInfoSaving result = (ReferralCustomGiftCardsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReferralCustomGiftCardsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReferralCustomGiftCardsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ReferralCustomGiftCardsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ReferralCustomGiftCardsInfoSavingDAOImpl) ctx.getBean("ReferralCustomGiftCardsInfoSavingDAO");
	}

}

