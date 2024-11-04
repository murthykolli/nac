package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.UserInformationDAO;
import com.nookandcove.model.UserInformation;

@SuppressWarnings({"rawtypes", "unchecked"})
@Repository
public class UserInformationDAOImpl extends HibernateDaoSupport implements UserInformationDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInformationDAOImpl.class);

	public static final String USER_NAME = "userName";
	
	protected void initDao() {
		// do nothing
	}

	public void save(UserInformation transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List findByUserInfoProperty(String userName, Object passwordSalt) {
		try {
			String queryString = "from UserInformation where userName = '"+userName+"' and passwordSalt = '"+passwordSalt+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by UserInformation name failed", re);
			throw re;
		}
	}
	
	public UserInformation findByUserInfoFromDB(String userName) {
		try {
			String queryString = "from UserInformation WHERE userName = '"+userName+"'";
			return (UserInformation) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public List adminDtaTakefromDB() {
		try {
			String queryString = "from UserInformation where typeOfUser = 'D'";				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by UserInformation name failed", re);
			throw re;
		}
	}
	
	public List updatedRowIdCheckingInDB(long userId) {
		try {
			String queryString = "from UserInformation WHERE userId = '"+userId+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public UserInformation updatedRowIdVerification(long userId) {
		try {
			String queryString = "from UserInformation WHERE userId = '"+userId+"' ";
			return (UserInformation) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerInfoDisplayInAdmin() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'D' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List inactiveDesignerInfoDisplayInAdmin() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'I' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List subAdminListDisplayInAdmin() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'S' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List packageLoginInfoDisplayInAdminSide() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'U' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List adminInfoCheckingInDB() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'A'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public UserInformation adminGettingUserIdFromDbUsingTypeOfUser() {
		try {
			String queryString = "from UserInformation WHERE typeOfUser = 'A'";
			return (UserInformation) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public UserInformation deleteSubAdminFromDB(long subAdminId) {
		try {
			String queryString = "from UserInformation WHERE userId = '"+subAdminId+"'";
			return (UserInformation) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(UserInformation persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public UserInformation findById(long id) {
		try {
			UserInformation instance = (UserInformation) getHibernateTemplate().get("com.nookandcove.UserInformation", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<UserInformation> findByExample(UserInformation instance) {
		try {
			List<UserInformation> results = (List<UserInformation>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from UserInformation as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<UserInformation> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findAll() {
		try {
			String queryString = "from UserInformation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public UserInformation merge(UserInformation detachedInstance) {
		try {
			UserInformation result = (UserInformation) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInformation instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInformation instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static UserInformationDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserInformationDAOImpl) ctx.getBean("UserInformationDAO");
	}
}