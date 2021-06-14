package com.hufe.frame.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@TableName("orders")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String name;

    @Enumerated
    @Column(nullable = false)
    private OrderState state;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

}
