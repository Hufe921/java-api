package com.hufe.frame.service;

import com.hufe.frame.bean.ao.order.CreateOrderAO;
import com.hufe.frame.bean.vo.order.OrderShowVO;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {

    List<OrderShowVO> findAll();

    boolean createOrder(ArrayList<CreateOrderAO> orderList);

}
