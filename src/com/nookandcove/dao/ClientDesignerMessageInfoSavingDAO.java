package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ClientDesignerMessageInfoSaving;

@SuppressWarnings("rawtypes")
public interface ClientDesignerMessageInfoSavingDAO {
	
	public void save(ClientDesignerMessageInfoSaving transientInstance);
	public List oneTimeDateFormationCheckingInDB(String oneTimeReffDate);	
	public List clientAndDesignerMessageInfoRowVerificationInDB(long clientInfoSavingId, long designerInfoSavingId);	
	public void delete(ClientDesignerMessageInfoSaving persistentInstance);	
	public ClientDesignerMessageInfoSaving findById(long id);	
	public List<ClientDesignerMessageInfoSaving> findByExample(ClientDesignerMessageInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ClientDesignerMessageInfoSaving merge(ClientDesignerMessageInfoSaving detachedInstance);	
	public List clientMessageInfoCountInDesigner(long clientInfoSavingId, long designerInfoSavingId);	
	public void attachDirty(ClientDesignerMessageInfoSaving instance);	
	public void attachClean(ClientDesignerMessageInfoSaving instance);	
	public int clientMessagesStatusUpdateInDesignerSide(long clientInfoSavingId, long designerInfoSavingId);	
	public List designerMessageInfoCountInClientSide(long clientInfoSavingId, long designerInfoSavingId);	
	public int designerMessagesStatusUpdateInClientSide(long clientInfoSavingId, long designerInfoSavingId);

}
