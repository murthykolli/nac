package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AddClientProductsToCartSaving;

@SuppressWarnings("rawtypes")
public interface AddClientProductsToCartSavingDAO {
	
	public void save(AddClientProductsToCartSaving transientInstance);	
	public List selectedDesnRowIdVerification(long userId);	
	public AddClientProductsToCartSaving updatedDesnRowIdVerification(long userId);	
	public void delete(AddClientProductsToCartSaving persistentInstance);	
	public AddClientProductsToCartSaving findById(long id);
	public List selectedClientProductFromCart(long userId, long clProdSavingId, String packageType);
	public List AdminOrderStatusValueCheckingInDB(long userId, long shopingCartSavingId);
	public AddClientProductsToCartSaving updateClientProductToCart(long userId, long productSavingId, String packageType);	
	public List<AddClientProductsToCartSaving> findByExample(AddClientProductsToCartSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AddClientProductsToCartSaving merge(AddClientProductsToCartSaving detachedInstance);
	public int allClientProductsUploadedToCartInDB(long userId,long shoCartPaySavingId);
	public void attachDirty(AddClientProductsToCartSaving instance);	
	public void attachClean(AddClientProductsToCartSaving instance);	
	public List selectedPaymentCartItemsListTakeFromDB(long userId);
	public AddClientProductsToCartSaving selectedPaymentCartItemsListUpdateInDB(long userId);
	public int updateAllPaimentCartItemsInDB(long userId, long shopingCartPayId, String returnVal);
	public AddClientProductsToCartSaving deletedSelectedProductsFromCartDB(long productSavingId);
	public AddClientProductsToCartSaving updatedSelectedProductsFromCartDB(long productSavingId);
	public List totalAddCartItemsListDisplay(long userId);
	public List purchasesPaymentCartItemsListTakeFromDB();

}
