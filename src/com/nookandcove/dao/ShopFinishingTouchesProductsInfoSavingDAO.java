package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ShopFinishingTouchesProductsInfoSaving;

@SuppressWarnings("rawtypes")
public interface ShopFinishingTouchesProductsInfoSavingDAO {
	
	public void save(ShopFinishingTouchesProductsInfoSaving transientInstance);
	public List adminShopFinishingTouchesDataTakeFromDB(String shopProductStatusRef);
	public ShopFinishingTouchesProductsInfoSaving adminShopPlaceOrderDataTakeFromDB(long shopFTProductManagementId);
	
	public void delete(ShopFinishingTouchesProductsInfoSaving persistentInstance);	
	public ShopFinishingTouchesProductsInfoSaving findById(long id);	
	public List<ShopFinishingTouchesProductsInfoSaving> findByExample(ShopFinishingTouchesProductsInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ShopFinishingTouchesProductsInfoSaving merge(ShopFinishingTouchesProductsInfoSaving detachedInstance);	
	public void attachDirty(ShopFinishingTouchesProductsInfoSaving instance);	
	public void attachClean(ShopFinishingTouchesProductsInfoSaving instance);

}
