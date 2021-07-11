package com.hufe.frame.dataobject.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserOrderDTO {

  @ApiModelProperty(value = "订单id")
  private Long id;

  @ApiModelProperty(value = "订单名称")
  private String name;

  @ApiModelProperty(value = "订单状态")
  private Integer state;

}
