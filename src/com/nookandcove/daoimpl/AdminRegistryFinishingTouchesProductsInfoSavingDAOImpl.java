package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminRegistryFinishingTouchesProductsInfoSavingDAO;
import com.nookandcove.model.AdminRegistryFinishingTouchesProductsInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminRegistryFinishingTouchesProductsInfoSavingDAOImpl extends HibernateDaoSupport implements AdminRegistryFinishingTouchesProductsInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRegistryFinishingTouchesProductsInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AdminRegistryFinishingTouchesProductsInfoSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public List adminRegFinishingTouchesSelectedProductsListFromDB(String regFTSelectedCategory) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE productCategory = '"+regFTSelectedCategory+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	ADMIN SIDE DISPLAY CODE
	
	public List adminRegFinishingTouchesCategoriesProductsTakeFromDB() {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";		
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminRegFurnitureSpecEditProductsInDB() {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminSelectedCheckBoxFinishingTouchesListFromDB(String prodCategory) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE productCategory in ('" + prodCategory + "') and adminApprovalStatus = 'Approved' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminRegFinishingTouchesEditProductsInDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryFinishingTouchesProductsInfoSaving adminRegFinishingTouchesEditProductsDataTakeFromDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminApprovalStatus = 'Approved' ";	
			return (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryFinishingTouchesProductsInfoSaving adminShopRegFinishingTouchesProductsDataTakeFromDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' ";	
			return (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	REGISTRY SIDE DISPLAY CODE

	public List registrantAdminRegFurnitureSpecEditProductsInDB() {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List registrantAdminSelectedCheckBoxFinishingTouchesListFromDB(String prodCategory) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE productCategory in ('" + prodCategory + "') and adminApprovalStatus = 'Approved' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List registrantAdminRegFinishingTouchesEditProductsInDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryFinishingTouchesProductsInfoSaving registrantAdminRegFinishingTouchesEditProductsDataTakeFromDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminApprovalStatus = 'Approved' ";	
			return (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

//	DESIGNER SIDE DISPLAY CODE
	
	public List designerRegFTFurnitureSpecEditProductsInDB() {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminDesignerCommonReferenceName = 'Designer' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRegFinishingTouchesEditProductsInDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminDesignerCommonReferenceName = 'Designer' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryFinishingTouchesProductsInfoSaving designerRegFinishingTouchesEditProductsDataTakeFromDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminDesignerCommonReferenceName = 'Designer' ";	
			return (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerSelectedCheckBoxFinishingTouchesListFromDB(String prodCategory) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE productCategory in ('" + prodCategory + "') and adminDesignerCommonReferenceName = 'Designer' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRegFinishingTouchesApprovalStatusInDB(long adminRegFinishingTouchesSavingId) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving WHERE adminRegistryFinishingTouchesProductsInfoSavingId = '"+adminRegFinishingTouchesSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public void delete(AdminRegistryFinishingTouchesProductsInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminRegistryFinishingTouchesProductsInfoSaving findById(long id) {
		try {
			AdminRegistryFinishingTouchesProductsInfoSaving instance = (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().get("com.nookandcove.AdminRegistryFinishingTouchesProductsInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminRegistryFinishingTouchesProductsInfoSaving> findByExample(AdminRegistryFinishingTouchesProductsInfoSaving instance) {
		try {
			List<AdminRegistryFinishingTouchesProductsInfoSaving> results = (List<AdminRegistryFinishingTouchesProductsInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminRegistryFinishingTouchesProductsInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminRegistryFinishingTouchesProductsInfoSaving merge(AdminRegistryFinishingTouchesProductsInfoSaving detachedInstance) {
		try {
			AdminRegistryFinishingTouchesProductsInfoSaving result = (AdminRegistryFinishingTouchesProductsInfoSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminRegistryFinishingTouchesProductsInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminRegistryFinishingTouchesProductsInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminRegistryFinishingTouchesProductsInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminRegistryFinishingTouchesProductsInfoSavingDAOImpl) ctx.getBean("AdminRegistryFinishingTouchesProductsInfoSavingDAO");
	}

}

