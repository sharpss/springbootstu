package com.llx.summer.web;

import com.llx.summer.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: sharps
 * @Date: 19-3-28 14:48
 * @Description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    static Map<Long,User> users = Collections.synchronizedMap(new LinkedHashMap<Long,User>());

    public UserController() {
        User user = new User();
        user.hashCode();
        user.setId(111L);
        user.setAge(21);
        user.setName("张三");
        users.put(user.getId(),user);
        user = new User();
        user.setId(112L);
        user.setAge(22);
        user.setName("李四");
        users.put(user.getId(),user);
    }

    /**
     * 处理/users/的get请求，用来获取用户列表
     * @return
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r =new ArrayList<>(users.values());
        return r;
    }

    /**
     * 处理/users/的post请求，用来创建USER
     * @param user
     * @return
     */
    //@RequestMapping(value = "/",method = RequestMethod.POST)
    @PostMapping("/")
    public String postUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "ok";
    }

    /**
     * 处理/users/{id}的get请求，用来获取url中ID值的User信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    /**
     * 处理/users/{id}的PUT请求，用来更新User信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id,@RequestBody User user){
        User u= users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "ok";
    }

    @DeleteMapping(value ="/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "ok";
    }



}
