package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AdminRegistryConceptBoardsSaving;

@SuppressWarnings("rawtypes")
public interface AdminRegistryConceptBoardsSavingDAO {
	
	public void save(AdminRegistryConceptBoardsSaving transientInstance);	
	public List selectedConBoardsDataRowIdVerification(long conceptBoardsSavingId);	
	public AdminRegistryConceptBoardsSaving updatedConBoardsImageInDB(long conceptBoardsSavingId);
	public List adminCBFurSpicStatusVerification();
	public AdminRegistryConceptBoardsSaving adminCBFurSpicStatusValueFromDB();
	public List adminConceptBoardsManagementList();
	public List adminConceptBoardsLivingRoomListTakeFromDB();
	public List adminConceptBoardsAllRoomListTakeFromDB(String rommName);	
	public List adminConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName);	
	public List adminConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue);
	public List adminConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue);
	
	public List registrantAdminConceptBoardsAllRoomListTakeFromDB(String rommName);
	public List registrantAdminConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName);
	public List registrantConceptBoardsSelRoomAndStyleListTakeFromDB(long regConceptBoardsSavingId);
	public AdminRegistryConceptBoardsSaving registrantConceptBoardsSelRoomDataTakeFromDB(long regConceptBoardsSavingId);
	public List registrantAdminConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue);
	public List registrantAdminConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue);
	public AdminRegistryConceptBoardsSaving selectedConBoardsImageDisplay(long conceptBoardsSavingId);

//	Adimin Side Designer Registry Coding
	public List designerConceptBoardsLivingRoomListTakeFromDB();
	public List designerConceptBoardsManagementList();
	public AdminRegistryConceptBoardsSaving updatedDesnRegConBoardsImageInDB(long conceptBoardsSavingId);
	public List designerRegCBFurSpicStatusVerification();
	public AdminRegistryConceptBoardsSaving designerRegCBFurSpicStatusValueFromDB();
	public List designerConceptBoardsAllRoomListTakeFromDB(String rommName);
	public List designerConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue);
	public List designerConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName);
	public List designerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue);
	
//	Designer Side Registry Coding
	public List onlyDesignerConceptBoardsLivingRoomListTakeFromDB(long designerUserId);
	public List onlyDesignerConceptBoardsManagementList(long designerUserId);
	public AdminRegistryConceptBoardsSaving updatedOnlyDesnRegConBoardsImageInDB(long conceptBoardsSavingId, long designerUserId);
	public AdminRegistryConceptBoardsSaving updatedAdminAndDesnRegConBoardsImageInDB(long conceptBoardsSavingId, long designerUserId);
	public List onlyDesignerRegCBFurSpicStatusVerification(long designerUserId);
	public AdminRegistryConceptBoardsSaving onlyDesignerRegCBFurSpicStatusValueFromDB(long designerUserId);
	public List onlyDesignerConceptBoardsAllRoomListTakeFromDB(String rommName, long designerUserId);
	public List onlyDesignerConceptBoardsAllRoomsAndPriceListTakeFromDB(String rommName, String priceValue, long designerUserId);
	public List onlyDesignerConceptBoardsAllRoomAndStyleListTakeFromDB(String rommName, long designerUserId);
	public List onlyDesignerConceptBoardsAllRoomStyleAndPriceCombListTakeFromDB(String rommName, String priceValue, long designerUserId);
	
	public List adminConceptBoardsStockCheckListTakeFromDB();
	public List adminCBStockCheckListTakeFromDBUsingRoomName(String roomNameRef);
	
	public void delete(AdminRegistryConceptBoardsSaving persistentInstance);	
	public AdminRegistryConceptBoardsSaving findById(long id);	
	public List<AdminRegistryConceptBoardsSaving> findByExample(AdminRegistryConceptBoardsSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AdminRegistryConceptBoardsSaving merge(AdminRegistryConceptBoardsSaving detachedInstance);	
	public void attachDirty(AdminRegistryConceptBoardsSaving instance);	
	public void attachClean(AdminRegistryConceptBoardsSaving instance);
}
