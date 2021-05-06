package com.hufe.frame.controller;

import com.hufe.frame.bean.ao.order.CreateOrderAO;
import com.hufe.frame.bean.po.exception.InterErrorException;
import com.hufe.frame.bean.vo.common.FrameResponse;
import com.hufe.frame.bean.vo.order.OrderShowVO;
import com.hufe.frame.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "订单")
@Validated
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
            throw new InterErrorException(e);
        }
    }

    @ApiOperation(value = "创建订单")
    @ApiResponses({
            @ApiResponse(code = 401, message = "非法访问"),
            @ApiResponse(code = 422, message = "参数验证失败"),
            @ApiResponse(code = 500, message = "内部服务错误")
    })
    @PostMapping("/v1/create")
    @ResponseStatus(HttpStatus.OK)
    public FrameResponse createOrder(@RequestBody @Valid ArrayList<CreateOrderAO> inputAO) {
        try {
            orderService.createOrder(inputAO);
            return new FrameResponse();
        } catch (Exception e) {
            throw new InterErrorException(e);
        }
    }

}
