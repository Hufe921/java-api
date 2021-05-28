package com.hufe.frame.dataobject.vo.user;

import com.hufe.frame.dataobject.dto.user.UserOrderDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UserOrderShowVO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "订单列表")
    private List<UserOrderDTO> userOrderDTOList;

}
