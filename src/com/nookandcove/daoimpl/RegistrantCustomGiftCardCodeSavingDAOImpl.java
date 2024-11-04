package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.RegistrantCustomGiftCardCodeSavingDAO;
import com.nookandcove.model.RegistrantCustomGiftCardCodeSaving;

@SuppressWarnings("rawtypes")
@Repository
public class RegistrantCustomGiftCardCodeSavingDAOImpl extends HibernateDaoSupport implements RegistrantCustomGiftCardCodeSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrantCustomGiftCardCodeSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(RegistrantCustomGiftCardCodeSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedGiftCardCodeRowIdVerification(long registryUserId) {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving WHERE registrantUserId = '"+registryUserId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantCustomGiftCardCodeSaving updatedGiftCardCodeRowInDataBasa(long registryUserId) {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving WHERE registrantUserId = '"+registryUserId+"' ";
			return (RegistrantCustomGiftCardCodeSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantGiftCardCodeValuesChecking(long registryUserId, String giftCuponCode) {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving WHERE registrantUserId = '"+registryUserId+"' and giftCardCode = '"+giftCuponCode+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public RegistrantCustomGiftCardCodeSaving registrantGiftCardCodeValuesTakeFromDB(long registryUserId, String giftCuponCode) {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving WHERE registrantUserId = '"+registryUserId+"' and giftCardCode = '"+giftCuponCode+"' ";
			return (RegistrantCustomGiftCardCodeSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(RegistrantCustomGiftCardCodeSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public RegistrantCustomGiftCardCodeSaving findById(long id) {
		try {
			RegistrantCustomGiftCardCodeSaving instance = (RegistrantCustomGiftCardCodeSaving) getHibernateTemplate().get("com.nookandcove.RegistrantCustomGiftCardCodeSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<RegistrantCustomGiftCardCodeSaving> findByExample(RegistrantCustomGiftCardCodeSaving instance) {
		try {
			List<RegistrantCustomGiftCardCodeSaving> results = (List<RegistrantCustomGiftCardCodeSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from RegistrantCustomGiftCardCodeSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public RegistrantCustomGiftCardCodeSaving merge(RegistrantCustomGiftCardCodeSaving detachedInstance) {
		try {
			RegistrantCustomGiftCardCodeSaving result = (RegistrantCustomGiftCardCodeSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RegistrantCustomGiftCardCodeSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RegistrantCustomGiftCardCodeSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static RegistrantCustomGiftCardCodeSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (RegistrantCustomGiftCardCodeSavingDAOImpl) ctx.getBean("RegistrantCustomGiftCardCodeSavingDAO");
	}

}

