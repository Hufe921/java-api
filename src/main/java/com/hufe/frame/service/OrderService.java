package com.hufe.frame.service;

import com.hufe.frame.dataobject.ao.order.CreateOrderAO;
import com.hufe.frame.dataobject.vo.order.OrderShowVO;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {

    List<OrderShowVO> findAll();

    boolean createOrder(ArrayList<CreateOrderAO> orderList);

}
