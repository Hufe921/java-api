package com.hufe.frame.bean.ao.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateOrderAO {

    @ApiModelProperty(value = "订单名称", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull
    private Long id;

}
