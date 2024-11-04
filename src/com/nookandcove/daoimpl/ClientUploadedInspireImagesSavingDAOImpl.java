package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ClientUploadedInspireImagesSavingDAO;
import com.nookandcove.model.ClientUploadedInspireImagesSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ClientUploadedInspireImagesSavingDAOImpl extends HibernateDaoSupport implements ClientUploadedInspireImagesSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientUploadedInspireImagesSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ClientUploadedInspireImagesSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE userId = '"+userId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientUploadedInspireImagesSaving updatedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE userId = '"+userId+"' ";
			return (ClientUploadedInspireImagesSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientUploadedInspireImagesRowIdVerification(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE userId = '" + userId + "' and clientInfoSavingId = '" + clientInfoSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminSideClientUploadedInspireImagesRowIdVerification(long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE clientInfoSavingId = '" + clientInfoSavingId + "' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ClientUploadedInspireImagesSaving deleteUploadedImagesSelectedRowInDB(long userId, long uploadImgId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE userId = '" + userId + "' and clientUploadedInspireImagesSavingId = '"+uploadImgId+"' ";			
			return (ClientUploadedInspireImagesSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ClientUploadedInspireImagesSaving clientUploadedInspireImagesTakeFromDB(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving WHERE userId = '" + userId + "' and clientInfoSavingId = '" + clientInfoSavingId + "' ";
			return (ClientUploadedInspireImagesSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ClientUploadedInspireImagesSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ClientUploadedInspireImagesSaving findById(long id) {
		try {
			ClientUploadedInspireImagesSaving instance = (ClientUploadedInspireImagesSaving) getHibernateTemplate().get("com.nookandcove.ClientUploadedInspireImagesSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ClientUploadedInspireImagesSaving> findByExample(ClientUploadedInspireImagesSaving instance) {
		try {
			List<ClientUploadedInspireImagesSaving> results = (List<ClientUploadedInspireImagesSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ClientUploadedInspireImagesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientUploadedInspireImagesSaving merge(ClientUploadedInspireImagesSaving detachedInstance) {
		try {
			ClientUploadedInspireImagesSaving result = (ClientUploadedInspireImagesSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientUploadedInspireImagesSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientUploadedInspireImagesSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ClientUploadedInspireImagesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientUploadedInspireImagesSavingDAOImpl) ctx.getBean("ClientUploadedInspireImagesSavingDAO");
	}

}

