package com.llx.summer.web;

import com.llx.summer.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "获取用户列表",notes="获取用户列表的值")
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
    @ApiOperation(value = "用户创建",notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
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
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long" , paramType = "path")
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
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id,@RequestBody User user){
        User u= users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "ok";
    }
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @DeleteMapping(value ="/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "ok";
    }



}
