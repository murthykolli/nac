package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistryCashFundsPaymentInfoSavingDAO;
import com.nookandcove.model.RegistryCashFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistryCashFundsPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements RegistryCashFundsPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistryCashFundsPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistryCashFundsPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

//	public List registryCashFundsInfoRowCheckingInDB(long registrantUserId) {
//		try {
//			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' ";	
//			return getHibernateTemplate().find(queryString);			
//		} catch (RuntimeException re) {
//			LOGGER.error("find by property name failed", re);
//			throw re;
//		}
//	}

	public List registryCashFundsAddCartRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCashFundsAddCartInfoCheckInDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCashFundsAddToCartInfoRowCheckingInDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status ='Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCashFundsPaymentInfoCheckingInDB(long registrantUserId, long cashFundsPaymentSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsPaymentInfoSavingId = '"+cashFundsPaymentSavingId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsPaymentInfoSaving registryCashFundsPaymentInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsPaymentInfoSavingId = '"+cashFundsPaymentSavingId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartInfoTakeFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCashFundsInfoSavingId+"' and status ='Cash Fund Only' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCashFundsPackageRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Cash Fund Only' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCashFundDeleteFromCartInDB(long registrantUserId, long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	public RegistryCashFundsPaymentInfoSaving adminRegistryCashFundInfoTakingFromDB(long regiPaymentInfoSavingId) {
//		try {
//			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' ";		
//			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
//		} catch (RuntimeException re) {
//			LOGGER.error("find by property name failed", re);
//			throw re;
//		}
//	}

	public List registryCashFundsPaymentInfoCheckInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int updateAllRegistryCashFundsInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistryCashFundsPaymentInfoSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"', refferanceDate = '"+currentDate+"', cashFundStatus = 'Funds Pending' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistryCashFundsPaymentInfoSaving functionality Update failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCashFundsValuesUpdateInDB(long registrantUserId, long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
//	Custom Funds Coding
	
	public List registryCustomFundsAddCartInfoCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCustomFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCustomFundsInfoSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsInfoSavingId = '"+regCustomFundsInfoSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";		
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomFundsAddCartRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCustomFundsPaymentInfoCheckingInDB(long registrantUserId, long cashFundsPaymentSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsPaymentInfoSavingId = '"+cashFundsPaymentSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryCustomFundsPaymentInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsPaymentInfoSavingId = '"+cashFundsPaymentSavingId+"' and status = 'Custom Fund Only' and checkoutPaymentStatus is null ";
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
//	My Accounts data Display 
	
	public List registryCashFundsMyAccountsDataCheckInDB(long registrantUserId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving registryMyAccountInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registryCashFundsPaymentInfoSavingId = '"+cashFundsPaymentSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
//	Admin Registry Cash Fund Info
	
	public List adminRegistrantCashFundsInfoCheckInDB() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminRegistrantPendingCashFundsInfoCheckInDB() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Funds Pending' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminRegistrantClearedNotRequestedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Now' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving adminRegistryCashFundColumnUpdateInDataBase(long regCFPaySavingId) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE registryCashFundsPaymentInfoSavingId = '"+regCFPaySavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminRegistrantTransferRequestedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Requested' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminRegistrantTransferCompletedCashFundsInfoCheckInDB() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving WHERE cashFundStatus = 'Transfer Completed' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}


	public void delete(RegistryCashFundsPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistryCashFundsPaymentInfoSaving findById(long id) {
		try {
			RegistryCashFundsPaymentInfoSaving instance = (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistryCashFundsPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistryCashFundsPaymentInfoSaving> findByExample(RegistryCashFundsPaymentInfoSaving instance) {
		try {
			List<RegistryCashFundsPaymentInfoSaving> results = (List<RegistryCashFundsPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistryCashFundsPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistryCashFundsPaymentInfoSaving merge(RegistryCashFundsPaymentInfoSaving detachedInstance) {
		try {
			RegistryCashFundsPaymentInfoSaving result = (RegistryCashFundsPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistryCashFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistryCashFundsPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistryCashFundsPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistryCashFundsPaymentInfoSavingDAOImpl) ctx.getBean("RegistryCashFundsPaymentInfoSavingDAO");
	}

}

