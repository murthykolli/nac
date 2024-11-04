package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.FurnitureSpecsProductsAccPackSavingDAO;
import com.nookandcove.model.FurnitureSpecsProductsAccPackSaving;

@SuppressWarnings("rawtypes")
@Repository
public class FurnitureSpecsProductsAccPackSavingDAOImpl extends HibernateDaoSupport implements FurnitureSpecsProductsAccPackSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(FurnitureSpecsProductsAccPackSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(FurnitureSpecsProductsAccPackSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FurnitureSpecsProductsAccPackSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecsConcept1AccPackRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsAccPackSaving furnitureSpecsConcept1AccPackRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List furnitureSpecsConcept1AccPackRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsAccPackSaving furnitureSpecsConcept1AccPackRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";	
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecsConcept2AccPackRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsAccPackSaving furnitureSpecsConcept2AccPackRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List furnitureSpecsConcept2AccPackRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsAccPackSaving furnitureSpecsConcept2AccPackRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";	
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List furnitureSpecsFinalConceptAccPackRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Final Concept Furniture Specs') order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsAccPackSaving furnitureSpecsFinalConceptAccPackRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Final Concept Furniture Specs') ";
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List furnitureSpecsFinalConceptAccPackRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Final Concept Furniture Specs') and (finalConStatus is null or finalConStatus = '') ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsAccPackSaving furnitureSpecsFinalConceptAccPackRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Final Concept Furniture Specs') and (finalConStatus is null or finalConStatus = '') ";	
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public int furnitureSpecsFinalConceptAccPackProdRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "UPDATE FurnitureSpecsProductsAccPackSaving set finalConStatus = 'Delete' WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Final Concept Furniture Specs') and (finalConStatus is null or finalConStatus = '') ";
			return getHibernateTemplate().bulkUpdate(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List addProductToCartRowVerificationInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsAccPackSaving addProductToCartRowUpdateInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminFurnitureSpecsAccOrderStatusRowVerInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and orderedStatus = 'YES' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminFurnitureSpecsAccDeliveryStatusRowVerInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' and deliveredStatus = 'YES' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsAccPackSaving adminPurchasesAccPackProductListDisplay(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving WHERE furnitureSpecsProductsAccPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int updateAdminAccAssignedNewDesignerInfoInDB(long clientInfoSavingId, long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE FurnitureSpecsProductsAccPackSaving set designerInfoSavingId = '"+designerInfoSavingId+"' WHERE clientInfoSavingId = '"+clientInfoSavingId+"' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by FurnitureSpecsProductsAccPackSaving name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsAccPackSaving findById(long id) {
		try {
			FurnitureSpecsProductsAccPackSaving instance = (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().get("com.nookandcove.FurnitureSpecsProductsAccPackSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FurnitureSpecsProductsAccPackSaving> findByExample(FurnitureSpecsProductsAccPackSaving instance) {
		try {
			List<FurnitureSpecsProductsAccPackSaving> results = (List<FurnitureSpecsProductsAccPackSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from FurnitureSpecsProductsAccPackSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsAccPackSaving merge(FurnitureSpecsProductsAccPackSaving detachedInstance) {
		try {
			FurnitureSpecsProductsAccPackSaving result = (FurnitureSpecsProductsAccPackSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FurnitureSpecsProductsAccPackSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FurnitureSpecsProductsAccPackSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FurnitureSpecsProductsAccPackSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FurnitureSpecsProductsAccPackSavingDAOImpl) ctx.getBean("FurnitureSpecsProductsAccPackSavingDAOImpl");
	}
}