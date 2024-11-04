package com.nookandcove.dao;

import java.util.List;
import com.nookandcove.model.DesignerEditableCalendarInfoSaving;

@SuppressWarnings("rawtypes")
public interface DesignerEditableCalendarInfoSavingDAO {
	
	public void save(DesignerEditableCalendarInfoSaving transientInstance);
	public List checkEditableCalendarRowInDB(long desnInfoSavingId);
	public DesignerEditableCalendarInfoSaving takeEditableCalendarRowDataFromDB(long desnInfoSavingId);
	public List editableCalendarMonthDataTakeFromDB(long desnInfoSavingId, String clientMonth, String clientDay, String clientYear);
	public void delete(DesignerEditableCalendarInfoSaving persistentInstance);
	public DesignerEditableCalendarInfoSaving findById(long id);
	public List<DesignerEditableCalendarInfoSaving> findByExample(DesignerEditableCalendarInfoSaving instance);
	public List findByProperty(String propertyName, Object value);
	public List newGiftCardsDataTakeFromDB();
	public List sentGiftCardsDataTakeFromDB();
	public List findAll();
	public DesignerEditableCalendarInfoSaving merge(DesignerEditableCalendarInfoSaving detachedInstance);
	public void attachDirty(DesignerEditableCalendarInfoSaving instance);
	public void attachClean(DesignerEditableCalendarInfoSaving instance);
	
}
