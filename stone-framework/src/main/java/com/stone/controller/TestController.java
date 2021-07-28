package com.stone.controller;


import com.stone.aop.Log;
import com.stone.component.enums.ReturnCodeEnum;
import com.stone.component.exception.BusinessException;
import com.stone.component.response.ResponseInfo;
import com.stone.enums.LogTypeEnum;
import com.stone.enums.ModuleTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 * @author stone
 * @date 2021/3/12
 */

@RequestMapping("test")
@Slf4j
@Api(value = "测试接口", description = "测试接口")
@RestController
public class TestController {

    /**
     * 测试接口
     * @return
     */
    @Log(description = "测试接口", value = LogTypeEnum.SELECT, type = ModuleTypeEnum.INDEX)
    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping("/getTest")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "creatTime",value = "创建时间，格式为yyyy-MM-dd HH:mm:ss"),
//            @ApiImplicitParam(name = "channel",value = "频道号码"),
//    })
    public String getTest() {
        return "测试正常";
    }

    @Log(description = "出现异常的接口", value = LogTypeEnum.EXPORT, type = ModuleTypeEnum.SYSTEM_MANAGE)
    @GetMapping("/wrong")
    public int error(@RequestParam Integer a,
                     @RequestParam Integer b){
        int i = a/b;
        return i;
    }

    @Log(description = "自定义异常的接口", value = LogTypeEnum.DELETE, type = ModuleTypeEnum.ROLE_MANAGE)
    @GetMapping("/ex")
    public int ex(){
        throw new BusinessException(ReturnCodeEnum.IMAGE_FORMAT_ERROR);
    }
}
