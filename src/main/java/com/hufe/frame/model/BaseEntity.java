package com.hufe.frame.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @TableField("is_active")
  private Boolean isActive = true;

  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private Date createTime = new Date();

  @TableField(value = "update_time", update = "now()", fill = FieldFill.INSERT_UPDATE)
  private Date updateTime = new Date();

  @TableField(update = "%s+1", fill = FieldFill.INSERT_UPDATE)
  private Integer version = 0;

}
