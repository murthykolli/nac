package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.FurnitureSpecsProductsFullRoomPackSavingDAO;
import com.nookandcove.model.FurnitureSpecsProductsFullRoomPackSaving;

@SuppressWarnings("rawtypes")
@Repository
public class FurnitureSpecsProductsFullRoomPackSavingDAOImpl extends HibernateDaoSupport implements FurnitureSpecsProductsFullRoomPackSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(FurnitureSpecsProductsFullRoomPackSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(FurnitureSpecsProductsFullRoomPackSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}

	public void delete(FurnitureSpecsProductsFullRoomPackSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
		
	public List furnitureSpecsConceptAndRendFRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecsConcept1FRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsConcept1FRRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List furnitureSpecsConcept1FRRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsConcept1FRRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept1 Furniture Specs' ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecsConcept2FRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsConcept2FRRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecsConcept2FRRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsConcept2FRRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and conceptsRenderingsRefferance = 'Concept2 Furniture Specs' ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List furnitureSpecsRoomRenderingFRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs') and (roomRendStatus is null or roomRendStatus = '') order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsRoomRenderingFRRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs') and (roomRendStatus is null or roomRendStatus = '') ";
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List furnitureSpecsRoomRenderingFRRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs') and (roomRendStatus is null or roomRendStatus = '') ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsRoomRenderingFRRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs') and (roomRendStatus is null or roomRendStatus = '') ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public int furnitureSpecsRoomRenderingFRProdRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "UPDATE FurnitureSpecsProductsFullRoomPackSaving set roomRendStatus = 'Delete' WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs') and (roomRendStatus is null or roomRendStatus = '') ";	
			return getHibernateTemplate().bulkUpdate(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List furnitureSpecs2ndRenderingFRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = '2nd Rendering Furniture Specs') and (secRendStatus is null or secRendStatus = '') order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecs2ndRenderingFRRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = '2nd Rendering Furniture Specs') and (secRendStatus is null or secRendStatus = '') ";
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List furnitureSpecs2ndRenderingFRRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = '2nd Rendering Furniture Specs') and (secRendStatus is null or secRendStatus = '') ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecs2ndRenderingFRRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = '2nd Rendering Furniture Specs') and (secRendStatus is null or secRendStatus = '') ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int furnitureSpecs2ndRenderingFRProdRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "UPDATE FurnitureSpecsProductsFullRoomPackSaving set secRendStatus = 'Delete' WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = '2nd Rendering Furniture Specs') and (secRendStatus is null or secRendStatus = '') ";	
			return getHibernateTemplate().bulkUpdate(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List furnitureSpecsRevisedRenderingFRRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs' or conceptsRenderingsRefferance = 'Revised Rendering Furniture Specs') and (revRendStatus is null or revRendStatus = '') order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsRevisedRenderingFRRowDisplayInJSP(long clientInfoSavingId, long designerInfoSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE clientInfoSavingId = '"+clientInfoSavingId+"' and designerInfoSavingId = '"+designerInfoSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs' or conceptsRenderingsRefferance = 'Revised Rendering Furniture Specs') and (revRendStatus is null or revRendStatus = '') ";
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List furnitureSpecsRevisedRenderingFRRowVerUsingIdInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs' or conceptsRenderingsRefferance = 'Revised Rendering Furniture Specs') and (revRendStatus is null or revRendStatus = '') ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving furnitureSpecsRevisedRenderingFRRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs' or conceptsRenderingsRefferance = 'Revised Rendering Furniture Specs') and (revRendStatus is null or revRendStatus = '') ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public int furnitureSpecsRevisedRenderingFRProdRowDeleteFromDB(long furSpecsProdSavingId) {
		try {
			String queryString = "UPDATE FurnitureSpecsProductsFullRoomPackSaving set revRendStatus = 'Delete' WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and (conceptsRenderingsRefferance = 'Concept1 Furniture Specs' or conceptsRenderingsRefferance = 'Concept2 Furniture Specs' or conceptsRenderingsRefferance = 'Room Rendering Furniture Specs' or conceptsRenderingsRefferance = 'Revised Rendering Furniture Specs') and (revRendStatus is null or revRendStatus = '') ";	
			return getHibernateTemplate().bulkUpdate(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List addProductToCartRowVerificationInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving addProductToCartRowUpdateInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminFurnitureSpecsOrderStatusRowVerInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and orderedStatus = 'YES' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminFurnitureSpecsDeliveryStatusRowVerInDB(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' and deliveredStatus = 'YES' ";	
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public FurnitureSpecsProductsFullRoomPackSaving adminPurchasesFullRmProductListDisplay(long furSpecsProdSavingId) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving WHERE furnitureSpecsProductsFullRoomPackSavingId = '"+furSpecsProdSavingId+"' ";	
			return (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int updateAdminFullRmAssignedNewDesignerInfoInDB(long clientInfoSavingId, long designerInfoSavingId) {		
		try {
			String queryString = "UPDATE FurnitureSpecsProductsFullRoomPackSaving set designerInfoSavingId = '"+designerInfoSavingId+"' WHERE clientInfoSavingId = '"+clientInfoSavingId+"' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by FurnitureSpecsProductsFullRoomPackSaving name failed", re);
			throw re;
		}
	}
	
	public FurnitureSpecsProductsFullRoomPackSaving findById(long id) {
		try {
			FurnitureSpecsProductsFullRoomPackSaving instance = (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().get("com.nookandcove.FurnitureSpecsProductsFullRoomPackSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<FurnitureSpecsProductsFullRoomPackSaving> findByExample(FurnitureSpecsProductsFullRoomPackSaving instance) {
		try {
			List<FurnitureSpecsProductsFullRoomPackSaving> results = (List<FurnitureSpecsProductsFullRoomPackSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from FurnitureSpecsProductsFullRoomPackSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public FurnitureSpecsProductsFullRoomPackSaving merge(FurnitureSpecsProductsFullRoomPackSaving detachedInstance) {
		try {
			FurnitureSpecsProductsFullRoomPackSaving result = (FurnitureSpecsProductsFullRoomPackSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FurnitureSpecsProductsFullRoomPackSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FurnitureSpecsProductsFullRoomPackSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static FurnitureSpecsProductsFullRoomPackSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (FurnitureSpecsProductsFullRoomPackSavingDAOImpl) ctx.getBean("FurnitureSpecsProductsFullRoomPackSavingDAOImpl");
	}
}