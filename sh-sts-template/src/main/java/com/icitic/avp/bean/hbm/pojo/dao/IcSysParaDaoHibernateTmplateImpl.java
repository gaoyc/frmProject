package com.icitic.avp.bean.hbm.pojo.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

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
public class IcSysParaDaoHibernateTmplateImpl  implements IcSysParaDao  {
	
	private HibernateTemplate hibernateTemplate;
	
	
	public List<IcSysPara> getList(){
		
		return (List<IcSysPara>)hibernateTemplate.find("from IcSysPara");
		
		
	}
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	   
	
}

