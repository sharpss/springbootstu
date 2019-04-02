package com.llx.eurekaconsumerfeign;

import com.llx.eurekaconsumerfeign.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: sharps
 * @Date: 19-4-2 10:28
 * @Description:
 */

@FeignClient("eureka-client-1")
public interface UserClient {
    @PostMapping("/user")
    public UserDto user(@RequestBody UserDto userDto);
}
