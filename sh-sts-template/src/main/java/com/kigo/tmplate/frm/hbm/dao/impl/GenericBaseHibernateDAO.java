package com.kigo.tmplate.frm.hbm.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.kigo.tmplate.frm.common.pagination.model1.Page;

/**
 * 通用泛型DAO，支持分页
 * <p>Title: BaseHibernateDAO.java</p>
 * <p>Description: </p>
 * @author    Kigo
 * @version   1.0
 * @date 2013-3-8下午05:41:34
 */
@SuppressWarnings("unchecked")
public class GenericBaseHibernateDAO<T, ID extends Serializable> extends
		HibernateDaoSupport  {
	private static final Logger logger = Logger
			.getLogger(GenericBaseHibernateDAO.class);
	
	
    
	/**
	 * 保存指定实体类
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public void save(T entity) {
		try {
			getHibernateTemplate().save(entity);
			if (logger.isDebugEnabled()) {
				logger.debug("保存实体类成功," + entity.getClass().getName());
			}
		} catch (RuntimeException e) {
			logger.error("保存实体异常," + entity.getClass().getName(), e);
			throw e;
		}
	}
	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public void delete(T entity) {
		try {
			getHibernateTemplate().delete(entity);
			if (logger.isDebugEnabled()) {
				logger.debug("删除实体类成功," + entity.getClass().getName());
			}
		} catch (RuntimeException e) {
			logger.error("删除实体异常", e);
			throw e;
		}
	}
	/**
	 * 获取所有实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> findAll(Class<T> entityClass) {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("开始删除实体：" + entityClass.getName());
			}
			return getHibernateTemplate().find("from " + entityClass.getName());
		} catch (RuntimeException e) {
			logger.error("查找指定实体集合异常，实体：" + entityClass.getName(), e);
			throw e;
		}
	}
	/**
	 * 更新或保存指定实体
	 * 
	 * @param entity
	 *            实体类
	 */
	public void saveOrUpdate(T entity) {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			if (logger.isDebugEnabled()) {
				logger.debug("更新或者保存实体成功," + entity.getClass().getName());
			}
		} catch (RuntimeException e) {
			logger.error("更新或保存实体异常", e);
			throw e;
		}
	}
	/**
	 * 查找指定ID实体类对象
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	public T findById(Class<T> entityClass, ID id) {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("开始查找ID为" + id + "的实体：" + entityClass.getName());
			}
			return (T) getHibernateTemplate().get(entityClass, id);
		} catch (RuntimeException e) {
			logger.error("查找指定ID实体异常，ID：" + id, e);
			throw e;
		}
	}
	/**
	 * 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列表
	 * @return 集合
	 */
	public List<Object> find(String hql, Object... values) {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("开始查询指定HQL语句," + hql);
			}
			return getHibernateTemplate().find(hql, values);
		} catch (RuntimeException e) {
			logger.error("查询指定HQL异常，HQL：" + hql, e);
			throw e;
		}
	}
	/**
	 * 按照HQL语句查询唯一对象.
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 */
	public Object findUnique(final String hql, final Object... values) {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("开始查询返回唯一结果的HQL语句," + hql);
			}
			return getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = createQuery(s, hql, values);
					return query.uniqueResult();
				}
			});
		} catch (RuntimeException e) {
			logger.error("查询指定HQL异常，HQL：" + hql, e);
			throw e;
		}
	}
	/**
	 * 查找指定HQL并返回INT型
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return INT
	 */
	public int findInt(final String hql, final Object... values) {
		Object result = findUnique(hql, values);
		if (result!=null) {
			return Integer.valueOf(result.toString());
		} else {
			return 0;
		}
	}
	/**
	 * 获取指定实体Class指定条件的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param where
	 *            HQL的查询条件,支持参数列表
	 * @param values
	 *            可变参数列表
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass, final String where,
			final Object... values) {
		String hql = "select count(e) from " + entityClass.getName() + " as e "
				+ where;
		return findInt(hql, values);
	}
	/**
	 * 获取指定实体Class的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass) {
		return findTotalCount(entityClass, "");
	}
	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 */
	public List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
	  try {
	   if (logger.isDebugEnabled()) {
		logger.debug("开始查找指定属性：" + propertyName + "为" + value + "的实体"
						+ entityClass.getName());
			}
			String queryStr = "from " + entityClass.getName()
					+ " as model where model." + propertyName + "=?";
			return getHibernateTemplate().find(queryStr, value);
		} catch (RuntimeException e) {
			logger.error("查找指定条件实体集合异常，条件：" + propertyName, e);
			throw e;
		}
	}
	/**
	 * 模糊查询指定条件对象集合 <br>
	 * 用法：可以实例化一个空的T对象，需要查询某个字段，就set该字段的条件然后调用本方法<br>
	 * 缺点：目前测试貌似只能支持String的模糊查询，虽然有办法重写，但没必要，其他用HQL<br>
	 * 
	 * @param entity
	 *            条件实体
	 * @return 结合
	 */
	public List<T> findByExample(T entity) {
		try {
			List<T> results = getHibernateTemplate().findByExample(entity);
			return results;
		} catch (RuntimeException re) {
			logger.error("查找指定条件实体集合异常", re);
			throw re;
		}
	}
	/**
	 * 补充方法(未测) 据说可以无视session的状态持久化对象
	 * 
	 * @param entity
	 *            实体类
	 * @return 持久后的实体类
	 */
	public T merge(T entity) {
		try {
			T result = (T) getHibernateTemplate().merge(entity);
			return result;
		} catch (RuntimeException re) {
			logger.error("merge异常", re);
			throw re;
		}
	}
	/**
	 * 清除实体的锁定状态<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	public void attachClean(T entity) {
		try {
			getHibernateTemplate().lock(entity, LockMode.NONE);
		} catch (RuntimeException re) {
			logger.error("实体解锁异常", re);
			throw re;
		}
	}
	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            页面对象
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return 分页数据
	 */
	public Page<T> findByPage(final Page<T> page, final String hql,
	final Object... values) {
	try {
	if (logger.isDebugEnabled()) {
		logger.debug("开始查找指定HQL分页数据," + hql);
	}
	return (Page<T>) getHibernateTemplate().execute(
		new HibernateCallback() {
			public Object doInHibernate(Session s)
				throws HibernateException, SQLException {
				Query query = createQuery(s, hql, values);
				if (page.isFirstSetted()) {
					query.setFirstResult(page.getFirst());
				}
			if (page.isPageSizeSetted()) {
				query.setMaxResults(page.getPageSize());
			}
			page.setResult(query.list());
			if (logger.isDebugEnabled()) {
				logger.debug("查找指定HQL分页数据成功," + hql);
			}
			return page;
		}
		});
	} catch (RuntimeException e) {
	logger.error("分页查询异常，HQL：" + hql, e);
		throw e;
	}
	}
	/**
	 * 根据查询条件与参数列表创建Query对象
	 * 
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	public Query createQuery(Session session, String hql, Object... objects) {
		Query query = session.createQuery(hql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query;
	}
	
/*	*//**
	 * 从Spring上下文中获取本类对象<br>
	 * 此方法可能存在线程并发问题（待测）
	 * 
	 * @param context
	 *            Spring上下文
	 * @return 本类对象
	 *//*
	public static BaseHibernateDAO getFromApplicationContext(
			WebApplicationContext context) {
		return (BaseHibernateDAO) context.getBean("BaseHibernateDAO");
	}*/
}

