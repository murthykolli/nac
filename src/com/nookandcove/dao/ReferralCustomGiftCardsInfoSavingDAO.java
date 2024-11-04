package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ReferralCustomGiftCardsInfoSaving;

@SuppressWarnings("rawtypes")
public interface ReferralCustomGiftCardsInfoSavingDAO {
	
	public void save(ReferralCustomGiftCardsInfoSaving transientInstance);	
	public List referralCustomGiftCardInfoVerification(long referralUsersInfoSavingId);	
	public ReferralCustomGiftCardsInfoSaving updatedReferralCustomGiftCardInfoInDataBasa(long referralUsersInfoSavingId);
	public List referralCustomGiftCardCodeCheckInDB(String CustomGiftCardName);
	public ReferralCustomGiftCardsInfoSaving referralCustomGiftCardCodeInfoTakeFromDB(String CustomGiftCardName);
	public void delete(ReferralCustomGiftCardsInfoSaving persistentInstance);	
	public ReferralCustomGiftCardsInfoSaving findById(long id);
	public List<ReferralCustomGiftCardsInfoSaving> findByExample(ReferralCustomGiftCardsInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ReferralCustomGiftCardsInfoSaving merge(ReferralCustomGiftCardsInfoSaving detachedInstance);
	public void attachDirty(ReferralCustomGiftCardsInfoSaving instance);	
	public void attachClean(ReferralCustomGiftCardsInfoSaving instance);	
	
}
