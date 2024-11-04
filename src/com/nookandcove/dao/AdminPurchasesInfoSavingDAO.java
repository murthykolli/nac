package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.AdminPurchasesInfoSaving;

@SuppressWarnings("rawtypes")
public interface AdminPurchasesInfoSavingDAO {
	
	public void save(AdminPurchasesInfoSaving transientInstance);	
	public List selectedDesnRowIdVerification(long userId);	
	public AdminPurchasesInfoSaving updatedDesnRowIdVerification(long userId);	
	public void delete(AdminPurchasesInfoSaving persistentInstance);	
	public AdminPurchasesInfoSaving findById(long id);	
	public List<AdminPurchasesInfoSaving> findByExample(AdminPurchasesInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public AdminPurchasesInfoSaving merge(AdminPurchasesInfoSaving detachedInstance);	
	public void attachDirty(AdminPurchasesInfoSaving instance);	
	public void attachClean(AdminPurchasesInfoSaving instance);
}
