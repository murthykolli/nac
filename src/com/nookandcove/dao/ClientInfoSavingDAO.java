package com.nookandcove.dao;

import java.util.List;
import com.nookandcove.model.ClientInfoSaving;

@SuppressWarnings("rawtypes")
public interface ClientInfoSavingDAO {
	
	public void save(ClientInfoSaving transientInstance);	
	public List selectedRowIdVerification(long userId);		
	public ClientInfoSaving updatedRowIdVerification(long userId);	
	public List rowIdSelectionUsingRoomName(long userId, String roomName);	
	public ClientInfoSaving rowIdUpdationUsingRoomName(long userId, String roomName);	
	public List rowIdSelectionUsingClientInfoID(long userId, long clientInfoId);	
	public ClientInfoSaving rowIdUpdationUsingClientInfoID(long userId, long clientInfoId);	
	public List clientManagementRowCheckingInDB(long userId);
	public void delete(ClientInfoSaving persistentInstance);
	public ClientInfoSaving findById(long id);
	public List<ClientInfoSaving> findByExample(ClientInfoSaving instance);
	public List findByProperty(String propertyName, Object value);	
	public List clientInfoDisplyInAdminNewCleintsUsingStatus();
	public List findAll();
	public ClientInfoSaving merge(ClientInfoSaving detachedInstance);
	public void attachDirty(ClientInfoSaving instance);
	public void attachClean(ClientInfoSaving instance);	
	public ClientInfoSaving viewClientInfoDataDisplay(long myRoomInfoId);	
	public List displayClientDataUsingDesignerID(long designerSavingId);
	public List displayOnlyDesignersClientsData(long designerSavingId);
	public List displayClientArchiveDataUsingDesignerID(long designerSavingId);
	public List adminAssignClientInfoToDesignerUsingIdStatus();	
	public List clientDirectoryRowChecking(long myRoomInfoId);	
	public ClientInfoSaving clientDirectoryValuesUpdationByAdmin(long myRoomInfoId);	
	public ClientInfoSaving viewClientInfoDisplayForDesigner(long clientInfoId, long designerInfoId);	
	public List checkDesignerDirectoryForClientsUsingDesignerID(long designerSavingId);
	public ClientInfoSaving userIdTakeFromTableUsingClId(long clientInfoId);
	public ClientInfoSaving viewClientInfoDisplayForAdminSide(long clientInfoId, long designerInfoId);
	public List designerArchiveClientRowCheck(long clientInfoId, long designerInfoId);
	public ClientInfoSaving designerArchiveClientsStatusCheck(long clientInfoId, long designerInfoId);
	
}