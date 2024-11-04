package com.nookandcove.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nookandcove.model.RegistryCashFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistryCashFundsPaymentInfoSavingDAO {
	
	public void save(RegistryCashFundsPaymentInfoSaving transientInstance);
//	public List registryCashFundsInfoRowCheckingInDB(long registrantUserId);
	public List registryCashFundsAddCartRowCheckingInDB(long registrantUserId);
	public List registryCashFundsAddCartInfoCheckInDB(long registrantUserId, long regCashFundsInfoSavingId);
	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCashFundsInfoSavingId);
	public List registryCashFundsAddToCartInfoRowCheckingInDB(long registrantUserId, long regCashFundsInfoSavingId);
	public List registryCashFundsPaymentInfoCheckingInDB(long registrantUserId, long cashFundsPaymentSavingId);
	public RegistryCashFundsPaymentInfoSaving registryCashFundsPaymentInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId);
	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartInfoTakeFromDB(long registrantUserId);
	public RegistryCashFundsPaymentInfoSaving registryCashFundsAddCartDataTakeFromDB(long registrantUserId, long regCashFundsInfoSavingId);
	public List registryCashFundsPackageRowCheckingInDB(long registrantUserId);
	public RegistryCashFundsPaymentInfoSaving registryCashFundDeleteFromCartInDB(long registrantUserId, long regiPaymentInfoSavingId);
//	public RegistryCashFundsPaymentInfoSaving adminRegistryCashFundInfoTakingFromDB(long regiPaymentInfoSavingId);
	
	public List registryCashFundsPaymentInfoCheckInDB(long registrantUserId);
	public int updateAllRegistryCashFundsInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate);
	public RegistryCashFundsPaymentInfoSaving registryCashFundsValuesUpdateInDB(long registrantUserId, long regiPaymentInfoSavingId);
	
	
//	Custom Funds Coding

	public List registryCustomFundsAddCartInfoCheckInDB(long registrantUserId, long regCustomFundsInfoSavingId);
	public RegistryCashFundsPaymentInfoSaving registryCustomFundsAddCartInfoDeleteFromDB(long registrantUserId, long regCustomFundsInfoSavingId);
	public List registryCustomFundsAddCartRowCheckingInDB(long registrantUserId);
	public List registryCustomFundsPaymentInfoCheckingInDB(long registrantUserId, long cashFundsPaymentSavingId);
	public RegistryCashFundsPaymentInfoSaving registryCustomFundsPaymentInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId);
		
	public List registryCashFundsMyAccountsDataCheckInDB(long registrantUserId);
	public RegistryCashFundsPaymentInfoSaving registryMyAccountInfoUpdateInDB(long registrantUserId, long cashFundsPaymentSavingId);
	
	public List adminRegistrantCashFundsInfoCheckInDB();
	public List adminRegistrantPendingCashFundsInfoCheckInDB();
	public List adminRegistrantClearedNotRequestedCashFundsInfoCheckInDB();
	public RegistryCashFundsPaymentInfoSaving adminRegistryCashFundColumnUpdateInDataBase(long regCFPaySavingId);
	public List adminRegistrantTransferRequestedCashFundsInfoCheckInDB();
	public List adminRegistrantTransferCompletedCashFundsInfoCheckInDB();
	
	public void delete(RegistryCashFundsPaymentInfoSaving persistentInstance);	
	public RegistryCashFundsPaymentInfoSaving findById(long id);	
	public List<RegistryCashFundsPaymentInfoSaving> findByExample(RegistryCashFundsPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistryCashFundsPaymentInfoSaving merge(RegistryCashFundsPaymentInfoSaving detachedInstance);	
	public void attachDirty(RegistryCashFundsPaymentInfoSaving instance);	
	public void attachClean(RegistryCashFundsPaymentInfoSaving instance);

}
