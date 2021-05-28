package com.hufe.frame.repository;

import com.hufe.frame.dataobject.dto.user.UserOrderDTO;
import com.hufe.frame.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select new com.hufe.frame.dataobject.dto.user.UserOrderDTO(o.id,o.name,o.state)"
            + " from OrderEntity o"
            + " where o.user.id = :userId"
            + " order by id DESC")
    List<UserOrderDTO> getOrderListByUserId(@Param("userId") Long userId);

}
