package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AdminRegistryConceptBoardsFurnitureSpecsSaving;

@SuppressWarnings("rawtypes")
public interface AdminRegistryConceptBoardsFurnitureSpecsSavingDAO {
	
	public void save(AdminRegistryConceptBoardsFurnitureSpecsSaving transientInstance);	
	public List adminRegFurnitureSpecCount(long conceptBoardsSavingId);
	public List adminRegFurnitureSpecEditProductsInDB(long productsId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving deleteConBoardsFurnitureSpecsProductsInDB(long conceptBoardsSavingId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving adminRegFurnitureSpecEditProductsDataTakeFromDB(long productsId);
	
	public List registrantAdminRegFurnitureSpecCount(long conceptBoardsSavingId);
	public List registrantAdminRegStockCheckFurnitureSpecCount(long conceptBoardsSavingId, String typeOfConcept);
	public List registrantAdminRegFurnitureSpecEditProductsInDB(long productsId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving registrantAdminRegFurnitureSpecEditProductsDataTakeFromDB(long productsId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving registrantAdminRegFurnitureSpecGiftReceivedData(long adminCBFurnitureSpecsSavingId);
	
//	Designer Side Registry Coding
	public List designerRegistryFurnitureSpecCount(long conceptBoardsSavingId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving designerDeleteConBoardsFurnitureSpecsProductsInDB(long conceptBoardsSavingId);
	public List designerRegFurnitureSpecEditProductsInDB(long productsId);
	public AdminRegistryConceptBoardsFurnitureSpecsSaving designerRegFurnitureSpecEditProductsDataTakeFromDB(long productsId);
	public List designerRegistryFurnitureSpecApprovalList(long conceptBoardsSavingId);
	
	public List allStockCheckConceptsTotalCount();
	public List allThreeStockCheckConceptsTotalCount(String typeOfConcept);
	
	public void delete(AdminRegistryConceptBoardsFurnitureSpecsSaving persistentInstance);	
	public AdminRegistryConceptBoardsFurnitureSpecsSaving findById(long id);	
	public List<AdminRegistryConceptBoardsFurnitureSpecsSaving> findByExample(AdminRegistryConceptBoardsFurnitureSpecsSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AdminRegistryConceptBoardsFurnitureSpecsSaving merge(AdminRegistryConceptBoardsFurnitureSpecsSaving detachedInstance);	
	public void attachDirty(AdminRegistryConceptBoardsFurnitureSpecsSaving instance);	
	public void attachClean(AdminRegistryConceptBoardsFurnitureSpecsSaving instance);
}
