package com.paratera.AutoReport.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paratera.AutoReport.dao.Dao;

/**
 * Hello world!
 *
 */
@RestController
public class AppHandler extends BaseHandler
{
    private static final long serialVersionUID = -8515077259377201699L;
    @Autowired
    private Dao dao;
    @RequestMapping("/helloWorld")
    public String hello() {
        return "hello world~~~";
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World! AAAA" );
    }
}
