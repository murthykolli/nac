package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AdminAssignClientInfoToDesignerSaving;

@SuppressWarnings("rawtypes")
public interface AdminAssignClientInfoToDesignerSavingDAO {
	
	public void save(AdminAssignClientInfoToDesignerSaving transientInstance);	
	public List selectedDesnRowIdVerification(long userId);	
	public List checkUpdatedStatusInDB(long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving updatedDesnRowIdVerification(long userId);	
	public void delete(AdminAssignClientInfoToDesignerSaving persistentInstance);	
	public AdminAssignClientInfoToDesignerSaving findById(long id);	
	public List<AdminAssignClientInfoToDesignerSaving> findByExample(AdminAssignClientInfoToDesignerSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AdminAssignClientInfoToDesignerSaving merge(AdminAssignClientInfoToDesignerSaving detachedInstance);	
	public void attachDirty(AdminAssignClientInfoToDesignerSaving instance);	
	public void attachClean(AdminAssignClientInfoToDesignerSaving instance);	
	public List clientCheckListVerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving adminAssignedNewDesignerInfoUpdateInClient(long clientInfoId);
	public AdminAssignClientInfoToDesignerSaving clientCheckListUpdationInDB(long clientInfoId, long designerInfoId);	
	public List designerConcept1VerificationInDB(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designerConcept1UpdationInDB(long clientInfoId, long designerInfoId);	
	public List designerConcept2VerificationInDB(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designerConcept2UpdationInDB(long clientInfoId, long designerInfoId);	
	public List designer3DRenderingVerificationInDB(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designer3DRenderingUpdationInDB(long clientInfoId, long designerInfoId);	
	public List designerConcept1VerificationInClientSide(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designerConcept1UpdationInClientSide(long clientInfoId, long designerInfoId);	
	public List designerConcept2VerificationInClientSide(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designerConcept2UpdationInClientSide(long clientInfoId, long designerInfoId);	
	public List designer3DRenderingVerificationInClientSide(long clientInfoId, long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving designer3DRenderingUpdationInClientSide(long clientInfoId, long designerInfoId);	
	public List checkClientsInfoUsingDesignerIdInDB(long designerInfoId);	
	public AdminAssignClientInfoToDesignerSaving updateClientsInfoUsingDesignerIdInDB(long designerInfoId);
	public List firstRenderingRedirectionCheck(long clientInfoId, long designerInfoId);
	public List secondRenderingRedirectionCheck(long clientInfoId, long designerInfoId);
	public List designerRendering1VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRendering1UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List designerRendering2VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRendering2UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List designerSecondRendering1VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering1UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List designerSecondRendering2VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering2UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List secondRenderingPaymentCheckingForClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving secondRenderingPaymentForClientSide(long clientInfoId, long designerInfoId);
	public List designerRoomRendering1VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRoomRendering1UpdationInDB(long clientInfoId, long designerInfoId);
	public List designerRoomRendering2VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRoomRendering2UpdationInDB(long clientInfoId, long designerInfoId);
	public List designerRevisedRendering1VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering1UpdationInDB(long clientInfoId, long designerInfoId);
	public List designerRevisedRendering2VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering2UpdationInDB(long clientInfoId, long designerInfoId);
	public List designerSecondRendering1VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering1UpdationInDB(long clientInfoId, long designerInfoId);
	public List designerSecondRendering2VerificationInDB(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering2UpdationInDB(long clientInfoId, long designerInfoId);
	
	public List designerRevisedRendering1VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering1UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List designerRevisedRendering2VerificationInClientSide(long clientInfoId, long designerInfoId);
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering2UpdationInClientSide(long clientInfoId, long designerInfoId);
	public List checkDesignerUpdatedStatusInDB(long designerInfoId);
	

}
