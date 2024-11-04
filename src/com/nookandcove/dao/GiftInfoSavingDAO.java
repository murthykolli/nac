package com.nookandcove.dao;

import java.util.List;
import com.nookandcove.model.GiftInfoSaving;

@SuppressWarnings("rawtypes")
public interface GiftInfoSavingDAO {
	
	public void save(GiftInfoSaving transientInstance);
	public void delete(GiftInfoSaving persistentInstance);	
	public List selectedGiftCardInfoDataChecking(long giftCardInfoId);	
	public GiftInfoSaving viewGiftCardInfoDataDisplay(long giftCardInfoId);
	public List selectedGiftCardUsedVerification(String couponCode);
	public GiftInfoSaving selectedGiftCardUsedStatusUpdateInDB(String couponCode);
	public List giftCardVerificationInDB(String couponCode);
	public GiftInfoSaving giftCardUsedStatusUpdateInDB(String couponCode);
	public List allGiftCardInfoDailyReports(String todayDate);
	public List allGiftCardInfoTotalReports(String referenceDate, String todayDate);
	public GiftInfoSaving findById(long id);
	public List<GiftInfoSaving> findByExample(GiftInfoSaving instance);
	public List findByProperty(String propertyName, Object value);
	public List newGiftCardsDataTakeFromDB();
	public List sentGiftCardsDataTakeFromDB();
	public List adminCreatedGiftCardsDataTakeFromDB();
	public List findAll();
	public GiftInfoSaving merge(GiftInfoSaving detachedInstance);
	public void attachDirty(GiftInfoSaving instance);
	public void attachClean(GiftInfoSaving instance);
	
}
