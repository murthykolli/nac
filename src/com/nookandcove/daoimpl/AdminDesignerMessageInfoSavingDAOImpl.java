package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminDesignerMessageInfoSavingDAO;
import com.nookandcove.model.AdminDesignerMessageInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminDesignerMessageInfoSavingDAOImpl extends HibernateDaoSupport implements AdminDesignerMessageInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDesignerMessageInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AdminDesignerMessageInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List adminAndDesignerMessageInfoRowVerificationInDB(long designerInfoSavingId) {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving WHERE designerInfoSavingId = '"+designerInfoSavingId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List oneTimeDateFormationCheckingInDB(String oneTimeReffDate) {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving WHERE oneTimeRefDate = '"+oneTimeReffDate+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int adminMessagesStatusUpdateInDesignerSide(long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE AdminDesignerMessageInfoSaving set status = null WHERE designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'ADDESNEW' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AdminDesignerMessageInfoSaving name failed", re);
			throw re;
		}
	}
	
	public List adminMessageCounttoDesignerSideInDB(long designerInfoSavingId) {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving WHERE designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'ADDESNEW' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerMessageCounttoAdminSideInDB(long designerInfoSavingId) {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving WHERE designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'DESADNEW' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int designerMessagesStatusUpdateInAdminSide(long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE AdminDesignerMessageInfoSaving set status = null WHERE designerInfoSavingId = '"+designerInfoSavingId+"' and status = 'DESADNEW' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AdminDesignerMessageInfoSaving name failed", re);
			throw re;
		}
	}
	
	public void delete(AdminDesignerMessageInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminDesignerMessageInfoSaving findById(long id) {
		try {
			AdminDesignerMessageInfoSaving instance = (AdminDesignerMessageInfoSaving) getHibernateTemplate()
					.get("com.nookandcove.AdminDesignerMessageInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminDesignerMessageInfoSaving> findByExample(AdminDesignerMessageInfoSaving instance) {
		try {
			List<AdminDesignerMessageInfoSaving> results = (List<AdminDesignerMessageInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminDesignerMessageInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminDesignerMessageInfoSaving merge(AdminDesignerMessageInfoSaving detachedInstance) {
		try {
			AdminDesignerMessageInfoSaving result = (AdminDesignerMessageInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminDesignerMessageInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminDesignerMessageInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminDesignerMessageInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminDesignerMessageInfoSavingDAOImpl) ctx.getBean("AdminDesignerMessageInfoSavingDAO");
	}

}

