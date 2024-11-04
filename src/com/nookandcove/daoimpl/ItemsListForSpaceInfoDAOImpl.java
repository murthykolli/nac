package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ItemsListForSpaceInfoDAO;
import com.nookandcove.model.ItemsListForSpaceInfo;

@SuppressWarnings("rawtypes")
@Repository
public class ItemsListForSpaceInfoDAOImpl extends HibernateDaoSupport implements ItemsListForSpaceInfoDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsListForSpaceInfoDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ItemsListForSpaceInfo transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
		
	public List selectedItemsTakeFromDB(String imageRefferance) {
		try {
			String queryString = "from ItemsListForSpaceInfo WHERE typeOfRefferance = '"+imageRefferance+"' order by createdDate ASC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ItemsListForSpaceInfo selectedSpaceItemsTakeFromDB(String styleName, String inspImgVal) {
		try {
			String queryString = "from ItemsListForSpaceInfo WHERE typeOfRefferance = '"+styleName+"' and typeOfSpace = '"+inspImgVal+"' ";
			return (ItemsListForSpaceInfo) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public void delete(ItemsListForSpaceInfo persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public ItemsListForSpaceInfo findById(long id) {
		try {
			ItemsListForSpaceInfo instance = (ItemsListForSpaceInfo) getHibernateTemplate().get("com.nookandcove.ItemsListForSpaceInfo", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ItemsListForSpaceInfo> findByExample(ItemsListForSpaceInfo instance) {
		try {
			List<ItemsListForSpaceInfo> results = (List<ItemsListForSpaceInfo>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ItemsListForSpaceInfo as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ItemsListForSpaceInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ItemsListForSpaceInfo merge(ItemsListForSpaceInfo detachedInstance) {
		try {
			ItemsListForSpaceInfo result = (ItemsListForSpaceInfo) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ItemsListForSpaceInfo instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ItemsListForSpaceInfo instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ItemsListForSpaceInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ItemsListForSpaceInfoDAOImpl) ctx.getBean("ItemsListForSpaceInfoDAO");
	}

}

