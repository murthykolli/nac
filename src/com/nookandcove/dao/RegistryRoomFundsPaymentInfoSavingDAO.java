package com.nookandcove.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nookandcove.model.RegistryRoomFundsPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistryRoomFundsPaymentInfoSavingDAO {
	
	public void save(RegistryRoomFundsPaymentInfoSaving transientInstance);
	public List regRoomAndCashFundsPackageRowCheckingInDB(long registrantUserId);
	public List registrantCashFundsPackageRowOnlyCheckingInDB(long registrantUserId);
	public List regRoomAndCashFundsPackageInfoRowCheckingInDB(long registrantUserId);
	public List regRoomAndCashFundPSNRowCheckingInDB(long registrantUserId);
	public RegistryRoomFundsPaymentInfoSaving regRoomAndCashFundRowDataTakingFromDB(long registrantUserId);
	public RegistryRoomFundsPaymentInfoSaving registryRoomAndCashFundDeleteFromCartInDB(long registrantUserId, long regiPaymentInfoSavingId);
	public RegistryRoomFundsPaymentInfoSaving adminRegistryRoomAndCashFundInfoTakingFromDB(long regiPaymentInfoSavingId);
	public int updateAllRegistryRoomAndCashFundInfoInDB(long registrantUserId, long regPaymentInfoSavingId, String returnType, Timestamp currentDate);
	
	public List adminRegistrantCashFundsPackageRowOnlyCheckingInDB();
	
	public void delete(RegistryRoomFundsPaymentInfoSaving persistentInstance);	
	public RegistryRoomFundsPaymentInfoSaving findById(long id);	
	public List<RegistryRoomFundsPaymentInfoSaving> findByExample(RegistryRoomFundsPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistryRoomFundsPaymentInfoSaving merge(RegistryRoomFundsPaymentInfoSaving detachedInstance);	
	public void attachDirty(RegistryRoomFundsPaymentInfoSaving instance);	
	public void attachClean(RegistryRoomFundsPaymentInfoSaving instance);

}
