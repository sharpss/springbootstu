package com.llx.summer.web;

import com.llx.summer.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: sharps
 * @Date: 19-3-29 13:48
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host","http://11.11.11.11");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() throws Exception{
        throw new Exception("发生错误,erro!");
    }


    @RequestMapping("/json")
    public String json() throws MyException{
        throw new MyException("发生自定义错误！");
    }
}
