package com.llx.summer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sharps
 * @Date: 19-3-28 09:23
 * @Description:
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
}
