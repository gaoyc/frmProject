package com.icitic.avp.bean.hbm.pojo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
@Component("IcSysParaDaoImpl")
public class IcSysParaDaoImpl extends GenericDAOImpl<IcSysPara, String> implements IcSysParaDao  {

    @Autowired
    @Qualifier("sessionFactory")
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}
	
	   
	
}

