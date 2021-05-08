package com.hufe.frame.service.impl;

import com.hufe.frame.bean.ao.order.CreateOrderAO;
import com.hufe.frame.bean.vo.order.OrderShowVO;
import com.hufe.frame.model.OrderEntity;
import com.hufe.frame.model.OrderState;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.repository.OrderRepository;
import com.hufe.frame.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderShowVO> findAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderShowVO> result = null;
        if (orderEntities != null) {
            result = orderEntities.stream().map(u ->
                    OrderShowVO.builder()
                            .name(u.getName())
                            .state(u.getState())
                            .build()
            ).collect(Collectors.toList());
        }
        return result;
    }

    @Override
    @Transactional
    public boolean createOrder(ArrayList<CreateOrderAO> orderList) {
        if (orderList.isEmpty()) {
            return false;
        }
        List<OrderEntity> orderEntityList = orderList.stream().map(o -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(o.getId());
            return OrderEntity.builder()
                    .name(o.getName())
                    .user(userEntity)
                    .state(OrderState.INIT)
                    .build();
        }).collect(Collectors.toList());
        // 批量插入-减少SELECT
        orderEntityList.forEach(entityManager::persist);
        entityManager.flush();
        entityManager.clear();
        return true;
    }

}
