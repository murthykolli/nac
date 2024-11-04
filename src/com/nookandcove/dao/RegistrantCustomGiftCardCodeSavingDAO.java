package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistrantCustomGiftCardCodeSaving;

@SuppressWarnings("rawtypes")
public interface RegistrantCustomGiftCardCodeSavingDAO {
	
	public void save(RegistrantCustomGiftCardCodeSaving transientInstance);	
	public List selectedGiftCardCodeRowIdVerification(long registryUserId);	
	public RegistrantCustomGiftCardCodeSaving updatedGiftCardCodeRowInDataBasa(long registryUserId);
	public List registrantGiftCardCodeValuesChecking(long registryUserId, String giftCuponCode);
	public RegistrantCustomGiftCardCodeSaving registrantGiftCardCodeValuesTakeFromDB(long registryUserId, String giftCuponCode);
	public void delete(RegistrantCustomGiftCardCodeSaving persistentInstance);	
	public RegistrantCustomGiftCardCodeSaving findById(long id);
	public List<RegistrantCustomGiftCardCodeSaving> findByExample(RegistrantCustomGiftCardCodeSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistrantCustomGiftCardCodeSaving merge(RegistrantCustomGiftCardCodeSaving detachedInstance);
	public void attachDirty(RegistrantCustomGiftCardCodeSaving instance);	
	public void attachClean(RegistrantCustomGiftCardCodeSaving instance);	
	
}
