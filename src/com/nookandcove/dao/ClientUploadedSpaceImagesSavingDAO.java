package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ClientUploadedSpaceImagesSaving;

@SuppressWarnings("rawtypes")
public interface ClientUploadedSpaceImagesSavingDAO {
	
	public void save(ClientUploadedSpaceImagesSaving transientInstance);	
	public List clientUploadedSpaceImagesRowIdVerification(long userId, long clientInfoSavingId);
	public List adminSideClientUploadedSpaceImagesRowIdVerification(long clientInfoSavingId);
	public ClientUploadedSpaceImagesSaving clientUploadedSpaceImagesTakeFromDB(long userId, long clientInfoSavingId);	
	public void delete(ClientUploadedSpaceImagesSaving persistentInstance);	
	public ClientUploadedSpaceImagesSaving findById(long id);	
	public List<ClientUploadedSpaceImagesSaving> findByExample(ClientUploadedSpaceImagesSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ClientUploadedSpaceImagesSaving merge(ClientUploadedSpaceImagesSaving detachedInstance);	
	public void attachDirty(ClientUploadedSpaceImagesSaving instance);	
	public void attachClean(ClientUploadedSpaceImagesSaving instance);	
	public ClientUploadedSpaceImagesSaving deleteUploadedImagesSelectedRowInDB(long userId, long uploadImgId);
}
