package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.DesignerInfoSavingDAO;
import com.nookandcove.model.DesignerInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class DesignerInfoSavingDAOImpl extends HibernateDaoSupport implements DesignerInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(DesignerInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(DesignerInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from DesignerInfoSaving WHERE designerId = '"+userId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List selectedDesnRowIdVerificationUsingStatus(long userId) {
		try {
			String queryString = "from DesignerInfoSaving WHERE designerId = '"+userId+"' and status is not null";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public DesignerInfoSaving updatedDesnRowIdVerification(long designerId) {
		try {
			String queryString = "from DesignerInfoSaving WHERE designerId = '"+designerId+"' ";
			return (DesignerInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public DesignerInfoSaving designerDataTakeFromDBUsingId(long designerSavingId) {
		try {
			String queryString = "from DesignerInfoSaving WHERE designerInfoSavingId = '"+designerSavingId+"' ";
			return (DesignerInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List displayDesignerNameInNewClientsUsingStatus() {
		try {
			String queryString = "from DesignerInfoSaving WHERE status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List displayDesignerNameAndDateInNewClientsUsingStatus() {
		try {
			String queryString = "from DesignerInfoSaving WHERE status is not null and (desWaitingForClientStatus is not null and desWaitingForClientStatus != '') order by desWaitingForClientDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List displayDesignerNameAndDateInNewClients() {
		try {
			String queryString = "from DesignerInfoSaving WHERE (desWaitingForClientStatus is not null and desWaitingForClientStatus != '') order by desWaitingForClientDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
//	Registry Side Data Display
	public List allDesignersInfoDisplayInRegAdmin() {
		try {
			String queryString = "from DesignerInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public void delete(DesignerInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public DesignerInfoSaving findById(long id) {
		try {
			DesignerInfoSaving instance = (DesignerInfoSaving) getHibernateTemplate().get("com.nookandcove.DesignerInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<DesignerInfoSaving> findByExample(DesignerInfoSaving instance) {
		try {
			List<DesignerInfoSaving> results = (List<DesignerInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from DesignerInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from DesignerInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public DesignerInfoSaving merge(DesignerInfoSaving detachedInstance) {
		try {
			DesignerInfoSaving result = (DesignerInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DesignerInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DesignerInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static DesignerInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (DesignerInfoSavingDAOImpl) ctx.getBean("DesignerInfoSavingDAO");
	}

}
