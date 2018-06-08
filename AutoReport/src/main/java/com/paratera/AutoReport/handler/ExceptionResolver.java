/**
 * com.paratera.user.handler
 * ExceptionResolver.java
 * 
 * 2015年7月22日
 * 2015北京并行科技公司-版权所有
 * 
 */
package com.paratera.AutoReport.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author chenchao@paratera.com
 *
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver, PriorityOrdered{
    private static final Log LOG = LogFactory.getLog(ExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        LOG.warn("spring error: in "+request.getRequestURL(), ex);
        Map<String,Object> map = new HashMap<>();
        map.put("desc", "UNKNOWN EXCEPTION");
        map.put("code", "111111111");
        map.put("msg", ex.getMessage());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ModelAndView(new MappingJackson2JsonView(),map); 
    }
    @Override
    public int getOrder() {
        return 0;
    }  

}
