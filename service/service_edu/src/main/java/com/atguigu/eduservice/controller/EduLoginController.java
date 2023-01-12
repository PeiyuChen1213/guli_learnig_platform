package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("/login")
    public R login(@RequestBody User user){
        System.out.println("login");
        if (user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
            return R.ok().data("token",user);
        }
        return R.error().message("用户名密码错误");
    }
    @GetMapping("/info")
    public R getInfo(){
        System.out.println("info");
        return R.ok().data("roles","[roles]").data("name","[name]").data("avatar","https://avatars.githubusercontent.com/u/88339757?s=40&v=4");
    }
}
