package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ShopUserPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface ShopUserPaymentInfoSavingDAO {
	
	public void save(ShopUserPaymentInfoSaving transientInstance);
	public List shopUserFullNameCheckInDataBase(long shopUserPaymentInfoSavingId);
	public ShopUserPaymentInfoSaving shopUserFullNameTakeFromDataBase(long shopUserPaymentInfoSavingId);
	public List shopUserReferralCouponPaymenListFromDB(String uniqueRefCode);
	
	public void delete(ShopUserPaymentInfoSaving persistentInstance);	
	public ShopUserPaymentInfoSaving findById(long id);	
	public List<ShopUserPaymentInfoSaving> findByExample(ShopUserPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ShopUserPaymentInfoSaving merge(ShopUserPaymentInfoSaving detachedInstance);	
	public void attachDirty(ShopUserPaymentInfoSaving instance);	
	public void attachClean(ShopUserPaymentInfoSaving instance);

}
