package com.hufe.frame.dataobject.ao.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UserAddAO {

  @ApiModelProperty(value = "用户名称", required = true)
  @NotNull
  private String name;

  @ApiModelProperty(value = "用户性别", required = true)
  @NotNull
  private Integer gender;

}
