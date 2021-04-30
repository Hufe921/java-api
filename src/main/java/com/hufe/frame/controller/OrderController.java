package com.hufe.frame.controller;

import com.hufe.frame.bean.po.exception.InterErrorException;
import com.hufe.frame.bean.vo.common.FrameResponse;
import com.hufe.frame.bean.vo.order.OrderShowVO;
import com.hufe.frame.serviceImpl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "订单")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @ApiOperation(value = "获取所有订单信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "非法访问"),
            @ApiResponse(code = 422, message = "参数验证失败"),
            @ApiResponse(code = 500, message = "内部服务错误")
    })
    @PostMapping("/v1/get")
    @ResponseStatus(HttpStatus.OK)
    public FrameResponse<List<OrderShowVO>> findAll() {
        try {
            List<OrderShowVO> result = orderService.findAll();
            return new FrameResponse<>(result);
        } catch (Exception e) {
            throw new InterErrorException();
        }
    }

}
