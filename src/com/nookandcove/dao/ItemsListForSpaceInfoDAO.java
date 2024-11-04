package com.nookandcove.dao;

import java.util.List;

import com.nookandcove.model.ItemsListForSpaceInfo;

@SuppressWarnings("rawtypes")
public interface ItemsListForSpaceInfoDAO {
	
	public void save(ItemsListForSpaceInfo transientInstance);	
	public List selectedItemsTakeFromDB(String imageRefferance);	
	public ItemsListForSpaceInfo selectedSpaceItemsTakeFromDB(String styleName, String inspImgVal);	
	public void delete(ItemsListForSpaceInfo persistentInstance);	
	public ItemsListForSpaceInfo findById(long id);	
	public List<ItemsListForSpaceInfo> findByExample(ItemsListForSpaceInfo instance);	
	public List findByProperty(String propertyName, Object value);	
	public List findAll();	
	public ItemsListForSpaceInfo merge(ItemsListForSpaceInfo detachedInstance);	
	public void attachDirty(ItemsListForSpaceInfo instance);	
	public void attachClean(ItemsListForSpaceInfo instance);
}
