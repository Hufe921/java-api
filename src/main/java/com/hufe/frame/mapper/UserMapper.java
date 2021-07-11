package com.hufe.frame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hufe.frame.dataobject.dto.user.UserOrderDTO;
import com.hufe.frame.model.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEntity> {

  @Select("select o.id,o.name,o.state"
          + " from orders o"
          + " where o.user_id = ${userId}"
          + " order by id DESC")
  List<UserOrderDTO> getOrderListByUserId(@Param("userId") Long userId);

}
