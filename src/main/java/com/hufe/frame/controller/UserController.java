package com.hufe.frame.controller;

import com.hufe.frame.dataobject.ao.user.UserAddAO;
import com.hufe.frame.dataobject.ao.user.UserRelationShipAO;
import com.hufe.frame.dataobject.vo.common.FrameResponse;
import com.hufe.frame.dataobject.vo.user.UserShowVO;
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

@Api(tags = "用户")
@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  @ApiOperation(value = "添加用户")
  @ApiResponses({
          @ApiResponse(code = 401, message = "非法访问"),
          @ApiResponse(code = 422, message = "参数验证失败"),
          @ApiResponse(code = 500, message = "内部服务错误")
  })
  @PostMapping("/v1/add")
  @ResponseStatus(HttpStatus.OK)
  public FrameResponse addUser(@RequestBody @Validated UserAddAO inputAO) {
    userService.addUser(inputAO);
    return new FrameResponse();
  }

  @ApiOperation(value = "查询用户")
  @ApiResponses({
          @ApiResponse(code = 401, message = "非法访问"),
          @ApiResponse(code = 422, message = "参数验证失败"),
          @ApiResponse(code = 500, message = "内部服务错误")
  })
  @PostMapping("/v1/get")
  @ResponseStatus(HttpStatus.OK)
  public FrameResponse<List<UserShowVO>> getUser() {
    List<UserShowVO> result = userService.getUser();
    return new FrameResponse<>(result);
  }

  @ApiOperation(value = "新增用户关系")
  @ApiResponses({
          @ApiResponse(code = 401, message = "非法访问"),
          @ApiResponse(code = 422, message = "参数验证失败"),
          @ApiResponse(code = 500, message = "内部服务错误")
  })
  @PostMapping("/v1/relation_ship/save")
  @ResponseStatus(HttpStatus.OK)
  public FrameResponse saveRelationShip(@RequestBody @Validated UserRelationShipAO inputAO) {
    userService.saveRelationShip(inputAO);
    return new FrameResponse();
  }

}
