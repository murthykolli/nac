package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.RegistrantShippingInfoSaving;

@SuppressWarnings("rawtypes")
public interface RegistrantShippingInfoSavingDAO {
	
	public void save(RegistrantShippingInfoSaving transientInstance);	
	public List selectedShippingAddressRowIdVerification(long registryUserId);	
	public RegistrantShippingInfoSaving updatedShippingAddressRowInDataBasa(long registryUserId);	
	public void delete(RegistrantShippingInfoSaving persistentInstance);	
	public RegistrantShippingInfoSaving findById(long id);
	public List<RegistrantShippingInfoSaving> findByExample(RegistrantShippingInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public RegistrantShippingInfoSaving merge(RegistrantShippingInfoSaving detachedInstance);
	public void attachDirty(RegistrantShippingInfoSaving instance);	
	public void attachClean(RegistrantShippingInfoSaving instance);	
	
}
