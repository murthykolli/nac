package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistryRoomFundsPaymentInfoSavingDAO;
import com.nookandcove.model.RegistryRoomFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistryRoomFundsPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements RegistryRoomFundsPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryRoomFundsPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistryRoomFundsPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List regRoomAndCashFundsPackageRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantCashFundsPackageRowOnlyCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regRoomAndCashFundsPackageInfoRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and selectedRoomFundsInfo is not null and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List regRoomAndCashFundPSNRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundRowDataTakingFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";		
			return (RegistryRoomFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryRoomFundsPaymentInfoSaving registryRoomAndCashFundDeleteFromCartInDB(long registrantUserId, long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' and checkoutPaymentStatus is null ";		
			return (RegistryRoomFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryRoomFundsPaymentInfoSaving adminRegistryRoomAndCashFundInfoTakingFromDB(long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' ";		
			return (RegistryRoomFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int updateAllRegistryRoomAndCashFundInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistryRoomFundsPaymentInfoSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistryRoomFundsPaymentInfoSaving functionality Update failed", re);
			throw re;
		}
	}
	
//	Admin Registry Cash Fund Info
	public List adminRegistrantCashFundsPackageRowOnlyCheckingInDB() {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving WHERE checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(RegistryRoomFundsPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistryRoomFundsPaymentInfoSaving findById(long id) {
		try {
			RegistryRoomFundsPaymentInfoSaving instance = (RegistryRoomFundsPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistryRoomFundsPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistryRoomFundsPaymentInfoSaving> findByExample(RegistryRoomFundsPaymentInfoSaving instance) {
		try {
			List<RegistryRoomFundsPaymentInfoSaving> results = (List<RegistryRoomFundsPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistryRoomFundsPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistryRoomFundsPaymentInfoSaving merge(RegistryRoomFundsPaymentInfoSaving detachedInstance) {
		try {
			RegistryRoomFundsPaymentInfoSaving result = (RegistryRoomFundsPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistryRoomFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistryRoomFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistryRoomFundsPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistryRoomFundsPaymentInfoSavingDAOImpl) ctx.getBean("RegistryRoomFundsPaymentInfoSavingDAO");
	}

}

