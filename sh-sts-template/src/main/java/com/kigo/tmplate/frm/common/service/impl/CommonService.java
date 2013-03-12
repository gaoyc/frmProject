package com.kigo.tmplate.frm.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kigo.tmplate.frm.common.Constants;
import com.kigo.tmplate.frm.common.model.AbstractModel;
import com.kigo.tmplate.frm.common.pagination.model2.Page;
import com.kigo.tmplate.frm.common.pagination.model2.PageUtil;
import com.kigo.tmplate.frm.common.service.ICommonService;
import com.kigo.tmplate.frm.hbm.dao.ICommonDao;

@Service("CommonService")
public class CommonService implements ICommonService {
    
    @Autowired
    @Qualifier("CommonHibernateDao")
    private ICommonDao commonDao;


    @Override
	public <T extends AbstractModel> T save(T model) {
        return commonDao.save(model);
    }

    @Override
	public <T extends AbstractModel> void saveOrUpdate(T model) {
        commonDao.saveOrUpdate(model);
        
    }
    
    @Override
	public <T extends AbstractModel> void update(T model) {
        commonDao.update(model);
    }
    
    @Override
	public <T extends AbstractModel> void merge(T model) {
        commonDao.merge(model);
    }

    @Override
	public <T extends AbstractModel, PK extends Serializable> void delete(Class<T> entityClass, PK id) {
        commonDao.delete(entityClass, id);
    }

    @Override
	public <T extends AbstractModel> void deleteObject(T model) {
        commonDao.deleteObject(model);
    }

    @Override
	public <T extends AbstractModel, PK extends Serializable> T get(Class<T> entityClass, PK id) {
        return commonDao.get(entityClass, id);
        
    }
    
    @Override
	public <T extends AbstractModel> int countAll(Class<T> entityClass) {
        return commonDao.countAll(entityClass);
    }
    
    @Override
	public <T extends AbstractModel> List<T> listAll(Class<T> entityClass) {
        return commonDao.listAll(entityClass);
    }
    
    @Override
	public <T extends AbstractModel> Page<T> listAll(Class<T> entityClass, int pn) {
        return listAll(entityClass, pn, Constants.DEFAULT_PAGE_SIZE);
    }
    
    @Override
	public <T extends AbstractModel> Page<T> listAll(Class<T> entityClass, int pn, int pageSize) {
        int total = countAll(entityClass);
        List<T> items = commonDao.listAll(entityClass, pn, pageSize);
        return PageUtil.getPage(total, pn, items, pageSize);
    }

}
