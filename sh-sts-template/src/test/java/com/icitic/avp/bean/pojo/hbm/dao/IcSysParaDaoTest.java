package com.icitic.avp.bean.pojo.hbm.dao;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)//设置测试事务回滚
public class IcSysParaDaoTest {
    
    
    @Autowired
    private IcSysParaDaoImpl beanDaoImpl;//通用泛型Dao
    
    @Autowired
    private IcSysParaDaoHibernateTmplateImpl beanDaoHibernateTmplateImpl;//针对要使用回调，基于Spring的hibernateTemplate
    
    @Autowired
    private IcSysParaDaoHibernateDaoSupportImpl beanDaoHibernateDaoSupportImpl;//继承Spring提供的HibernateDaoSupport, 针对不使用回调
    
	@Autowired
	private SessionFactory sessionFactory; //使用hibernate原生DAO
	
	@Autowired
//    @Qualifier("genericBaseHibernateDAO")
	private GenericBaseHibernateDAO<IcSysPara, Long> genericBaseHibernateDAO;
	
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
	
    @Test
    public void testGenericBaseHibernateDAO() {
    	System.err.println("genericBaseHibernateDAO is null :"+(genericBaseHibernateDAO==null));
		List<IcSysPara> IcSysParas = genericBaseHibernateDAO.findAll(IcSysPara.class);
		
		for (IcSysPara icSysPara : IcSysParas) {
			System.out.println(icSysPara.getParameterIndex()+"\t value:"+icSysPara.getParameterValue());
		}
        
    }
	
	
    @Test
    public void testAddBean() {
    	
    	
    	IcSysPara newIC = new IcSysPara();
    	
    	newIC.setParameterIndex("0088");
    	newIC.setParameterName("hiTestName");
    	newIC.setParameterValue("hiTestValue");
    	newIC.setParameterControl("1");
    	newIC.setParameterDescription("1");
    	
    	beanDaoImpl.create(newIC);
    	
    	Assert.assertNotNull(newIC);
    	
    	newIC = null;
    	
    	Assert.assertNull(newIC);
    	
    	newIC = beanDaoImpl.fetch("0088");
    	Assert.assertNotNull(newIC);
    	
    	
    	
    }
	
    @Test
    public void testHibernateOriginalQuery() {
    	
    	List<IcSysPara> IcSysParas;
    	
//    	List<IcSysPara> IcSysParas = (List<IcSysPara>) sessionFactory.getCurrentSession().createQuery("from IcSysPara");
    	System.err.println("beanDaoHibernateTmplateImpl is null :"+(beanDaoHibernateTmplateImpl==null));
    	
//    	IcSysPara paraBean = new IcSysPara();
//    	paraBean.setParameterIndex("000004");
    	IcSysParas = beanDaoHibernateDaoSupportImpl.getall();
    	
    	
    	
//    	List<IcSysPara> IcSysParas = beanDaoImpl.fetchAll();
    	System.err.println("IcSysParas size is :"+IcSysParas.size());
    	for (IcSysPara icSysPara : IcSysParas) {
    		System.out.println(icSysPara.getParameterIndex()+"\t value:"+icSysPara.getParameterValue());
    	}
    	
    }
    
    @Test
    public void testList() {
    	System.err.println("beanDaoImpl is null :"+(beanDaoImpl==null));
		List<IcSysPara> IcSysParas = beanDaoImpl.fetchAll();
		
		for (IcSysPara icSysPara : IcSysParas) {
			System.out.println(icSysPara.getParameterIndex()+"\t value:"+icSysPara.getParameterValue());
		}
        
    }
    
    

}
