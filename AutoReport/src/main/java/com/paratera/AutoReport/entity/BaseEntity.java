/**
 * com.paratera.AutoReport.entity
 * BaseEntity.java
 * 
 * 2015年9月22日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author chenchao@paratera.com
 *
 */
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_date", nullable=false)
    private Timestamp createDate;
    @Column(name="updated_date", nullable = false) 
    private Timestamp updateDate;
    public Timestamp getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    public Timestamp getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
    
}
