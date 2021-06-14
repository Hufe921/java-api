package com.hufe.frame.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@TableName("users")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
}
