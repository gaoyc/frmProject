package com.kigo.tmplate.frm.common.service.hbm.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icitic.avp.bean.hbm.pojo.IcSysPara;
import com.kigo.tmplate.frm.common.pagination.model1.Page;
import com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm;
import com.kigo.tmplate.frm.hbm.dao.impl.GenericBaseHibernateDAO;

/**
 * 
 * <p>Title: ICommonServiceHbm.java</p>
 * <p>Description: </p>
 * @author    Kigo
 * @version   1.0
 * @date 2013-3-13下午04:46:35
 */
@Service("iCommonServiceHbm")
public class ICommonServiceHbmImpl<T, ID extends Serializable> implements ICommonServiceHbm<T, ID>{

	
//  @Qualifier("genericBaseHibernateDAO")
	@Autowired
	private GenericBaseHibernateDAO<T, ID> genericBaseHibernateDAO;
	

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		genericBaseHibernateDAO.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#delete(java.lang.Object)
	 */
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		genericBaseHibernateDAO.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findAll(java.lang.Class)
	 */
	@Override
	public List<T> findAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findAll(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		genericBaseHibernateDAO.saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findById(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public T findById(Class<T> entityClass, ID id) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findById(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#find(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<Object> find(String hql, Object... values) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.find(hql, values);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findUnique(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Object findUnique(String hql, Object... values) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findUnique(hql, values);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findInt(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int findInt(String hql, Object... values) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findInt(hql, values);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findTotalCount(java.lang.Class, java.lang.String, java.lang.Object[])
	 */
	@Override
	public int findTotalCount(Class<T> entityClass, String where,
			Object... values) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findTotalCount(entityClass, where, values);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findTotalCount(java.lang.Class)
	 */
	@Override
	public int findTotalCount(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findTotalCount(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findByProperty(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findByProperty(entityClass, propertyName, value);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findByExample(java.lang.Object)
	 */
	@Override
	public List<T> findByExample(T entity) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findByExample(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#merge(java.lang.Object)
	 */
	@Override
	public T merge(T entity) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.merge(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#attachClean(java.lang.Object)
	 */
	@Override
	public void attachClean(T entity) {
		// TODO Auto-generated method stub
		genericBaseHibernateDAO.attachClean(entity);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#findByPage(com.kigo.tmplate.frm.common.pagination.model1.Page, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Page<T> findByPage(Page<T> page, String hql, Object... values) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.findByPage(page, hql, values);
	}

	/* (non-Javadoc)
	 * @see com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm#createQuery(org.hibernate.Session, java.lang.String, java.lang.Object[])
	 */
	@Override
	public Query createQuery(Session session, String hql, Object... objects) {
		// TODO Auto-generated method stub
		return genericBaseHibernateDAO.createQuery(session, hql, objects);
	}
	
	

}

