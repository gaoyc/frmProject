package com.icitic.avp.bean.hbm.pojo.dao;

import org.hibernate.Session;

import com.googlecode.genericdao.dao.hibernate.original.GenericDAOImpl;
import com.icitic.avp.bean.hbm.pojo.IcSysPara;




/**
 * 
 * <p>Title: BeanDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: ICITIC</p>
 * <p>Company: 中信网络股份有限公司</p>
 * @author    Kigo
 * @version   1.0
 * @date 2013-3-8下午04:29:52
 */
public class IcSysParaDaoImpl extends GenericDAOImpl<IcSysPara, String> implements IcSysParaDao  {
	
	   protected Session getHibernateSession()
	   {
	     return getSession();
	   }
	   
	   
	
}

