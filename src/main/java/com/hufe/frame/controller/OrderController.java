package com.hufe.frame.controller;

import com.hufe.frame.dataobject.ao.order.CreateOrderAO;
import com.hufe.frame.dataobject.ao.order.UpdateOrderAO;
import com.hufe.frame.dataobject.vo.common.FrameResponse;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;
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
import java.util.concurrent.CompletableFuture;

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
    CompletableFuture<List<OrderShowVO>> result = orderService.findAll();
    return new FrameResponse<>(result.join());
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
    orderService.createOrder(inputAO);
    return new FrameResponse();
  }

  @ApiOperation(value = "更新订单")
  @ApiResponses({
          @ApiResponse(code = 401, message = "非法访问"),
          @ApiResponse(code = 422, message = "参数验证失败"),
          @ApiResponse(code = 500, message = "内部服务错误")
  })
  @PostMapping("/v1/update")
  @ResponseStatus(HttpStatus.OK)
  public FrameResponse updateOrder(@RequestBody @Valid UpdateOrderAO inputAO) {
    orderService.updateOrder(inputAO);
    return new FrameResponse();
  }

}
