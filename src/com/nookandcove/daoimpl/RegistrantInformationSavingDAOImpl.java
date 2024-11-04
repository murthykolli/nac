package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantInformationSavingDAO;
import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings({"rawtypes", "unchecked"})
@Repository
public class RegistrantInformationSavingDAOImpl extends HibernateDaoSupport implements RegistrantInformationSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantInformationSavingDAOImpl.class);

	public static final String REG_USER_NAME = "regUserName";
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantInformationSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List registryAddressValuesCheckingInDB(String regAddress) {
		try {
			String queryString = "from RegistrantInformationSaving where regAddress = '"+regAddress+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public List registryNamesListTakeFromDB() {
		try {
			String queryString = "from RegistrantInformationSaving WHERE status = 'Done'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public List adminRegistryLoginInfoListTakeFromDB() {
		try {
			String queryString = "from RegistrantInformationSaving WHERE typeOfUser = 'R'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public List searchRegistryInfoInDBForGuest(String regiAddress) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regAddress = '"+regiAddress+"' and status = 'Done' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving searchRegistryInfoTakeFromDBForGuest(String regiAddress) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regAddress = '"+regiAddress+"' and status = 'Done' ";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List selectedFirstNameValuesCheckingInDB(String firstName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regFirstName = '"+firstName+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedLastNameValuesCheckingInDB(String lastName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regLastName = '"+lastName+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedTwoNameValuesCheckingInDB(String firstName, String lastName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regFirstName = '"+firstName+"' and regLastName = '"+lastName+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public RegistrantInformationSaving selectedFirstNameValuesFromDB(String firstName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regFirstName = '"+firstName+"' ";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving selectedLastNameValuesFromDB(String lastName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regLastName = '"+lastName+"' ";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving selectedTwoNameValuesFromDB(String firstName, String lastName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regFirstName = '"+firstName+"' and regLastName = '"+lastName+"' ";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantInformationSaving registryDataTakeFromDB(long regUserId) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE registrantUserId = '"+regUserId+"'";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registryAddressDataTakeFromDB(String regAddress) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regAddress = '"+regAddress+"'";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving findByUserInfoFromDB(String regUserName) {
		try {
			String queryString = "from RegistrantInformationSaving WHERE regUserName = '"+regUserName+"'";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Admin Side All Registrants Data Display
	
	public List adminAllRegistrantsLiveStatusDataCheckInDB() {
		try {
			String queryString = "from RegistrantInformationSaving where regArchiveStatus is null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminAllRegistrantsArchiveStatusDataCheckInDB() {
		try {
			String queryString = "from RegistrantInformationSaving where regArchiveStatus = 'Archive' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminAllRegistrantsDataCheckInDB() {
		try {
			String queryString = "from RegistrantInformationSaving";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving adminAllRegistrantsDataTakeFromDB() {
		try {
			String queryString = "from RegistrantInformationSaving";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(RegistrantInformationSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantInformationSaving findById(long id) {
		try {
			RegistrantInformationSaving instance = (RegistrantInformationSaving) getHibernateTemplate().get("com.nookandcove.RegistrantInformationSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantInformationSaving> findByExample(RegistrantInformationSaving instance) {
		try {
			List<RegistrantInformationSaving> results = (List<RegistrantInformationSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByUserInfoProperty(String regUserName, Object passwordSalt) {
		try {
			String queryString = "from RegistrantInformationSaving where regUserName = '"+regUserName+"' and passwordSalt = '"+passwordSalt+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving regiUserInfoDataTakeFromDB(String regUserName, Object passwordSalt) {
		try {
			String queryString = "from RegistrantInformationSaving where regUserName = '"+regUserName+"' and passwordSalt = '"+passwordSalt+"'";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantInformationSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantUserIdsListCheckUsingUniqueRefCode(String uniqueRefCode) {
		try {
			String queryString = "from RegistrantInformationSaving where regVendorCouponId = '"+uniqueRefCode+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving registrantUserIdsListUsingUniqueRefCode(String uniqueRefCode) {
		try {
			String queryString = "from RegistrantInformationSaving where regVendorCouponId = '"+uniqueRefCode+"'";
			return (RegistrantInformationSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by RegistrantInformationSaving name failed", re);
			throw re;
		}
	}
	
	public List<UserInformation> findByUserName(Object regUserName) {
		return findByProperty(REG_USER_NAME, regUserName);
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantInformationSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantInformationSaving merge(RegistrantInformationSaving detachedInstance) {
		try {
			RegistrantInformationSaving result = (RegistrantInformationSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantInformationSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantInformationSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantInformationSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantInformationSavingDAOImpl) ctx.getBean("RegistrantInformationSavingDAO");
	}

}

