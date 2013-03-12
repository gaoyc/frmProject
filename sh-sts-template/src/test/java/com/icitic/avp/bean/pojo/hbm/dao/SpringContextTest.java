/**
 * 
 * <p>Title: CardAccountBizBean.java</p>
 * <p>Description: </p>
 * <p>Copyright: ICITIC</p>
 * <p>Company: 中信网络股份有限公司</p>
 * @author    Kigo
 * @version   1.0
 * @date 2012-10-25下午07:38:52
 */
package com.icitic.avp.bean.pojo.hbm.dao;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icitic.avp.bean.hbm.pojo.IcSysPara;
import com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoHibernateTmplateImpl;
import com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringContextTest {
	
	private static ApplicationContext appContext;
	public static void main(String[] args) {
		
		
		appContext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		
//		CommonService commService = (CommonService) 
		IcSysParaDaoImpl dao = (IcSysParaDaoImpl) appContext.getBean("beanDaoImpl");
		com.icitic.avp.bean.hbm.pojo.dao.IcSysParaDaoHibernateTmplateImpl dao2 = (IcSysParaDaoHibernateTmplateImpl) appContext.getBean("beanDaoHibernateTmplateImpl");
		
		List<IcSysPara> IcSysParas = dao2.getList();
		
		for (IcSysPara icSysPara : IcSysParas) {
			System.out.println(icSysPara.getParameterIndex()+"\t value:"+icSysPara.getParameterValue());
		}
		
		
//		Transaction trans = commService.transNoExchange("0200430"); //"0200430" 0200420
//		System.out.println(trans.toString());
		
	}

}

