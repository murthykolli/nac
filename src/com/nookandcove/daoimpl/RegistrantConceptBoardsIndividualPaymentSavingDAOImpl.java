package com.nookandcove.daoimpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantConceptBoardsIndividualPaymentSavingDAO;
import com.nookandcove.model.RegistrantConceptBoardsIndividualPaymentSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantConceptBoardsIndividualPaymentSavingDAOImpl extends HibernateDaoSupport implements RegistrantConceptBoardsIndividualPaymentSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantConceptBoardsIndividualPaymentSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	public void save(RegistrantConceptBoardsIndividualPaymentSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	

	public List registryConceptBoardsIndividualPriceCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualPaymentStatusCheck(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPriceTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPaymentStatusValue(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualPaymentStatusCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPaymentStatusTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualProductsInfoSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryConceptBoardsIndividualTotalCartCount(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualPaymentSaving regConceptBoardsIndividualCartCountFromDB(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and checkoutPaymentStatus is null ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryCBIndividualAddCartPaymentDataCheckInDB(long registrantUserId, long regCBIndividualPaymentSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + regCBIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualPaymentSaving registryCBIndividualAddCartPaymentDataTakeFromDB(long registrantUserId, long regCBIndividualPaymentSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + regCBIndividualPaymentSavingId + "' and checkoutPaymentStatus is null ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int regConceptBoardsIndividualPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate) {		
		try {
			String queryString = "UPDATE RegistrantConceptBoardsIndividualPaymentSaving set checkoutPaymentStatus = '"+returnType+"', registrantPaymentInfoSavingId = '"+regPaymentInfoSavingId+"', updatedDate = '"+currentDate+"', individualStatus = 'No Action', refferanceDate = '"+currentDate+"' WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus is null ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("RegistrantConceptBoardsIndividualPaymentSaving functionality Update failed", re);
			throw re;
		}
	}

	public List regConceptBoardsIndividualMyAccountDataDisplay(long registrantUserId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and checkoutPaymentStatus = 'This transaction has been approved.' order by createdDate DESC nulls last, refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditCBIndividualRemoveDuplicateRows(long registrantUserId) {
		try {
			String queryString = "SELECT DISTINCT registrantConceptBoardsIndividualProductsInfoSavingId, registrantUserId from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantStoreCreditCBIndividualAmountCheckingInDB(long registrantUserId, long regSelectedProdsId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '"+registrantUserId+"' and registrantConceptBoardsIndividualProductsInfoSavingId = '"+regSelectedProdsId+"' and (individualStatus = 'Converted to Store Credit' or individualStatus = 'Converted to Store Credit Due to Out of Stock') and checkoutPaymentStatus = 'This transaction has been approved.' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	
/* My Account GiftReceived Data Display */

	public List registryCBMyAccountIndividualPaymentDataCheckInDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualPaymentSaving registryCBMyAccountIndividualPaymentDataTakeFromDB(long registrantUserId, long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantUserId = '" + registrantUserId + "' and registrantConceptBoardsIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
/* Admin Gift Received Data Display */
	
	public List registryAdminCBIndividualGiftReceivedDataTakeFromDB(String individualStatusRef) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE individualStatus = '" + individualStatusRef + "' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualPaymentSaving registryCBGiftReceivedIndividualPaymentDataTakeFromDB(long cbIndividualProductSavingId) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE registrantConceptBoardsIndividualPaymentSavingId = '" + cbIndividualProductSavingId + "' and checkoutPaymentStatus = 'This transaction has been approved.' ";
			return (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryAdminCBIndividualNoActionGiftReceivedData() {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE individualStatus = 'No Action' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registryAdminCBIndividualConvertedToCreditGiftReceivedData() {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving WHERE individualStatus = 'Converted to Store Credit' and checkoutPaymentStatus = 'This transaction has been approved.' order by refferanceDate DESC nulls last ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	
	public void delete(RegistrantConceptBoardsIndividualPaymentSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantConceptBoardsIndividualPaymentSaving findById(long id) {
		try {
			RegistrantConceptBoardsIndividualPaymentSaving instance = (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().get("com.nookandcove.RegistrantConceptBoardsIndividualPaymentSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantConceptBoardsIndividualPaymentSaving> findByExample(RegistrantConceptBoardsIndividualPaymentSaving instance) {
		try {
			List<RegistrantConceptBoardsIndividualPaymentSaving> results = (List<RegistrantConceptBoardsIndividualPaymentSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantConceptBoardsIndividualPaymentSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantConceptBoardsIndividualPaymentSaving merge(RegistrantConceptBoardsIndividualPaymentSaving detachedInstance) {
		try {
			RegistrantConceptBoardsIndividualPaymentSaving result = (RegistrantConceptBoardsIndividualPaymentSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantConceptBoardsIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantConceptBoardsIndividualPaymentSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantConceptBoardsIndividualPaymentSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantConceptBoardsIndividualPaymentSavingDAOImpl) ctx.getBean("RegistrantConceptBoardsIndividualPaymentSavingDAO");
	}

}

