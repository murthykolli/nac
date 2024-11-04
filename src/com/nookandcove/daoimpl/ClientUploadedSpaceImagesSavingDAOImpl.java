package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ClientUploadedSpaceImagesSavingDAO;
import com.nookandcove.model.ClientUploadedSpaceImagesSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ClientUploadedSpaceImagesSavingDAOImpl extends HibernateDaoSupport implements ClientUploadedSpaceImagesSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientUploadedSpaceImagesSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ClientUploadedSpaceImagesSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List clientUploadedSpaceImagesRowIdVerification(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving WHERE userId = '" + userId + "' and clientInfoSavingId = '" + clientInfoSavingId + "' ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List adminSideClientUploadedSpaceImagesRowIdVerification(long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving WHERE clientInfoSavingId = '" + clientInfoSavingId + "' ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public ClientUploadedSpaceImagesSaving deleteUploadedImagesSelectedRowInDB(long userId, long uploadImgId) {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving WHERE userId = '" + userId + "' and clientUploadedSpaceImagesSavingId = '"+uploadImgId+"' ";			
			return (ClientUploadedSpaceImagesSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientUploadedSpaceImagesSaving clientUploadedSpaceImagesTakeFromDB(long userId, long clientInfoSavingId) {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving WHERE userId = '" + userId + "' and clientInfoSavingId = '" + clientInfoSavingId + "' ";
			return (ClientUploadedSpaceImagesSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(ClientUploadedSpaceImagesSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ClientUploadedSpaceImagesSaving findById(long id) {
		try {
			ClientUploadedSpaceImagesSaving instance = (ClientUploadedSpaceImagesSaving) getHibernateTemplate().get("com.nookandcove.ClientUploadedSpaceImagesSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ClientUploadedSpaceImagesSaving> findByExample(ClientUploadedSpaceImagesSaving instance) {
		try {
			List<ClientUploadedSpaceImagesSaving> results = (List<ClientUploadedSpaceImagesSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ClientUploadedSpaceImagesSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientUploadedSpaceImagesSaving merge(ClientUploadedSpaceImagesSaving detachedInstance) {
		try {
			ClientUploadedSpaceImagesSaving result = (ClientUploadedSpaceImagesSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientUploadedSpaceImagesSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientUploadedSpaceImagesSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ClientUploadedSpaceImagesSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientUploadedSpaceImagesSavingDAOImpl) ctx.getBean("ClientUploadedSpaceImagesSavingDAO");
	}

}

