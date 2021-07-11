package com.hufe.frame.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@TableName("orders")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity implements Serializable {

  private String name;

  private Integer state;

  @TableField("user_id")
  private Long userId;

}
