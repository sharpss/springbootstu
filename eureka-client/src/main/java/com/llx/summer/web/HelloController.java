package com.llx.summer.web;

import com.llx.summer.Dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sharps
 * @Date: 19-4-2 09:34
 * @Description:
 */

@RestController
public class HelloController{

    @PostMapping("/user")
    public UserDto user(@RequestBody UserDto userDto) throws Exception{

        return userDto;

    }
}