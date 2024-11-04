package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.DesignerEditableCalendarInfoSavingDAO;
import com.nookandcove.model.DesignerEditableCalendarInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class DesignerEditableCalendarInfoSavingDAOImpl extends HibernateDaoSupport implements DesignerEditableCalendarInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(DesignerEditableCalendarInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(DesignerEditableCalendarInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List checkEditableCalendarRowInDB(long desnInfoSavingId) {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving WHERE designerInfoSavingId = '"+desnInfoSavingId+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public DesignerEditableCalendarInfoSaving takeEditableCalendarRowDataFromDB(long desnInfoSavingId) {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving WHERE designerInfoSavingId = '"+desnInfoSavingId+"' ";
			return (DesignerEditableCalendarInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List editableCalendarMonthDataTakeFromDB(long desnInfoSavingId, String clientMonth, String clientDay, String clientYear) {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving WHERE designerInfoSavingId = '"+desnInfoSavingId+"' and clientMonth = '"+clientMonth+"' and clientDay = '"+clientDay+"' and clientYear = '"+clientYear+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(DesignerEditableCalendarInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public DesignerEditableCalendarInfoSaving findById(long id) {
		try {
			DesignerEditableCalendarInfoSaving instance = (DesignerEditableCalendarInfoSaving) getHibernateTemplate().get("com.nookandcove.DesignerEditableCalendarInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<DesignerEditableCalendarInfoSaving> findByExample(DesignerEditableCalendarInfoSaving instance) {
		try {
			List<DesignerEditableCalendarInfoSaving> results = (List<DesignerEditableCalendarInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List newGiftCardsDataTakeFromDB() {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving WHERE status = 'NEW' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List sentGiftCardsDataTakeFromDB() {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving WHERE status = 'SENT' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from DesignerEditableCalendarInfoSaving order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public DesignerEditableCalendarInfoSaving merge(DesignerEditableCalendarInfoSaving detachedInstance) {
		try {
			DesignerEditableCalendarInfoSaving result = (DesignerEditableCalendarInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DesignerEditableCalendarInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DesignerEditableCalendarInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static DesignerEditableCalendarInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (DesignerEditableCalendarInfoSavingDAOImpl) ctx.getBean("DesignerEditableCalendarInfoSavingDAOImpl");
	}
}