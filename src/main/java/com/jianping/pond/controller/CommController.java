package com.jianping.pond.controller;

import com.jianping.pond.common.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(description = "用户操作接口")
@RestController
public class CommController {
    //public Object
    @ApiOperation("测试swagger2实现Restfl API")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "字符串", required = true, dataType = "String")})
    @RequestMapping(value = "/tests/{name}",method = RequestMethod.GET)

    public ResponseData apiTestController(@PathVariable String name) {
        System.out.println("======================================");
        return ResponseData.createSuccessMessage("成功访问",name);
    }
}
