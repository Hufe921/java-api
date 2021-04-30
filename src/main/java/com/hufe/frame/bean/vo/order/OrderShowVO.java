package com.hufe.frame.bean.vo.order;

import com.hufe.frame.model.OrderState;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderShowVO {

    @ApiModelProperty(value = "订单名称")
    private String name;

    @ApiModelProperty(value = "订单状态")
    private OrderState state;

}
