package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistryRoomFundsInfoSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings("rawtypes")
public interface RegistryRoomFundsInfoSavingDAO {
	
	public void save(RegistryRoomFundsInfoSaving transientInstance);
	public List selectedRegAddGiftRowCheckingInDB(long regUserId);
	public RegistryRoomFundsInfoSaving selectedRegAddGiftRowValueFromDB(long regUserId);
	public List<RegistryRoomFundsInfoSaving> findByExample(RegistryRoomFundsInfoSaving instance);
	public List findByUserInfoProperty(String regUserName, Object passwordSalt);
	public List findByProperty(String propertyName, Object value);
	public List<UserInformation> findByUserName(Object userName);
	public List findAll();	
	public RegistryRoomFundsInfoSaving merge(RegistryRoomFundsInfoSaving detachedInstance);	
	public void attachDirty(RegistryRoomFundsInfoSaving instance);	
	public void attachClean(RegistryRoomFundsInfoSaving instance);

}
