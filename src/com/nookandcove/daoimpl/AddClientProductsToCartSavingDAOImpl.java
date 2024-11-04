package com.nookandcove.daoimpl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nookandcove.dao.AddClientProductsToCartSavingDAO;
import com.nookandcove.model.AddClientProductsToCartSaving;

@SuppressWarnings("rawtypes")
@Repository
public class AddClientProductsToCartSavingDAOImpl extends HibernateDaoSupport implements AddClientProductsToCartSavingDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddClientProductsToCartSavingDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	public void save(AddClientProductsToCartSaving transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			LOGGER.error("save failed", re);
			throw re;
		}
	}	
	
	public List selectedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' ";			
			return getHibernateTemplate().find(queryString);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AddClientProductsToCartSaving updatedDesnRowIdVerification(long userId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' ";
			return (AddClientProductsToCartSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List totalAddCartItemsListDisplay(long userId) {
		try {
			String queryString = "select productCount from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and shoppingCartPaymentInfoSavingId = '0' and (cartPaymentStatus is null or cartPaymentStatus = '') ";		
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}	

	public List selectedPaymentCartItemsListTakeFromDB(long userId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and shoppingCartPaymentInfoSavingId = '0' and (cartPaymentStatus is null or cartPaymentStatus = '') order by createdDate DESC nulls last ";		
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AddClientProductsToCartSaving selectedPaymentCartItemsListUpdateInDB(long userId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and shoppingCartPaymentInfoSavingId = '0' and (cartPaymentStatus is null or cartPaymentStatus = '') ";		
			return (AddClientProductsToCartSaving) getHibernateTemplate().find(queryString).get(0);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int updateAllPaimentCartItemsInDB(long userId, long shopingCartPayId, String returnVal) {		
		try {
			String queryString = "UPDATE AddClientProductsToCartSaving set shoppingCartPaymentInfoSavingId = '"+shopingCartPayId+"', cartPaymentStatus = '"+returnVal+"', orderedStatus = 'NO', deliveredStatus = 'NO' WHERE userId = '"+userId+"' and shoppingCartPaymentInfoSavingId = '0' and (cartPaymentStatus is null or cartPaymentStatus = '') ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AddClientProductsToCartSaving name failed", re);
			throw re;
		}
	}

	public AddClientProductsToCartSaving deletedSelectedProductsFromCartDB(long productSavingId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE addClientProductsToCartSavingId = '"+productSavingId+"' ";
			return (AddClientProductsToCartSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public AddClientProductsToCartSaving updatedSelectedProductsFromCartDB(long productSavingId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE addClientProductsToCartSavingId = '"+productSavingId+"' ";
			return (AddClientProductsToCartSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List selectedClientProductFromCart(long userId, long clProdSavingId, String packageType) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and clientProductsUploadedByDesignerSavingId = '"+clProdSavingId+"' and conceptsThreedRefferance = '"+packageType+"' and (cartPaymentStatus is null or cartPaymentStatus = '') order by createdDate DESC nulls last ";		
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public List AdminOrderStatusValueCheckingInDB(long userId, long shopingCartSavingId) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and shoppingCartPaymentInfoSavingId = '"+shopingCartSavingId+"' order by createdDate DESC nulls last, updatedDate DESC nulls last";	
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public AddClientProductsToCartSaving updateClientProductToCart(long userId, long productSavingId, String packageType) {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE userId = '"+userId+"' and clientProductsUploadedByDesignerSavingId = '"+productSavingId+"' and conceptsThreedRefferance = '"+packageType+"' and (cartPaymentStatus is null or cartPaymentStatus = '') ";
			return (AddClientProductsToCartSaving) getHibernateTemplate().find(queryString).get(0);			
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public int allClientProductsUploadedToCartInDB(long userId,long shoCartPaySavingId) {		
		try {
			String queryString = "UPDATE AddClientProductsToCartSaving set shoppingCartPaymentInfoSavingId = '"+shoCartPaySavingId+"', cartUsedStatus = 'Pending' WHERE userId = '"+userId+"' ";			
			return getHibernateTemplate().bulkUpdate(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find by AddClientProductsToCartSaving name failed", re);
			throw re;
		}
	}
	
	public List purchasesPaymentCartItemsListTakeFromDB() {
		try {
			String queryString = "from AddClientProductsToCartSaving WHERE shoppingCartPaymentInfoSavingId > 0 and (cartPaymentStatus is not null and cartPaymentStatus != '') order by createdDate DESC nulls last ";		
			return getHibernateTemplate().find(queryString);		
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}

	public void delete(AddClientProductsToCartSaving persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}
	
	public AddClientProductsToCartSaving findById(long id) {
		try {
			AddClientProductsToCartSaving instance = (AddClientProductsToCartSaving) getHibernateTemplate().get("com.nookandcove.AddClientProductsToCartSaving", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public List<AddClientProductsToCartSaving> findByExample(AddClientProductsToCartSaving instance) {
		try {
			List<AddClientProductsToCartSaving> results = (List<AddClientProductsToCartSaving>) getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from AddClientProductsToCartSaving as model where model."	+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			LOGGER.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from AddClientProductsToCartSaving";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			LOGGER.error("find all failed", re);
			throw re;
		}
	}

	public AddClientProductsToCartSaving merge(AddClientProductsToCartSaving detachedInstance) {
		try {
			AddClientProductsToCartSaving result = (AddClientProductsToCartSaving) getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			LOGGER.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AddClientProductsToCartSaving instance) {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AddClientProductsToCartSaving instance) {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			LOGGER.error("attach failed", re);
			throw re;
		}
	}

	public static AddClientProductsToCartSavingDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AddClientProductsToCartSavingDAOImpl) ctx.getBean("AddClientProductsToCartSavingDAO");
	}

}

