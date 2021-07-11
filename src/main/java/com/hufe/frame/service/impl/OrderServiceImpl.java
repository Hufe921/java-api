package com.hufe.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hufe.frame.dataobject.ao.order.CreateOrderAO;
import com.hufe.frame.dataobject.ao.order.UpdateOrderAO;
import com.hufe.frame.dataobject.po.exception.FrameMessageException;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;
import com.hufe.frame.mapper.OrderMapper;
import com.hufe.frame.model.OrderEntity;
import com.hufe.frame.model.OrderState;
import com.hufe.frame.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

  @Autowired
  private MapperFactory mapperFactory;

  @Autowired
  private OrderMapper orderMapper;

  @Override
  @Async("asyncExecutor")
  public CompletableFuture<List<OrderShowVO>> findAll() {
    QueryWrapper<OrderEntity> qw = new QueryWrapper<>();
    qw.eq("is_active", true);
    List<OrderEntity> orderEntities = this.list(qw);
    return CompletableFuture.completedFuture(mapperFactory.getMapperFacade()
            .mapAsList(orderEntities, OrderShowVO.class));

  }

  @Override
  @Transactional
  public boolean createOrder(ArrayList<CreateOrderAO> orderList) {
    if (orderList.isEmpty()) {
      throw new FrameMessageException("订单列表不能为空");
    }
    this.saveBatch(orderList.stream().map(o -> OrderEntity.builder()
            .name(o.getName())
            .userId(o.getUserId())
            .state(OrderState.INIT.getValue())
            .build()).collect(Collectors.toList()));
    return true;
  }

  @Override
  public boolean updateOrder(UpdateOrderAO updateOrder) {
    QueryWrapper<OrderEntity> qw = new QueryWrapper<>();
    qw.eq("is_active", true);
    qw.eq("id", updateOrder.getId());
    OrderEntity order = orderMapper.selectOne(qw);
    if (order == null) {
      throw new FrameMessageException("不存在该订单信息");
    }
    order.setName(updateOrder.getName());
    orderMapper.updateById(order);
    return true;
  }

}
