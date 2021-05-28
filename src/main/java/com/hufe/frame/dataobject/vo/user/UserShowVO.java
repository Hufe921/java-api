package com.hufe.frame.dataobject.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserShowVO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

}
