package com.hufe.frame.bean.ao.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UserOrderGetAO {

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull
    private Long userId;

}
