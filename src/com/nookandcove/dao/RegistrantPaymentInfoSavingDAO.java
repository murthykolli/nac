package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistrantPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistrantPaymentInfoSavingDAO {
	
	public void save(RegistrantPaymentInfoSaving transientInstance);
	public RegistrantPaymentInfoSaving registrantUserPaymentRowDataTakingFromDB(long registrantUserId);
	public List registrantUserPaymentRowCheckingInDB(long registrantUserId);	
	public List adminRegistryUserPaymentDataTakeFromDB();
	public RegistrantPaymentInfoSaving adminRegistrantPaymentInfoTakingFromDB(long regiPaymentInfoSavingId);
	public RegistrantPaymentInfoSaving registryTransactionNumberTakeFromDB(long registrantUserId, long regiPaymentInfoSavingId);
	public List registrantMyAccountStoredCreditGiftedPrice(long registrantUserId, String giftCardCode);
	public List registrantMyAccountSCGPriceUsingCodeReff(long registrantUserId, long regPaymentInfoSavingId);
	public RegistrantPaymentInfoSaving registrantMyAccountSCGPriceValueUsingCodeReff(long registrantUserId, long regPaymentInfoSavingId);
	public List registrantUserPaymentCheckUsingUniqueRefCode(long registrantUserId);
	public void delete(RegistrantPaymentInfoSaving persistentInstance);	
	public RegistrantPaymentInfoSaving findById(long id);	
	public List<RegistrantPaymentInfoSaving> findByExample(RegistrantPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistrantPaymentInfoSaving merge(RegistrantPaymentInfoSaving detachedInstance);	
	public void attachDirty(RegistrantPaymentInfoSaving instance);	
	public void attachClean(RegistrantPaymentInfoSaving instance);

}
