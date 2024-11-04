package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ShopConceptBoardsProductsInfoSaving;

@SuppressWarnings("rawtypes")
public interface ShopConceptBoardsProductsInfoSavingDAO {
	
	public void save(ShopConceptBoardsProductsInfoSaving transientInstance);
	public List adminShopConceptBoardsDataTakeFromDB(String shopProductStatusRef);
	public ShopConceptBoardsProductsInfoSaving adminShopPlaceOrderDataTakeFromDB(long shopCBProductManagementId);
	
	public void delete(ShopConceptBoardsProductsInfoSaving persistentInstance);	
	public ShopConceptBoardsProductsInfoSaving findById(long id);	
	public List<ShopConceptBoardsProductsInfoSaving> findByExample(ShopConceptBoardsProductsInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ShopConceptBoardsProductsInfoSaving merge(ShopConceptBoardsProductsInfoSaving detachedInstance);	
	public void attachDirty(ShopConceptBoardsProductsInfoSaving instance);	
	public void attachClean(ShopConceptBoardsProductsInfoSaving instance);

}
