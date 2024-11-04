package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.DesignerInfoSaving;

@SuppressWarnings("rawtypes")
public interface DesignerInfoSavingDAO {
	
	public void save(DesignerInfoSaving transientInstance);	
	public List selectedDesnRowIdVerification(long userId);	
	public DesignerInfoSaving updatedDesnRowIdVerification(long designerId);	
	public void delete(DesignerInfoSaving persistentInstance);	
	public DesignerInfoSaving findById(long id);	
	public List<DesignerInfoSaving> findByExample(DesignerInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public DesignerInfoSaving merge(DesignerInfoSaving detachedInstance);	
	public void attachDirty(DesignerInfoSaving instance);	
	public void attachClean(DesignerInfoSaving instance);	
	public List displayDesignerNameInNewClientsUsingStatus();	
	public List selectedDesnRowIdVerificationUsingStatus(long userId);	
	public DesignerInfoSaving designerDataTakeFromDBUsingId(long designerSavingId);
	public List displayDesignerNameAndDateInNewClients();
	public List allDesignersInfoDisplayInRegAdmin();
	public List displayDesignerNameAndDateInNewClientsUsingStatus();	

}
