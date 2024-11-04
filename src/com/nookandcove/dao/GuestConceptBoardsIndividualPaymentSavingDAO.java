package com.nookandcove.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nookandcove.model.GuestConceptBoardsIndividualPaymentSaving;

@SuppressWarnings("rawtypes")
public interface GuestConceptBoardsIndividualPaymentSavingDAO {
	
	public void save(GuestConceptBoardsIndividualPaymentSaving transientInstance);
	
	public List registryConceptBoardsIndividualPriceCheckInDB(long registrantUserId, long cbIndividualProductSavingId);
	public GuestConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPriceTakeFromDB(long registrantUserId, long cbIndividualProductSavingId);
	public List registryConceptBoardsIndividualPaymentStatusCheckInDB(long registrantUserId, long cbIndividualProductSavingId);
	public GuestConceptBoardsIndividualPaymentSaving registryConceptBoardsIndividualPaymentStatusTakeFromDB(long registrantUserId, long cbIndividualProductSavingId);
	public List registryConceptBoardsIndividualTotalCartCount(long registrantUserId);
	public GuestConceptBoardsIndividualPaymentSaving regConceptBoardsIndividualCartCountFromDB(long registrantUserId);
	public List registryCBIndividualAddCartPaymentDataCheckInDB(long registrantUserId, long regCBIndividualPaymentSavingId);
	public GuestConceptBoardsIndividualPaymentSaving registryCBIndividualAddCartPaymentDataTakeFromDB(long registrantUserId, long regCBIndividualPaymentSavingId);
	public int regConceptBoardsIndividualPaymentInfoUpdateInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate);
	public List regConceptBoardsIndividualMyAccountDataDisplay(long registrantUserId);
	public List guestStoreCreditCBIndividualRemoveDuplicateRows(long registrantUserId);
	public List guestStoreCreditCBIndividualAmountCheckingInDB(long registrantUserId, long regSelectedProdsId);
	
	public List guestCBMyAccountIndividualPaymentDataCheckInDB(long registrantUserId, long cbIndividualPaymentSavingId);
	public GuestConceptBoardsIndividualPaymentSaving guestCBMyAccountIndividualPaymentDataTakeFromDB(long registrantUserId, long cbIndividualPaymentSavingId);
	
	public List guestAdminCBIndividualGiftReceivedDataTakeFromDB(String individualStatusRef);
	public GuestConceptBoardsIndividualPaymentSaving guestCBGiftReceivedIndividualPaymentDataTakeFromDB(long cbIndividualPaymentSavingId);
	
	public List guestAdminCBIndividualNoActionGiftReceivedData();
	public List guestAdminCBIndividualConvertedToCreditGiftReceivedData();
	
	public void delete(GuestConceptBoardsIndividualPaymentSaving persistentInstance);	
	public GuestConceptBoardsIndividualPaymentSaving findById(long id);	
	public List<GuestConceptBoardsIndividualPaymentSaving> findByExample(GuestConceptBoardsIndividualPaymentSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public GuestConceptBoardsIndividualPaymentSaving merge(GuestConceptBoardsIndividualPaymentSaving detachedInstance);	
	public void attachDirty(GuestConceptBoardsIndividualPaymentSaving instance);	
	public void attachClean(GuestConceptBoardsIndividualPaymentSaving instance);
}
