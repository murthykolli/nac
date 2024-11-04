package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistrantCashFundBankAccountInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistrantCashFundBankAccountInfoSavingDAO {
	
	public void save(RegistrantCashFundBankAccountInfoSaving transientInstance);	
	public List selectedCashFundBackAccountRowIdVerification(long registryUserId);	
	public RegistrantCashFundBankAccountInfoSaving updatedCashFundBackAccountRowInDataBasa(long registryUserId);	
	public void delete(RegistrantCashFundBankAccountInfoSaving persistentInstance);	
	public RegistrantCashFundBankAccountInfoSaving findById(long id);
	public List<RegistrantCashFundBankAccountInfoSaving> findByExample(RegistrantCashFundBankAccountInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistrantCashFundBankAccountInfoSaving merge(RegistrantCashFundBankAccountInfoSaving detachedInstance);
	public void attachDirty(RegistrantCashFundBankAccountInfoSaving instance);	
	public void attachClean(RegistrantCashFundBankAccountInfoSaving instance);	
	
}
