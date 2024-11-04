package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.GuestRoomFundPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface GuestRoomFundPaymentInfoSavingDAO {
	
	public void save(GuestRoomFundPaymentInfoSaving transientInstance);
	public List guestPaymentRowCheckingInDB(long guestRegUserId);
	public List guestOnlyRoomsPaymentRowCheckingInDB(long guestRegUserId);
	public List guestOnlyCashFundsPaymentRowCheckingInDB(long guestRegUserId);
	public List guestRoomAndCashFundsPackageRowCheckingInDB(long guestRegUserId);
	public List guestRoomAndCashFundsPackageInfoRowCheckingInDB(long guestRegUserId);
	public List adminGuestUserPaymentDataTakeFromDB();
	public GuestRoomFundPaymentInfoSaving guestRegistrantPaymentInfoTakingFromDB(long guestPaymentInfoSavingId);
	public List guestPaymentRowDataTakingFromDB(long guestRegUserId);
	public List guestEmailDataChecking(String guestEmail);
	public GuestRoomFundPaymentInfoSaving guestEmailDataDisplay(String guestEmail);
	
	public List adminGuestOnlyCashFundsPaymentRowCheckingInDB();
	
	public void delete(GuestRoomFundPaymentInfoSaving persistentInstance);	
	public GuestRoomFundPaymentInfoSaving findById(long id);	
	public List<GuestRoomFundPaymentInfoSaving> findByExample(GuestRoomFundPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public GuestRoomFundPaymentInfoSaving merge(GuestRoomFundPaymentInfoSaving detachedInstance);	
	public void attachDirty(GuestRoomFundPaymentInfoSaving instance);	
	public void attachClean(GuestRoomFundPaymentInfoSaving instance);

}
