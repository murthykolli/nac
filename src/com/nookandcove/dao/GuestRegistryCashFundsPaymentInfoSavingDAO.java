package com.nookandcove.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nookandcove.model.GuestRegistryCashFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface GuestRegistryCashFundsPaymentInfoSavingDAO {
	
	public void save(GuestRegistryCashFundsPaymentInfoSaving transientInstance);
	public List guestCashFundsPackageRowCheckingInDB(long registrantUserId);
	
	public int updateAllGuestCashFundsInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate);	
	public List guestCashFundsAddToCartInfoRowCheckingInDB(long registrantUserId, long regCashFundsInfoSavingId);
	public GuestRegistryCashFundsPaymentInfoSaving guestCashFundsAddCartDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId);
	public List guestCashFundsAddCartRowCheckingInDB(long registrantUserId);
	
	public List guestCustomFundsAddCartInfoCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId);
	public GuestRegistryCashFundsPaymentInfoSaving guestCustomFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCustomFundsInfoSavingId);
	public List guestCustomFundsAddCartRowCheckingInDB(long registrantUserId);
	
	public List guestCashFundsMyAccountDataCheckingInDB(long registrantUserId);
	public GuestRegistryCashFundsPaymentInfoSaving guestMyAccountInfoUpdateInDB(long registrantUserId, long guestCashFundsPaymentSavingId);
	
	public List adminGuestCashFundsInfoCheckInDB();
	public List adminGuestPendingCashFundsInfoCheckInDB();
	public List adminGuestClearedNotRequestedCashFundsInfoCheckInDB();
	public GuestRegistryCashFundsPaymentInfoSaving adminGuestCashFundColumnUpdateInDataBase(long guestCFPaySavingId);
	public List adminGuestTransferRequestedCashFundsInfoCheckInDB();
	public List adminGuestTransferCompletedCashFundsInfoCheckInDB();
	
	public void delete(GuestRegistryCashFundsPaymentInfoSaving persistentInstance);	
	public GuestRegistryCashFundsPaymentInfoSaving findById(long id);	
	public List<GuestRegistryCashFundsPaymentInfoSaving> findByExample(GuestRegistryCashFundsPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public GuestRegistryCashFundsPaymentInfoSaving merge(GuestRegistryCashFundsPaymentInfoSaving detachedInstance);	
	public void attachDirty(GuestRegistryCashFundsPaymentInfoSaving instance);	
	public void attachClean(GuestRegistryCashFundsPaymentInfoSaving instance);

}
