package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistryCashFundsInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistryCashFundsInfoSavingDAO {
	
	public void save(RegistryCashFundsInfoSaving transientInstance);
//	public List registryCashFundsCreateTableCheckInDB(long registrantUserId);
	public List registryCashFundsDataCheckInDB(long registrantUserId);
//	public RegistryCashFundsInfoSaving registryCashFundsUpdateTableInDB(long registrantUserId);
	
	public List registryCashFundsDataCheckUsingFundNameInDB(long registrantUserId, String cashFundName);
	public RegistryCashFundsInfoSaving registryCashFundsUpdateTableUsingFundNameInDB(long registrantUserId, String cashFundName);
	
	
	public List registryCustomCashFundsDataCheckUsingFundNameInDB(long registrantUserId);
	public RegistryCashFundsInfoSaving registryCustomCashFundsUpdateTableUsingFundNameInDB(long registrantUserId);
	public List registryCustomFundsDataCheckUsingFundNameInDB(long registrantUserId, String customFundName);
	public RegistryCashFundsInfoSaving registryCustomFundsUpdateTableUsingFundNameInDB(long registrantUserId, String customFundName);
	public List registryCustomCashFundsNameInDB(long registrantUserId, String customFundName);
	public List registryCustomFundsDataTakeFromDB(long registrantUserId);
	public RegistryCashFundsInfoSaving registryCashFundsEditedDataTakeFromDB(long registrantUserId, long regCustomFundsId);
	public List registryCustomFundsLandingDataCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId);
	public RegistryCashFundsInfoSaving registryCustomFundsLandingUpdateTableInDB(long registrantUserId, long regCustomFundsInfoSavingId);
	
	public RegistryCashFundsInfoSaving registryCashFundsValuesUpdateInDB(long registrantUserId, long regCustomFundsInfoSavingId);
	
	public RegistryCashFundsInfoSaving cashFundsMyAccountDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId);
	
	public List registryCashFundsLandingDataCheckInDB(long registrantUserId, long regCashFundsInfoSavingId);
	public RegistryCashFundsInfoSaving registryCashFundsLandingUpdateTableInDB(long registrantUserId, long regCashFundsInfoSavingId);
	public RegistryCashFundsInfoSaving registryCashFundsDataTakeFromDB(long registrantUserId);
	
	public void delete(RegistryCashFundsInfoSaving persistentInstance);	
	public RegistryCashFundsInfoSaving findById(long id);	
	public List<RegistryCashFundsInfoSaving> findByExample(RegistryCashFundsInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistryCashFundsInfoSaving merge(RegistryCashFundsInfoSaving detachedInstance);	
	public void attachDirty(RegistryCashFundsInfoSaving instance);	
	public void attachClean(RegistryCashFundsInfoSaving instance);

}
