package com.icitic.avp.bean.hbm.pojo.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
public class IcSysParaDaoHibernateDaoSupportImpl extends HibernateDaoSupport  implements IcSysParaDao  {
	
	
	
	public List<IcSysPara> getall(){
		
		return getHibernateTemplate().find("from IcSysPara");
		
		
	}
	
	
	
	   
	
}

