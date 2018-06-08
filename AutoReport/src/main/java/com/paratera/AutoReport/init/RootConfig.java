/**
 * com.paratera.user.init
 * RootConfig.java
 * 
 * 2015年8月18日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.init;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.paratera.sqlplug.hibernate.HibernateConfig;
import com.paratera.AutoReport.config.ModelConfig;

/**
 * @author chenchao@paratera.com
 *
 */
@EnableWebMvc
@Configuration
@Import(value={HibernateConfig.class})
@ComponentScan(basePackages={ModelConfig.HIBERNATE_PACKAGE,ModelConfig.SELF_PACKAGE})
public class RootConfig extends WebMvcConfigurerAdapter {

}
