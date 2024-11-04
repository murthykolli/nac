package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AdminDesignerMessageInfoSaving;

@SuppressWarnings("rawtypes")
	public interface AdminDesignerMessageInfoSavingDAO {
		
	public void save(AdminDesignerMessageInfoSaving transientInstance);		
	public List adminAndDesignerMessageInfoRowVerificationInDB(long designerInfoSavingId);
	public List oneTimeDateFormationCheckingInDB(String oneTimeReffDate);	
	public int adminMessagesStatusUpdateInDesignerSide(long designerInfoSavingId);	
	public List designerMessageCounttoAdminSideInDB(long designerInfoSavingId);	
	public List adminMessageCounttoDesignerSideInDB(long designerInfoSavingId);	
	public void delete(AdminDesignerMessageInfoSaving persistentInstance);	
	public AdminDesignerMessageInfoSaving findById(long id);	
	public List<AdminDesignerMessageInfoSaving> findByExample(AdminDesignerMessageInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AdminDesignerMessageInfoSaving merge(AdminDesignerMessageInfoSaving detachedInstance);	
	public int designerMessagesStatusUpdateInAdminSide(long designerInfoSavingId);	
	public void attachDirty(AdminDesignerMessageInfoSaving instance);	
	public void attachClean(AdminDesignerMessageInfoSaving instance);

}
