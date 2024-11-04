package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistryCashFundsInfoSavingDAO;
import com.nookandcove.model.RegistryCashFundsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistryCashFundsInfoSavingDAOImpl extends HibernateDaoSupport implements RegistryCashFundsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryCashFundsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistryCashFundsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

//	public List registryCashFundsCreateTableCheckInDB(long registrantUserId) {
//		try {
//			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' ";	
//			return getHibernateTemplate().find(queryString);			
//		} catch (RuntimeException re) {
//			LOGGER.error("find by property name failed", re);
//			throw re;
//		}
//	}
	
	public List registryCashFundsDataCheckInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName is not null and cashFundNewName = 'Cash Fund Only' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	public RegistryCashFundsInfoSaving registryCashFundsUpdateTableInDB(long registrantUserId) {
//		try {
//			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' ";		
//			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
//		} catch (RuntimeException re) {
//			LOGGER.error("find by property name failed", re);
//			throw re;
//		}
//	}

	public List registryCashFundsDataCheckUsingFundNameInDB(long registrantUserId, String cashFundName) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName = '"+cashFundName+"' and cashFundNewName = 'Cash Fund Only' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsInfoSaving registryCashFundsUpdateTableUsingFundNameInDB(long registrantUserId, String cashFundName) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName = '"+cashFundName+"' and cashFundNewName = 'Cash Fund Only' ";		
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryCashFundsLandingDataCheckInDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and cashFundNewName is not null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsInfoSaving registryCashFundsLandingUpdateTableInDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and cashFundNewName is not null ";		
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsInfoSaving registryCashFundsDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName is not null ";	
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	Custom Funds Coding
	
	public List registryCustomCashFundsDataCheckUsingFundNameInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundNewName is null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsInfoSaving registryCustomCashFundsUpdateTableUsingFundNameInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundNewName is null ";
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomFundsDataCheckUsingFundNameInDB(long registrantUserId, String customFundName) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName = '"+customFundName+"' and cashFundNewName is null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsInfoSaving registryCustomFundsUpdateTableUsingFundNameInDB(long registrantUserId, String customFundName) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName = '"+customFundName+"' and cashFundNewName is null ";
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomCashFundsNameInDB(long registrantUserId, String customFundName) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName = '"+customFundName+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomFundsDataTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and cashFundName is not null and (cashFundNewName = 'Custom Fund Only' or cashFundNewName is null) order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsInfoSaving registryCashFundsEditedDataTakeFromDB(long registrantUserId, long regCustomFundsId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsId+"' ";		
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomFundsLandingDataCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and (cashFundNewName = 'Custom Fund Only' or cashFundNewName is null) ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsInfoSaving registryCustomFundsLandingUpdateTableInDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and (cashFundNewName = 'Custom Fund Only' or cashFundNewName is null) ";		
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public RegistryCashFundsInfoSaving registryCashFundsValuesUpdateInDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and checkoutPaymentStatus is null ";	
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	MyAccount Cash Fund data Display

	public RegistryCashFundsInfoSaving cashFundsMyAccountDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' ";	
			return (RegistryCashFundsInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
	public void delete(RegistryCashFundsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsInfoSaving findById(long id) {
		try {
			RegistryCashFundsInfoSaving instance = (RegistryCashFundsInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistryCashFundsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistryCashFundsInfoSaving> findByExample(RegistryCashFundsInfoSaving instance) {
		try {
			List<RegistryCashFundsInfoSaving> results = (List<RegistryCashFundsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistryCashFundsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistryCashFundsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistryCashFundsInfoSaving merge(RegistryCashFundsInfoSaving detachedInstance) {
		try {
			RegistryCashFundsInfoSaving result = (RegistryCashFundsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistryCashFundsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistryCashFundsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistryCashFundsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistryCashFundsInfoSavingDAOImpl) ctx.getBean("RegistryCashFundsInfoSavingDAO");
	}

}

