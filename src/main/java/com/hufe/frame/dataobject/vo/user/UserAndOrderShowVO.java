package com.hufe.frame.dataobject.vo.user;

import com.hufe.frame.dataobject.vo.order.OrderShowVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserAndOrderShowVO {

    @ApiModelProperty(value = "用户列表")
    List<UserShowVO> userShowList;

    @ApiModelProperty(value = "订单列表")
    List<OrderShowVO> orderShowList;

}
