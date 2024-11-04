package com.nookandcove.daoimpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.ClientInfoSavingDAO;
import com.nookandcove.model.ClientInfoSaving;

@SuppressWarnings("rawtypes")
@Repository
public class ClientInfoSavingDAOImpl extends HibernateDaoSupport implements ClientInfoSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientInfoSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(ClientInfoSaving transientInstance) {
		LOGGER.debug("saving ClientInfoSaving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}
	
	public List selectedRowIdVerification(long userId) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and status is null";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public ClientInfoSaving updatedRowIdVerification(long userId) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and status is null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List rowIdSelectionUsingRoomName(long userId, String roomName) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and typeOfSpace = '"+roomName+"' and status is null";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving rowIdUpdationUsingRoomName(long userId, String roomName) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and typeOfSpace = '"+roomName+"' and status is null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List rowIdSelectionUsingClientInfoID(long userId, long clientInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoId+"' ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving rowIdUpdationUsingClientInfoID(long userId, long clientInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' and clientInfoSavingId = '"+clientInfoId+"' ";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientManagementRowCheckingInDB(long userId) {
		try {
			String queryString = "from ClientInfoSaving WHERE userId = '"+userId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving viewClientInfoDataDisplay(long myRoomInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+myRoomInfoId+"' and status is null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List clientDirectoryRowChecking(long myRoomInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+myRoomInfoId+"' and status is not null";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving clientDirectoryValuesUpdationByAdmin(long myRoomInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+myRoomInfoId+"' and status is not null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving viewClientInfoDisplayForDesigner(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and status is not null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public List displayClientDataUsingDesignerID(long designerSavingId) {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId = '"+designerSavingId+"' and status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List displayOnlyDesignersClientsData(long designerSavingId) {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId = '"+designerSavingId+"' and status is not null and roomStatus is null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public List displayClientArchiveDataUsingDesignerID(long designerSavingId) {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId = '"+designerSavingId+"' and roomStatus = 'Finished' and status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List checkDesignerDirectoryForClientsUsingDesignerID(long designerSavingId) {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId = '"+designerSavingId+"' and status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving userIdTakeFromTableUsingClId(long clientInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+clientInfoId+"' ";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public ClientInfoSaving viewClientInfoDisplayForAdminSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and status is not null";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerArchiveClientRowCheck(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and roomStatus = 'Finished'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientInfoSaving designerArchiveClientsStatusCheck(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from ClientInfoSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and roomStatus = 'Finished'";
			return (ClientInfoSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(ClientInfoSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	public ClientInfoSaving findById(long id) {
		try {
			ClientInfoSaving instance = (ClientInfoSaving) getHibernateTemplate().get("com.nookandcove.ClientInfoSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<ClientInfoSaving> findByExample(ClientInfoSaving instance) {
		try {
			List<ClientInfoSaving> results = (List<ClientInfoSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from ClientInfoSaving as model where model."+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List clientInfoDisplyInAdminNewCleintsUsingStatus() {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId = 0 and status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List adminAssignClientInfoToDesignerUsingIdStatus() {
		try {
			String queryString = "from ClientInfoSaving WHERE designerInfoSavingId > 0 and status is not null order by createdDate DESC nulls last, updatedDate DESC nulls last";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from ClientInfoSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public ClientInfoSaving merge(ClientInfoSaving detachedInstance) {
		try {
			ClientInfoSaving result = (ClientInfoSaving) getHibernateTemplate().merge(detachedInstance);
			LOGGER.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientInfoSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientInfoSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static ClientInfoSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientInfoSavingDAOImpl) ctx.getBean("ClientInfoSavingDAOImpl");
	}
}