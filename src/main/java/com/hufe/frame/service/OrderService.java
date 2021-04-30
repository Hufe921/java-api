package com.hufe.frame.service;

import com.hufe.frame.bean.vo.order.OrderShowVO;

import java.util.List;

public interface OrderService {

    List<OrderShowVO> findAll();

}
