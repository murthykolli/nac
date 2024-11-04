package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.GuestUserPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface GuestUserPaymentInfoSavingDAO {
	
	public void save(GuestUserPaymentInfoSaving transientInstance);
	public List guestPaymentRowCheckingInDB(long guestRegUserId);
	public List guestUserFirstNameCheckingInDB(long guestPaymentInfoSavingId);
	public GuestUserPaymentInfoSaving guestUserFirstNameInfoTakingFromDB(long guestPaymentInfoSavingId);
	public List guestRoomAndCashFundsPackageRowCheckingInDB(long guestRegUserId);
	public List adminGuestUserPaymentDataTakeFromDB();
	public GuestUserPaymentInfoSaving guestRegistrantPaymentInfoTakingFromDB(long guestPaymentInfoSavingId);
	public List guestPaymentRowDataTakingFromDB(long guestRegUserId);
	public List guestEmailDataChecking(String guestEmail);
	public GuestUserPaymentInfoSaving guestEmailDataDisplay(String guestEmail);
	public List guestUserPaymentCheckUsingUniqueRefCode(long guestRegUserId);
	public void delete(GuestUserPaymentInfoSaving persistentInstance);	
	public GuestUserPaymentInfoSaving findById(long id);	
	public List<GuestUserPaymentInfoSaving> findByExample(GuestUserPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public GuestUserPaymentInfoSaving merge(GuestUserPaymentInfoSaving detachedInstance);	
	public void attachDirty(GuestUserPaymentInfoSaving instance);	
	public void attachClean(GuestUserPaymentInfoSaving instance);

}
