package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminRegistryConceptBoardsFurnitureSpecsSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminRegistryConceptBoardsFurnitureSpecsSavingDAOImpl extends HibernateDaoSupport implements AdminRegistryConceptBoardsFurnitureSpecsSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRegistryConceptBoardsFurnitureSpecsSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AdminRegistryConceptBoardsFurnitureSpecsSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
//	ADMIN SIDE DISPLAY CODE
	
	public List adminRegFurnitureSpecCount(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminRegFurnitureSpecEditProductsInDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving deleteConBoardsFurnitureSpecsProductsInDB(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminApprovalStatus = 'Approved' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving adminRegFurnitureSpecEditProductsDataTakeFromDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminApprovalStatus = 'Approved' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

//	REGISTRY SIDE DISPLAY CODE

	public List registrantAdminRegFurnitureSpecCount(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantAdminRegStockCheckFurnitureSpecCount(long conceptBoardsSavingId, String typeOfConcept) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and  adminStockCheckStatus = '"+typeOfConcept+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantAdminRegFurnitureSpecEditProductsInDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminApprovalStatus = 'Approved' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving registrantAdminRegFurnitureSpecGiftReceivedData(long adminCBFurnitureSpecsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+adminCBFurnitureSpecsSavingId+"' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	Designer Side Registry Coding
	
	public List designerRegistryFurnitureSpecCount(long conceptBoardsSavingId) {
		try {
//			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus = 'Approved' ";
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving designerDeleteConBoardsFurnitureSpecsProductsInDB(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRegFurnitureSpecEditProductsInDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminDesignerCommonReferenceName = 'Designer' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving designerRegFurnitureSpecEditProductsDataTakeFromDB(long productsId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsFurnitureSpecsSavingId = '"+productsId+"' and adminDesignerCommonReferenceName = 'Designer' ";	
			return (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRegistryFurnitureSpecApprovalList(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

//	REGISTRY SIDE DISPLAY CODE

	public List allStockCheckConceptsTotalCount() {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List allThreeStockCheckConceptsTotalCount(String typeOfConcept) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving WHERE adminStockCheckStatus = '"+typeOfConcept+"' and adminApprovalStatus = 'Approved' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(AdminRegistryConceptBoardsFurnitureSpecsSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminRegistryConceptBoardsFurnitureSpecsSaving findById(long id) {
		try {
			AdminRegistryConceptBoardsFurnitureSpecsSaving instance = (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().get("com.nookandcove.AdminRegistryConceptBoardsFurnitureSpecsSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminRegistryConceptBoardsFurnitureSpecsSaving> findByExample(AdminRegistryConceptBoardsFurnitureSpecsSaving instance) {
		try {
			List<AdminRegistryConceptBoardsFurnitureSpecsSaving> results = (List<AdminRegistryConceptBoardsFurnitureSpecsSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminRegistryConceptBoardsFurnitureSpecsSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsFurnitureSpecsSaving merge(AdminRegistryConceptBoardsFurnitureSpecsSaving detachedInstance) {
		try {
			AdminRegistryConceptBoardsFurnitureSpecsSaving result = (AdminRegistryConceptBoardsFurnitureSpecsSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminRegistryConceptBoardsFurnitureSpecsSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminRegistryConceptBoardsFurnitureSpecsSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminRegistryConceptBoardsFurnitureSpecsSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminRegistryConceptBoardsFurnitureSpecsSavingDAOImpl) ctx.getBean("AdminRegistryConceptBoardsFurnitureSpecsSavingDAO");
	}

}

