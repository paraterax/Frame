/**
 * com.paratera.AutoReport.dao
 * DAO.java
 * 
 * 2015年9月22日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paratera.sqlplug.hibernate.AbstractDao;
import com.paratera.sqlplug.hibernate.Page;
import com.paratera.sqlplug.hibernate.PageQuery;
import com.paratera.AutoReport.dao.sub.StatisticDao;

/**
 * @author chenchao@paratera.com
 *
 */
@Repository
@Transactional
public class Dao {
    @Autowired
    StatisticDao AutoReportDao;
    
    public StatisticDao getStatisticDao() {
        return AutoReportDao;
    }
    public void setStatisticDao(StatisticDao AutoReportDao) {
        this.AutoReportDao = AutoReportDao;
    }
    
    public <K, T extends AbstractDao<? extends Serializable, K>> K saveOrUpdate(T dao, K entity) {
        dao.saveOrUpdate(entity);
        return entity;
    }
    public <K, T extends AbstractDao<? extends Serializable, K>> K persist(T dao, K entity) {
        dao.persist(entity);
        return entity;
    }
    
    public <M extends  Serializable, K, T extends AbstractDao<? extends M, K>> void delete(T dao, K entity) {
        dao.delete(entity);
    }
     
    public <M extends  Serializable, K, T extends AbstractDao<M, K>> K getByKey(T dao, M key) {
        return dao.getByKey(key);
    }
    
    public <M extends  Serializable, K, T extends AbstractDao<M, K>> K insertOrUpdate(T dao, K entity, M key) {
        K ret = dao.getByKey(key);
        if (ret == null) {
            dao.persist(entity);
        } else {
            dao.saveOrUpdate(dao.merge(entity));
        }
        return entity;
    }
    
    public <M extends  Serializable, K, T extends AbstractDao<M, K>> Page<K> queryAllColumn(T dao, int pageNo, int pageSize, boolean isCount) {
        return dao.queryAll(pageNo, pageSize, isCount);
    }
    
    protected <M extends  Serializable, K, T extends AbstractDao<M, K>> Criteria createCriteria(T dao) { 
        return dao.createCriteria();
    }
    
    protected <M extends  Serializable, K, T extends AbstractDao<M, K>> Page<K> queryPage(T dao, Criteria query, int pageNo, int pageSize, boolean isCount) {
        PageQuery pageQuery = new PageQuery(query, pageNo, pageSize, isCount);
        return dao.queryPage(pageQuery);
    }
}
