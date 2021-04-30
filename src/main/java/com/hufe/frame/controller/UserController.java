package com.hufe.frame.controller;

import com.hufe.frame.bean.ao.user.UserOrderGetAO;
import com.hufe.frame.bean.po.exception.FrameValidationException;
import com.hufe.frame.bean.po.exception.InterErrorException;
import com.hufe.frame.bean.vo.common.FrameResponse;
import com.hufe.frame.bean.vo.user.UserOrderShowVO;
import com.hufe.frame.bean.vo.user.UserShowVO;
import com.hufe.frame.serviceImpl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "获取所有用户信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "非法访问"),
            @ApiResponse(code = 422, message = "参数验证失败"),
            @ApiResponse(code = 500, message = "内部服务错误")
    })
    @PostMapping("/v1/get")
    @ResponseStatus(HttpStatus.OK)
    public FrameResponse<List<UserShowVO>> findAll() {
        try {
            List<UserShowVO> result = userService.findAll();
            return new FrameResponse<>(result);
        } catch (Exception e) {
            throw new InterErrorException();
        }
    }

    @ApiOperation(value = "获取所有用户信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "非法访问"),
            @ApiResponse(code = 422, message = "参数验证失败"),
            @ApiResponse(code = 500, message = "内部服务错误")
    })
    @PostMapping("/v1/order_list/get")
    @ResponseStatus(HttpStatus.OK)
    public FrameResponse<UserOrderShowVO> getOrderListByUserId(@Valid @RequestBody UserOrderGetAO inputDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new FrameValidationException(bindingResult);
        }
        try {
            UserOrderShowVO result = userService.getOrderListByUserId(inputDTO.getUserId());
            return new FrameResponse<>(result);
        } catch (Exception e) {
            throw new InterErrorException();
        }
    }

}
