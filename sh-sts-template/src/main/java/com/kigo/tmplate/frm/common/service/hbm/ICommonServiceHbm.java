package com.kigo.tmplate.frm.common.service.hbm;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kigo.tmplate.frm.common.pagination.model1.Page;

/**
 * 
 * <p>Title: ICommonServiceHbm.java</p>
 * <p>Description: </p>
 * @author    Kigo
 * @version   1.0
 * @date 2013-3-13下午04:43:27
 */
public interface ICommonServiceHbm<T, ID extends Serializable> {

	/**
	 * 保存指定实体类
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public void save(T entity);

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public void delete(T entity);

	/**
	 * 获取所有实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> findAll(Class<T> entityClass);

	/**
	 * 更新或保存指定实体
	 * 
	 * @param entity
	 *            实体类
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 查找指定ID实体类对象
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	public T findById(Class<T> entityClass, ID id);

	/**
	 * 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列表
	 * @return 集合
	 */
	public List<Object> find(String hql, Object... values);

	/**
	 * 按照HQL语句查询唯一对象.
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 */
	public Object findUnique(final String hql, final Object... values);

	/**
	 * 查找指定HQL并返回INT型
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return INT
	 */
	public int findInt(final String hql, final Object... values);

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
			final Object... values);

	/**
	 * 获取指定实体Class的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	public int findTotalCount(Class<T> entityClass);

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
			Object value);

	/**
	 * 模糊查询指定条件对象集合 <br>
	 * 用法：可以实例化一个空的T对象，需要查询某个字段，就set该字段的条件然后调用本方法<br>
	 * 缺点：目前测试貌似只能支持String的模糊查询，虽然有办法重写，但没必要，其他用HQL<br>
	 * 
	 * @param entity
	 *            条件实体
	 * @return 结合
	 */
	public List<T> findByExample(T entity);

	/**
	 * 补充方法(未测) 据说可以无视session的状态持久化对象
	 * 
	 * @param entity
	 *            实体类
	 * @return 持久后的实体类
	 */
	public T merge(T entity);

	/**
	 * 清除实体的锁定状态<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	public void attachClean(T entity);

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
			final Object... values);

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
	public Query createQuery(Session session, String hql, Object... objects);

}
