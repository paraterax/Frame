/**
 * com.paratera.user.entity
 * UserIPKey.java
 * 
 * 2015年7月23日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.entity;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author chenchao@paratera.com
 *
 */
public class StatisticKey implements Serializable {
    private static final long serialVersionUID = 4960350487073830363L;
    @Column(name="login_id")
    private String loginId;
    @Column
    private String ip;
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    @Override
    public int hashCode() {
        return loginId.hashCode()*7+ip.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || ! (obj instanceof StatisticKey)) {
            return false;
        }
        StatisticKey key = (StatisticKey) obj;
        return loginId.equals(key.loginId) && ip.equals(key.ip);
    }
    
    public StatisticKey() {
        
    }
    public StatisticKey(String loginId, String ip) {
        this.loginId = loginId;
        this.ip = ip;
    }
    
}
