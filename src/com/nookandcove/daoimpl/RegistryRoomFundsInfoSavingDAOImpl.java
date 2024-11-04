package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistryRoomFundsInfoSavingDAO;
import com.nookandcove.model.RegistryRoomFundsInfoSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings({"rawtypes", "unchecked"})
@Repository
public class RegistryRoomFundsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistryRoomFundsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryRoomFundsInfoSavingDAOImpl.class);

	public static final String REG_USER_NAME = "regUserName";
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistryRoomFundsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List selectedRegAddGiftRowCheckingInDB(long regUserId) {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving where registrantUserId = '"+regUserId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistryRoomFundsInfoSaving name failed", re);
			throw re;
		}
	}
	
	public RegistryRoomFundsInfoSaving selectedRegAddGiftRowValueFromDB(long regUserId) {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving WHERE registrantUserId = '"+regUserId+"' ";
			return (RegistryRoomFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryRoomFundsInfoSaving findByUserInfoFromDB(String regUserName) {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving WHERE regUserName = '"+regUserName+"'";
			return (RegistryRoomFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistryRoomFundsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistryRoomFundsInfoSaving findById(long id) {
		try {
			RegistryRoomFundsInfoSaving instance = (RegistryRoomFundsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistryRoomFundsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistryRoomFundsInfoSaving> findByExample(RegistryRoomFundsInfoSaving instance) {
		try {
			List<RegistryRoomFundsInfoSaving> results = (List<RegistryRoomFundsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByUserInfoProperty(String regUserName, Object passwordSalt) {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving where regUserName = '"+regUserName+"' and passwordSalt = '"+passwordSalt+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistryRoomFundsInfoSaving name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<UserInformation> findByUserName(Object regUserName) {
		return findByProperty(REG_USER_NAME, regUserName);
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistryRoomFundsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistryRoomFundsInfoSaving merge(RegistryRoomFundsInfoSaving detachedInstance) {
		try {
			RegistryRoomFundsInfoSaving result = (RegistryRoomFundsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistryRoomFundsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistryRoomFundsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistryRoomFundsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistryRoomFundsInfoSavingDAOImpl) ctx.getBean("RegistryRoomFundsInfoSavingDAO");
	}

}

