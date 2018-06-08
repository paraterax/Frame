package com.paratera.AutoReport.config;

import com.paratera.comutil.Config;
/**
 * 
 * StatisticConfig.java
 * 
 * 2015年9月22日
 * 2015北京并行科技公司-版权所有
 * 
 */

/**
 * @author chenchao@paratera.com
 *
 */
public class ModelConfig {
    private Config config;
    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
    public static final String HIBERNATE_PACKAGE = "com.paratera.sqlplug.hibernate";
    public static final String SELF_PACKAGE = "com.paratera.AutoReport";
    public static final String SELF_ENTITY_PACKAGE = "com.paratera.AutoReport.entity";
    public static final String SELF_DAO_PACKAGE = "com.paratera.AutoReport.dao";
    
    private ModelConfig() {
        config = Config.getInstance("AutoReport.properties");
    }

    private static volatile ModelConfig instance = null;

    public static ModelConfig getInstance() {
        if (instance == null) {
            synchronized (ModelConfig.class) {
                if (instance == null) {
                    instance = new ModelConfig();
                }
            }
        }
        return instance;
    }
}
