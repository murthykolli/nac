package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ShopReferralUsersInfoSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings("rawtypes")
public interface ShopReferralUsersInfoSavingDAO {
	
	public void save(ShopReferralUsersInfoSaving transientInstance);
	public List shopReferralUsersInfoCheckingInDB(long referralUsersId);
	public ShopReferralUsersInfoSaving shopReferralUsersInfoTakeFromDB(long referralUsersId);
	public List shopReferralUsersEmailInfoCheckInDB(String referralUserName);
	public ShopReferralUsersInfoSaving shopReferralUsersInfoTakeFromDB(String referralUserName);
	
	public List referralUserInfoCheckingInDB(String referralUserName, Object passwordSalt);
	public ShopReferralUsersInfoSaving referralUserInfoDataTakeFromDB(String referralUserName, Object passwordSalt);
	
	public List adminReferralNewApplicantsDataCheckInDB();
	public List adminReferralCurrentVendorsDataCheckInDB();
	
	public void delete(ShopReferralUsersInfoSaving persistentInstance);	
	public ShopReferralUsersInfoSaving findById(long id);
		
	public List<ShopReferralUsersInfoSaving> findByExample(ShopReferralUsersInfoSaving instance);
	public List findByUserInfoProperty(String regUserName, Object passwordSalt);
	public ShopReferralUsersInfoSaving regiUserInfoDataTakeFromDB(String regUserName, Object passwordSalt);
	public List findByProperty(String propertyName, Object value);
	public List<UserInformation> findByUserName(Object userName);
	public List findAll();	
	public ShopReferralUsersInfoSaving merge(ShopReferralUsersInfoSaving detachedInstance);	
	public void attachDirty(ShopReferralUsersInfoSaving instance);	
	public void attachClean(ShopReferralUsersInfoSaving instance);

}
