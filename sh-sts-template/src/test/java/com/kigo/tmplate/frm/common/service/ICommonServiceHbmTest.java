package com.kigo.tmplate.frm.common.service;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.icitic.avp.bean.hbm.pojo.IcSysPara;
import com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoHibernateDaoSupportImpl;
import com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoHibernateTmplateImpl;
import com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoImpl;
import com.kigo.tmplate.frm.common.service.hbm.ICommonServiceHbm;
import com.kigo.tmplate.frm.hbm.dao.impl.GenericBaseHibernateDAO;

/**
 * 
 * <p>Title: ICommonServiceHbmTest.java</p>
 * <p>Description: </p>
 * @author    Kigo
 * @version   1.0
 * @date 2013-3-13下午05:15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)//设置测试事务回滚
public class ICommonServiceHbmTest {
    
	
	@Autowired
    @Qualifier("iCommonServiceHbm")
	private ICommonServiceHbm<IcSysPara, Long> iCommonServiceHbmImpl;
	
    
	@Test
	public void testICommonServiceHbm() {
		System.err.println("iCommonServiceHbmImpl is null :"+(iCommonServiceHbmImpl==null));
		List<IcSysPara> IcSysParas = iCommonServiceHbmImpl.findAll(IcSysPara.class);
		
		for (IcSysPara icSysPara : IcSysParas) {
			System.out.println("iCommonServiceHbmImpl: "+icSysPara.getParameterIndex()+"\t value:"+icSysPara.getParameterValue());
		}
		
	}
	

}


