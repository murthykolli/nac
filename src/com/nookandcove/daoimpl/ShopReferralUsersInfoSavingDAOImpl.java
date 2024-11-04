package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ShopReferralUsersInfoSavingDAO;
import com.nookandcove.model.ShopReferralUsersInfoSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings({"rawtypes", "unchecked"})
@Repository
public class ShopReferralUsersInfoSavingDAOImpl extends HibernateDaoSupport implements ShopReferralUsersInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopReferralUsersInfoSavingDAOImpl.class);

	public static final String REF_USER_NAME = "referralUserEmail";
	
	protected void initDao() {
		// do nothing
	}

	public void save(ShopReferralUsersInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List shopReferralUsersInfoCheckingInDB(long referralUsersId) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving where referralUserId = '"+referralUsersId+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by ShopReferralUsersInfoSaving name failed", re);
			throw re;
		}
	}

	
	public ShopReferralUsersInfoSaving shopReferralUsersInfoTakeFromDB(long referralUsersId) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving WHERE referralUserId = '"+referralUsersId+"'";
			return (ShopReferralUsersInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List shopReferralUsersEmailInfoCheckInDB(String referralUserName) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving WHERE referralUserEmail = '"+referralUserName+"' and referralPassword is not null";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ShopReferralUsersInfoSaving shopReferralUsersInfoTakeFromDB(String referralUserName) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving WHERE referralUserEmail = '"+referralUserName+"'";
			return (ShopReferralUsersInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

	public List referralUserInfoCheckingInDB(String referralUserName, Object passwordSalt) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving where referralUserEmail = '" + referralUserName + "' and passwordSalt = '" + passwordSalt + "'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by ShopReferralUsersInfoSaving name failed", re);
			throw re;
		}
	}

	public ShopReferralUsersInfoSaving referralUserInfoDataTakeFromDB(String referralUserName, Object passwordSalt) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving where referralUserEmail = '" + referralUserName + "' and passwordSalt = '" + passwordSalt + "'";
			return (ShopReferralUsersInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by ShopReferralUsersInfoSaving name failed", re);
			throw re;
		}
	}
	
	
//	Admin Referral Program DAO code
	
	public List adminReferralNewApplicantsDataCheckInDB() {
		try {
			String queryString = "from ShopReferralUsersInfoSaving WHERE referralPassword is null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminReferralCurrentVendorsDataCheckInDB() {
		try {
			String queryString = "from ShopReferralUsersInfoSaving WHERE referralPassword is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public void delete(ShopReferralUsersInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ShopReferralUsersInfoSaving findById(long id) {
		try {
			ShopReferralUsersInfoSaving instance = (ShopReferralUsersInfoSaving) getHibernateTemplate().get("com.nookandcove.ShopReferralUsersInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ShopReferralUsersInfoSaving> findByExample(ShopReferralUsersInfoSaving instance) {
		try {
			List<ShopReferralUsersInfoSaving> results = (List<ShopReferralUsersInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByUserInfoProperty(String regUserName, Object passwordSalt) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving where regUserName = '"+regUserName+"' and passwordSalt = '"+passwordSalt+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by ShopReferralUsersInfoSaving name failed", re);
			throw re;
		}
	}

	public ShopReferralUsersInfoSaving regiUserInfoDataTakeFromDB(String regUserName, Object passwordSalt) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving where regUserName = '"+regUserName+"' and passwordSalt = '"+passwordSalt+"'";
			return (ShopReferralUsersInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by ShopReferralUsersInfoSaving name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ShopReferralUsersInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<UserInformation> findByUserName(Object referralUserEmail) {
		return findByProperty(REF_USER_NAME, referralUserEmail);
	}
	
	public List findAll() {
		try {
			String queryString = "from ShopReferralUsersInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ShopReferralUsersInfoSaving merge(ShopReferralUsersInfoSaving detachedInstance) {
		try {
			ShopReferralUsersInfoSaving result = (ShopReferralUsersInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopReferralUsersInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopReferralUsersInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ShopReferralUsersInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShopReferralUsersInfoSavingDAOImpl) ctx.getBean("ShopReferralUsersInfoSavingDAO");
	}

}

