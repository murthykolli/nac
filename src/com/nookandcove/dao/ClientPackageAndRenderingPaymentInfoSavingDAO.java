package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ClientPackageAndRenderingPaymentInfoSaving;

@SuppressWarnings("rawtypes")
public interface ClientPackageAndRenderingPaymentInfoSavingDAO {
	
	public void save(ClientPackageAndRenderingPaymentInfoSaving transientInstance);	
	public List selectedClientPackagePaymentRowIdVerification(long userId, long clientInfoSavingId);	
	public ClientPackageAndRenderingPaymentInfoSaving updatedClientPackagePaymentRowInDB(long userId, long clientInfoSavingId);
	public List selectedClientSecRenderingPaymentRowIdVerification(long userId, long clientInfoSavingId);
	public ClientPackageAndRenderingPaymentInfoSaving updatedClientSecRenderingPaymentRowInDB(long userId, long clientInfoSavingId);
	public List clientPackagePaymentCountInAdmin();
	public List client2ndRenderingPaymentCountInAdmin();
	public List clientPackagePaymentRowVerUsingJoins();
	public List client2ndRenderingPaymentRowVerUsingJoins();
	public void delete(ClientPackageAndRenderingPaymentInfoSaving persistentInstance);	
	public ClientPackageAndRenderingPaymentInfoSaving findById(long id);	
	public List<ClientPackageAndRenderingPaymentInfoSaving> findByExample(ClientPackageAndRenderingPaymentInfoSaving instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ClientPackageAndRenderingPaymentInfoSaving merge(ClientPackageAndRenderingPaymentInfoSaving detachedInstance);	
	public void attachDirty(ClientPackageAndRenderingPaymentInfoSaving instance);	
	public void attachClean(ClientPackageAndRenderingPaymentInfoSaving instance);
	public List allPackageInfoDailyReports(String todayDate);
	public List allPackageInfoTotalReports(String referenceDate, String todayDate);
	public List allRenderingInfoDailyReports(String todayDate);
	public List allRenderingInfoTotalReports(String referenceDate, String todayDate);

}
