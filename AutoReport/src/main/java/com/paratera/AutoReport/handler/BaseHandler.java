/**
 * warAutoReport
 * com.paratera.AutoReport
 * BaseHandler.java
 * 
 * 2015年6月24日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.handler;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author chenchao@paratera.com
 *
 */
public class BaseHandler extends HttpServlet{
    private static final long serialVersionUID = -2599792623957513105L;
    private static final Log LOG = LogFactory.getLog(BaseHandler.class);
    public BaseHandler() {
        LOG.info("handler:"+this.getClass()+" init.");
    }
    
}
