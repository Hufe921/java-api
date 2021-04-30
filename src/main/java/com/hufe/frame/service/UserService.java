package com.hufe.frame.service;

import com.hufe.frame.bean.vo.user.UserOrderShowVO;
import com.hufe.frame.bean.vo.user.UserShowVO;

import java.util.List;

public interface UserService {

    List<UserShowVO> findAll();

    UserOrderShowVO getOrderListByUserId(Long id);

}
