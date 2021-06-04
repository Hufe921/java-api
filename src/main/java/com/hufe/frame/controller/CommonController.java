package com.hufe.frame.controller;

import com.hufe.frame.dataobject.vo.common.FrameResponse;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserAndOrderShowVO;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
import com.hufe.frame.service.impl.OrderServiceImpl;
import com.hufe.frame.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Api(tags = "通用")
@Validated
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderServiceImpl orderService;

    @ApiOperation(value = "异步并发获取用户和订单信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "非法访问"),
            @ApiResponse(code = 422, message = "参数验证失败"),
            @ApiResponse(code = 500, message = "内部服务错误")
    })
    @PostMapping("/v1/user_order/get")
    @ResponseStatus(HttpStatus.OK)
    public FrameResponse<UserAndOrderShowVO> asyncFindUserAndOrderAll() {
        CompletableFuture<List<UserShowVO>> userFuture = userService.findAll();
        CompletableFuture<List<OrderShowVO>> orderFuture = orderService.findAll();
        CompletableFuture.allOf(userFuture, orderFuture).join();
        return new FrameResponse<>(UserAndOrderShowVO.builder()
                .orderShowList(orderFuture.join())
                .userShowList(userFuture.join())
                .build());
    }

}
