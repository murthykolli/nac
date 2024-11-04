package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ClientUploadedInspireImagesSaving;

@SuppressWarnings("rawtypes")
public interface ClientUploadedInspireImagesSavingDAO {
	
	public void save(ClientUploadedInspireImagesSaving transientInstance);	
	public List selectedDesnRowIdVerification(long userId);	
	public ClientUploadedInspireImagesSaving updatedDesnRowIdVerification(long userId);	
	public List clientUploadedInspireImagesRowIdVerification(long userId, long clientInfoSavingId);
	public List adminSideClientUploadedInspireImagesRowIdVerification(long clientInfoSavingId);
	public ClientUploadedInspireImagesSaving deleteUploadedImagesSelectedRowInDB(long userId, long uploadImgId);	
	public void delete(ClientUploadedInspireImagesSaving persistentInstance);	
	public ClientUploadedInspireImagesSaving findById(long id);	
	public List<ClientUploadedInspireImagesSaving> findByExample(ClientUploadedInspireImagesSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ClientUploadedInspireImagesSaving merge(ClientUploadedInspireImagesSaving detachedInstance);	
	public void attachDirty(ClientUploadedInspireImagesSaving instance);	
	public void attachClean(ClientUploadedInspireImagesSaving instance);	
	public ClientUploadedInspireImagesSaving clientUploadedInspireImagesTakeFromDB(long userId, long clientInfoSavingId);

}
