package com.jianping.pond.controller;

import com.jianping.pond.common.ResponseData;
import com.jianping.pond.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(description = "用户操作接口")
@RestController
public class LoginController {
    @ApiOperation("测试swagger2实现Restfl API")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "字符串", required = true, dataType = "String")})
    @RequestMapping("/login")
    public ResponseData<List> login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        System.out.println("-------------------------------");
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e ){
            System.out.println("登录失败");
        }

        return ResponseData.createSuccessMessage("登录成功",new User());
    }
}
