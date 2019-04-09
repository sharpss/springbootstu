package com.llx.summer.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: sharps
 * @Date: 19-4-2 13:58
 * @Description:
 */
@RestController
public class UserController {

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user){
        user.setName("name:"+user.getName());
        user.setAge(user.getAge()+10);
        return user;
    }

    @GetMapping(value = "/user")
    public String hello(){
        return "hellotest";
    }
}
