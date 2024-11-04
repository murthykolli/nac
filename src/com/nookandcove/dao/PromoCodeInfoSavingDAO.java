package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.PromoCodeInfoSaving;

@SuppressWarnings("rawtypes")
public interface PromoCodeInfoSavingDAO {
	
	public void save(PromoCodeInfoSaving transientInstance);	
	public List selectedPromocodeVerification();
	public List promocodeDataListFromDB(long promoCodeId);
	public PromoCodeInfoSaving promocodeSelectedDataListFromDB(long promoCodeId);
	public List selectedPromoCodeChecking(String promoCode);
	public PromoCodeInfoSaving selectedPromoCodeUpdateInDB(String promoCode);
	public PromoCodeInfoSaving updatedPromoCodeInDB();
	public List selectedPromoCodeCheckingNotUsed(String promoCode);
	public PromoCodeInfoSaving selectedPromoCodeUpdateInDBNotUsed(String promoCode);
	public void delete(PromoCodeInfoSaving persistentInstance);	
	public PromoCodeInfoSaving findById(long id);	
	public List<PromoCodeInfoSaving> findByExample(PromoCodeInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public PromoCodeInfoSaving merge(PromoCodeInfoSaving detachedInstance);	
	public void attachDirty(PromoCodeInfoSaving instance);	
	public void attachClean(PromoCodeInfoSaving instance);

}
