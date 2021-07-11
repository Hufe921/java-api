package com.hufe.frame.service;

import com.hufe.frame.dataobject.ao.order.CreateOrderAO;
import com.hufe.frame.dataobject.ao.order.UpdateOrderAO;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface OrderService {

  CompletableFuture<List<OrderShowVO>> findAll();

  boolean createOrder(ArrayList<CreateOrderAO> orderList);

  boolean updateOrder(UpdateOrderAO updateOrder);

}
