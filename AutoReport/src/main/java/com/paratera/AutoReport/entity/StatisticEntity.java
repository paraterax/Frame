/**
 * com.paratera.AutoReport.entity
 * StatisticEntity.java
 * 
 * 2015年9月22日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author chenchao@paratera.com
 *
 */
@Entity
@Table(name="t_AutoReport")
public class StatisticEntity extends BaseEntity {
    @EmbeddedId
    private StatisticKey AutoReportKey;
    @Column
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StatisticKey getStatisticKey() {
        return AutoReportKey;
    }

    public void setStatisticKey(StatisticKey AutoReportKey) {
        this.AutoReportKey = AutoReportKey;
    }
  
}
