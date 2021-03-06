package com.hufe.frame.service.impl;

import com.hufe.frame.dataobject.ao.order.CreateOrderAO;
import com.hufe.frame.dataobject.po.exception.FrameMessageException;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;
import com.hufe.frame.model.OrderEntity;
import com.hufe.frame.model.OrderState;
import com.hufe.frame.model.UserEntity;
import com.hufe.frame.repository.OrderRepository;
import com.hufe.frame.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<OrderShowVO>> findAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return CompletableFuture.completedFuture(mapperFactory.getMapperFacade()
                .mapAsList(orderEntities, OrderShowVO.class));
    }

    @Override
    @Transactional
    public boolean createOrder(ArrayList<CreateOrderAO> orderList) {
        if (orderList.isEmpty()) {
            throw new FrameMessageException("订单列表不能为空");
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
