package com.hufe.frame.dataobject.ao.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateOrderAO {

  @ApiModelProperty(value = "订单id", required = true)
  @NotNull
  private Long id;

  @ApiModelProperty(value = "订单名称", required = true)
  @NotNull
  private String name;

}
