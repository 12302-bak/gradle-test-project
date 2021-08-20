package site.wtfu.framework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
