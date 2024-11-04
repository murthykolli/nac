package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ClientDesignerMessageInfoSavingDAO;
import com.nookandcove.model.ClientDesignerMessageInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ClientDesignerMessageInfoSavingDAOImpl extends HibernateDaoSupport implements ClientDesignerMessageInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDesignerMessageInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ClientDesignerMessageInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List oneTimeDateFormationCheckingInDB(String oneTimeReffDate) {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving WHERE oneTimeRefDate = '"+oneTimeReffDate+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientAndDesignerMessageInfoRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientMessageInfoCountInDesigner(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'CLDESNEW' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public int clientMessagesStatusUpdateInDesignerSide(long clientInfoSavingId, long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE ClientDesignerMessageInfoSaving set status = null WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'CLDESNEW' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by ClientDesignerMessageInfoSaving name failed", re);
			throw re;
		}
	}	

	public List designerMessageInfoCountInClientSide(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'DESCLNEW' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public int designerMessagesStatusUpdateInClientSide(long clientInfoSavingId, long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE ClientDesignerMessageInfoSaving set status = null WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'DESCLNEW' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by ClientDesignerMessageInfoSaving name failed", re);
			throw re;
		}
	}
	
	public void delete(ClientDesignerMessageInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ClientDesignerMessageInfoSaving findById(long id) {
		try {
			ClientDesignerMessageInfoSaving instance = (ClientDesignerMessageInfoSaving) getHibernateTemplate().get("com.nookandcove.ClientDesignerMessageInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ClientDesignerMessageInfoSaving> findByExample(ClientDesignerMessageInfoSaving instance) {
		try {
			List<ClientDesignerMessageInfoSaving> results = (List<ClientDesignerMessageInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ClientDesignerMessageInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientDesignerMessageInfoSaving merge(ClientDesignerMessageInfoSaving detachedInstance) {
		try {
			ClientDesignerMessageInfoSaving result = (ClientDesignerMessageInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientDesignerMessageInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientDesignerMessageInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ClientDesignerMessageInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientDesignerMessageInfoSavingDAOImpl) ctx.getBean("ClientDesignerMessageInfoSavingDAO");
	}

}

