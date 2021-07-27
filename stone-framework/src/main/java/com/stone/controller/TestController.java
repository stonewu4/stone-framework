package com.stone.controller;


import com.stone.component.response.ResponseCallBack;
import com.stone.component.response.ResponseCriteria;
import com.stone.component.response.ResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangchen
 * @date 2021/3/12
 */

@RequestMapping("audio/message")
@Slf4j
@Api(value = "测试接口", description = "测试接口")
@RestController
public class TestController {

    /**
     * 测试接口
     * @return
     */
    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping("/getTest")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "creatTime",value = "创建时间，格式为yyyy-MM-dd HH:mm:ss"),
//            @ApiImplicitParam(name = "channel",value = "频道号码"),
//    })
    public ResponseInfo getTest() {
        return new ResponseCallBack( ) {
            @Override
            public void execute(ResponseCriteria criteria, Object... obj) throws Exception {
                String testStr = "测试接口正常";
                criteria.setResult(testStr);
            }
        }.sendRequest();
    }

}
