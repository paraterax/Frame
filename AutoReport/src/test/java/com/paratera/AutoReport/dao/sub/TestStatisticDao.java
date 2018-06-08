/**
 * com.paratera.AutoReport.dao.sub
 * TestStatisticDao.java
 * 
 * 2015年9月22日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.dao.sub;

import java.sql.Timestamp;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paratera.AutoReport.dao.Dao;
import com.paratera.AutoReport.dao.EntityDaoImplTest;
import com.paratera.AutoReport.entity.StatisticEntity;
import com.paratera.AutoReport.entity.StatisticKey;

/**
 * @author chenchao@paratera.com
 *
 */
public class TestStatisticDao extends EntityDaoImplTest{
    @Autowired
    Dao dao;
    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("StatisticEntity.xml"));
        return dataSet;
    }
    @Test
    public void test() {
        StatisticKey key = new StatisticKey();
        key.setLoginId("1");
        key.setIp("172.18.1.1");
        StatisticEntity entity  = dao.getByKey(dao.getStatisticDao(), key);
        Assert.assertEquals(entity.getValue(), "0");
        StatisticKey key2 = new StatisticKey("a","b");
        StatisticEntity entity2 = new StatisticEntity();
        entity2.setStatisticKey(key2);
        entity2.setValue("2");
        entity2.setCreateDate(new Timestamp(System.currentTimeMillis()));
        entity2.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        dao.persist(dao.getStatisticDao(), entity2);
        StatisticEntity tmp = dao.getByKey(dao.getStatisticDao(), key2);
        Assert.assertEquals(tmp.getValue(), entity2.getValue());
        Assert.assertEquals(tmp.getStatisticKey(), entity2.getStatisticKey());
        Assert.assertEquals(tmp.getCreateDate(), entity2.getCreateDate());
        Assert.assertEquals(tmp.getUpdateDate(), entity2.getUpdateDate());
        
        entity2.setValue("3");
        dao.insertOrUpdate(dao.getStatisticDao(), entity2, entity2.getStatisticKey());
        tmp = dao.getByKey(dao.getStatisticDao(), key2);
        Assert.assertEquals(tmp.getValue(), entity2.getValue());
    }
}
