package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistrantInformationSaving;
import com.nookandcove.model.UserInformation;

@SuppressWarnings("rawtypes")
public interface RegistrantInformationSavingDAO {
	
	public void save(RegistrantInformationSaving transientInstance);
	public List registryAddressValuesCheckingInDB(String regAddress);
	public List registryNamesListTakeFromDB();
	public List adminRegistryLoginInfoListTakeFromDB();
	public List searchRegistryInfoInDBForGuest(String regiAddress);
	public RegistrantInformationSaving searchRegistryInfoTakeFromDBForGuest(String regiAddress);
	
	
	
	
	public List selectedFirstNameValuesCheckingInDB(String firstName);
	public List selectedLastNameValuesCheckingInDB(String lastName);
	public List selectedTwoNameValuesCheckingInDB(String firstName, String lastName);
	public RegistrantInformationSaving selectedFirstNameValuesFromDB(String firstName);
	public RegistrantInformationSaving selectedLastNameValuesFromDB(String lastName);
	public RegistrantInformationSaving selectedTwoNameValuesFromDB(String firstName, String lastName);
	public RegistrantInformationSaving registryDataTakeFromDB(long regUserId);
	public List registryAddressDataTakeFromDB(String regAddress);
	public void delete(RegistrantInformationSaving persistentInstance);	
	public RegistrantInformationSaving findById(long id);
	public RegistrantInformationSaving findByUserInfoFromDB(String regUserName);
	
	public List adminAllRegistrantsLiveStatusDataCheckInDB();
	public List adminAllRegistrantsArchiveStatusDataCheckInDB();
	public List adminAllRegistrantsDataCheckInDB();
	public RegistrantInformationSaving adminAllRegistrantsDataTakeFromDB();
	
	public List<RegistrantInformationSaving> findByExample(RegistrantInformationSaving instance);
	public List findByUserInfoProperty(String regUserName, Object passwordSalt);
	public RegistrantInformationSaving regiUserInfoDataTakeFromDB(String regUserName, Object passwordSalt);
	public List findByProperty(String propertyName, Object value);
	public List registrantUserIdsListCheckUsingUniqueRefCode(String uniqueRefCode);
	public RegistrantInformationSaving registrantUserIdsListUsingUniqueRefCode(String uniqueRefCode);
	
	public List<UserInformation> findByUserName(Object userName);
	public List findAll();	
	public RegistrantInformationSaving merge(RegistrantInformationSaving detachedInstance);	
	public void attachDirty(RegistrantInformationSaving instance);	
	public void attachClean(RegistrantInformationSaving instance);

}
