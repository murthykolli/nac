package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ReferralNookAndCoveStoreCreditInfoSaving;

@SuppressWarnings("rawtypes")
public interface ReferralNookAndCoveStoreCreditInfoSavingDAO {
	
	public void save(ReferralNookAndCoveStoreCreditInfoSaving transientInstance);	
	public List selectedReferralRewardClientsInfoVerification(long referralUsersInfoSavingId, long registryUserId);	
	public ReferralNookAndCoveStoreCreditInfoSaving updatedReferralRewardClientsInfoInDataBasa(long referralUsersInfoSavingId, long registryUserId);
	public List selectedReferralRewardNookAndCoveCreditWithId(long referralUsersInfoSavingId);
	public List selectedReferralRewardNookAndCoveCredit();
	public List selectedReferralRewardVisaGiftCard(long referralUsersInfoSavingId);
	public List adminReferralRewardVisaGiftCardsDspl();
	public void delete(ReferralNookAndCoveStoreCreditInfoSaving persistentInstance);	
	public ReferralNookAndCoveStoreCreditInfoSaving findById(long id);
	public List<ReferralNookAndCoveStoreCreditInfoSaving> findByExample(ReferralNookAndCoveStoreCreditInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ReferralNookAndCoveStoreCreditInfoSaving merge(ReferralNookAndCoveStoreCreditInfoSaving detachedInstance);
	public void attachDirty(ReferralNookAndCoveStoreCreditInfoSaving instance);	
	public void attachClean(ReferralNookAndCoveStoreCreditInfoSaving instance);	
	
}
