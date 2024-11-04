package com.nookandcove.dao;

import java.util.List;
import com.nookandcove.model.UserInformation;

@SuppressWarnings("rawtypes")
public interface UserInformationDAO {
	
	public void save(UserInformation transientInstance);	
	public UserInformation findByUserInfoFromDB(String userName);	
	public List findByUserInfoProperty(String userName, Object passwordSalt);	
	public UserInformation updatedRowIdVerification(long userId);
	public void delete(UserInformation persistentInstance);
	public UserInformation findById(long id);
	public List updatedRowIdCheckingInDB(long userId);
	public List<UserInformation> findByExample(UserInformation instance);
	public List findByProperty(String propertyName, Object value);	
	public List<UserInformation> findByUserName(Object userName);
	public List findAll();	
	public List adminDtaTakefromDB();
	public UserInformation merge(UserInformation detachedInstance);
	public void attachDirty(UserInformation instance);
	public void attachClean(UserInformation instance);	
	public List designerInfoDisplayInAdmin();
	public List inactiveDesignerInfoDisplayInAdmin();
	public List subAdminListDisplayInAdmin();
	public List packageLoginInfoDisplayInAdminSide();
	public List adminInfoCheckingInDB();
	public UserInformation adminGettingUserIdFromDbUsingTypeOfUser();
	public UserInformation deleteSubAdminFromDB(long subAdminId);

}