package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ShoppingCartPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface ShoppingCartPaymentInfoSavingDAO {
	
	public void save(ShoppingCartPaymentInfoSaving transientInstance);	
	public List selectedShoppingCartRowVerification(long userId);	
	public ShoppingCartPaymentInfoSaving updatedShoppingCartPaymentRowInDB(long userId);
	public List adminPurchasesInfoRowVerification();
	public List adminPurchasedArchiveInfoDisplay();
	public ShoppingCartPaymentInfoSaving purchaseClientShippingDataTakeFromDB(long shopCartPaymentRef);
	public ShoppingCartPaymentInfoSaving archivePurchaseClientShippingData(long shopCartPaymentRef);
	public void delete(ShoppingCartPaymentInfoSaving persistentInstance);	
	public ShoppingCartPaymentInfoSaving findById(long id);	
	public List<ShoppingCartPaymentInfoSaving> findByExample(ShoppingCartPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ShoppingCartPaymentInfoSaving merge(ShoppingCartPaymentInfoSaving detachedInstance);	
	public void attachDirty(ShoppingCartPaymentInfoSaving instance);	
	public void attachClean(ShoppingCartPaymentInfoSaving instance);
	public List allShoppingCartInfoDailyReports(String todayDate);
	public List allShoppingCartInfoTotalReports(String referenceDate, String todayDate);

}
