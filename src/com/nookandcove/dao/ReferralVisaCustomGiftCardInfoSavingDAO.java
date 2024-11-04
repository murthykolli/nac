package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ReferralVisaCustomGiftCardInfoSaving;

@SuppressWarnings("rawtypes")
public interface ReferralVisaCustomGiftCardInfoSavingDAO {
	
	public void save(ReferralVisaCustomGiftCardInfoSaving transientInstance);	
	public List selectedReferralVisaCustomGiftCardsInfoVerification(long referralUsersInfoSavingId);	
	public ReferralVisaCustomGiftCardInfoSaving updatedReferralVisaCustomGiftCardsInfoInDataBasa(long referralUsersInfoSavingId);
	public List selectedReferralVisaCustomGiftCardsInfoDisplay(long referralUsersInfoSavingId);
	public List selectedReferralVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId);
	public ReferralVisaCustomGiftCardInfoSaving referralVisaCustomGiftCardsInfoUpdateinDB(long refVisaCustomGiftCardsSavingId);
	public List adminReferralGiftCardsTotalCountDisplay();
	public List adminReferralVisaCustomGiftCardsInfoDisplay();
	public List adminReferralVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId);
	public List adminIssuedReferralVisaCustomGiftCardsInfoDisplay();
	public List adminReferralIssuedVisaCustomGiftCardsInfoTakeFromDB(long referralUsersInfoSavingId);
	public ReferralVisaCustomGiftCardInfoSaving adminReferralIssuedVisaCustomGiftCardsDateTakeFromDB(long referralUsersInfoSavingId);
	public ReferralVisaCustomGiftCardInfoSaving adminRefIssuedVisaCustomGiftCardsUpdatedInDB(long referralVisaCustomGiftCardsInfoSavingId);
	public void delete(ReferralVisaCustomGiftCardInfoSaving persistentInstance);	
	public ReferralVisaCustomGiftCardInfoSaving findById(long id);
	public List<ReferralVisaCustomGiftCardInfoSaving> findByExample(ReferralVisaCustomGiftCardInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ReferralVisaCustomGiftCardInfoSaving merge(ReferralVisaCustomGiftCardInfoSaving detachedInstance);
	public void attachDirty(ReferralVisaCustomGiftCardInfoSaving instance);	
	public void attachClean(ReferralVisaCustomGiftCardInfoSaving instance);	
	
}
