package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantPaymentInfoSavingDAO;
import com.nookandcove.model.RegistrantPaymentInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantPaymentInfoSavingDAOImpl extends HibernateDaoSupport implements RegistrantPaymentInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantPaymentInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantPaymentInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public RegistrantPaymentInfoSaving registrantUserPaymentRowDataTakingFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";		
			return (RegistrantPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantUserPaymentRowCheckingInDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminRegistryUserPaymentDataTakeFromDB() {
		try {
			String queryString = "from RegistrantPaymentInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantPaymentInfoSaving adminRegistrantPaymentInfoTakingFromDB(long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' ";		
			return (RegistrantPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantPaymentInfoSaving registryTransactionNumberTakeFromDB(long registrantUserId, long regiPaymentInfoSavingId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regiPaymentInfoSavingId+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";		
			return (RegistrantPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantMyAccountStoredCreditGiftedPrice(long registrantUserId, String giftCardCode) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and giftCardCode = '"+giftCardCode+"' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantMyAccountSCGPriceUsingCodeReff(long registrantUserId, long regPaymentInfoSavingId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"' and giftCardCode is not null and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantPaymentInfoSaving registrantMyAccountSCGPriceValueUsingCodeReff(long registrantUserId, long regPaymentInfoSavingId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"' and giftCardCode is not null and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return (RegistrantPaymentInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantUserPaymentCheckUsingUniqueRefCode(long registrantUserId) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is not null ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantPaymentInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantPaymentInfoSaving findById(long id) {
		try {
			RegistrantPaymentInfoSaving instance = (RegistrantPaymentInfoSaving) getHibernateTemplate().get("com.nookandcove.RegistrantPaymentInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantPaymentInfoSaving> findByExample(RegistrantPaymentInfoSaving instance) {
		try {
			List<RegistrantPaymentInfoSaving> results = (List<RegistrantPaymentInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantPaymentInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantPaymentInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantPaymentInfoSaving merge(RegistrantPaymentInfoSaving detachedInstance) {
		try {
			RegistrantPaymentInfoSaving result = (RegistrantPaymentInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantPaymentInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantPaymentInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantPaymentInfoSavingDAOImpl) ctx.getBean("RegistrantPaymentInfoSavingDAO");
	}

}

