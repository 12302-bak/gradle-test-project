package site.wtfu.framework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:"
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/demo")
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping(value = "/request")
    public String test(HttpServletRequest request){
        System.out.println("OK");
        return "OK";
    }
}
