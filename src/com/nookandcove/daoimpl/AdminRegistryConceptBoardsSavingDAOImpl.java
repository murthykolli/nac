package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminRegistryConceptBoardsSavingDAO;
import com.nookandcove.model.AdminRegistryConceptBoardsSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminRegistryConceptBoardsSavingDAOImpl extends HibernateDaoSupport implements AdminRegistryConceptBoardsSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRegistryConceptBoardsSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AdminRegistryConceptBoardsSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
//	ADMIN SIDE DISPLAY CODE
	
	public List selectedConBoardsDataRowIdVerification(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving updatedConBoardsImageInDB(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List adminCBFurSpicStatusVerification() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving adminCBFurSpicStatusValueFromDB() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsManagementList() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsLivingRoomListTakeFromDB() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = 'Living Room' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsAllRoomListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
//	REGISTRY SIDE DISPLAY CODE
	
	public List registrantAdminConceptBoardsAllRoomListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantAdminConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantConceptBoardsSelRoomAndStyleListTakeFromDB(long regConceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+regConceptBoardsSavingId+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving registrantConceptBoardsSelRoomDataTakeFromDB(long regConceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+regConceptBoardsSavingId+"' and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantAdminConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List registrantAdminConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving selectedConBoardsImageDisplay(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' ";			
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

// 	Admin Designer Side Registry Display Coding

	public List designerConceptBoardsLivingRoomListTakeFromDB() {
		try {
//			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = 'Living Room' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus = 'Approved' ";
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = 'Living Room' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerConceptBoardsManagementList() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving updatedDesnRegConBoardsImageInDB(long conceptBoardsSavingId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRegCBFurSpicStatusVerification() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving designerRegCBFurSpicStatusValueFromDB() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerConceptBoardsAllRoomListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	

//	Designer Side Registry Coding

	public List onlyDesignerConceptBoardsLivingRoomListTakeFromDB(long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = 'Living Room' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List onlyDesignerConceptBoardsManagementList(long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving updatedOnlyDesnRegConBoardsImageInDB(long conceptBoardsSavingId, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving updatedAdminAndDesnRegConBoardsImageInDB(long conceptBoardsSavingId, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminRegistryConceptBoardsSavingId = '"+conceptBoardsSavingId+"' and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is not null ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List onlyDesignerRegCBFurSpicStatusVerification(long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving onlyDesignerRegCBFurSpicStatusValueFromDB(long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE furnitureSpecsStatus is null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";	
			return (AdminRegistryConceptBoardsSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List onlyDesignerConceptBoardsAllRoomListTakeFromDB(String rommName, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List onlyDesignerConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List onlyDesignerConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List onlyDesignerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue, long designerUserId) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE room = '"+rommName+"' and price in ('" + priceValue + "') and furnitureSpecsStatus is not null and adminDesignerCommonReferenceName = 'Designer' and adminDesignerCommonReferenceId = '"+designerUserId+"' and adminApprovalStatus is null ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
		
//Admin Stock Check Data Display
	
	public List adminConceptBoardsStockCheckListTakeFromDB() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminApprovalStatus = 'Approved' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List adminCBStockCheckListTakeFromDBUsingRoomName(String roomNameRef) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving WHERE adminApprovalStatus = 'Approved' and room = '" + roomNameRef + "' order by createdDate DESC nulls last, updatedDate DESC nulls last ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}


	public void delete(AdminRegistryConceptBoardsSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminRegistryConceptBoardsSaving findById(long id) {
		try {
			AdminRegistryConceptBoardsSaving instance = (AdminRegistryConceptBoardsSaving) getHibernateTemplate().get("com.nookandcove.AdminRegistryConceptBoardsSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminRegistryConceptBoardsSaving> findByExample(AdminRegistryConceptBoardsSaving instance) {
		try {
			List<AdminRegistryConceptBoardsSaving> results = (List<AdminRegistryConceptBoardsSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminRegistryConceptBoardsSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminRegistryConceptBoardsSaving merge(AdminRegistryConceptBoardsSaving detachedInstance) {
		try {
			AdminRegistryConceptBoardsSaving result = (AdminRegistryConceptBoardsSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminRegistryConceptBoardsSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminRegistryConceptBoardsSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminRegistryConceptBoardsSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminRegistryConceptBoardsSavingDAOImpl) ctx.getBean("AdminRegistryConceptBoardsSavingDAO");
	}

}

