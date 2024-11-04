package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantCashFundBankAccountInfoSavingDAO;
import com.nookandcove.model.RegistrantCashFundBankAccountInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantCashFundBankAccountInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantCashFundBankAccountInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantCashFundBankAccountInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantCashFundBankAccountInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedCashFundBackAccountRowIdVerification(long registryUserId) {
		try {
			String queryString = "from RegistrantCashFundBankAccountInfoSaving WHERE registrantUserId = '"+registryUserId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantCashFundBankAccountInfoSaving updatedCashFundBackAccountRowInDataBasa(long registryUserId) {
		try {
			String queryString = "from RegistrantCashFundBankAccountInfoSaving WHERE registrantUserId = '"+registryUserId+"' ";
			return (RegistrantCashFundBankAccountInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(RegistrantCashFundBankAccountInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantCashFundBankAccountInfoSaving findById(long id) {
		try {
			RegistrantCashFundBankAccountInfoSaving instance = (RegistrantCashFundBankAccountInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantCashFundBankAccountInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantCashFundBankAccountInfoSaving> findByExample(RegistrantCashFundBankAccountInfoSaving instance) {
		try {
			List<RegistrantCashFundBankAccountInfoSaving> results = (List<RegistrantCashFundBankAccountInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantCashFundBankAccountInfoSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantCashFundBankAccountInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantCashFundBankAccountInfoSaving merge(RegistrantCashFundBankAccountInfoSaving detachedInstance) {
		try {
			RegistrantCashFundBankAccountInfoSaving result = (RegistrantCashFundBankAccountInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantCashFundBankAccountInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantCashFundBankAccountInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantCashFundBankAccountInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantCashFundBankAccountInfoSavingDAOImpl) ctx.getBean("RegistrantCashFundBankAccountInfoSavingDAO");
	}

}

