package com.hufe.frame.dataobject.vo.order;

import com.hufe.frame.model.OrderState;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class OrderShowVO {

  @ApiModelProperty(value = "订单名称")
  private String name;

  @ApiModelProperty(value = "订单状态")
  private Integer state;

  @ApiModelProperty(value = "订单创建时间")
  private Date createTime;

}
