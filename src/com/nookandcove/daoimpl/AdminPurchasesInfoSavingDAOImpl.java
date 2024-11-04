package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminPurchasesInfoSavingDAO;
import com.nookandcove.model.AdminPurchasesInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminPurchasesInfoSavingDAOImpl extends HibernateDaoSupport implements AdminPurchasesInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminPurchasesInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AdminPurchasesInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AdminPurchasesInfoSaving WHERE userId = '"+userId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminPurchasesInfoSaving updatedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AdminPurchasesInfoSaving WHERE userId = '"+userId+"' ";
			return (AdminPurchasesInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(AdminPurchasesInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminPurchasesInfoSaving findById(long id) {
		try {
			AdminPurchasesInfoSaving instance = (AdminPurchasesInfoSaving) getHibernateTemplate().get("com.nookandcove.AdminPurchasesInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminPurchasesInfoSaving> findByExample(AdminPurchasesInfoSaving instance) {
		try {
			List<AdminPurchasesInfoSaving> results = (List<AdminPurchasesInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminPurchasesInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminPurchasesInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminPurchasesInfoSaving merge(AdminPurchasesInfoSaving detachedInstance) {
		try {
			AdminPurchasesInfoSaving result = (AdminPurchasesInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminPurchasesInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminPurchasesInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminPurchasesInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminPurchasesInfoSavingDAOImpl) ctx.getBean("AdminPurchasesInfoSavingDAO");
	}

}

