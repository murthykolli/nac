package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AdminAssignClientInfoToDesignerSavingDAO;
import com.nookandcove.model.AdminAssignClientInfoToDesignerSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AdminAssignClientInfoToDesignerSavingDAOImpl extends HibernateDaoSupport implements AdminAssignClientInfoToDesignerSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminAssignClientInfoToDesignerSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}
	
	public List clientCheckListVerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AdminAssignClientInfoToDesignerSaving adminAssignedNewDesignerInfoUpdateInClient(long clientInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List checkUpdatedStatusInDB(long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE designerInfoSavingId = '"+designerInfoId+"' and (newUploads is not null and newUploads != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List checkDesignerUpdatedStatusInDB(long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE designerInfoSavingId = '"+designerInfoId+"' and (designerUploads is not null and designerUploads != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List checkClientsInfoUsingDesignerIdInDB(long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE designerInfoSavingId = '"+designerInfoId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving updateClientsInfoUsingDesignerIdInDB(long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE designerInfoSavingId = '"+designerInfoId+"' ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving clientCheckListUpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerConcept1VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept1ImageUpload is not null and concept1ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerConcept1UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept1ImageUpload is not null and concept1ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerConcept2VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept2ImageUpload is not null and concept2ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerConcept2UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept2ImageUpload is not null and concept2ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designer3DRenderingVerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designer3DRenderingUpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List designerRoomRendering1VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRoomRendering1UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRoomRendering2VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering2ImageUpload is not null and rendering2ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public AdminAssignClientInfoToDesignerSaving designerRoomRendering2UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering2ImageUpload is not null and rendering2ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
		
	public List designerRevisedRendering1VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering1UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerRevisedRendering2VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering2ImageUpload is not null and revisedRendering2ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering2UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering2ImageUpload is not null and revisedRendering2ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List designerSecondRendering1VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering1UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List designerSecondRendering2VerificationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering2ImageUpload is not null and secondRendering2ImageUpload != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering2UpdationInDB(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering2ImageUpload is not null and secondRendering2ImageUpload != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public void save(AdminAssignClientInfoToDesignerSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE userId = '"+userId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving updatedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE userId = '"+userId+"' ";
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerConcept1VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept1ImageUpload is not null and concept1ImageUpload != '') and (adminApprovedForConcept is not null and adminApprovedForConcept != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerConcept1UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept1ImageUpload is not null and concept1ImageUpload != '') and (adminApprovedForConcept is not null and adminApprovedForConcept != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerConcept2VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept2ImageUpload is not null and concept2ImageUpload != '') and (adminApprovedForConcept is not null and adminApprovedForConcept != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerConcept2UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (concept2ImageUpload is not null and concept2ImageUpload != '') and (adminApprovedForConcept is not null and adminApprovedForConcept != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
		
	public List designer3DRenderingVerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designer3DRenderingUpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List firstRenderingRedirectionCheck(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List secondRenderingRedirectionCheck(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (rendering2ImageUpload is not null and rendering2ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List designerRendering1VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRendering1UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerRendering2VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (rendering2ImageUpload is not null and rendering2ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRendering2UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (rendering1ImageUpload is not null and rendering1ImageUpload != '') and (rendering2ImageUpload is not null and rendering2ImageUpload != '') and (adminApprovedForRendering is not null and adminApprovedForRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	
	
	public List designerSecondRendering1VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') and (adminApprovedForSecondRendering is not null and adminApprovedForSecondRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering1UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') and (adminApprovedForSecondRendering is not null and adminApprovedForSecondRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerSecondRendering2VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') and (secondRendering2ImageUpload is not null and secondRendering2ImageUpload != '') and (adminApprovedForSecondRendering is not null and adminApprovedForSecondRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerSecondRendering2UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (secondRendering1ImageUpload is not null and secondRendering1ImageUpload != '') and (secondRendering2ImageUpload is not null and secondRendering2ImageUpload != '') and (adminApprovedForSecondRendering is not null and adminApprovedForSecondRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List secondRenderingPaymentCheckingForClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving secondRenderingPaymentForClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerRevisedRendering1VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') and (adminApprovedForRevisedRendering is not null and adminApprovedForRevisedRendering != '') ";
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering1UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') and (adminApprovedForRevisedRendering is not null and adminApprovedForRevisedRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List designerRevisedRendering2VerificationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') and (revisedRendering2ImageUpload is not null and revisedRendering2ImageUpload != '') and (adminApprovedForRevisedRendering is not null and adminApprovedForRevisedRendering != '') ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving designerRevisedRendering2UpdationInClientSide(long clientInfoId, long designerInfoId) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving WHERE clientInfoSavingId = '"+clientInfoId+"' and designerInfoSavingId = '"+designerInfoId+"' and (revisedRendering1ImageUpload is not null and revisedRendering1ImageUpload != '') and (revisedRendering2ImageUpload is not null and revisedRendering2ImageUpload != '') and (adminApprovedForRevisedRendering is not null and adminApprovedForRevisedRendering != '') ";			
			return (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().find(queryString).get(0);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void delete(AdminAssignClientInfoToDesignerSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AdminAssignClientInfoToDesignerSaving findById(long id) {
		try {
			AdminAssignClientInfoToDesignerSaving instance = (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().get("com.nookandcove.AdminAssignClientInfoToDesignerSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AdminAssignClientInfoToDesignerSaving> findByExample(AdminAssignClientInfoToDesignerSaving instance) {
		try {
			List<AdminAssignClientInfoToDesignerSaving> results = (List<AdminAssignClientInfoToDesignerSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AdminAssignClientInfoToDesignerSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AdminAssignClientInfoToDesignerSaving merge(AdminAssignClientInfoToDesignerSaving detachedInstance) {
		try {
			AdminAssignClientInfoToDesignerSaving result = (AdminAssignClientInfoToDesignerSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminAssignClientInfoToDesignerSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdminAssignClientInfoToDesignerSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AdminAssignClientInfoToDesignerSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminAssignClientInfoToDesignerSavingDAOImpl) ctx.getBean("AdminAssignClientInfoToDesignerSavingDAO");
	}

}

