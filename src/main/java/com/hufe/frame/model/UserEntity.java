package com.hufe.frame.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@TableName("users")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

  private String name;

  @TableField("birth_date")
  private Date birthDate;
}
